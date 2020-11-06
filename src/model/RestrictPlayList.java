package model;
/**
*This class allows to create a Restrict playlist<br>
*@author BrianR<br>
*/
public class RestrictPlayList extends PlayList{
	private String[] owners;
	/**
	*Basic contructor of the Restrict playlist<br>
	*<b>pre: </b><br>
	*<b>post: </b>The private playlist has been created<br>
	*/
	public RestrictPlayList(){
		super();
		owners = new String[5];
	}//End constructor1
	/**
	* Constructor of the Restrict Playlist class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> Restrict playlist class object created. <br>
	* @param name Playlist name. name != "". name != null.<br>
	* @param owners Playlist owners. owner != "". owner != null.<br>
	*/
	public RestrictPlayList(String name,String[] owners){
		super(name);
		this.owners = owners;
	}//End constructor2
	/**
	* Changes the owners of the playlist. <br>
	* <b>pre:</b> owners is initialized. <br>
	* <b>post:</b> owners has been changed. <br>
	* @param owners New owners of the playlist. owners != "". owners != null.<br>
	*/
	public void setOwners(String[] owners){
		this.owners = owners;
	}//End setOwners.
	/**
	* Returns the owners of the playlist. <br>
	* <b>pre:</b> owners is initialized. owners is not null<br>
	* <b>post:</b> owners of the playlist. <br>
	*@return Return the ownes of the playlist<br>
	*/
	public String[] getOwners(){
		return owners;
	}//End getOwners.
	/*public String addOwner(String o){
		
	}*///End addOwner
	/**
	*Get a String representation fo the Restrict playlist<br>
	*<b>pre: </b> The playlist is initialized with all its attributes.<br>
	*<b>post: </b><br>
	*@return Return a String representation of the object<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "**Owners: ";
		boolean allOwners = false;
		String[] owners = getOwners();
		for(int i = 0; i < owners.length && !allOwners; i++){
			if(owners[i] != null)
				obj += owners[i]+", ";
			else
				allOwners = true;
		}//End for
		obj += "\n";
		return obj;
	}//End toString
}//End RestrictPlayList