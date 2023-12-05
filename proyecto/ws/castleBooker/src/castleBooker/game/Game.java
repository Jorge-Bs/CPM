package castleBooker.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

	public static final int COLUMNAS=7;
	public static final int FILAS=5;
	
	private Casilla board[][];
	private List<String> listaType = new ArrayList<>();
	
	public Game() {
		inicializar();
	}
	
	public void inicializar() {
		createList();
		fillBoard();
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
	
}
