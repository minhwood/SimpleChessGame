package Component;

import javax.swing.ImageIcon;

public class Queen extends Piece {
	
	Bishop bishopRule;
	Rook rookRule;
	
	public Queen(String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_QUEEN_ICON);
			this.color = true;
			bishopRule = new Bishop("w");
			rookRule = new Rook("w");
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_QUEEN_ICON);
			this.color = false;
			bishopRule = new Bishop("b");
			rookRule = new Rook("b");
		}
	}

	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		if (bishopRule.moveValidation(posx, posy, x, y, board) == true) return true;
		else if (rookRule.moveValidation(posx, posy, x, y, board) == true ) return true;
		else return false;
	}
}
