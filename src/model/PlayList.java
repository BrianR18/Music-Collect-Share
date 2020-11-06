package model;
/**
*This class allows you to create a template for the inheritance hierarchy.<br>
*@author BrianR<br>
*/
public abstract class PlayList{
	final private int amountSongs = 30;//Max songs allowed
	private String playListName;
	private int minutes;
	private int seconds;
	private int hours;
	private Genre[] genres;
	private Song[] songs;
	
	/**
	*Basic constructor<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*/
	public PlayList(){
		playListName = new String();
		genres = new Genre[7];
		songs = new Song[amountSongs];
		minutes = 0;
		seconds = 0;
		hours = 0;
	}//End constructor1
	/**
	*Allows to create a new playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param playListName The playList name.<br>
	*/
	public PlayList(String playListName){
		this.playListName = playListName;
		genres = new Genre[7];
		songs = new Song[amountSongs];
		minutes = 0;
		seconds = 0;
		hours = 0;
	}//End constructor2
	/**
	*Set the playList name.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param playListName .<br>
	*/
	public void setName(String playListName){
		this.playListName = playListName;
	}//End setName.
	/**
	*Get the playList name.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a string with the playList name.<br>
	*/
	public String getName(){
		return playListName;
	}//End getName
	/**
	*Set the duration hours of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param h Duration hours.<br>
	*/
	public void setHours(int h){
		hours = h;
	}//End setHours
	/**
	*Get the duration hours of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a int with the duration hours.<br>
	*/
	public int getHours(){
		return hours;
	}//End getHours
	/**
	*Set the duration minutes of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param m Duration minutes.<br>
	*/
	public  void setMinutes(int m){
		this.minutes = m;
	}//End setMinutes
	/**
	*Get the duration minutes of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a int with The Duration minutes.<br>
	*/
	public int getMinutes(){
		return minutes;
	}//End getMinutes.
	/**
	*Set the duration seconds of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param s The duration seconds.<br>
	*/
	public void setSeconds(int s){
		seconds = s;
	}//End setSeconds
	/**
	*Get the duration seconds of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a int with the duration seconds.<br>
	*/
	public int getSeconds(){
		return seconds;
	}//End getSeconds
	/**
	*Set the genre of the playList.<br>
	*<b>pre:</b> The genre has to be an existing genre in the Category enum.<br>
	*<b>post:</b><br>
	*@param genre The genre of the playList.<br>
	*/
	public void setGenre(String genre){
		boolean set = false;
		for(int i = 0; i < genres.length && !set; i++){
			if(genres[i] != null){
				genres[i] = Genre.valueOf(genre);
				set = true;
			}//End if.
		}//End for
	}//End setGenre
	/**
	*Get the genres of the playList.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return an array with all genres of the playList.<br>
	*/
	public String[] getGenres(){
		String[] genre = new String[7];
		for(int i = 0; i < genres.length; i++){
			if(genres[i] != null){
				genre[i] = genres[i].toString();
			}//End if
		}//End for
		return genre;
	}//End getGenres
	/**
	*Add a song to the playList.<br>
	*<b>pre: </b>The song is not null and has all of its attributes initialized.<br>
	*<b>post: </b><br>
	*@param song The song to add to the playList.<br>
	*@return Return a boolean value, True if the song was added and false if the song was not added.<br>
	*/
	public boolean addSong(Song song){
		boolean add = false;
		for(int i = 0; i < songs.length && !add; i++){
			if(songs[i] == null){
				songs[i] = song;
				add = true;
			}//End if
		}//End for
		return add;
	}//End addSong
	/**
	*Update the genres of the playList.<br>
	*<b>pre: </b>The genre has to be an existing genre in the Category enum.<br>
	*<b>post: </b><br>
	*@param genre Genre of the song. genre != "" and genre != nulls<br>
	*/
	public void updateGenre(String genre){
		boolean update = false;
		boolean exist = false;
		for(int i = 0; i < genres.length && !update; i++){
			if(genres[i] != null){
				if(genres[i] == Genre.valueOf(genre))
					exist = true;
			}//End if
			else if(!exist){
				genres[i] = Genre.valueOf(genre);
				update = true;
			}//end else if
		}//End for
	}//End updateGenre
	/**
	*Update the duration of the playList.<br>
	*<b>pre: Parameters are initialized</b>
	*<b>post: </b>
	*@param m Duration minutes of the playList, m bigger or equal than 0.<br>
	*@param s Duration seconds of the playList, s bigger than 0.<br>
	*/
	public void updateDuration(int m,int s){
		int hours = getHours();
		int minutes = m + getMinutes();
		int seconds = s + getSeconds();
		
		while(seconds >= 60){
			minutes ++;
			seconds -= 60;
		}//End calculate minutes
		while(minutes >= 60){
			hours++;
			minutes -= 60;
		}//End calculate hours
		setSeconds(seconds);
		setMinutes(minutes);
		setHours(hours);
	}//End updateDuration.
	/**
	*Get a string representation of the playList<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a string with the object representation.<br>
	*/
	public String toString(){
		String[] g = getGenres();
		boolean nmg = false;//No more genres
		String obj = "\n**************PlayList**************\n" + 
					 "**Title: " + getName() + "\n";
		if(getHours() > 0)
			obj += String.format("**Duration: %02d:%02d:%02d\n",getHours(),getMinutes(),getSeconds());
		else
			obj += String.format("**Duration: %02d:%02d:%02d\n",getHours(),getMinutes(),getSeconds());
		
		obj += "**Genre: ";
		if(g[0] == null )
			obj += "Desconocido\n";
		else{
			for(int i = 0; i < g.length && !nmg; i++){
				if(g[i] != null)
					obj += g[i].toString() + ", ";
				else
					nmg = true;
			}//End for
			obj += "\n";
		}//End else
			return obj;
	}//End toString
}//End PlayList.