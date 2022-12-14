
public class Nivel {
	private int númeroNivel;
	private int númeroEnemigos;
	private Enemigo enemigos[];
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
	
	public void atqEnem() {
		for(int i=0;i<enemigos.length;i++) {
			int objetivo=(int) (Math.random()*10)+1;
			if(objetivo<5) {
				daño(e1.getEquipoPos(0),i);
			}//atq a p1
			else {
				daño(e1.getEquipoPos(1),i);
			}//atq a p
		}
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
		if(p.getVidaActual()<1) {
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
	
	
	}
