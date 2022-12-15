
public class Personaje {
	private int vidaActual;
	private int vida;
	private String nombre;
	private int ataque;
	private Hechizo hechizoAprendido;
	private String aspecto;
	private boolean vivo;
	private final String estados[]= {"","○","奭"};
	private int estadoNum;
	
	private static final String aspectos[]={
		    "\n       √°}\r\n"
			+ "       \033[35m[\u001B[0m|\033[35m]\u001B[0m\\\033[32m•\u001B[0m\r\n"
			+ "        |\n",
			
			"\n      \033[34m|\u001B[0m •\033[34m|\u001B[0m  \033[31m/\u001B[0m   \r\n"
			+ "      \033[34m( |)\\\u001B[0m\033[31m/\u001B[0m\r\n"
			+ "        \033[34m|,\u001B[0m\n",
			
	 		"\n        (°} \033[36m☼\u001B[0m\r\n"
			+ "       \033[35m/\u001B[0m\033[31m[\u001B[0m|\033[31m]\u001B[0m\\\033[32m|\u001B[0m\r\n"
			+ "      \033[35m/\u001B[0m  |. \033[32m|\u001B[0m\n",
	};
	
	public static String selecAspecto(int n) {
		return aspectos[n];
	}
	public static String[] getListaAspectos() {
		return aspectos;
	}

	//Nuevo personaje con datos dados
	public Personaje(int vida,String nombre,int ataque,String hechizo,String aspecto) {
		this.estadoNum=0;
		this.vida=vida;
		this.nombre=nombre;
		this.ataque=ataque;
		this.hechizoAprendido=new Hechizo(hechizo);
		this.aspecto=aspecto;
		this.vidaActual=vida;
		vivo=true;
	}
	
	//Nuevo personaje sin datos
	public Personaje() {}
	


	public String toString() {
		return ""
				+ "╭═════════ .✧"+nombre+"✧. ═════════╮\n"
				+ "  \033[31m"+vida+"♥\u001B[0m"+"  Fuerza:"+ataque+"  "+hechizoAprendido.getHechizo()+"\n"
				+ "    "+aspecto;
	}
	
	public String ronda() {
		return vidaActual+"        ♥\n\n"+aspecto;
	}
	
	public Hechizo getHechizoAprendido() {
		return hechizoAprendido;
	}
	//Curar o hacer daño
	public void variarVida(int cantidad) {
		vidaActual=vidaActual+cantidad;
		if(vidaActual>vida) {
			vidaActual=vida;
		}
		if(vidaActual<=0) {
			morir();
		}
	}
	
	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
		if(this.vidaActual<0) {
			morir();
		}
	}

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	//Muere el personaje
	private void morir() {
		vivo=false;
	}
	
	

	public boolean isVivo() {
		return vivo;
	}
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
		if(this.vida<1) {
			morir();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		int atq=ataque;
		if(estadoNum==2) {
			atq=(int) (atq+atq*0.5);
			estadoNum=0;
		}
		return atq;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String[] getHechizo() {
		return hechizoAprendido.getLista();
	}
	public int getEstadoNum() {
		return estadoNum;
	}
	public void setEstadoNum(int estadoNum) {
		this.estadoNum = estadoNum;
	}
	public String getEstado() {
		return estados[estadoNum];
	}

	
	
}
