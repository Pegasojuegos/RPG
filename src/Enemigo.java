
public class Enemigo {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Datos que almacena un enemigo
	private int daño;
	private int vida;
	private int vidaActual;
	//Lista con todos los aspectos disponibles (tienen colores de ahí esos códigos)
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

	private String aspecto;//Que aspecto de la lista tiene 
	private boolean vivo;
	//Estados disponibles:Sin estado, fuego, enamorado
	private final String estados[]= {" ","\033[33m╨\u001B[0m","\033[35m❦\u001B[0m"};
	private int estadoNum;
	private int contEstado;
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Metodo para crear un nuevo enemigo en el que hay que indicar el nivel en el que va estar y contra que 
	//equipo se va a enfrentar para así poder nivelarlo
	public Enemigo(int lvl,Equipo e) {
		vivo=true;
		estadoNum=0;
		aspecto=aspectos[lvl-1];
		
		//El daño que hará se calcula dividiendo la media de la vida del equipo entre 7 lo que haría que de 
		//media aguanten 7 golpes
		int nivelarDaño=(e.getEquipoPos(0).getVida()+e.getEquipoPos(1).getVida()/2)/7;
		//La vida que tendrá el enemigo será igual a la media del ataque que haga el equipo al que se enfrenta
		//entre 14, lo que hará que aguante 14 golpes de media
		int nivelarVida=(e.getEquipoPos(0).getAtaque()+e.getEquipoPos(1).getAtaque()/2)*14;
		
		//Para que suba la dificultad con el nivel, su vida y su daño se multiplicará por el número de nivel.
		//Para que no siempre tengan la misma vida y daño, se creará un número aleatorio ente el número obtenido al multiplicar por el nivel
		//y el obtenido al dividirlo entre dos.
		vida=(int) (Math.random()*(lvl*nivelarVida))+lvl*nivelarVida/2;
		daño=(int) (Math.random()*(lvl*nivelarDaño))+lvl*nivelarDaño/2;
		
		//En el nivel 2 al haber 2 enemigos se divide tanto el daño como la vida entre 2
		if(lvl==2) {
			vida=vida/2;
			daño=daño/2;
		}
		vidaActual=vida;
	}
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Getters y setters
	public int getContEstado() {
		return contEstado;
	}
	public int getEstadoNum() {
		return estadoNum;
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
	public int getVidaActual() {
		return vidaActual;
	}
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
		//Si su vida esta por debajo de uno muere
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
	
	//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛

}
