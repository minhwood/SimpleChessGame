package Component;

import java.awt.Color;

import javax.swing.JButton;

public class Square extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x,y;
	
	public Square(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.setBackground(color);
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
}
