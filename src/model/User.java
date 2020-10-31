package model;

public class User{
	private String name;
	private String password;
	private int age;
	private int shareSongs;
	Category category;
	
	public User(){
		name = new String();
		password = new String();;
		age = 0;
		shareSongs = 0;
		category = Category.NEWBIE;
	}//End constructor1
	public User(String name,String password,int age){
		this.name = name;
		this.password = password;
		this.age = age;
		shareSongs = 0;
		category = Category.NEWBIE;
	}//End constructor2
	
	public void setName(String name){
		this.name = name;
	}//End setName.
	public String getName(){
		return name;
	}//end getName
	public void setPassword(String password){
		this.password = password;
	}//End setPassword
	public String getPassword(){
		return password;
	}//End getPassword
	public void setAge(int age){
		this.age = age;
	}//End setAge
	public int getAge(){
		return age;
	}//End getAge
	public void setShareSongs(int shareSongs){
		this.shareSongs = shareSongs;
	}//End setShareSongs
	public int getShareSongs(){
		return shareSongs;
	}//End getShareSongs
	public void setCategory(String category){
		this.category = Category.valueOf(category);
	}//End setCategory
	public String getCategory(){
		return category.toString();
	}//End getCategory.
	
}//End class User