package model;

public class PublicPlayList extends PlayList{
	private double rate;
	
	public PublicPlayList(){
		super();
		rate = 0;
	}//End PublicPlayList
	
	public PublicPlayList(String name,double rate){
		super(name);
		this.rate = rate;
	}//End PublicPlayList
	
	public void setRate(double r){
		rate = r;
	}//End setRate
	public double getRate(){
		return rate;
	}//End getRate
	
	public double 
}//End PublicPlayList