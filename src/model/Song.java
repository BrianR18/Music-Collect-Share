package model;

public class Song{
	private String tittle;
	private String artistName;
	private String releaseDate;
	private int minutes;
	private int seconds;
	Genre genre;
	
	public Song(){
		tittle = new String();
		artistName = new String();
		releaseDate = new String();
		minutes = 0;
		seconds = 0;
	}//End constructor1
	public Song(String tittle, String name, String date,int minutes,int seconds,String genre){
		this.tittle = tittle;
		this.artistName = name;
		releaseDate = date;
		this.minutes = minutes;
		this.seconds = seconds;
		this.genre = Genre.valueOf(genre);
	}//End constructor2
	public void setTittle(String tittle){
		this.tittle = tittle;
	}//End setTittle
	public String getTittle(){
		return tittle;
	}//End getTittle
	public void setName(String name){
		this.artistName = name;
	}//End setName
	public String getName(){
		return artistName;
	}//End getName
	public void setReleaseDate(String date){
		releaseDate = date;
	}//End setReleaseDate
	public String getReleaseDate(){
		return releaseDate;
	}//End getReleaseDate
	public void setMinutes(int m){
		minutes = m;
	}//End setMinutes
	public int getMinutes(){
		return minutes;
	}//End getMinutes
	public void setSecond(int s){
		seconds = s;
	}//End setMinutes
	public int getSecond(){
		return seconds;
	}//End getMinutes
	public void setGenre(String genre){
		this.genre = Genre.valueOf(genre);
	}//End setGenre
	public String getGenre(){
		return genre.toString();
	}//End getGenre
	
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