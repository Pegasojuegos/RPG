
public class Hechizo {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//En un hechizo se guarda la lista de todos los hechizos disponibles y cual es el hechizo seleccionado
	public static final String lista[]={"Llama del dragón","Sanación","Beso de la muerte","Furia vikinga","Caelestis protector"};
	private int numHechizo;
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Metodo para crear un hechizo en el que se selecciona uno de la lista
	public Hechizo(String nom) {
		for(int i=0;i<lista.length;i++) {
			if(lista[i].equalsIgnoreCase(nom)) {
				numHechizo=i;
			}//if
		}//for
	}//Hechizo

	//Metodo para lanzar un hechizo a un enemigo, en el que mandas el enemigo objetivo
	public void usarHechizoEnemigo(Enemigo enemigo) {
		switch(numHechizo) {
		case 0://Llama del dragón
			enemigo.setEstadoNum(1);//Le pone estado de quemado
			enemigo.setContEstado(3);//Pone el contador de estado a 3(durará 3 rondas)
			break;
		case 2://Beso de la muerte
			enemigo.setEstadoNum(2);//Le pone estado enamorado
			break;
		}
	}
	
	//Metodo para lanzar un hechizo a un aliado, en el que mandas el aliado objetivo
	public void usarHechizoAliado(Personaje aliado) {
		switch(numHechizo) {
		case 1://Sanación
			//Suma a su vida actual el 25% de su vida máxima
			aliado.setVidaActual(aliado.getVidaActual()+((int)(aliado.getVida()*0.25)));
			break;
		case 3://Furia vikinga
			aliado.setContEstado(0);//Establece el contador de estado a 0(irá aumentando con los ataques)
			aliado.setEstadoNum(2);//Le pone estado furioso
			break;
		case 4://Caelestis protector
			aliado.setContEstado(0);//Establece el contador de estado a 0(aumetará al recibir daño)
			aliado.setEstadoNum(1);//Le pone estado escudo
			break;
		}
	}
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Getters y setter
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
