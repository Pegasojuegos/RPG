
public class Equipo {
	private final int tamaño=2;
	Personaje equipo[]= new Personaje[tamaño];
	

	public String toString(){
		String res="";
		for(Personaje i:equipo) {
			res+=i+"\n";
		}
		return res;
	}
	
	public Personaje[] getEquipo() {
		return equipo;
	}

	public void setEquipo(Personaje[] equipo) {
		this.equipo = equipo;
	}
	
	public Personaje getEquipoPos(int pos) {
		return equipo[pos];
	}

	public void añadirMiembro(Personaje p1,int pos) {
		this.equipo[pos] = p1;
	}

}
