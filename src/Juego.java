import java.util.Scanner;

public class Juego {
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Datos iniciales
	public static void main(String[] args) {
		Equipo e3=new Equipo();//Equipo que se igualará al que va a jugar el juego (el por degfecto o el personalizado)
		
		//Creación de un equipo con dos personajes por defecto
		Personaje p1=new Personaje(10,"Mago",2, Hechizo.selectHechizo(0),Personaje.selecAspecto(2));
		Personaje p2=new Personaje(20,"Guerrero",8,Hechizo.selectHechizo(3),Personaje.selecAspecto(1));
		Equipo e1=new Equipo();
		e1.añadirMiembro(p1, 0);
		e1.añadirMiembro(p2, 1);
		
		//Equipo que será personalizable
		Equipo e2=new Equipo();
		int personajes=0;//Contador de cuantos personajes creados hay
		
		//Opciones del menú de inicial
		String opciónesIniciales="| Nuevo personaje | Borrar personaje | Ver equipo | Jugar |";
		
		
		Scanner s= new Scanner(System.in);
		//Texto inicial con el contexto del juego y una breve explicación de los hechizos y como jugar
		System.out.println(""
				+ "Al principio eran unos simples monstruos que no representaban una gran amenaza,\n"
				+ "pero en los últimos años han ido aumentando su fuerza y cada vez son más frecuentes\n"
				+ "las desapariciónes de campesinos debida a estos montruos denominados Clucks.\n"
				+ "Los habitantes de Ulkar buscan desesperados ayuda por todos los reinos pero al ser\n"
				+ "un pequeña aldea sin gran importancia económica todos hacen caso omiso a su petición.\n"
				+ "Tú y tu fiel compañero habéis escuchado sobre su petición de ayuda y decidís acercaros\n"
				+ "a la aldea para prestar vuestra ayuda y conseguir una buena recompensa, pues no creéis\n"
				+ "que sea un gran reto para vosotros que tenéis siglos de experiencia enfrentadoos a \n"
				+ "todo tipo de criaturas, y esta vez simplemente son unos aldeanos pidiendo ayuda. \n"
				+ "O tal vez no...\n\n"
				+ ""
				+ "Crea un equipo de dos personajes para intentar enfrentarte a los Clucks y salbar a los\n"
				+ "habitantes de Ulkar, o intentarlo.\n"
				+ "-Para seleccionar una de las opciónes disponibles escribe tal cual la opción deseada y\n"
				+ "pulsa enter."
				+ "-A la hora de crear un personaje deberas introducir los datos pedidos y elegir un\n"
				+ "hechizo entre los siguientes:\n"
				+ "	+Llama del dragón: quema al enemigo seleccionado durante las próximas 3 róndas.\n"
				+ "	 Un enemigo que se etá quemando sufre un daño igual al 10% de su vida máxima.\n"
				+ "	+Sanación: cura al alado seleccionado un 25% de su vida máxima.\n"
				+ "	+Beso de la muerte: enamora a un enemigo, lo cual le impedira atacar, el \n"
				+ "	 enamoramiento dura una ronda.\n"
				+ "	+Furia vikinga: aumenta en un 50% el daño que realizas en tus próximos 3 ataques\n"
				+ "	+Caelestis protector: pone un escudo a un aliado que bloquea los próximos\n"
				+ "	 2 ataques que reciba.\n"
				+ "-Durante el combate tendrás que selecciónar la opción deseada mediante 1 o 2 al igual\n"
				+ "el objetivo a quien va dirigira."
				+ "-Tras cada nivel los personajes se tomarán un descanso en el que se curaran toda la\n"
				+ "vida y si uno de ellos ha muerto revivirá con el máximo de vida. Para finalizar este\n"
				+ "descnaso simplemente debrás pulsar enter.");
		System.out.println(opciónesIniciales);//Muestra las opciones
		String operación=s.nextLine();//Pide una primera operación
		boolean inicio=false;
		
		//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
		
		//Menú de creación de personajes
		while(inicio==false) {//Seguirá comparando las opciones dadas hasta que vaya a iniciar el juego
			switch (operación) {		
			
			//Añadir un nuevo personaje al equipo
			case "Nuevo personaje":
				if (personajes<2) {//Si no hay ya dos creados
				
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
				
				//Muestra todos los hechizos disponibles
				System.out.print("Hechizos: ");
				for(String i:p1.getHechizo()) {
					System.out.print(i+" | ");
				}
				System.out.println();
				//Comprueba si el hechizo introducido es válido
				String hechizo=""; 
				boolean correcto=false;
				while (correcto==false) {
					System.out.print("Hechizo conocido: ");
					hechizo=s.nextLine();
					for(String i:p1.getHechizo()) {
						if(i.equalsIgnoreCase(hechizo)) {
							correcto=true;
							break;
						}
					}
					if (correcto==false) System.out.println("Hechizo erróneo");
				}
				
				//Muestra los aspectos disponibles
				for(int i=0;i<Personaje.getListaAspectos().length;i++) {
					System.out.println("•------|"+(i+1)+"|------•");
					System.out.println(Personaje.selecAspecto(i));
				}
				//Pide un número de aspecto
				System.out.print("Aspecto: ");
				int aspecto=s.nextInt()-1;
				s.nextLine();
			
				
				//Crea el nuevo personaje y lo añade al equipo
				e2.añadirMiembro(new Personaje(vida,nombre,daño,hechizo,Personaje.selecAspecto(aspecto)), personajes);
				System.out.println("¡"+nombre+" se ha unido al equipo!");
				personajes++;
				}
				//si ya hay dos personajes creados dice que el quipo está completo y no deja añadir uno nuevo
				else {
					System.out.println("Equipo comleto");
					System.out.println(opciónesIniciales);
					operación=s.nextLine();
					break;
				}
				
				
				//Pide siguiente operación
				System.out.println(opciónesIniciales);
				operación=s.nextLine();
				break;
				
				
				//Borrar un personaje creado
			case "Borrar personaje":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.print("Nombre del personaje a borrar: ");
				String nomb=s.nextLine();
				System.out.println("¿Seguro que quieres borrar los datos de "+nomb+"?");//Pide confirmación
				String conf=s.nextLine();
				
				if(conf.equalsIgnoreCase("si")) {//Confirmar borrado
					for(Personaje i:e2.getEquipo()) {//Recorre el equipo en busca del nombre dado
						int cont=0;
						//Si hay un personaje y coincide con el nombre lo borra, sino  vuelve a pedir operación
						if(i!=null) {
							if(i.getNombre().equalsIgnoreCase(nomb)) {//Ha encontrado el personaje y lo borra
								i=null;
								personajes--;
								System.out.println(nomb+" ha sido borrado correctamente");
								System.out.println(opciónesIniciales);
								operación=s.nextLine();
								break;
							}
							else {//No ha encontrado el personaje así que vuelve a pedir operación
								System.out.println(nomb+" no esta en el equipo");
								System.out.println(opciónesIniciales);
								operación=s.nextLine();
							}
						}else {
							if(cont<2) cont++;
							else {//Si no hay ningún personaje creado lo dirá
								System.out.println("Equipo vacío");
								System.out.println(opciónesIniciales);
								operación=s.nextLine();
							}
						}
					}//fori
				}//ifsi
				else {
					if(conf.equalsIgnoreCase("no")) {//Cancelar borrado
						System.out.println("Borrado de "+nomb+" cancelado");
						System.out.println(opciónesIniciales);
						operación=s.nextLine();
					}//ifno
					else {//Si no coincide ni con si ni con no dirá que esas son las únicas opciones válidas
						System.out.println("Error, opciones válidas: si | no");
						conf=s.nextLine();
					}//else error
				}//else
				
				//Escribe el equipo por pantalla con el método toString de Equipo que a su vez llama al de cada personaje
			case "Ver equipo":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(e2);
				System.out.println(opciónesIniciales);
				operación=s.nextLine();
				break;
				
				//Iniciar el juego
			case "Jugar":
				int contador=0;
				//Comprueba si se ha completado el quipo personalizado
				for(Personaje i:e2.getEquipo()) {
					if(i==null) {
						contador++;
					}
				}
				if(contador>0) {
						//si el equipo no está completo te da opción de usar uno por defécto
						System.out.println("Equipo incompleto. ¿Deseas continuar con el equipo por defecto?");
						String confir=s.nextLine();
						if(confir.equalsIgnoreCase("si")) {
								e3=e1;//Iguala el quipo que va a jugar con el por defecto
								inicio=true;
								break;
						}//ifsi
						else {
							if(confir.equalsIgnoreCase("no")) {
									System.out.println(opciónesIniciales);
									operación=s.nextLine();
									break;
							}//ifno
							else {
									System.out.println("Error, opciones válidas: si | no");
									conf=s.nextLine();
							}//else error
						}//else
				}
				else {
					e3=e2;//Iguala el equipo que va a jugar con el personalizado
					inicio=true;
					break;
				}
				
				//Si la operación introducida no cincide con nignuna volverá a pedirla
			default:
				System.out.println("Operación no válida");
				System.out.println(opciónesIniciales);
				operación=s.nextLine();
			}//switch
		}//while
		
		//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

		//Empiza el juego
		
		//Variables iniciales necesarias para jugar 
		boolean finJuego=false;
		int numNivel=1;
		Nivel nivel=new Nivel(numNivel,e3);
		int enemDerrotados=0;
		int opción;
		
		//El juego seguirá hasta que mates al jefe final o ambos personajes estén muertos a la vez
		while(finJuego==false) {
			System.out.println(nivel);
			//recorre todos los personajes del equipo
			for(Personaje p:e3.getEquipo()) {
				
				//Comprueba que el personaje está vivo ya que sino no puede atacar
				if(p.isVivo()) {
					//Pide número de acción a realizar y llama a la función correspondiente
					opción=opciones(p);
					if(opción==1) atacar(p,nivel);
					if(opción==2) hechizar(p, nivel, e3);
					
				}//if vivo
			}//for Acciones personajes
			
			//Tras atacar los personajes hace que el nivel avance una ronda, atacando de esta forma los enemigos
			nivel.ronda();
			
			//Contador de enemigos derrotados
			for(Enemigo en:nivel.getEnemigos()) {
				if(en.getVidaActual()<1) {
					enemDerrotados++;
				}
			}//for enemDerrotados
			
			//Si el contador de enemigos derrotados es igual al total de enemigos 
			if(enemDerrotados==nivel.getEnemigos().length) {
				enemDerrotados=0;
				numNivel++;//Pasa al próximo nivel
				descansar(e3);//Hace que el equipo descanse
				nivel=new Nivel(numNivel,e3);
			}//if
			//Si no están todos derrotados vuelve a poner el contador a 0
			else enemDerrotados=0;
			
			//Si pasa el nivel 3 Ganará y se acabará el juego
			if (nivel.getNúmeroNivel()>3) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                 ¡Victória!\n\n\n\n\n\n\n");
				finJuego=true;
			};
			//Si todos los personajes mueren perderá y se acabará el juego
			if(e3.getEquipoPos(0).isVivo()==false&e3.getEquipoPos(1).isVivo()==false) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n                                 ¡Fin del juego!\n\n\n\n\n\n\n");
				finJuego=true;
			}
		}//finJuego
	
		
	}//main
	
	//┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓

	//Funciones
	
	//Llama a la función de descanso del propio equipo y muestra que los personajes descansan junto a la hogera
	public static void descansar(Equipo e) {
		e.Descanso();//Metodo de descanso del propio equipo
		//Pinta los personajes descnansando en la hoguera
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+e.getEquipoPos(0).getAspecto()+""
				+ "\n                \u001B[0m░"
				+ "\n                \033[31mω"
				+ "\n               \033[33m===\u001B[0m\n"+e.getEquipoPos(1).getAspecto());
		System.out.println("| Siguiente nivel |");
		Scanner s=new Scanner(System.in);
		s.nextLine();
	}
	
	//Función que muestra y pide las opcion durante el combate
	public static int opciones(Personaje p) {
		//Muestra las opciones
		System.out.printf("• %s\n    └➔Atacar\n    └➔%s\n    └:",p.getNombre(),p.getHechizoAprendido().getHechizo());
		Scanner s=new Scanner(System.in);
		int res=s.nextInt();
		//Pide una opción hasta que coincida con 1 o 2 y devuelve este número
		while(res!=1&res!=2) res=s.nextInt();		
		return res;
	}
	
	//Fucnión para que un personaje ataque a un enemigo
	public static void atacar(Personaje atacante,Nivel lvl) {
		int objetivo=0;
		if(lvl.getNúmeroNivel()==2) {//En el nivel 2 al haber 2 enemigos pregunta a cual atacar
			System.out.println("Enemigo:");
			Scanner s=new Scanner(System.in);
			objetivo=s.nextInt()-1;
		}
		//Hace un daño al objetivo igual al daño del atacante
		lvl.getEnemigos()[objetivo].setVidaActual(lvl.getEnemigos()[objetivo].getVidaActual()-atacante.getAtaque());
		System.out.println(lvl);//Vuelve a escribir el nivel (con la nueva vida del enemigo)
	}//atacar
	
	//Función para lanzar un hechizo
	public static void hechizar(Personaje atacante,Nivel lvl,Equipo e) {
		//Pide el objetivo al que va dirigido
		int objetivo;
		System.out.println("Objetivo:");
		Scanner s=new Scanner(System.in);
		objetivo=s.nextInt()-1;
		String hechizoAUsar=atacante.getHechizoAprendido().getHechizo();
		//Si es un echizo para un aliado 
		//Esto lo sabe comparando el hechizo que sabe hacer el personaje con las posiciones de la lista de hechizo
		if(hechizoAUsar.equals((Hechizo.selectHechizo(1)))|(hechizoAUsar.equals((Hechizo.selectHechizo(3)))|(hechizoAUsar.equals((Hechizo.selectHechizo(4)))))){
			atacante.getHechizoAprendido().usarHechizoAliado(e.getEquipoPos(objetivo));
		}//if aliado
		//Si es un echizo para un enemigo
		if(hechizoAUsar.equals((Hechizo.selectHechizo(0)))|(hechizoAUsar.equals((Hechizo.selectHechizo(2))))){
			atacante.getHechizoAprendido().usarHechizoEnemigo(lvl.getEnemigos()[objetivo]
					);
		}//if aliado
		System.out.println(lvl);

	}

	//┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━•(=^●ω●^=)•━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛

}
