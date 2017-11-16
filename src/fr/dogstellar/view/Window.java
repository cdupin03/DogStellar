/**
 * 
 */
package fr.dogstellar.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author clarisse
 *
 */
public class Window extends JFrame {
	
	private JPanel north, south;
	

	public Window (String gameName) {
		
	}


	/**
	 * @return the north
	 */
	public JPanel getNorth() {
		return north;
	}


	/**
	 * @param north the north to set
	 */
	public void setNorth(JPanel north) {
		this.north = north;
	}


	/**
	 * @return the south
	 */
	public JPanel getSouth() {
		return south;
	}


	/**
	 * @param south the south to set
	 */
	public void setSouth(JPanel south) {
		this.south = south;
	}
	
	
}
