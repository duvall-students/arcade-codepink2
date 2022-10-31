package gamePlay;

//@author: Shannon Seignious
public class Galaga extends Game {
	
	protected static final int MAX_BADGUY_COUNT = 40;
	
	@Override
	public boolean hasWon(int badGuyCount) {
		if (badGuyCount == MAX_BADGUY_COUNT) {
    		return true;
    	}
    	return false;
	}

}
