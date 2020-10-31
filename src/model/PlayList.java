package model;

public abstract class PlayList{
	private String name;
	private int duration;
	private Genre[] genres;
	
	public PlayList(){
		name = new String();
		duration = 0;
		genres = new Genre[7];
	}//End constructor1
	public PlayList(String name, int duration){
		this.name = name;
		this.duration = duration;
		genres = new Genre[7];
	}//End constructor2
	public void setName(String name){
		this.name = name;
	}//End setName.
	public String getName(){
		return name;
	}//End getName
	public  void setDuration(int duration){
		this.duration = duration;
	}//End setDuration
	public int getDuration(){
		return duration;
	}//End getDuration.
	public void setGenre(String genre){
		double set = false;
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
	
}//End PlayList.