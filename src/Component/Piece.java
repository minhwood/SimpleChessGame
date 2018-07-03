package Component;

import javax.swing.ImageIcon;

public abstract class Piece {
	
	// if type == false then the piece is black
	// if type == true then the piece is white
	protected String BLACK_KNIGHT_ICON = "IMG/knightb.png";
	protected String WHITE_KNIGHT_ICON = "IMG/knightw.png";
	protected String BLACK_ROOK_ICON = "IMG/rookb.png";
	protected String WHITE_ROOK_ICON = "IMG/rookw.png";
	protected String BLACK_BISHOP_ICON = "IMG/bishopb.png";
	protected String WHITE_BISHOP_ICON = "IMG/bishopw.png";
	protected String BLACK_QUEEN_ICON = "IMG/knightb.png";
	protected String WHITE_QUEEN_ICON = "IMG/knightw.png";
	protected String BLACK_KING_ICON = "IMG/knightw.png";
	protected String WHITE_KING_ICON = "IMG/knightw.png";
	
	boolean color;
	ImageIcon icon;
	boolean onBoard;
	
	public Piece() {
		onBoard = true;
	}
	
	public boolean isBlack() {
		if (color == false ) return true;
		else return false;
	}
	
	public boolean isWhite() {
		if (color == false ) return false;
		else return true;
	}
	
	public Boolean getColor() {
		return color;
	}
	
	/* function check the basic rule for piece , Overridden by every child class */
	public abstract boolean basicRuleCheck(int posx, int posy, int x, int y);
	

	/* function check if their any piece on the way of the move, if the move is possible */
	public abstract boolean moveValidation(int posx, int posy, int x, int y, Board board);
	
}
