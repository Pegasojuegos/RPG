
public class Hechizo {
	public static final String lista[]={"Llama del dragón","Sanación","Beso de la muerte","Furia vikinga","Caelestis protector"};
	private int numHechizo;
	

	public Hechizo(String nom) {
		for(int i=0;i<lista.length;i++) {
			if(lista[i].equalsIgnoreCase(nom)) {
				numHechizo=i;
			}//if
		}//for
	}//Hechizo

	public void usarHechizoEnemigo(Enemigo enemigo,Nivel lvl) {
		switch(numHechizo) {
		case 0://Llama del dragón
			enemigo.setEstadoNum(1);
			enemigo.setContEstado(3);
		case 2://Beso de la muerte
			enemigo.setEstadoNum(2);
		}
	}
	
	public void usarHechizoAliado(Personaje aliado,Nivel lvl) {
		switch(numHechizo) {
			
		case 1://Sanación
			aliado.setVidaActual(aliado.getVidaActual()+((int)(aliado.getVida()*0.25)));
		case 3://Furia vikinga
			aliado.setEstadoNum(2);
		case 4://Caelestis protector
			aliado.setEstadoNum(1);
		}
	}
	
	public String[] getLista() {
		return lista;
	}

	public int getNumHechizo() {
		return numHechizo;
	}
	
	public String getHechizo() {
		return lista[numHechizo];
	}
	
	public static String selectHechizo(int n) {
		return lista[n];
	}
	
}
