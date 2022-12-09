
public class Personaje {
	private int vida;
	private String nombre;
	private int ataque;
	private String hechizo[]=new String[1];
	private String aspecto;
	
	//Nuevo personaje con datos dados
	public Personaje(int vida,String nombre,int ataque,String hechizo,String aspecto) {
		this.vida=vida;
		this.nombre=nombre;
		this.ataque=ataque;
		this.hechizo[0]=hechizo;
		this.aspecto=aspecto;
	}
	
	public String toString() {
		return ""
				+ "╭══════ .✧"+nombre+"✧. ══════╮\n"
				+ "  "+vida+"♥"+"     Fuerza:"+ataque+"\n"
				+ "  Hechizos:"+verHechizos()+"\n"
				+ ""+aspecto;
	}
	
	
	private String verHechizos(){
		String res="";
		for(String i:hechizo) {
			res+=" "+i+",";
		}
		return res.substring(0,res.length()-1);
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
