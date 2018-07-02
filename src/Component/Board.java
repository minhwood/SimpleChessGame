package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Square[][] squares = new Square[9][9];
	
	Color black = Color.DARK_GRAY;
	Color white = Color.WHITE;
	
	public Board() {
		this.setLayout(new GridLayout(8,8));
		initSquare();
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				this.add(squares[i][j]);
			}
		}
		this.setPreferredSize(new Dimension(800,800));
		this.setVisible(true);
	}
	
	private void initSquare() {
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j< 9; j++) {
				if ((i+j) % 2 == 0) squares[i][j] = new Square(i,j,black);
				else squares[i][j] = new Square(i,j,white);
			}
		}
	}
}
