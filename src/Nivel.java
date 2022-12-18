
public class Nivel {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Datos que guarda el nivel
	private int numRonda=1;
	private int númeroNivel;
	private int númeroEnemigos;
	private static Enemigo enemigos[];//Array con los enemigos que hay en ese nivel
	private Equipo e1=new Equipo();//El equipo que esta jugando al nivel
	private String lápida[]={""
			+ "      _____\n"
			+ "     |R.I.P|\n"
			+ "     |     |\n"		
	+ "    \033[33m~~~~~~~~~\u001B[0m\n",
			  "                                        _____\n"
			+ "                                       |R.I.P|\n"
			+ "                                       |     |\n"		
	+ "                                      \033[33m~~~~~~~~~\u001B[0m\n"};
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Metodo para crear un nivel, en el que se manda el número de nivel y el equipo que lo va a jugar
	public Nivel(int númeroNivel,Equipo e1) {
		this.númeroNivel=númeroNivel;
		this.e1=e1;
		//El número de enemigos será igual al del nivel menos en el 3 que habrá un solo jefe final
		númeroEnemigos=númeroNivel;
		if(númeroEnemigos>2) {
			númeroEnemigos=1;
		}//if
		//Crea un nuevo grupo de enemigos con la cantidad indicada
		enemigos=new Enemigo[númeroEnemigos];
		//En cada posición del grupo crea un nuevo enemigo, el cual generara todos sus datos internos
		for(int i=0;i<númeroEnemigos;i++) {
			enemigos[i]=new Enemigo(númeroNivel,e1);
		}//fori
	}//Nivel
	
	//Avanza una ronda, haciendo que los enemigos ataquen 
	public void ronda() {
		//Recorre el grupo de enemigos para que todos ataquen
		for(int i=0;i<enemigos.length;i++) {
			//Comprueba que no esta enamorado, ya que sino no puede atacar
			if(enemigos[i].getEstadoNum()!=2) {
				//Crea un número aleatorio para atacar de forma aleatoria a uno de los personajes
				int objetivo=(int) (Math.random()*10)+1;
				if(objetivo<=5) {
					//Comprueba que esta vivo y sino ataca al otro ------------------------------------------------------------┐
					if(e1.getEquipoPos(0).isVivo()) {//                                                                        |
					//Compreuba que no tiene un escudo ---------------------------------------------------------------┐        |
						if(e1.getEquipoPos(0).getEstadoNum()!=1) {//                                                  |        |
								daño(e1.getEquipoPos(0),i);//                                                         |        |
						}else {//Si tiene escudo suma al contador de estado y si llega a dos le quita el escudo ------┘        |
							e1.getEquipoPos(0).setContEstado(e1.getEquipoPos(0).getContEstado()+1);//                          |
							if(e1.getEquipoPos(0).getContEstado()==2) {//-----┐                                                |
								e1.getEquipoPos(0).setEstadoNum(0);//---------┘                                                |
							}//if                                                                                              |
						}//else                                                                                                |
					}else daño(e1.getEquipoPos(1),i);//------------------------------------------------------------------------┘
				}//atq a p1
				else {
					//Comprueba que esta vivo y sino ataca al otro ------------------------------------------------------------┐
					if(e1.getEquipoPos(1).isVivo()) {//                                                                        |
					//Compreuba que no tiene un escudo ---------------------------------------------------------------┐        |
						if(e1.getEquipoPos(1).getEstadoNum()!=1) {//                                                  |        |
								daño(e1.getEquipoPos(1),i);//                                                         |        |
						}else {//Si tiene escudo suma al contador de estado y si llega a dos le quita el escudo ------┘        |
							e1.getEquipoPos(1).setContEstado(e1.getEquipoPos(1).getContEstado()+1);//                          |
							if(e1.getEquipoPos(1).getContEstado()==2) {//-----┐                                                |
								e1.getEquipoPos(1).setEstadoNum(1);//---------┘                                                |
							}//if                                                                                              |
						}//else                                                                                                |
					}else daño(e1.getEquipoPos(0),i);//------------------------------------------------------------------------┘
				}//atq a p2
			}//ifNoEnamorado
			//si lo está no atacará y dejará de estarlo
			else enemigos[i].setEstadoNum(0);
			//Si se esta quemando se le quitará un 10% de su vida máxima y se restará al contador de estado para que dure 3 rondas
			if(enemigos[i].getEstadoNum()==1) {
				if(enemigos[i].getContEstado()>0) {
					enemigos[i].setVidaActual((int) (enemigos[i].getVidaActual()-(enemigos[i].getVida()*0.1)));
					enemigos[i].setContEstado(enemigos[i].getContEstado()-1);
				}
				else enemigos[i].setEstadoNum(0);
			}
		}//for
		numRonda++;
	}//atqEnem
	
	//Metodo para hacer daño a un personaje, que recibe el personaje al que dañar y el número del enemigo que lo va a dañar
	private void daño(Personaje p,int i) {
		//Si el golpe te mata y tenías más de uno de vida, te de una te deja a uno de vida (para dar más emoción ante golpes mortales)
		if(p.getVidaActual()>1) {
			p.setVidaActual(p.getVidaActual()-enemigos[i].getDaño());
			if(p.getVidaActual()<1) {
				p.setVidaActual(1);
			}//if
		}//if
		//Si ya tenías uno de vida sí que te mata
		else p.setVidaActual(0);
	}
	
	//Metodo para pasar un nivel a String el cual pinta a los enemigos del nivel con su vida actual y a los personajes
	public String toString() {
		String res="\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
		for(Enemigo i:enemigos) {//Si uno de los enemigos esta muerto pinta en su lugar una lápida
			if(i.isVivo()==false) {
				res+="\n         \n"+lápida[1];
			}//if
			else {
				res+="                                       \033[31m♥"+i.getVidaActual()+"\u001B[0m "+i.getEstado()+"\n";
				res+=String.format("%100s\n\n", i.getAspecto());
			}
		}
		res+=pintaPersonaje(e1.getEquipoPos(0));
		res+=pintaPersonaje(e1.getEquipoPos(1));
		return res;
	}
	
	//Metodo al que llama el nivel para pintar un personaje con una representación similar a la de los enemigos
	private String pintaPersonaje(Personaje p) {
		String res="";
		if(p.isVivo()==false) {//Al igual que los enemigos si un personaje muere en su lugar saldrá una lápida
			res+="\n         \n"+lápida[0];
		}//if
		else {
			res+="\n        \033[31m♥"+p.getVidaActual()+"\u001B[0m "+p.getEstado()+"\n"+p.getAspecto().substring(1);
		}

		return res;
	}//pintaPersonaje

	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
	
	//Getters y setters
	
	public Enemigo[] getEnemigos() {
		return enemigos;
	}

	public int getNúmeroNivel() {
		return númeroNivel;
	}
	public int getNumRonda() {
		return numRonda;
	}
	
	//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
	
	}
