package model;

public class Song{
	private String tittle;
	private String artistName;
	private String releaseDate;
	private int duration;
	Genre genre;
	
	public Song(){
		tittle = new String();
		name = new String();
		releaseDate = new String();
		duration = 0;
	}//End constructor1
	public Song(String tittle, String name, String date,int duration,String genre){
		this.tittle = tittle;
		this.name = name;
		releaseDate = date;
		this.duration = duration;
		this.genre = Genre.valueOf(genre);
	}//End constructor2
	public void setTittle(String tittle){
		this.tittle = tittle;
	}//End setTittle
	public String getTittle(){
		return tittle;
	}//End getTittle
	public void setName(String name){
		this.name = name;
	}//End setName
	public String getName(){
		return name;
	}//End getName
	public void setReleaseDate(String date){
		releaseDate = date;
	}//End setReleaseDate
	public String getReleaseDate(){
		return releaseDate;
	}//End getReleaseDate
	public void setDuration(int duration){
		this.duration = duration;
	}//End setDuration
	public int getDuration(){
		return duration;
	}//End getDuration
	public void setGenre(String genre){
		this.genre = Genre.valueOf(genre);
	}//End setGenre
	public String getGenre(){
		return genre.toString();
	}//End getGenre
}//End PoolSongs