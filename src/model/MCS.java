package model;

public class MCS{
	private User[] users;
	private Song[] poolSongs;
	
	public MCS(){
		users = new User[10];
		poolSongs = new Song[30];
	}//End constructor
	public String addUser(String name,int age,String password){
		String msg = "No se ha podido agregar el usuario.\nNo quedan espacios de registro";
		boolean add = false;
		if(!checkName(name)){
			for(int i = 0; i < users.length && !add; i++){
				if(users[i] == null){
					users[i] = new User(name,password,age);
					add = true;
					msg = "Se ha agregado el usuario correctamente.";
				}//End if
			}//End for
		}//End if
		else
			msg = "No se ha podido agregar el usuario.\nYa existe un usuario con ese nombre.";
		return msg;
	}//End addUser
	private boolean checkName(String name){
		boolean check = false;
		for(int i = 0; i < users.length && !check; i++){
			if(users[i] != null){
				if(users[i].getName().equalsIgnoreCase(name)){
					check = true;
				}//End if equals
			}//End if null
		}//End for
		return check;
	}//End checkName
	public String displayUsers(){
		boolean all = false;
		String users = new String();
		for(int i = 0; i < users.length && !all; i++){
			if(users[i] != null){
				users += "\n***************User***************\n";
				users += "**User name: " + users[i].getName(); + "\n";
				users += "**Age: " + users[i].getAge(); + "\n";
				users += "**Category: " + users[i].getCategory(); + "\n";
				users += "\n**********************************\n";
			}//End if
			else
				all = true;
		}//End for
		return users;
	}//End displayUsers.
	
}//End MCS