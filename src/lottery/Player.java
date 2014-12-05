package lottery;

public class Player {

	String name;
	int score;
	int level;
	boolean isHuman;
	
	//constructor
	public Player(String _name){
		
		if(_name !=  null && _name.length()>0){
			name = _name;
		} else{
			name ="Player";
		}
		
		score=0;
		
		isHuman=true;
		
		level=0;
	}
	
	public Player(String _name, boolean _isHuman, int _level){
		
		if(_name != null && _name.length()>0){
			name = _name;
		} else{
			name ="Player";
		}
		
		score=0;
		
		isHuman=_isHuman;
		
		level = _level;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int _score){
		score = _score;
	}
	
	public boolean isHuman(){
		return isHuman;
	}
	
	public String getName(){
		return name;
	}
	
	public int increaseScore(){
		score++;
		return getScore();
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int _level){
		level = _level;
	}
}
