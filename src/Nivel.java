
public class Nivel {
	private int númeroNivel;
	private int númeroEnemigos;
	private Enemigo enemigos[];
	private Personaje p1;
	private Personaje p2;
	
	public Nivel(int númeroNivel,Personaje p1,Personaje p2) {
		this.númeroNivel=númeroNivel;
		this.p1=p1;
		this.p2=p2;
		númeroEnemigos=númeroNivel;
		if(númeroEnemigos>2) {
			númeroEnemigos=1;
		}//if
		enemigos=new Enemigo[númeroEnemigos];
		for(int i=0;i<númeroEnemigos;i++) {
			enemigos[i]=new Enemigo(númeroNivel-1);
		}//fori
	}//Nivel
	
	public void atqEnem() {
		for(int i=0;i<enemigos.length;i++) {
			int objetivo=(int) (Math.random()*10)+1;
			if(objetivo<5) {
				p1.setVidaActual(p1.getVidaActual()-enemigos[i].getDaño());
			}//atq a p1
			else {
				p2.setVidaActual(p2.getVidaActual()-enemigos[i].getDaño());
			}//atq a p
		}
	}//atqEnem
	
	public String toString() {
		String res="";
		for(Enemigo i:enemigos) {
			res+="                                       ♥"+i.getVidaActual()+"\n";
			res+=String.format("%100s\n\n", i.getAspecto());
		}
		res+="        ♥"+p1.getVidaActual()+"\n"+p1.getAspecto()+"        ♥"+p2.getVidaActual()+"\n"+p2.getAspecto();
		return res;
	}
}
