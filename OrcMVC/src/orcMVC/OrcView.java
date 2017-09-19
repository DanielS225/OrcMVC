/* Kaeini Ekong
 * Daniel Schmidt
 * 
 * CISC 275 - 021L
 * Lab 3
 * 9/18/2017
 */

package orcMVC;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import orcMVC.OrcModel.orcAction;

public class OrcView {
	JFrame frame;
	Animation a;
	OrcModel m;

	public OrcView(OrcModel m) {
		this.m = m;
		frame = new JFrame();
		a = new Animation(m);
		frame.getContentPane().add(a);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(OrcModel.frameWidth, OrcModel.frameHeight);
		frame.setVisible(true);
	}

	public void images(OrcModel m, int xStart, int yStart, OrcModel.orcAction initialAction) { // original x location, y location, and initial action
		m.currentAction = initialAction;
		m.xloc = xStart;
		m.yloc = yStart;
		BufferedImage img;
		m.pics = new BufferedImage[orcAction.values().length][OrcModel.frameCount];
		for (OrcModel.orcAction a : orcAction.values()) {
			for (int i = 0; i < OrcModel.frameCount; i++) {
				img = OrcController.createImage(a);
				m.pics[a.ordinal()][i] = img.getSubimage(OrcModel.imgWidth * i, 0, OrcModel.imgWidth,
						OrcModel.imgHeight);
			}
		}
	}
}