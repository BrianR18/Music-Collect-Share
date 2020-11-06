package model;
/**
*This class allows to create a public playlist <br>
*@author BrianR<br>
*/
public class PublicPlayList extends PlayList{
	private double score;
	/**
	*Basic contructor of the public playlist<br>
	*<b>pre: </b><br>
	*<b>post: </b>The public playlist has been created<br>
	*/
	public PublicPlayList(){
		super();
		score = 0;
	}//End PublicPlayList
	/**
	* Constructor of the public playlist class. <br>
	* <b>pre:</b> parameters are initialized. <br>
	* <b>post:</b> public playlist class object created. <br>
	* @param name Playlist name. name != "". name != null.<br>
	* @param score Playlist score. score bigger or equals than 1 and score lower or equals than 5.<br>
	*/
	public PublicPlayList(String name,double score){
		super(name);
		this.score = score;
	}//End PublicPlayList
	/**
	* Changes the score of the playlist. <br>
	* <b>pre:</b> 
	* <b>post:</b> score has been changed. <br>
	* @param s New score of the playlist. s bigger or equals than 1 and s lower or equals than 5.<br>
	*/
	public void setScore(double s){
		score = calculateScore(s);
	}//End setRate
	/**
	* Returns the score of the playlist. <br>
	* <b>pre:</b> 
	* <b>post:</b> 
	*@return Return the playlist score<br>
	*/
	public double getScore(){
		return score;
	}//End getRate
	/**
	* Calculate the score of the playlist. <br>
	* <b>pre:</b> 
	* <b>post:</b> 
	*@param s New score of the playlist. s bigger or equals than 1 and s lower or equals than 5.<br>
	*@return Return the new playlist score<br>
	*/
	public double calculateScore(double s){
		double score = 0;
		if(getScore() > 0)
			score = (s + getScore())/2;
		else
			score = s;
		
		return score;
	}//End calculateQualification
	/**
	*Get a String representation fo the public playlist<br>
	*<b>pre: </b> The playlist is initialized with all its attributes.<br>
	*<b>post: </b>
	*@return Return a String representation of the object<br>
	*/
	@Override
	public String toString(){
		String obj = super.toString() + "**Score: " + getScore() + "\n";
		return obj;
	}//End toString
}//End PublicPlayList