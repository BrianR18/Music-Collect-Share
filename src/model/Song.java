package model;
/**
*This class allows to create a song<br>
*@author BrianR<br>
*/
public class Song{
	private String tittle;
	private String artistName;
	private String releaseDate;
	private int minutes;
	private int seconds;
	Genre genre;
	/**
	*Basic contructor of the Song<br>
	*<b>pre: </b><br>
	*<b>post: </b>The Song has been created <br>
	*/
	public Song(){
		tittle = new String();
		artistName = new String();
		releaseDate = new String();
		minutes = 0;
		seconds = 0;
	}//End constructor1
	/**
	*Constructor of the song class. <br>
	*<b>pre:</b> parameters are initialized. <br>
	*<b>post:</b> Song class object created. <br>
	*@param tittle Song tittle. tittle != "". tittle != null.<br>
	*@param name artist song name. name != "". name != null.<br>
	*@param date Release date of the song. date != "". date != null.<br>
	*@param minutes Duration minutes of the song. minutes bigger or equals than 0<br>
	*@param seconds Duration seconds of the song. seconds bigger than 0<br>
	*@param genre Genre of the song. The genre has to be an existing genre in the Category enum <br>
	*/
	public Song(String tittle, String name, String date,int minutes,int seconds,String genre){
		this.tittle = tittle;
		this.artistName = name;
		releaseDate = date;
		checkDuration(minutes,seconds);
		this.genre = Genre.valueOf(genre);
	}//End constructor2
	/**
	* Changes the tittle of the Song. <br>
	* <b>pre:</b> tittle is initialized. <br>
	* <b>post:</b> tittle has been changed. <br>
	* @param tittle New tittle of the song. tittle != "". tittle != null.<br>
	*/
	public void setTittle(String tittle){
		this.tittle = tittle;
	}//End setTittle
	/**
	* Returns the tittle of the song. <br>
	* <b>pre:</b> tittle is initialized. tittle is not null<br>
	* <b>post:</b> tittle of the song has been changed.<br>
	*@return Return the tittle<br>
	*/
	public String getTittle(){
		return tittle;
	}//End getTittle
	/**
	* Changes the name of the artist Song. <br>
	* <b>pre:</b> name is initialized. <br>
	* <b>post:</b> name	has been changed. <br>
	* @param name New name of the artist song. name != "". name != null.<br>
	*/
	public void setName(String name){
		this.artistName = name;
	}//End setName
	/**
	* Returns the name of the artist song. <br>
	* <b>pre:</b> name is initialized. name is not null<br>
	* <b>post:</b> name of the artist song has been changed. <br>
	*@return Return the artist name<br>
	*/
	public String getName(){
		return artistName;
	}//End getName
	/**
	* Changes the releaseDate of the Song. <br>
	* <b>pre:</b> releaseDate is initialized. <br>
	* <b>post:</b> releaseDate	has been changed. <br>
	* @param date New date of the song. date != "". date != null.<br>
	*/
	public void setReleaseDate(String date){
		releaseDate = date;
	}//End setReleaseDate
	/**
	* Returns the releaseDate of the song. <br>
	* <b>pre:</b> releaseDate is initialized. releaseDate is not null<br>
	* <b>post:</b> releaseDate of the song has been changed. <br>
	*@return Return the releaseDates<br>
	*/
	public String getReleaseDate(){
		return releaseDate;
	}//End getReleaseDate
	/**
	* Changes the Duration minutes of the Song. <br>
	* <b>pre:</b> Duration minutes is initialized. <br>
	* <b>post:</b> Duration minutes	has been changed. <br>
	* @param m New duration minutes of the song. m bigger or equals than 0.<br>
	*/
	public void setMinutes(int m){
		minutes = m;
	}//End setMinutes
	/**
	* Returns the duration minutes of the song. <br>
	* <b>pre:</b> duration minutes is initialized.<br>
	* <b>post:</b> duration minutes of the song has been changed. <br>
	*@return Return the duration minutes<br>
	*/
	public int getMinutes(){
		return minutes;
	}//End getMinutes
	/**
	* Changes the Duration seconds of the Song. <br>
	* <b>pre:</b> Duration seconds is initialized. <br>
	* <b>post:</b> Duration seconds	has been changed. <br>
	* @param s New duration seconds of the song. s bigger than 0.<br>
	*/
	public void setSecond(int s){
		seconds = s;
	}//End setMinutes
	/**
	* Returns the duration seconds of the song. <br>
	* <b>pre:</b> duration seconds is initialized.<br>
	* <b>post:</b> duration seconds of the song has been changed. <br>
	*@return Return the duration seconds<br>
	*/
	public int getSecond(){
		return seconds;
	}//End getMinutes
	/**
	* Changes the genre of the Song. <br>
	* <b>pre:</b> The genre has to be an existing genre in the Category enum. <br>
	* <b>post:</b> Genre has been changed. <br>
	* @param genre New genre of the song. genre != 0 and genre != null.<br>
	*/
	public void setGenre(String genre){
		this.genre = Genre.valueOf(genre);
	}//End setGenre
	/**
	* Returns the genre of the song. <br>
	* <b>pre:</b> genre is initialized.<br>
	* <b>post:</b> genre of the song has been changed. <br>
	*@return Return the genre<br>
	*/
	
	public String getGenre(){
		return genre.toString();
	}//End getGenre
	/**
	* Changes the Duration of the Song. <br>
	* <b>pre:</b> the parameters are initialized. <br>
	* <b>post:</b> Duration has been changed. <br>
	* @param m New minutes of the song. m bigger or equals than 0.<br>
	* @param s New seconds of the song. s bigger than 0<br>
	*/
	public void checkDuration(int m, int s){
		while(s >= 60){
			m++;
			s -= 60;
		}//End while
		setMinutes(m);
		setSecond(s);
	}//End checkDuration
	/**
	*Get a string representation of the song<br>
	*<b>pre: </b><br>
	*<b>post: </b><br>
	*@return Return a string with the object representation.<br>
	*/
	public String toString(){
		String obj = "\n***************Song***************\n" +
					 "**Tittle: " + getTittle() + "\n" +
					 "**Artist: " + getName() + "\n" +
					 "**Duration: " + getMinutes() +":"+ getSecond()+ "\n" +
					 "**Genre: " + getGenre() + "\n" +
					 "\n**********************************\n";
		return obj;
	}//End toString.
}//End PoolSongs