import javax.swing.SwingUtilities;

import interfaces.ConnexionFenetre;

public class Program {

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	
	        	ConnexionFenetre test = new ConnexionFenetre();
	        	test.setVisible(true);
	        	test.pack();
	        }
	    });
	}

}
