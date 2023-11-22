package uo.cpm.p8.player;

import java.io.*;

public class MyFile {
	private File f;
	
	public MyFile (File f){
		this.f = f;
	}
	
	public File getF() {
		return f;
	}

	public String toString() {
		return f.getName().replace(".mp3","");
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyFile other = (MyFile) obj;
		return this.toString().equals(other.toString());
	}
	
	
}