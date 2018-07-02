package UI;

import java.awt.Dimension;

import javax.swing.JFrame;

import Component.Board;

public class GameUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameUI() {

		this.setPreferredSize(new Dimension(1000,1000));
		this.setSize(1000, 1000);
		this.add(new Board());
		this.setVisible(true);
	}
}
