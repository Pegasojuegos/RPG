
public class Hechizo {
	String lista[]={"Llama del dragón","Sanación","Beso de la muerte","Furia vikinga"};
	int numHechizo;
	
	public Hechizo(String nom) {
		for(int i=0;i<lista.length;i++) {
			if(lista[i].equalsIgnoreCase(nom)) {
				numHechizo=i;
			}//if
		}//for
	}//Hechizo

	public String[] getLista() {
		return lista;
	}

	public int getNumHechizo() {
		return numHechizo;
	}
	
	
}
