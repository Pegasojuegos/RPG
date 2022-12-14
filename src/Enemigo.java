
public class Enemigo {
	private String aspectos[]= {
			  "                                      (°U°)\n"
			+ "                                      τ(θ)τ\n"
			+ "                                       ωωω",
			  "                                      ξ•)\n"
			+ "                                      (ΞΞΞ)φ\n"
			+ "                                       Γ Γ",
			     "                                                                            (ಠ益⁠ಠ)    Ξ\n"
			+ "                                  [Ξ]={ Φ }=[Ξ]\n"
			+ "                                   Ξ  Δ   Δ"};
	public String getAspecto() {
		return aspecto;
	}

	private String aspecto;
	private int daño;
	private int vida;
	private int vidaActual;
	
	public Enemigo(int lvl,Equipo e) {
		aspecto=aspectos[lvl-1];
		int nivelarDaño=(e.getEquipoPos(0).getVida()+e.getEquipoPos(1).getVida()/2)/7;
		int nivelarVida=(e.getEquipoPos(0).getAtaque()+e.getEquipoPos(1).getAtaque()/2)*14;

		vida=(int) (Math.random()*(lvl*nivelarVida))+lvl*nivelarVida/2;
		daño=(int) (Math.random()*(lvl*nivelarDaño))+lvl*nivelarDaño/2;
		vidaActual=vida;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getDaño() {
		return daño;
	}

	public int getVida() {
		return vida;
	}
	
}
