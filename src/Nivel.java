
public class Nivel {
	private int númeroNivel;
	private int númeroEnemigos;
	private Enemigo enemigos[]=new Enemigo[númeroEnemigos];
	private Personaje p1;
	private Personaje p2;
	
	public Nivel(int númeroNivel,Personaje p1,Personaje p2) {
		this.númeroNivel=númeroNivel;
		this.p1=p1;
		this.p2=p2;
		númeroEnemigos=númeroNivel;
		if(númeroEnemigos>3) {
			númeroEnemigos=1;
		}//if
		for(int i=0;i<númeroEnemigos;i++) {
			enemigos[i]=new Enemigo(i);
		}//fori
	}
}
