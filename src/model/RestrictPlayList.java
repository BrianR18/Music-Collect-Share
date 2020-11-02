package model;

public class RestrictPlayList extends PlayList{
	private String[] owners;
	
	public RestrictPlayList(){
		super();
		owners = new String[5];
	}//End constructor1
	public RestrictPlayList(String name,String[] owners){
		super(name);
		this.owners = owners;
	}//End constructor2
	public void setOwners(String[] owners){
		this.owners = owners;
	}//End setOwners.
	public String[] getOwners(){
		return owners;
	}//End getOwners.
	
}//End RestrictPlayList