package orcMVC;

import java.awt.image.BufferedImage;

public class OrcModel {
	//current picture that is being displayed
	int picNum = 0;

	BufferedImage[][] pics;
	
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
	
	public OrcModel() {
		picNum = 0;
	}
	
    
    public enum orcAction {
    	FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
    }
    
    public void images(OrcModel m, int xStart, int yStart, OrcModel.orcAction initialAction){ //original x location, y location, and initial action
		m.currentAction = initialAction;
		m.xloc = xStart;
		m.yloc = yStart;
		BufferedImage img;
		m.pics = new BufferedImage[orcAction.values().length][m.frameCount];
		for (OrcModel.orcAction a : orcAction.values()) {
			for (int i = 0; i < m.frameCount; i++) {
				img = OrcController.createImage(a);
				m.pics[a.ordinal()][i] = img.getSubimage(imgWidth * i, 0, imgWidth, imgHeight);
			}
		}
    }
}
