package ui;
import model.MCS;
import java.util.Scanner;
/**
*This class allows to create a menu for to use the MCS
*@author BrianR
*/
public class Menu{
	
	//Main menu
	private final int ADD_USERS = 1;
	private final int SEE_USERS = 2;
	private final int ADD_SONG = 3;
	private final int SEE_SONGS = 4;
	private final int ADD_PLAYLIST = 5;
	private final int ADD_SONG_TO_PLAYLIST = 6;
	private final int SEE_PLAYLIST = 7;
	private final int RATE_PLAYLIST = 8;
	private final int EXIT = 9;
	
	//Choose playlist
	private final int PUBLIC = 1;
	private final int RESTRICTED = 2;
	private final int PRIVATE = 3;
	
	private Scanner sc = new Scanner(System.in);
	private MCS mcs;
	/**
	*Constructor of the Menu class<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public Menu(){
		mcs = new MCS();
	}//End constructor
	/**
	*Show the logo of the program<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
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
						"((((  /((((((((  ((((((((       ((((*(.(*   ((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"((((((((((((((((((((((((((((((((((((((((((((((((\n" +
						"                    .#//////#.\n"+                                               
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
		System.out.println("\nBIENVENIDO!!!\n");
		sc.nextLine();
	}//End showLogo.
	/**
	*Show the menu of the program<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void showMenu(){
		System.out.println("\n");
		System.out.println("[1]Agregar usuario.");
		System.out.println("[2]Listar usuarios.");
		System.out.println("[3]Agregar cancion a la pool.");
		System.out.println("[4]Listar canciones de la pool.");
		System.out.println("[5]Crear playlist.");
		System.out.println("[6]Agregar cancion a la playlist.");
		System.out.println("[7]Listar playlist existentes.");
		System.out.println("[8]Calificar playList publica.");
		System.out.println("[9]Salir");
	}//End showMenu
	/**
	*Read the options choose by the user<br>
	*<b>pre: </b>
	*<b>post: </b>
	*@return Return the option choose by the user
	*/
	public int readOption(){
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}//End readOption.
	/**
	*Read the user data<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void readUsersData(){
		System.out.print("\nIngrese el apodo del usuario(el apodo se guardara sin espacios): ");
		String name = sc.nextLine();
		while(mcs.checkName(name)){
			System.out.println("\""+name+"\" ya esta en uso.Elige un apodo distinto.");
			System.out.print("\nIngrese el apodo del usuario: ");
			name = sc.nextLine();
		}//End while
		System.out.println("Se guardara como [" + mcs.validateName(name) + "]");
		System.out.print("Contrasenia: ");
		String password = sc.nextLine();
		System.out.print("Ingrese su edad: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("\n" + mcs.addUser(name,age,password));
		sc.nextLine();
	}//End readUsersData
	/**
	*Read the song data<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void readSongData(){
		String msg = new String();
		System.out.print("\nIngrese el nombre del usuario que creara la cancion: ");
		String user = sc.nextLine();
		while(!mcs.checkName(user)){
			System.out.println("\""+user+"\" no es un usuario registrado en la aplicacion.");
			System.out.println("Es posible que tenga que escribir el nombre sin espacios.");
			System.out.print("\nIngrese el nombre sel usuario que creara la cancion: ");
			user = sc.nextLine();
		}//End while
		System.out.print("Ingrese el titulo de la cancion: ");
		String title = sc.nextLine();
		System.out.print("Ingrese el nombre del artista o banda de la cancion: ");
		String artistName = sc.nextLine();
		System.out.print("Ingrese la fecha de lanzamiento del disco: ");
		String date = sc.nextLine();
		System.out.print("Ingrese los minutos que dura la cancion: ");
		int minutes = sc.nextInt();
		sc.nextLine();
		System.out.print("Ingrese los segundos que dura la cancion: ");
		int seconds = sc.nextInt();
		sc.nextLine();
		System.out.println("Mostrando los generos musicales posibles...");
		System.out.println(mcs.displayGenres());
		System.out.println("Escriba el genero de la cancion: ");
		String genre = sc.nextLine();
		while(!mcs.checkGenre(genre)){
			System.out.println("El genero ingresado es incorrecto!");
			System.out.println("Escriba el genero de la cancion: ");
			genre = sc.nextLine();
		}//End while
		genre = genre.toUpperCase();
		msg = mcs.addSong(user,title,artistName,date,minutes,seconds,genre);
		System.out.println("\n" + msg);
	}//End readSongData
	/**
	*Read the playList data<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void readPlayListData(){
		
		String msg = new String();
		String owner = new String();
		String[] owners = new String[5];
		System.out.print("\nIngrese el nombre de la playlist: ");
		String name = sc.nextLine();
		System.out.println("Listando tipos de playlist...");
		System.out.println("\n[1]Playlist publica.\n[2]Playlist restringida.\n[3]Playlist privada.");
		System.out.print("Ingrese el tipo de playlist que creara: ");
		int opt = sc.nextInt();
		while(opt < 1 || opt > 3){
			System.out.println("\nOpcion erronea!");
			System.out.print("Ingrese el tipo de playlist que creara: ");
		    opt = sc.nextInt();
		}//End while
		sc.nextLine();
		switch(opt){
			case PUBLIC:
				msg = mcs.addPlayList(name);
				break;
			case RESTRICTED:
				boolean end = false;
				int i = 0;
				opt = 0;
				while(!end || i >= 5){
					System.out.print("\n[1] Agregar propietario(maximo 5).\n[Cualquier otro numero] Dejar de agregar propietarios\n");
					System.out.print("Ingrese la opcion: ");
					opt = sc.nextInt();
					sc.nextLine();
					if(opt == 1){
						System.out.print("Ingresa el nombre del propietario (sin espacios): ");
						owners[i] = sc.nextLine();
						while(!mcs.checkName(owners[i])){
							System.out.println(owners[i] + ", no es un usuario registrado en la aplicacion.");
							System.out.print("Ingresa el nombre del propietario (sin espacios): ");
							owners[i] = sc.nextLine();
						}//End while
						i++;
					}//End if
					else
						end = true;
				}//End while
				msg = mcs.addPlayList(name,owners);
				break;
				
			case PRIVATE:
				System.out.print("\nIngresa el nombre del propietario (sin espacios): ");
				owner = sc.nextLine();
				while(!mcs.checkName(owner)){
					System.out.println(owner + ", no es un usuario registrado en la aplicacion.");
					System.out.print("Ingresa el nombre del propietario (sin espacios): ");
					owner = sc.nextLine();
				}//End while
				msg = mcs.addPlayList(name,owner);
				break;
		}//End switch
		System.out.println("\n" + msg);
		sc.nextLine();
	}//End readPlayListData.
	/**
	*Read the calification of the playList<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void rateList(){
		System.out.println("Mostrando listas publicas...");
		System.out.println(mcs.displayPublicPlayList());
		System.out.print("Ingrese el numero de la lista a calificar: ");
		int opt = sc.nextInt();
		sc.nextLine();
		while(opt < 1 || opt > mcs.amountPublicPlaylist()){
			System.out.println("Opcion erronea!!");
			System.out.print("Ingrese el numero de la lista a calificar: ");
		    opt = sc.nextInt();
			sc.nextLine();
		}//End while
		System.out.print("Ingrese una calificacion del 1 al 5 para la playList: ");
		double score = sc.nextInt();
		sc.nextLine();
		while( score < 1 || score > 5){
			System.out.println("Calificacion erronea!!");
			System.out.print("Ingrese una calificacion del 1 al 5 para la playList: ");
			score = sc.nextInt();
			sc.nextLine();
		}//End while
		System.out.println(mcs.ratePlayList(opt, score));
	}//End rateList
	/**
	*Read a song and added to playList<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void addSong(){
		System.out.println("\nMostrando playList existentes...");
		System.out.println(mcs.displayPlayListNames());
		System.out.print("Ingrese el numero de la playlist para agregar una cancion: ");
		int playlistIndex = sc.nextInt();
		while( playlistIndex < 1 && playlistIndex > mcs.amountPlaylist()){
			System.out.println("Opcion incorrecta!!");
			System.out.print("Ingrese el numero de la playlist para agregar una cancion: ");
		    playlistIndex = sc.nextInt();
		}//End while
		System.out.println("\nMostrando canciones existentes...");
		System.out.print(mcs.displaySongsNames());
		System.out.print("Ingrese el numero de la cancion para agregarla: ");
		int songIndex = sc.nextInt();
		while( songIndex < 1 && songIndex > mcs.amountPlaylist()){
			System.out.println("Opcion incorrecta!!");
			System.out.print("Ingrese el numero de la cancion para agregarla: ");
		    songIndex = sc.nextInt();
		}//End while
		sc.nextLine();
		System.out.println("\n" + mcs.addSongToPlayList(songIndex,playlistIndex));
		sc.nextLine();
	}//End addSong.
	/**
	*Execute the opcion choose by the user<br>
	*<b>pre: </b>
	*<b>post: </b>
	*@param option Option choose by the user
	*/
	public void doOperation(int option){
		switch(option){
			case ADD_USERS:
				readUsersData();
				break;
			case SEE_USERS:
				if(!mcs.isNullUser())
					System.out.println(mcs.displayUsers());
				else
					System.out.println("\nNo existen usuarios que mostrar.");
					sc.nextLine();
				break;
			case ADD_SONG:
				if(!mcs.isNullUser())
					readSongData();
				else
					System.out.println("\nTal parece que no hay usuarios registrados aun.\nPrueba crear un usuario primero.");
					sc.nextLine();
				break;
			case SEE_SONGS:
				if(!mcs.isNullPool())
					System.out.println(mcs.displayPoolSongs());
				else
					System.out.println("\nNo existen canciones en la pool de canciones para mostrar");
					sc.nextLine();
				break;
			case ADD_PLAYLIST:
				if(!mcs.isNullUser())
					readPlayListData();
				else
					System.out.println("\nTal parece que no hay usuarios registrados aun.\nPrueba crear un usuario primero.");
					sc.nextLine();
				break;
			case ADD_SONG_TO_PLAYLIST:
				if(!mcs.isNullPlayList() || !mcs.isNullPool())
					addSong();
				else
					System.out.println("\nTal parece que no existen canciones o playList.\nPrueba a crear estas primero =)");
					sc.nextLine();
				break;
			case SEE_PLAYLIST:
				if(!mcs.isNullPlayList())
					System.out.println(mcs.displayPlayList());
				else 
					System.out.println("\nNo existen playlist que mostrar.");
					sc.nextLine();
				break;
			case RATE_PLAYLIST:
				if(!mcs.isNullPublicPlayList())
					rateList();
				else 
					System.out.println("\nNo existen playlist publicas que mostrar.");
					sc.nextLine();
				break;
			case EXIT:
				break;
		}//End switch
	}//End doOperation
	/**
	*Start the program<br>
	*<b>pre: </b>
	*<b>post: </b>
	*/
	public void startProgram(){
		int opt = 0;
		showLogo();
		do{
			System.out.print("\nQue deseas hacer?...");
			showMenu();
			System.out.print("Ingrese la opcion que desea seguir: ");
			opt = readOption();
			doOperation(opt);
		}while(opt != 9);//End do while
	}//End startProgram
}//End Menu