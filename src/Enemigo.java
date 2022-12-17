
public class Enemigo {
	private final String aspectos[]= {
			  "                                      \033[34m(\033[32m°\033[34mU\033[32m°\033[34m)\n"
			+ "                                      τ(\033[32mθ\033[34m)τ\n"
			+ "                                       ωωω\u001B[0m",
			  "                                      \033[33mξ\033[31m•\033[33m)\n"
			+ "                                      (ΞΞΞ)φ\n"
			+ "                                       Γ Γ\u001B[0m",
			  "                                      \033[35m(ಠ益⁠ಠ)   \033[36mΞ\n"
			+ "                                  [\033[36mΞ\033[35m]={ \033[34mΦ\033[35m }=[\033[36mΞ\033[35m]\n"
			+ "                                   \033[36mΞ\033[35m  Δ   Δ\u001B[0m"};
	private boolean vivo;

	private final String estados[]= {" ","\033[31m╨\u001B[0m","\033[34m❦\u001B[0m"};
	private int estadoNum;
	public int getEstadoNum() {
		return estadoNum;
	}
	private int contEstado;
	
	public int getContEstado() {
		return contEstado;
	}

	public void setContEstado(int contEstado) {
		this.contEstado = contEstado;
	}

	public void setEstadoNum(int estadoNum) {
		this.estadoNum = estadoNum;
	}

	public String getEstado() {
		return estados[estadoNum];
	}


	public String getAspecto() {
		return aspecto;
	}

	private String aspecto;
	private int daño;
	private int vida;
	private int vidaActual;
	
	public Enemigo(int lvl,Equipo e) {
		vivo=true;
		estadoNum=0;
		aspecto=aspectos[lvl-1];
		int nivelarDaño=(e.getEquipoPos(0).getVida()+e.getEquipoPos(1).getVida()/2)/7;
		int nivelarVida=(e.getEquipoPos(0).getAtaque()+e.getEquipoPos(1).getAtaque()/2)*14;
		vida=(int) (Math.random()*(lvl*nivelarVida))+lvl*nivelarVida/2;
		daño=(int) (Math.random()*(lvl*nivelarDaño))+lvl*nivelarDaño/2;
		if(lvl==2) {
			vida=vida/2;
			daño=daño/2;
		};
		vidaActual=vida;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
		if(this.vidaActual<1) {
			vivo=false;
		}
	}

	public boolean isVivo() {
		return vivo;
	}

	public int getDaño() {
		return daño;
	}

	public int getVida() {
		return vida;
	}
	
}
