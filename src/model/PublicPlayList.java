package model;

public class PublicPlayList extends PlayList{
	private double score;
	
	public PublicPlayList(){
		super();
		score = 0;
	}//End PublicPlayList
	
	public PublicPlayList(String name,double score){
		super(name);
		this.score = score;
	}//End PublicPlayList
	
	public void setScore(double s){
		score = calculateScore(s);
	}//End setRate
	public double getScore(){
		return score;
	}//End getRate
	
	public double calculateScore(double s){
		double score = 0;
		if(getScore() > 0)
			score = (s + getScore())/2;
		else
			score = s;
		
		return score;
	}//End calculateQualification
	@Override
	public String toString(){
		String obj = super.toString() + "**Score: " + getScore() + "\n";
		return obj;
	}//End toString
}//End PublicPlayList