package castleBooker.model.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import castleBooker.model.discount.Discount;

public class Game {

	public static final int COLUMNAS=7;
	public static final int FILAS=5;
	
	private Casilla board[][];
	private List<String> listaType = new ArrayList<>();
	
	private int diceValue;
	private int remainingMoves;
	
	private Set<String> enemies;
	
	private Discount discount;
	

	
	public Game() {
		inicializar();
	}
	
	public void inicializar() {
		createList();
		fillBoard();
		remainingMoves=7;
		defaultGhost();
		discount=null;
	}
	
	private void defaultGhost() {
		enemies = new HashSet<>();
	}

	protected void setDiscount(Discount discount) {
		this.discount = discount;
	}

	private void fillBoard() {
		board= new Casilla[FILAS][COLUMNAS];
		int notToFill=6;
		int toFill=1;
		for(int i=0;i<FILAS;i++) {
			if(i==3) {
				for(int j=0;j<COLUMNAS;j++) {
					String type = randomType();
					board[i][j]=new Casilla(type,"fantasma"+ type);
				}
			}else if(i==4) {
				for(int j=0;j<7;j++) {
					board[i][j]=new Casilla("G", "ghostBuster");
				}
			}else {
				int j=0;
				for(int k=0;k<notToFill/2;k++) {
					board[i][j]=new Casilla("pared","wall");
					j++;
				}for(int k=0;k<toFill;k++) {
					if(i==0 && k==0) {
						board[i][j]=new Casilla("X", "fantasmaX");
					}else {
						String type = randomType();
						board[i][j]=new Casilla(type,"fantasma"+ type);
					}
					j++;
				}for(int k=0;k<notToFill/2;k++) {
					board[i][j]=new Casilla("pared","wall");
					j++;
				}
				notToFill-=2;
				toFill+=2;
			}
		}
	}
	
	private String randomType() {
		Random rd = new Random();
		if(listaType.size()==0) throw new IllegalStateException("El tamaño del array es 0, no se puede seguir con la operacion");
		int value = rd.nextInt(listaType.size());
		String type = listaType.get(value);
		listaType.remove(value);
		return type;
	}
	
	private void createList() {
		String list[]= {"A","B","C","D","E","A","B","C","D","E","A","B","C","D","E"};
		for(String element:list) {
			listaType.add(element);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				sb.append(board[i][j]+"\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	public Casilla getCasilla(int fila,int columna) {
		return board[fila][columna];
	}
	
	public void lanzar() {
		remainingMoves--;
		diceValue=Dice.lanzar();
	}
	
	public int getDiceValue() {
		return diceValue;
	}
	
	private int search(int posicion) {
		for(int i=0;i<FILAS;i++) {
			if(board[i][posicion].getType().equals("G")) {
				return i;
			}
		}
		throw new IllegalArgumentException("El elemento no se encontró");
	}

	public boolean move(int location) { 
		int ghostLocation=search(location);
		int place = ghostLocation-getDiceValue();
		if(place<0 || board[place][location].getType().equals("pared")) {
			return false;
		}else {
			setPoints(board[place][location]);
			board[place][location]=board[ghostLocation][location];
			board[ghostLocation][location]=new Casilla("pared", "wall");
			return true;
		}
	}

	private void setPoints(Casilla casilla) {
		String type = casilla.getType();
		enemies.add(type);
	}
	
	public boolean isFinished() {
		if(remainingMoves==0 || (oneTypeDefeat()&& enemies.contains("X"))) {
			calculateDiscount();
			return true;
		}
		return false;
	}
	
	private boolean oneTypeDefeat() {
		return enemies.contains("A") && enemies.contains("B") && enemies.contains("C") && 
				enemies.contains("D") && enemies.contains("E");
	}
	
	public boolean canGetDicount() {
		return getDiscount()!=0;
	}
	
	private void calculateDiscount() {
		if(oneTypeDefeat()&& enemies.contains("X")) {
			setDiscount(Discount.EXTRA25);
		}else if(oneTypeDefeat()) {
			setDiscount(Discount.EXTRA10);
		}
	}
	
	public double getDiscount() {
		if(discount==null) return 0;
		else {
			return discount.getAmount();
		}
	}
	
	
}
