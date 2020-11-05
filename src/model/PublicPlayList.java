package model;

public class PublicPlayList extends PlayList{
	private double qualification;
	
	public PublicPlayList(){
		super();
		qualification = 0;
	}//End PublicPlayList
	
	public PublicPlayList(String name,double qualification){
		super(name);
		this.qualification = qualification;
	}//End PublicPlayList
	
	public void setQualification(double q){
		qualification = q;
	}//End setRate
	public double getQualification(){
		return qualification;
	}//End getRate
	
	public double calculateQualification(double q){
		double qualification = 0;
		if(getQualification() > 0)
			qualification = (q + getQualification())/2;
		else
			qualification = q;
		
		setQualification(qualification);
		
		return qualification;
	}//End calculateQualification
	@Override
	public String toString(){
		String obj = super.toString() + "**Qualification: " + getQualification() + "\n";
		return obj;
	}//End toString
}//End PublicPlayList