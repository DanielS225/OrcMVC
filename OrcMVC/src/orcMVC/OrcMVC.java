/* Kaeini Ekong
 * Daniel Schmidt
 * 
 * CISC 275 - 021L
 * Lab 3
 * 9/18/2017
 */

package orcMVC;

public class OrcMVC {
	public static void main(String[] args) {
		
		//Creates the model, view, and controller
		OrcModel m = new OrcModel();
		OrcView v = new OrcView(m);
		OrcController c = new OrcController(m,v);
		
		for (int i = 0; i < 1000; i++) {
			c.updateAction(m.currentAction);
			v.frame.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
