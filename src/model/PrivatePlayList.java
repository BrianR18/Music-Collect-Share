package model;
/**
*This class allows to create a Private playlist<br>
*@author BrianR<br>
*/
public class PrivatePlayList extends PlayList{
	private String owner;
	
	/**
	*Basic contructor of the private playlist<br>
	*<b>pre: </b><br>
	*<b>post: </b>The private playlist has been created<br>
	*/
	public PrivatePlayList(){
		super();
		owner = new String();
	}//End constructor1
	/**
	* Constructor of the PrivatePlaylist class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> PrivatePlaylist class object created. <br>
	* @param name Playlist name. name != "". name != null.<br>
	* @param owner Playlist owner. owner != "". owner != null.<br>
	*/
	public PrivatePlayList(String name,String owner){
		super(name);
		this.owner = owner;
	}//End PrivatePlayList
	/**
	* Changes the owner of the playlist. <br>
	* <b>pre:</b> owner is initialized. <br>
	* <b>post:</b> owner has been changed. <br>
	* @param u New owner of the playlist. u != "". u != null.<br>
	*/
	public void setUser(String u){
		owner = u;
	}//End setUser
	/**
	* Returns the owner of the playlist. <br>
	* <b>pre:</b> owner is initialized. owner is not null<br>
	* <b>post:</b> owner of the playlist. <br>
	*@return Return the owner<br>
	*/
	public String getUser(){
		return owner;
	}//End getUser
	/**
	*Get a String representation fo the private playlist<br>
	*<b>pre: </b> The playlist is initialized with all its attributes.<br>
	*<b>post: </b><br>
	*@return Return a String representation of the object<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "**Owner: " + getUser() + "\n";
		return obj;
	}//End toString
}//End PrivatePlayList