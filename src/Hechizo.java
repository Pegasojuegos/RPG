
public class Hechizo {
	private final String lista[]={"Llama del dragón","Sanación","Beso de la muerte","Furia vikinga","Caelestis protector"};
	private int numHechizo;
	
	public Hechizo(String nom) {
		for(int i=0;i<lista.length;i++) {
			if(lista[i].equalsIgnoreCase(nom)) {
				numHechizo=i;
			}//if
		}//for
	}//Hechizo

	public void usarHechizoEnemigo(Enemigo Enemigo) {
		switch(numHechizo) {
		case 0://Llama del dragón
				
		case 2://Beso de la muerte
						
		}
	}
	
	public void usarHechizoAliado(Personaje Aliado) {
		switch(numHechizo) {
			
		case 1://Sanación
			Aliado.setVidaActual(Aliado.getVidaActual()+((int)(Aliado.getVida()*0.25)));
		case 3://Furia vikinga
			
		case 4://Caelestis protector
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
	
	
}
