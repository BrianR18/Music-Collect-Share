package model;

public abstract class PlayList{
	final private int amountSongs = 30;
	private String playListName;
	private int minutes;
	private int seconds;
	private int hours;
	private Genre[] genres;
	private Song[] songs;
	
	public PlayList(){
		playListName = new String();
		genres = new Genre[7];
		songs = new Song[amountSongs];
		minutes = 0;
		seconds = 0;
		hours = 0;
	}//End constructor1
	public PlayList(String playListName){
		this.playListName = playListName;
		genres = new Genre[7];
		songs = new Song[amountSongs];
		minutes = 0;
		seconds = 0;
		hours = 0;
	}//End constructor2
	public void setName(String playListName){
		this.playListName = playListName;
	}//End setName.
	public String getName(){
		return playListName;
	}//End getName
	public void setHours(int h){
		hours = h;
	}//End setHours
	public int getHours(){
		return hours;
	}//End getHours
	public  void setMinutes(int m){
		this.minutes = m;
	}//End setMinutes
	public int getMinutes(){
		return minutes;
	}//End getMinutes.
	public void setSeconds(int s){
		seconds = s;
	}//End setSeconds
	public int getSeconds(){
		return seconds;
	}//End getSeconds
	public void setGenre(String genre){
		boolean set = false;
		for(int i = 0; i < genres.length && !set; i++){
			if(genres[i] != null){
				genres[i] = Genre.valueOf(genre);
				set = true;
			}//End if.
		}//End for
	}//End setGenre
	public String getGenres(){
		String genre = new String();
		for(int i = 0; i < genres.length; i++){
			if(genres[i] != null){
				genre += genres[i] + ", ";
			}//End if
		}//End for
		return genre;
	}//End getGenres
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
	public void updateGenre(String genre){
		boolean update = false;
		boolean exist = false;
		for(int i = 0; i < genres.length && !update; i++){
			if(genres[i] != null){
				if(genres[i] == Genre.valueOf(genre)){
					exist = true;
				}//End if
			}//End if
			else if(!exist){
				genres[i] = Genre.valueOf(genre);
			}//end else if
		}//End for
		
	}//End updateGenre
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
	
}//End PlayList.