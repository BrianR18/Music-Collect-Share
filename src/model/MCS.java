package model;

public class MCS{
	private User[] users;
	private Song[] poolSongs;
	private PlayList[] playList;
	
	public MCS(){
		users = new User[10];
		poolSongs = new Song[30];
		playList = new PlayList[30];
	}//End constructor
	
	public String addUser(String name,int age,String password){
		String msg = "No se ha podido agregar el usuario.\nNo quedan espacios de registro";
		boolean add = false;
		if(!checkName(name)){
			for(int i = 0; i < users.length && !add; i++){
				if(users[i] == null){
					users[i] = new User(name,password,age);
					add = true;
					msg = "Se ha agregado el usuario correctamente.";
				}//End if
			}//End for
		}//End if
		else
			msg = "No se ha podido agregar el usuario.\nYa existe un usuario con ese nombre.";
		return msg;
	}//End addUser
	private boolean checkName(String name){
		boolean check = false;
		for(int i = 0; i < users.length && !check; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(name)){
					check = true;
				}//End if equals
			}//End if null
		}//End for
		return check;
	}//End checkName
	public String displayUsers(){
		boolean all = false;
		String users = new String();
		for(int i = 0; i < this.users.length && !all; i++){
			if(this.users[i] != null){
				users += "\n***************User***************\n";
				users += "**User name: " + this.users[i].getName() + "\n";
				users += "**Age: " + this.users[i].getAge() + "\n";
				users += "**Category: " + this.users[i].getCategory() + "\n";
				users += "\n**********************************\n";
			}//End if
			else
				all = true;
		}//End for
		return users;
	}//End displayUsers.
	public String addSong(String user,String tittle, String artistName, String releaseDate,int minutes,int seconds,String genre){
		boolean add = false;
		String msg = "No se ha podido agregar la cancion";
		for(int i = 0; i < users.length && !add; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(user)){
					for(int j = 0; j < poolSongs.length && !add;j++ ){
						if(poolSongs[j] == null){
							poolSongs[j] = new Song(tittle,artistName,releaseDate,minutes,seconds,genre);
							users[i].increaseShareSongs();
							users[i].updateCategory();
							add = true;
							msg = "Se ha agregado la cancion";
						}//End if
					}//End for
				}//End if
			}//End if
		}//End for
		return msg;
	}//End addSong
	
	public String displayPoolSongs(){
		boolean all = false;
		String song = new String();
		for(int i = 0; i < poolSongs.length && !all; i++){
			if(poolSongs[i] != null){
				song += "\n"+ ( i + 1)+")" +"\n***************Song***************\n";
				song += "**Tittle: " + poolSongs[i].getTittle() + "\n";
				song += "**Artist: " + poolSongs[i].getName() + "\n";
				song += "**Duration: " + poolSongs[i].getMinutes() +":"+ poolSongs[i].getSecond()+ "\n";
				song += "**Genre: " + poolSongs[i].getGenre() + "\n";
				song += "\n**********************************\n";
			}//End if
			else
				all = true;
		}//End for
		return song;
	}//End displayPoolSongs
	//add public playList.
	public String addPlayList(String name, double rate){
		boolean add = false;
		String msg = "No se ha podido crear la playList";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new PublicPlayList(name,0);
				msg = "Se ha creado la playList publica correctamente";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList1
	//add restrict playList.
	public String addPlayList(String name, String[] owners){
		boolean add = false;
		String msg = "No se ha podido crear la playList";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new RestrictPlayList(name,owners);
				msg = "Se ha creado la playList restringida correctamente";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList2
	//add private playList.
	public String addPlayList(String name, String owner){
		boolean add = false;
		String msg = "No se ha podido crear la playList";
		for(int i = 0; i < playList.length && !add; i++){
			if(playList[i] == null ){
				playList[i] = new PrivatePlayList(name,owner);
				msg = "Se ha creado la playList privada correctamente";
				add = true;
			}//End if
		}//End for
		return msg;
	}//End addPlayList2
	
	public String addSongToPlayList(int songIndex,int playListIndex){
		String msg = "No se ha podido agregar la cancion a la playList.No queda espacio en la playList";
		double add = playList[playListIndex-1].addSong(poolSongs[songIndex-1]);
		if(add){
			playList[playListIndex-1].updateGenre(poolSongs[songIndex-1].getGenre());
			playList[playListIndex-1].updateDuration(poolSongs[songIndex-1].getMinutes(),poolSongs[songIndex-1].getSecond());
			msg = "Se ha agregado la cancion a la playList";
		}//End if
		return msg;
	}//End addSongToPlayList.
	
}//End MCS