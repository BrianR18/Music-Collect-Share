package model;

public class MCS{
	private User[] users;
	private Song[] poolSongs;
	private PlayList[] playList;
	
	public MCS(){
		users = new User[10];
		poolSongs = new Song[30];
		playList = new PlayList[20];
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
	
	public	boolean checkName(String name){
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
				users += this.users[i].toString();
			}//End if
			else
				all = true;
		}//End for
		return users;
	}//End displayUsers.
	public String addSong(String user,String title, String artistName, String releaseDate,int minutes,int seconds,String genre){
		boolean add = false;
		String msg = "No se ha podido agregar la cancion";
		for(int i = 0; i < users.length && !add; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(user)){
					for(int j = 0; j < poolSongs.length && !add;j++ ){
						if(poolSongs[j] == null){
							poolSongs[j] = new Song(title,artistName,releaseDate,minutes,seconds,genre);
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
				song += "\n"+ ( i + 1)+")" + poolSongs[i].toString();
			}//End if
			else
				all = true;
		}//End for
		return song;
	}//End displayPoolSongs
	//add public playList.
	public String addPlayList(String name){
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
		boolean add = playList[playListIndex-1].addSong(poolSongs[songIndex-1]);
		if(add){
			playList[playListIndex-1].updateGenre(poolSongs[songIndex-1].getGenre());
			playList[playListIndex-1].updateDuration(poolSongs[songIndex-1].getMinutes(),poolSongs[songIndex-1].getSecond());
			msg = "Se ha agregado la cancion a la playList";
		}//End if
		return msg;
	}//End addSongToPlayList.
	public String displayPlayList(){
		boolean allPlayList = false;
		String msg = new String();
		for(int i = 0; i < playList.length && !allPlayList; i++ ){
			if(playList[i] != null)
				msg += playList[i].toString() + "\n";
			else
				allPlayList = true;
		}//End for
		return msg;
	}//End displayPlayList
	
	public String displayGenres(){//Se requiere añadir al UML de clases apartir de aqui
		String genres = new String();
		Genre[] g = Genre.values();
		for(Genre genre:g){
			if(genre != Genre.DESCONOCIDO)
				genres += "-" + genre.toString() + ".\n";
		}//End for
		return genres;
	}//End displayGenres
	
	public boolean checkGenre(String genre){
		boolean check = false;
		Genre[] g = Genre.values();
		genre = genre.toUpperCase();
		for(int i = 0; i < g.length && ! check; i++){
			if(g[i].toString().equals(genre)){
				check = true;
			}//End if
		}//End for
		return check;
	}//End checkGenre
	
	public String displaySongsNames(){
		boolean all = false;
		String songsNames = new String();
		for(int i = 0; i < poolSongs.length && !all; i++){
			if(poolSongs[i] != null)
				songsNames += "[" + (i+1) + "]" + poolSongs[i].getTittle() + " - artista: " + poolSongs[i].getName() + "\n";
			else
				all = true;
		}//End for
		return songsNames;
	}//End displaySongsNames
	
	public String displayPlayListNames(){
		boolean all = false;
		String playlistNames = new String();
		for(int i = 0; i < playList.length && !all; i++){
			if(playList[i] != null)
				playlistNames += "[" + (i+1) + "]" + playList[i].getName() + "\n";
			else
				all = true;
		}//End for
		return playlistNames;
	}//End displayPlayListNames
	public int amountPlaylist(){
		boolean all = false;
		int amount = 0;
		for(int i = 0; i < playList.length && !all; i++ ){
			if(playList[i] != null)
				amount++;
			else
				all = true;
		}//End for
		return amount;
	}//End amountPlaylist
	
	public int amountSongs(){
		boolean all = false;
		int amount = 0;
		for(int i = 0; i < poolSongs.length && !all; i++ ){
			if(poolSongs[i] != null)
				amount++;
			else
				all = true;
		}//End for
		return amount;
	}//End amountSongs
	
	public boolean isNullPlayList(){
		boolean isnull = false;
		if(playList[0] == null )
			isnull = true;
		return isnull;
	}//En isNullPlayList
	
	public boolean isNullUser(){
		boolean isnull = false;
		if(users[0] == null )
			isnull = true;
		return isnull;
	}//End isNullUser
	
	public boolean isNullPool(){
		boolean isnull = false;
		if(poolSongs[0] == null )
			isnull = true;
		return isnull;
	}//En isNullPool
}//End MCS