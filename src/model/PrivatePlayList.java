package model;

public class PrivatePlayList extends PlayList{
	private String user;
	
	public PrivatePlayList(){
		super();
		user = new String();
	}//End constructor1
	
	public PrivatePlayList(String name,String user){
		super(name);
		this.user = user;
	}//End PrivatePlayList
	public void setUser(String u){
		user = u;
	}//End setUser
	public String getUser(){
		return user;
	}//End getUser
	
}//End PrivatePlayList