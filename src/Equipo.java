
public class Equipo {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Guarda un array de Personajes con un tamaño fijo de dos
	private final int tamaño=2;
	Personaje equipo[]= new Personaje[tamaño];
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Metodo para pasar un equipo a String, el cual llama al propio método de cada Personaje
	public String toString(){
		StringBuffer res=new StringBuffer("");
		for(Personaje i:equipo) {
			res.append(i+"\n");
		}
		return res.toString();
	}
	
	//Curar toda la vida y revive al equipo
	public void Descanso(){
		for(Personaje p:equipo) {
			p.setVidaActual(p.getVida());
			p.setVivo(true);
		}//for
	}
	
	//Añade un nuevo Personaje dado al equipo en la posición indicada
	public void añadirMiembro(Personaje p1,int pos) {
		this.equipo[pos] = p1;
	}
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
		
	//Getters y setters
	public Personaje[] getEquipo() {
		return equipo;
	}

	public void setEquipo(Personaje[] equipo) {
		this.equipo = equipo;
	}
	
	public Personaje getEquipoPos(int pos) {
		return equipo[pos];
	}

	//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛

}
