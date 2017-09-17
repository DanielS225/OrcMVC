package orcMVC;

public class OrcMVC {
	public static void main(String[] args) {
		
		OrcModel m = new OrcModel();
		OrcView v = new OrcView(m);
		OrcController c = new OrcController(m,v);
		
		for (int i = 0; i < 1000; i++) {
			v.frame.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
