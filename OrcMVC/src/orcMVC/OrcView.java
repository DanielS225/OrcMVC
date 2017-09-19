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
}