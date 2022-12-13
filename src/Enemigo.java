
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
	
	public Enemigo(int lvl) {
		aspecto=aspectos[lvl];
		vida=(int) (Math.random()*(lvl*30))+lvl*20;
		daño=(int) (Math.random()*(lvl*7))+lvl*5;
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
