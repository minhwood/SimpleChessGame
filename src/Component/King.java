package Component;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class King extends Piece{

	public King(String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_KING_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_KING_ICON);
			this.color = false;
		}
	}
	
	@Override
	public void kill() {
		if (color == true) JOptionPane.showMessageDialog(null,"Black Win");
		else if (color == false) JOptionPane.showMessageDialog(null,"White Win");
		onBoard = false;
	}
	
	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		int xOffset = x - posx;
		int yOffset = y - posy;
		if (Math.abs(xOffset) <= 1 && Math.abs(yOffset) <= 1) return true;
		else return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		if (basicRuleCheck(posx, posy, x, y)) {
			if (board.squares[x][y].getPiece() != null && board.squares[x][y].getPiece().getColor() == this.color) return false;
			else return true;
		}
		return false;
	}

}
