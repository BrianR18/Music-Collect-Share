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
		this.name = validateString(name);
		this.password = password;
		this.age = age;
		shareSongs = 0;
		category = Category.NEWBIE;
	}//End constructor2
	
	public void setName(String name){
		this.name = validateString(name);
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
	
	private String validateString(String s){
		String validated = new String();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                validated += s.charAt(i);
            }//End if
        }//End for
		return validated;
	}//End validateString
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
	
	//
	public void updateCategory(){
		if(getShareSongs() == 3)
			category = Category.LITTLE_CONTRIBUTOR;
		else if(getShareSongs() == 10)
			category = Category.MILD_CONTRIBUTOR;
		else if(getShareSongs() == 30)
			category = Category.STAR_CONTRIBUTOR;
	}//End updateCategory
				
	public String toString(){
		String obj = "\n***************User***************\n" +
					 "**User name: " + getName() + "\n" +
					 "**Age: " + getAge() + "\n" +
					 "**Category: " + getCategory() + "\n" +
					 "\n**********************************\n";
		return obj;
	}//End toString
}//End class User