package orcMVC;

public class OrcModel {
	//current picture that is being displayed
	int picNum = 0;

	final int xIncr = 8;
	final int yIncr = 2;
	
	int xloc, yloc; //undefined until object created
	
	final static int frameWidth = 500;
	final static int frameHeight = 300;
	// Are constants only because all the png's are same size
	final static int imgWidth = 165;
	final static int imgHeight = 165;
	
	final static int xOffset = 30;
	final static int yOffset = 30;
	
	final int frameCount = 10;
	
	orcAction currentAction;
    
    public enum orcAction {
    	FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
    }

}
