package orcMVC;

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;



public class OrcController {
	
	public OrcModel m;
	public OrcView v;
	
	public OrcController(OrcModel m, OrcView v) {
		/*
		 * CARDINAL DIRECTION TO FRAME ORIENTATION North = Top of the frame
		 * South = Bottom of the frame East = Right of the frame West = Left of
		 * the frame
		 */
		this.m = m;
		this.v = v;
		
		int xInit = 0;
		int yInit = 0;

		// v.frame.getContentPane().add();
		// frame.getContentPane().add(new Animation(xInit, yInit,
		// orcAction.FORWARD_SOUTHEAST));
		v.frame.setBackground(Color.gray);
		v.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.frame.setSize(OrcModel.frameWidth, OrcModel.frameHeight);
		v.frame.setVisible(true);
	}

	public static BufferedImage createImage(OrcModel.orcAction specifiedAction) { // orcAction is an enum corresponding to a png file
		BufferedImage bufferedImage;
		String file = "";
		switch (specifiedAction) {
		case FORWARD_NORTHEAST:
			file = "images/orc/orc_forward_northeast.png";
			//System.out.println(specificedAction);
			break;
		case FORWARD_NORTHWEST:
			file = "images/orc/orc_forward_northwest.png";
			break;
		case FORWARD_SOUTHEAST:
			file = "images/orc/orc_forward_southeast.png";
			break;
		case FORWARD_SOUTHWEST:
			file = "images/orc/orc_forward_southwest.png";
			break;
		case FORWARD_NORTH:
			file = "images/orc/orc_forward_north.png";
			break;
		case FORWARD_SOUTH:
			file = "images/orc/orc_forward_south.png";
			break;
		case FORWARD_EAST:
			file = "images/orc/orc_forward_east.png";
			break;
		case FORWARD_WEST:
			file = "images/orc/orc_forward_west.png";
			break;
		}
		try {
			bufferedImage = ImageIO.read(new File(file));
			return bufferedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateAction(OrcModel.orcAction currentAction){
		
		if(m.xloc >= m.calcEastBound()){// East boundary switching direction
    		switch(currentAction){// Redirection
	    		case FORWARD_EAST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_WEST;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_NORTHWEST;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_SOUTHWEST;
	    			break;
    		}
    	}
    	else if (m.xloc < m.calcWestBound()){//West boundary switching direction, offset to account for blank space on image.
    		
    		switch(m.currentAction){
	    		case FORWARD_WEST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_EAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_SOUTHEAST;
	    			break;
	    	}
    	}
    	else if (m.yloc >= m.calcSouthBound()){// South boundary switching direction, offset to account for blank space on image.
    		
    		switch(m.currentAction){
	    		case FORWARD_SOUTH:
	    			m.currentAction = OrcModel.orcAction.FORWARD_NORTH;
	    			break;
	    		case FORWARD_SOUTHEAST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_NORTHEAST;
	    			break;
	    		case FORWARD_SOUTHWEST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_NORTHWEST;
	    			break;
	    	}
    	}
    	else if (m.yloc < m.calcNorthBound()){// North boundary switching direction, offset to account for blank space on image.
    		
    		switch(m.currentAction){
	    		case FORWARD_NORTH:
	    			m.currentAction = OrcModel.orcAction.FORWARD_SOUTH;
	    			break;
	    		case FORWARD_NORTHEAST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_SOUTHEAST;
	    			break;
	    		case FORWARD_NORTHWEST:
	    			m.currentAction = OrcModel.orcAction.FORWARD_SOUTHWEST;
	    			break;
	    			}
    }
}
}
		