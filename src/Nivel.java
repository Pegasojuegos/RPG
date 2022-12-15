
public class Nivel {
	private int numRonda=1;
	public int getNumRonda() {
		return numRonda;
	}

	private int númeroNivel;
	private int númeroEnemigos;
	private static Enemigo enemigos[];
	private Equipo e1=new Equipo();
	private String lápida=""
			+ "      _____\n"
			+ "     |R.I.P|\n"
			+ "     |     |\n"		
			+ "    ~~~~~~~~~\n";
	
	public Nivel(int númeroNivel,Equipo e1) {
		this.númeroNivel=númeroNivel;
		this.e1=e1;
		númeroEnemigos=númeroNivel;
		if(númeroEnemigos>2) {
			númeroEnemigos=1;
		}//if
		enemigos=new Enemigo[númeroEnemigos];
		for(int i=0;i<númeroEnemigos;i++) {
			enemigos[i]=new Enemigo(númeroNivel,e1);
		}//fori
	}//Nivel
	
	public void ronda() {
		for(int i=0;i<enemigos.length;i++) {
			if(enemigos[i].getEstadoNum()!=2) {
				int objetivo=(int) (Math.random()*10)+1;
				if(objetivo<5) {
					//Compreuba que no tiene un escudo y si lo teine no ataca pero se lo quita
					if(e1.getEquipoPos(0).getEstadoNum()!=1) {
						daño(e1.getEquipoPos(0),i);
					}else e1.getEquipoPos(0).setEstadoNum(0);
				}//atq a p1
				else {
					if(e1.getEquipoPos(1).getEstadoNum()!=1) {
						daño(e1.getEquipoPos(1),i);
					}else e1.getEquipoPos(1).setEstadoNum(0);
				}//atq a p
			}//ifNoEnamorado
			//si lo está no atacará y dejará de estarlo
			else enemigos[i].setEstadoNum(0);
			if(enemigos[i].getEstadoNum()==1) {
				if(enemigos[i].getContEstado()>0) {
					enemigos[i].setVidaActual((int) (enemigos[i].getVidaActual()-(enemigos[i].getVida()*0.05)));
					enemigos[i].setContEstado(enemigos[i].getContEstado()-1);
				}
				else enemigos[i].setEstadoNum(0);
			}
		}//for
		numRonda++;
	}//atqEnem
	
	private void daño(Personaje p,int i) {
		//Si el golpe te mata y tenías más de uno de vida, te de una te deja a uno de vida
		if(p.getVidaActual()>1) {
		p.setVidaActual(p.getVidaActual()-enemigos[i].getDaño());
		
			if(p.getVidaActual()<1) {
				p.setVidaActual(1);
			}//if
		}//if
		else p.setVidaActual(0);
	}
	
	public String toString() {
		String res="";
		for(Enemigo i:enemigos) {
			res+="                                       ♥"+i.getVidaActual()+" "+i.getEstado()+"\n";
			res+=String.format("%100s\n\n", i.getAspecto());
		}
		res+=pintaPersonaje(e1.getEquipoPos(0));
		res+=pintaPersonaje(e1.getEquipoPos(1));
		return res;
	}
	
	private String pintaPersonaje(Personaje p) {
		String res="";
		if(p.isVivo()==false) {
			res+="\n         \n"+lápida;
		}//if
		else {
			res+="\n        ♥"+p.getVidaActual()+" "+p.getEstado()+"\n"+p.getAspecto().substring(1);
		}

		return res;
	}//pintaPersonaje

	public Enemigo[] getEnemigos() {
		return enemigos;
	}

	public int getNúmeroNivel() {
		return númeroNivel;
	}
	
	
	}
