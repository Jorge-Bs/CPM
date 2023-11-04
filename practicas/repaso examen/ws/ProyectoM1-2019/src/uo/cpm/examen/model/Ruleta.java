package uo.cpm.examen.model;

public class Ruleta {

	public int lanzamiento() {
		return ((int) (Math.random()*5)+1)*100;
	}
}
