package orcMVC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import orcMVC.OrcModel.orcAction;


public class OrcView extends JPanel{
	JFrame frame;
	Animation a;
	OrcModel m;
	public OrcView(OrcModel m){
		this.m = m;
		frame = new JFrame();
		a = new Animation(m);
    	frame.getContentPane().add(a);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(OrcModel.frameWidth, OrcModel.frameHeight);
    	frame.setVisible(true);
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
				m.pics[a.ordinal()][i] = img.getSubimage(OrcModel.imgWidth * i, 0, OrcModel.imgWidth, OrcModel.imgHeight);
			}
		}
    }
}