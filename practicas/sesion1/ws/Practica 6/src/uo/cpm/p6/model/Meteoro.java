package uo.cpm.p6.model;

public class Meteoro extends Casilla{


		boolean encontrado;

		
		public Meteoro() {
			setPuntos(0);
			setImagen ( "/img/meteorite.jpg");
			setTipo("Meteoro");
		}
		
		public boolean isEncontrado() {
			return encontrado;
		}
		
		public void setEncontrado(boolean encontrado) {
			this.encontrado = encontrado;
		}
		
		public int descubrir () {
			setEncontrado(true);
			return getPuntos();	
		}
		
		
	}

