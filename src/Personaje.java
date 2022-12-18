
public class Personaje {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Datos que guardará un Personaje
	private int vidaActual;
	private int vida;
	private String nombre;
	private int ataque;
	private Hechizo hechizoAprendido;
	private String aspecto;
	private boolean vivo;
	private final String estados[]= {"","\033[36m○\u001B[0m","\033[35m奭\u001B[0m"};//Estados disponibles:Sin estado, escudo, furia
	private int estadoNum;
	private int contEstado=0;
	//Lista con todos los aspectos disponibles (tienen colores de ahí esos códigos)
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
		
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Metodos de la clase
	
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
	}//Crear personaje
	
	//Metodo para pasar el personaje a String, usado para ver cada miembro del equipo con sus datos
	public String toString() {
		return ""
				+ "╭═════════ .✧"+nombre+"✧. ═════════╮\n"
				+ "  \033[31m"+vida+"♥\u001B[0m"+"  Fuerza:"+ataque+"  "+hechizoAprendido.getHechizo()+"\n"
				+ "    "+aspecto;
	}
	
	//Metrodo para pasase el personaje a String durante el nivel, solo devuelve la vida y su aspecto
	public String ronda() {
		return vidaActual+"        ♥\n\n"+aspecto;
	}
	
	//Curar o hacer daño variando su vida actual
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
		//Si sobre pasa su vida máxima vuelve a tener la vida máxima
		if(vidaActual>vida) {
			vidaActual=vida;
		}
		//Si tienes 0 de vida o menos llama a morir
		if(this.vidaActual<=0) {
			morir();
		}
	}
		
	//Muere el personaje
	private void morir() {
		vivo=false;
	}
	
	//Devuelve el daño que hace y si tiene furia lo tiene en cuenta aumentando este daño que manda 
	//y aumenta un contador para al tercer ataque quitar el estado de furia
	public int getAtaque() {
		int atq=ataque;
		if(estadoNum==2) {
			atq=(int) (atq+atq*0.5);
			contEstado++;
			if(contEstado==3) {
				estadoNum=0;
				contEstado=0;
			}
		}
		return atq;
	}
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓	
	
	//Resto de de getters y setters
	public static String selecAspecto(int n) {
		return aspectos[n];
	}
	public static String[] getListaAspectos() {
		return aspectos;
	}
	public Hechizo getHechizoAprendido() {
		return hechizoAprendido;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public String getAspecto() {
		return aspecto;
	}
	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
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
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getContEstado() {
		return contEstado;
	}
	public void setContEstado(int contEstado) {
		this.contEstado = contEstado;
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
	
	//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
}
