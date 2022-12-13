
public class Pruebas {

	public static void main(String[] args) {
		Personaje p0=new Personaje();
		Personaje p1=new Personaje(10,"Mago",2,"fuego",p0.getAspectos(1));
		Personaje p2=new Personaje(20,"Guerrero",8,"furia",p0.getAspectos(2));
		Nivel uno=new Nivel(3,p1,p2);
		System.out.println(uno);
	}

}
