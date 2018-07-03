package Component;

import java.awt.Color;

import javax.swing.JButton;

public class Square extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int x,y;
	Piece piece;
	
	public Square(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.setBackground(color);
		piece = null;
	}
	
	public boolean setPiece(Piece piece) {
		this.piece = piece;
		setIcon(piece.icon);
		return false;
	}
	
	public boolean removePiece() {
		piece = null;
		return false;
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
	
	public Piece getPiece() {
		return piece;
	}
}
