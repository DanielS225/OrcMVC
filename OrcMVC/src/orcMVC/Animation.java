package orcMVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Animation extends JPanel{
	OrcModel m;
	public Animation(OrcModel m) {
		this.m = m;
		BufferedImage img;
		m.pics = new BufferedImage[OrcModel.orcAction.values().length][OrcModel.frameCount];
		for (OrcModel.orcAction a : OrcModel.orcAction.values()) {
			for (int i = 0; i < OrcModel.frameCount; i++) {
				img = createImage(a);
				m.pics[a.ordinal()][i] = img.getSubimage(OrcModel.imgWidth * i, 0, OrcModel.imgWidth, OrcModel.imgHeight);
			}
		}
		System.out.println("Animation object created");
	}
	
	//Read image from file and return 
	private BufferedImage createImage(OrcModel.orcAction specifiedAction){ //orcAction is an enum corresponding to a png file
    	BufferedImage bufferedImage;
    	String file = "";
    	switch(specifiedAction){
    	case FORWARD_NORTHEAST: 
    		file = "images/orc/orc_forward_northeast.png";
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
	
	public void paint(Graphics g) {
		System.out.println("Do we get here?");
    	/*CARDINAL DIRECTION TO FRAME ORIENTATION
    	 * North = Top of the frame
    	 * South = Bottom of the frame
    	 * East = Right of the frame
    	 * West = Left of the frame
    	 */
		g.drawImage(m.pics[m.currentAction.ordinal()][m.picNum], m.xloc, m.yloc, Color.gray, this);
    	m.picNum = (m.picNum + 1) % m.frameCount;
    	
    	 switch(m.currentAction){// Increments coordinates by direction
	 		case FORWARD_NORTH:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_NORTH.ordinal()][m.picNum], m.xloc, m.decrementY(), Color.gray, this);
	 			break;
	 		case FORWARD_SOUTH:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_SOUTH.ordinal()][m.picNum], m.xloc, m.incrementY(), Color.gray, this);
	 			break;
	 		case FORWARD_EAST:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_EAST.ordinal()][m.picNum], m.incrementX(), m.yloc, Color.gray, this);
	 			break;
	 		case FORWARD_WEST:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_WEST.ordinal()][m.picNum], m.decrementX(), m.yloc, Color.gray, this);
	 			break;
	 		case FORWARD_NORTHEAST:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_NORTHEAST.ordinal()][m.picNum], m.incrementX(), m.decrementY(), Color.gray, this);
	 			break;
	 		case FORWARD_NORTHWEST:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_NORTHWEST.ordinal()][m.picNum], m.decrementX(), m.decrementY(), Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHEAST:
	 			System.out.println(m.pics[OrcModel.orcAction.FORWARD_SOUTHEAST.ordinal()][m.picNum]);
	 			//System.out.println(m.xloc+m.xIncr);
	 			//System.out.println(m.yloc+m.yIncr);
	 			//System.out.println(this);
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_SOUTHEAST.ordinal()][m.picNum], m.incrementX(), m.incrementY(), Color.gray, this);
	 			break;
	 		case FORWARD_SOUTHWEST:
	 			g.drawImage(m.pics[OrcModel.orcAction.FORWARD_SOUTHWEST.ordinal()][m.picNum], m.decrementX(), m.incrementY(), Color.gray, this);
	 			break;
	 	}
    }
}
