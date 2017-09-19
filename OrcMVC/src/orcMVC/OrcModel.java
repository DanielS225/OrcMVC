/* Kaeini Ekong
 * Daniel Schmidt
 * 
 * CISC 275 - 021L
 * Lab 3
 * 9/18/2017
 */

package orcMVC;

import java.awt.image.BufferedImage;

public class OrcModel {
	// current picture that is being displayed
	int picNum = 0;

	BufferedImage[][] pics;

	final int xIncr = 8;
	final int yIncr = 2;

	int xloc, yloc; // undefined until object created

	final static int frameWidth = 500;
	final static int frameHeight = 300;
	// Are constants only because all the png's are same size
	final static int imgWidth = 165;
	final static int imgHeight = 165;

	final static int xOffset = 30;
	final static int yOffset = 30;

	final static int frameCount = 10;

	orcAction currentAction;

	public OrcModel() {
		picNum = 0;
		currentAction = orcAction.FORWARD_SOUTHEAST;
		xloc = 0;
		yloc = 0;
	}

	// Action enum, used for movement and image loading/selection
	public enum orcAction {
		FORWARD_NORTHEAST, FORWARD_NORTHWEST, FORWARD_SOUTHEAST, FORWARD_SOUTHWEST, FORWARD_NORTH, FORWARD_SOUTH, FORWARD_EAST, FORWARD_WEST
	}

	public int incrementX() {
		xloc += xIncr;
		return xloc;
	}

	public int decrementX() {
		xloc -= xIncr;
		return xloc;
	}

	public int incrementY() {
		yloc += yIncr;
		return yloc;
	}

	public int decrementY() {
		yloc -= yIncr;
		return yloc;
	}

	public int calcEastBound() {
		return frameWidth - imgWidth;
	}

	public int calcWestBound() {
		return 0 - xOffset;
	}

	public int calcSouthBound() {
		return frameHeight - imgHeight - yOffset;
	}

	public int calcNorthBound() {
		return 0 - yOffset;
	}
}
