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
	
	@Override
	public String toString(){
		String obj = super.toString() + "Owners: ";
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