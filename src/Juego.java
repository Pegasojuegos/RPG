import java.util.Scanner;

public class Juego {

	public static void main(String[] args) {
		String aspectos[]={
			      "       √°}\r\n"
				+ "       [|]\\•\r\n"
				+ "        |",
				
				  "      | •|  /   \r\n"
				+ "      ( |)\\/\r\n"
				+ "        |,",
				
		 		  "        (°} ☼\r\n"
				+ "       /[|]\\|\r\n"
				+ "      /  |. |",
		};
		String hechizos[]= {"Fuego","Sanación","Furia"};
		Personaje p1=new Personaje(10,"Mago",2,"fuego",aspectos[1]);
		Personaje p2=new Personaje(20,"Guerrero",8,"furia",aspectos[2]);
		Equipo e1=new Equipo();
		e1.añadirMiembro(p1, 0);
		e1.añadirMiembro(p2, 1);
		Equipo e2=new Equipo();
		
		int personajes=0;
		
		Scanner s= new Scanner(System.in);
		System.out.println("| Nuevo personaje | Borrar personaje | Ver personaje");
		String operación=s.nextLine();
		while(!operación.equals("FIN")) {
			switch (operación) {		
			case "Nuevo personaje":
				if (personajes<=2) {
				//pido todos los datos del nuevo personaje
				System.out.print("Nombre: ");
				String nombre=s.nextLine();
				System.out.println();
				
				System.out.print("Puntos de vida: ");
				int vida=s.nextInt();
				System.out.println();

				System.out.print("Puntos de daño: ");
				int daño=s.nextInt();
				s.nextLine();
				System.out.println();
				
				System.out.print("Hechizos: ");
				for(String i:hechizos) {
					System.out.print(i+" | ");
				}
				System.out.println();
				 
				String hechizo=""; 
				boolean correcto=false;
				while (correcto==false) {
					System.out.print("Hechizo conocido: ");
					hechizo=s.nextLine();
					for(String i:hechizos) {
						if(i.equalsIgnoreCase(hechizo)) {
							correcto=true;
							break;
						}
					}
					System.out.println("Hechizo erróneo");
				}
				
				for(int i=0;i<aspectos.length;i++) {
					System.out.println("•------|"+(i+1)+"|------•");
					System.out.println(aspectos[i]);
				}
				System.out.print("Aspecto: ");
				int aspecto=s.nextInt()-1;
				s.nextLine();
				
				//creo el nuevo personaje
				e2.añadirMiembro(new Personaje(vida,nombre,daño,hechizo,aspectos[aspecto]), personajes);
				System.out.println("¡"+nombre+" se ha unido al equipo!");
				personajes++;
				}
				operación=s.nextLine();
				break;
			case "Borrar personaje":
				System.out.print("Nombre del personaje a borrar: ");
				String nomb=s.nextLine();
				System.out.println("¿Seguro que quieres borrar los datos de "+nomb+"?");
				String conf=s.nextLine();
				if(conf.equalsIgnoreCase("si")) {
					for(Personaje i:e2.getEquipo()) {
						if(i!=null) {
							if(i.getNombre().equalsIgnoreCase(nomb)) {
								i=null;
								System.out.println(nomb+" ha sido borrado correctamente");
								operación=s.nextLine();
								break;
							}
							else {
								System.out.println(nomb+" no esta en el equipo");
							}
						}else System.out.println("Falta personaje");
					}//fori
				}//ifsi
				else {
					if(conf.equalsIgnoreCase("no")) {
						System.out.println("Borrado de "+nomb+" cancelado");
						operación=s.nextLine();
					}//ifno
					else {
						System.out.println("Error, opciones válidas: si | no");
						conf=s.nextLine();
					}//else error
				}//else
			case "Ver equipo":
				System.out.println(e2);
				operación=s.nextLine();
				break;
				
				
			default:
				
			}
		}
	}

}
