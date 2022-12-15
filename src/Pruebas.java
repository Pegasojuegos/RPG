
public class Pruebas {

	public static void main(String[] args) {
		Personaje p0=new Personaje();
		Personaje p1=new Personaje(10,"Mago",2, Hechizo.selectHechizo(0),Personaje.selecAspecto(2));
		Personaje p2=new Personaje(20,"Guerrero",8,Hechizo.selectHechizo(3),Personaje.selecAspecto(1));
		Equipo e1=new Equipo();
		e1.añadirMiembro(p1, 0);
		e1.añadirMiembro(p2, 1);
		Nivel uno=new Nivel(2,e1);
		uno.atqEnem();
		System.out.println(uno);
		uno.atqEnem();
		uno.getEnemigos();
		System.out.println(uno);
		
	}

}
