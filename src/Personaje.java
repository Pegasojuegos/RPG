
public class Personaje {
	private int vidaActual;
	private int vida;
	private String nombre;
	private int ataque;
	private String hechizo[]=new String[1];
	private String aspecto;
	private boolean vivo;
	
	private String aspectos[]={
		    "\n       √°}\r\n"
			+ "       [|]\\•\r\n"
			+ "        |\n",
			
			"\n      | •|  /   \r\n"
			+ "      ( |)\\/\r\n"
			+ "        |,\n",
			
	 		"\n        (°} ☼\r\n"
			+ "       /[|]\\|\r\n"
			+ "      /  |. |\n",
	};
	
	public String getAspectos(int n) {
		return aspectos[n];
	}
	public String[] getListaAspectos() {
		return aspectos;
	}

	//Nuevo personaje con datos dados
	public Personaje(int vida,String nombre,int ataque,String hechizo,String aspecto) {
		this.vida=vida;
		this.nombre=nombre;
		this.ataque=ataque;
		this.hechizo[0]=hechizo;
		this.aspecto=aspecto;
		this.vidaActual=vida;
		vivo=true;
	}
	
	//Nuevo personaje sin datos
	public Personaje() {}
	


	public String toString() {
		return ""
				+ "╭═════════ .✧"+nombre+"✧. ═════════╮\n"
				+ "  "+vida+"♥"+"  Fuerza:"+ataque+"  "+verHechizos()+"\n"
				+ "    "+aspecto;
	}
	
	public String ronda() {
		return vidaActual+"        ♥\n\n"+aspecto;
	}
	
	private String verHechizos(){
		String res="";
		for(String i:hechizo) {
			res+=" "+i+",";
		}
		return res.substring(0,res.length()-1);
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
	
	//Curar toda la vida y revive al personaje
	public void Descanso(){
		vidaActual=vida;
		vivo=true;
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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public String[] getHechizo() {
		return hechizo;
	}

	public void setHechizo(String[] hechizo) {
		this.hechizo = hechizo;
	}
	
	
}
