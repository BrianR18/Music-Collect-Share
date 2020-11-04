package ui;
import model.MCS;
import java.util.Scanner;

public class Menu{
	
	//Main menu
	private final int ADD_USERS = 1;
	private final int SEE_USERS = 2;
	private final int ADD_SONG = 3;
	private final int SEE_SONGS = 4;
	private final int ADD_PLAYLIST = 5;
	private final int ADD_SONG_TO_PLAYLIST = 6;
	private final int SEE_PLAYLIST = 7;
	private final int EXIT = 8;
	
	//Choose playlist
	private final int PUBLIC = 1;
	private final int RESTRICTED = 2;
	private final int PRIVATE = 3;
	
	private Scanner sc = new Scanner(System.in);
	private MCS mcs;
	
	public Menu(){
		mcs = new MCS();
	}//End constructor

	public void showLogo(){
		String logo =   "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
					    "((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((  ((((((((*  ((((((((,      (((((((     ((((\n" +
						"((((   (((((((   ((((((   /((((((((((.  ((((((((\n" +
						"((((    ((((((   (((((*  ((((((((((((  /((((((((\n" +
						"((((    /((((*   (((((*  ((((((((((((   ((((((((\n" +
						"((((  (  ((((    (((((.  ((((((((((((/  *(((((((\n" +
						"((((  (. ,((*    *((((.  (((((((((((((/  .((((((\n" +
						"((((  ((  ((  (  ,((((.  (((((((((((((((   (((((\n" +
						"((((  ((* ,, .(  (((((.  ((((((((((((((((   ((((\n" +
						"((((  (((    ((  (((((,  (((((((((((((((((   (((\n" +
						"((((  (((   ,((  (((((/  ((((((((((((((((((  /((\n" +
						"((((  /((   (((  ((((((  ,(((((((((((((((((  *((\n" +
						"((((  /((((((((  ((((((/  .(((((((((((((((   (((\n" +
						"((((  /((((((((  ((((((((       ((((* .(*   ((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"				     .#//////#.\n"+                                               
						"               .###/         /###.\n"+
						"            ##                     ##\n"+
						"          #*                         /#\n"+         
						"        .#       ///////////////       #(\n"+        
						"        #     /////////////////////     #,\n"+       
						"       /#   *///////////////////////,   ##\n"+     
						"     ,///////////////////////////////*//////\n"+     
						"     /////////////////////......////////////\n"+    
						"     //////..........................,//////\n"+   
						"     //////........((.......*(*......,//////\n"+  
						"     //////..........................,//////\n"+ 
						"      *///, .......,/......../....... ,////\n"+
						"              .......//,..*/*......\n"+
						"                  .............\n";              
		System.out.println(logo);
		sc.nextLine();
		System.out.println("\n\n\n\nBIENVENIDO!!!\n\n\n");
		sc.nextLine();
	}//End showLogo.
	
	public void showMenu(){
		System.out.println("\n");
		System.out.println("[1]Agregar usuario.\n");
		System.out.println("[2]Listar usuarios.\n");
		System.out.println("[3]Agregar cancion a la pool.\n");
		System.out.println("[4]Listar canciones de la pool.\n");
		System.out.println("[5]Crear playlist.\n");
		System.out.println("[6]Agregar cancion a la playlist\n");
		System.out.println("[7]Listar playlist existentes.\n");
		System.out.println("[8]Salir\n");
	}//End showMenu
	
	public int readOption(){
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}//End readOption.
	
	public void readUsersData(){
		System.out.print("\nIngrese el apodo del usuario: ");
		String name = sc.nextLine();
		while(mcs.checkName(name)){
			System.out.println("\""+name+"\" ya esta en uso.Elige un apodo distinto.");
			System.out.print("\nIngrese el apodo del usuario: ");
			name = sc.nextLine();
		}//End while
		System.out.print("Contrasenia: ");
		String password = sc.nextLine();
		System.out.print("Ingrese su edad: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("\n" + mcs.addUser(name,password,age));
	}//End readUsersData
	
	public void readSongData(){
		System.out.print("\nIngrese el nombre sel usuario que creara la cancion: ");
		String user = sc.nextLine();
		while(mcs.checkName(name)){
			System.out.println("\""+user+"\" no es un usuario registrado en la aplicacion.");
			System.out.print("\nIngrese el nombre sel usuario que creara la cancion: ");
			user = sc.nextLine();
		}//End while
		System.out.print("Ingrese el titulo de la cancion: ");
		String title = sc.nextLine();
		System.out.print("Ingrese el nombre del artista o banda de la cancion: ");
		String artistname = sc.nextLine();
		System.out.print("Ingrese la fecha de lanzamiento del disco: ");
		String date = sc.nextLine();
		System.out.print("Ingrese los minutos que dura la cancion: ");
		int minutes = sc.nextInt();
		System.out.print("Ingrese los segundos que dura la cancion: ");
		int seconds = sc.nextInt();
		
	}//End readSongData
	
	public void doOperation(int option){
		switch(option){
			case ADD_USERS:
				readUsersData(); 
				break;
			case SEE_USERS:
				System.out.println(mcs.displayUsers());
				break;
			case ADD_SONG:
				
				break;
			case SEE_SONGS:
				break;
			case ADD_PLAYLIST:
				break;
			case ADD_SONG_TO_PLAYLIST:
				break;
			case SEE_PLAYLIST:
				break;
			case EXIT:
				break;
		}//End switch
	}//End doOperation
}//End Menu