package model;
/**
*This class allows to create the Music Collect and Share<br>
*@author BrianR<br>
*/
public class MCS{
	private User[] users;
	private Song[] poolSongs;
	private PlayList[] playList;
	
	/**
	* Constructor of the Mcs class. <br>
	* <b>pre:</b><br>
	* <b>post:</b> Mcs class object created. <br>
	*/
	public MCS(){
		users = new User[10];
		poolSongs = new Song[30];
		playList = new PlayList[20];
	}//End constructor
	/**
	* Adds a new user.<br>
	* <b>pre:</b> parameters are initialized. User array is initialized. <br>
	* <b>post:</b> User added sucesfully or User could not be added. <br>
	* @param name User name. name != "". name != null.<br>
	* @param age User age. age bigger than 0. age != null.<br>
	* @param password User passWord. passWord != "". passWord != null.<br>
	* @return return the state of the user<br>
	*/
	public String addUser(String name,int age,String password){
		String msg = "No se ha podido agregar el usuario.\nNo quedan espacios de registro";
		boolean add = false;
		if(!checkName(validateName(name))){
			for(int i = 0; i < users.length && !add; i++){
				if(users[i] == null){
					users[i] = new User(validateName(name),password,age);
					add = true;
					msg = "Se ha agregado el usuario correctamente.";
				}//End if
			}//End for
		}//End if
		else
			msg = "No se ha podido agregar el usuario.\nYa existe un usuario con ese nombre.";
		return msg;
	}//End addUser
	/**
	* Searches for an user. <br>
	* <b>pre:</b> User array is initialized. Name is initialized <br>
	* <b>post:</b> True if the user exists, false if not. <br>
	* @param name Name of the user to search. user != null.<br>
	* @return return a boolean value.<br>
	*/
	public	boolean checkName(String name){
		boolean check = false;
		for(int i = 0; i < users.length && !check; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(validateName(name))){
					check = true;
				}//End if equals
			}//End if null
		}//End for
		return check;
	}//End checkName
	/**
	* Saves the information of the users on a String.<br>
	* <b>pre:</b> Users array is initialized.<br>
	* <b>post:</b> info of the users.<br>
	* @return Return all users information.<br>
	*/
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
	/**
	* Adds a new song.<br>
	* <b>pre:</b> parameters are initialized. Song list is initialized. <br>
	* <b>post:</b> Song was sucesfully added or Song could not be added. <br>
	* @param user Name of the user who adds the song. user != "". user != null.<br>
	* @param title Song title. title != "". title != null.<br>
	* @param artistName Song artist. artistName != "". artistName != null.<br>
	* @param releaseDate Song release date. releaseDate != "". releaseDate != null.<br>
	* @param minutes Song minutes duration. minutes bigger or equals than 0.<br>
	* @param seconds Song seconds duration. seconds bigger than 0.<br>
	* @param genre Song genre. genre != "". genre != null.<br>
	* @return return the state of the song<br>
	*/
	public String addSong(String user,String title, String artistName, String releaseDate,int minutes,int seconds,String genre){
		boolean add = false;
		boolean found = false;
		int index = 0;
		user = validateName(user);
		String msg = "No se ha podido agregar la cancion";
		for(int i = 0; i < users.length && !found; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(user)){
					index = i;
					found = true;
				}//End if
			}//End if
		}//End for
		for(int i = 0; i < poolSongs.length && !add;i++ ){
			if(poolSongs[i] == null){
				poolSongs[i] = new Song(title,artistName,releaseDate,minutes,seconds,genre);
				users[index].increaseShareSongs();
				users[index].updateCategory();
				add = true;
				msg = "Se ha agregado la cancion";
			}//End if
		}//End for
		return msg;
	}//End addSong
	/**
	* Saves the information of the songs on a String.<br>
	* <b>pre:</b> Poolsongs array is initialized.<br>
	* <b>post:</b><br>
	* @return Return all songs information.<br>
	*/
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
	/**
	* Adds a new public playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist array is initialized.<br>
	* <b>post:</b> Playlist added sucesfully or playlist could not be added.<br>
	* @param name Playlist name. name != "". name != null.<br>
	* @return return the state of the playList<br>
	*/
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
	/**
	* Adds a new restricted playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist array is initialized.<br>
	* <b>post:</b> Playlist sucesfully added or Playlist could not be added.<br>
	* @param owners Playlist owners. owners != "". owners != null.<br>
	* @param name Playlist name. name != "". name != null.<br>
	* @return return the state of the playList<br>
	*/
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
	/**
	* Adds a new private playlist.<br>
	* <b>pre:</b> parameters are initialized. Playlist array is initialized.<br>
	* <b>post:</b> Playlist sucesfully added or Playlist could not be added.<br>
	* @param owner Playlist owner. owner != "". owner != null.<br>
	* @param name Playlist name. name != "". name != null.<br>
	* @return return the state of the playList<br>
	*/
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
	/**
	* Adds a song to a playlist.<br>
	* <b>pre:</b> parameters are initialized. Song array is initialized. Playlist array is initialized.<br>
	* <b>post:</b> Song sucesfully added to playlist or Song could not be added. <br>
	* @param songIndex Playlist owners. songIndex bigger than 0. songIndex != null.<br>
	* @param playListIndex Playlist. playListIndex bigger than 0. playListIndex != null.<br>
	* @return return the state of the song<br>
	*/
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
	/**
	* Saves the information of the playList on a String.<br>
	* <b>pre:</b> PlayList array is initialized.<br>
	* <b>post:</b> info of the users.<br>
	* @return Return all playList information.<br>
	*/
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
	
	/**
	* Saves the information of the public playList on a String.<br>
	* <b>pre:</b> public playList have to exist.<br>
	* <b>post:</b><br>
	* @return Return all names of the public playList.<br>
	*/
	public String displayPublicPlayList(){
		String publicList = new String();
		int index = 0;
		for(int i = 0; i < playList.length; i++){
			if(playList[i] instanceof PublicPlayList){
				++index;
				System.out.println("["+index+"]"+playList[i].getName()+".");
			}//End if
		}//End for
		return publicList;
	}//End displayPublicPlayList
	/**
	* Rates a public playlist.<br>
	* <b>pre:</b> Parameters are initialized. Song list is initialized. Playlist list is initialized.<br>
	* <b>post:</b> The public playlist was rated. <br>
	* @param index Playlist owners. index bigger than 0. index != null.<br>
	* @param score Playlist. score bigger than 0. score != null.<br>
	* @return Return the state of the playList<br>
	*/
	public String ratePlayList(int index,double	score){
		boolean update = false;
		String msg = "No se ha podido calificar la playList";
		int count = 0;
		for(int i = 0; i < playList.length && !update; i++){
			if(playList[i] != null){
				if(playList[i] instanceof PublicPlayList){
					++count;
				if(count == index){
						PublicPlayList publicList = (PublicPlayList) playList[i];
						publicList.setScore(score);
						update = true;
						msg = "Se ha calificado la playList";
					}//Enf if
				}//End if
			}//End if
		}//End for
		return msg;
	}//End ratePlayList
	/**
	* Saves the information of the genres on a String.<br>
	* <b>pre:</b> <br>
	* <b>post:</b><br>
	* @return Return all genres.<br>
	*/
	public String displayGenres(){//Se requiere añadir al UML de clases apartir de aqui
		String genres = new String();
		Genre[] g = Genre.values();
		for(Genre genre:g){
			if(genre != Genre.DESCONOCIDO)
				genres += "-" + genre.toString() + ".\n";
		}//End for
		return genres;
	}//End displayGenres
	/**
	* Searches for an genre on a list. <br>
	* <b>pre:</b> genre is initialized. <br>
	* <b>post:</b> True if the genre exists, false if not. <br>
	* @param genre Genre to search. genre != null.<br>
	* @return Return a boolean value.<br>
	*/
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
	/**
	* Saves the names of the songs on a String.<br>
	* <b>pre:</b> Songs array is initialized.<br>
	* <b>post:</b><br>
	* @return Return all names of the songs.<br>
	*/
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
	/**
	*Remove blank spaces of the String <br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@param s String to validate. s != null.<br>
	*@return Return a string without Blank spaces.<br>
	*/
	public String validateName(String s){
		String validated = new String();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                validated += s.charAt(i);
            }//End if
        }//End for
		return validated;
	}//End validateString
	/**
	* Saves the names of the playList on a String.<br>
	* <b>pre:</b> playList array is initialized.<br>
	* <b>post:</b><br>
	* @return Return all names of the playList.<br>
	*/
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
	/**
	* Counts the amount of playList.<br>
	* <b>pre:</b> playList array is initialized.<br>
	* <b>post:</b> amount of playList.<br>
	* @return Return the amount of playList<br>
	*/
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
	/**
	* Counts the amount of public playlists.<br>
	* <b>pre:</b>Playlist array is initialized.<br>
	* <b>post:</b> amount of public playlists.<br>
	* @return Return the amount of public playList<br>
	*/
	public int amountPublicPlaylist(){
		boolean all = false;
		int amount = 0;
		for(int i = 0; i < playList.length && !all; i++ ){
			if(playList[i] instanceof PublicPlayList)
				amount++;
			else
				all = true;
		}//End for
		return amount;
	}//End amountPlaylist
	/**
	* Counts the amount of songs.<br>
	* <b>pre:</b> Pool of songs is initialized.<br>
	* <b>post:</b> amount of songs.<br>
	* @return Return the amount of songs<br>
	*/
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
	/**
	* Counts the amount of users.<br>
	* <b>pre:</b> User list is initialized.<br>
	* <b>post:</b> amount of users.<br>
	* @return Return the amount of users<br>
	*/
	public int amountUsers(){
		boolean all = false;
		int amount = 0;
		for(int i = 0; i < users.length && !all; i++ ){
			if(users[i] != null)
				amount++;
			else
				all = true;
		}//End for
		return amount;
	}//End amountSongs
	/**
	*Check is the public playList is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value. True if the public playList is null and false if it is not.<br>
	*/
	public boolean isNullPublicPlayList(){
		boolean isnull = true;
		for(int i = 0; i < playList.length && isnull; i++){
			if(playList[i] instanceof PublicPlayList){
				isnull = false;
			}//End if
		}//End for
		return isnull;
	}//En isNullPlayList
	/**
	*Check is the playList is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value. True if the playList is null and false if it is not.<br>
	*/
	public boolean isNullPlayList(){
		boolean isnull = false;
		if(playList[0] == null )
			isnull = true;
		return isnull;
	}//En isNullPlayList
	/**
	*Check is the users is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value. True if the users is null and false if it is not.<br>
	*/
	public boolean isNullUser(){
		boolean isnull = false;
		if(users[0] == null )
			isnull = true;
		return isnull;
	}//End isNullUser
	/**
	*Check is the poolsong is null<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a boolean value. True if the poolsong is null and false if it is not.<br>
	*/
	public boolean isNullPool(){
		boolean isnull = false;
		if(poolSongs[0] == null )
			isnull = true;
		return isnull;
	}//En isNullPool
}//End MCS