package model;
/**
*This class allows to represent the user of application.<br>
*@author BrianR<br>
*/
public class User{
	
	private String name;//Saves the username.
	private String password;//Saves the user's password.
	private int age;//Save the user's age.
	private int shareSongs;//Saves the amount of song share by the user.
	Category category;//Represent the category of the user.
	
	/**
	*basic constructor, receives no parameters.<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*/
	public User(){
		name = new String();
		password = new String();;
		age = 0;
		shareSongs = 0;
		category = Category.NEWBIE;
	}//End constructor1
	/**
	*Allows to create a new user.<br>
	*<b>pre:</b> The age is bigger than zero.<br>
	*<b>post:</b> The user has been created.<br>
	*@param name Username.<br>
	*@param password User's password.<br>
	*@param age User's age. Age bigger or equals than 0.<br>
	*/
	public User(String name,String password,int age){
		this.name = name;
		this.password = password;
		this.age = age;
		shareSongs = 0;
		category = Category.NEWBIE;
	}//End constructor2
	/**
	*Set the username<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param name username<br>
	*/
	public void setName(String name){
		this.name = name;
	}//End setName.
	/**
	*Get the username<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a string with the username<br>
	*/
	public String getName(){
		return name;
	}//end getName
	/**
	*Set the password<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param password  user's password<br>
	*/
	public void setPassword(String password){
		this.password = password;
	}//End setPassword
	/**
	*Get the password<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a string with the user's password<br>
	*/
	public String getPassword(){
		return password;
	}//End getPassword
	/**
	*Set the age<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param age user's age<br>
	*/
	public void setAge(int age){
		this.age = age;
	}//End setAge
	/**
	*Get the user's age<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a int with the user's age<br>
	*/
	public int getAge(){
		return age;
	}//End getAge
	/**
	*Set the shareSongs<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param shareSongs user's shareSongs<br>
	*/
	public void setShareSongs(int shareSongs){
		this.shareSongs = shareSongs;
	}//End setShareSongs
	/**
	*Get the shareSongs<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a int with the user's shareSongs<br>
	*/
	public int getShareSongs(){
		return shareSongs;
	}//End getShareSongs
	/**
	*Set the user category<br>
	*<b>pre: </b>Category has to be an existent category in the enum<br>
	*<b>post:</b><br>
	*@param category user category<br>
	*/
	public void setCategory(String category){
		this.category = Category.valueOf(category);
	}//End setCategory
	/**
	*Get the user category<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a string with the user category<br>
	*/
	public String getCategory(){
		return category.toString();
	}//End getCategory.
	/**
	*Check if the password entered is correct<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@param p The password entered by the user<br>
	*@return Return a boolean value. True if the password is correct and false if the password is wrong.<br>
	*/
	public boolean checkPassword(String p){
		boolean check = false;
		if(p.equals(getPassword())){
			check = true;
		}//End if
		return check;
	}//End checkPassword
	public void increaseShareSongs(){
		shareSongs++;
	}//End increaseShareSongs
	
	/**
	*Update the user category<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*/
	public void updateCategory(){
		if(getShareSongs() == 3)
			category = Category.LITTLE_CONTRIBUTOR;
		else if(getShareSongs() == 10)
			category = Category.MILD_CONTRIBUTOR;
		else if(getShareSongs() == 30)
			category = Category.STAR_CONTRIBUTOR;
	}//End updateCategory
	
	/**
	*Represent the object as a string<br>
	*<b>pre:</b><br>
	*<b>post:</b><br>
	*@return Return a string whith the object information<br>
	*/
	public String toString(){
		String obj = "\n***************User***************\n" +
					 "**User name: " + getName() + "\n" +
					 "**Age: " + getAge() + "\n" +
					 "**Category: " + getCategory() + "\n" +
					 "\n**********************************\n";
		return obj;
	}//End toString
}//End class User