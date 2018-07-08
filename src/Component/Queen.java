package Component;

import javax.swing.ImageIcon;

public class Queen extends Piece {

	public Queen(String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_QUEEN_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_QUEEN_ICON);
			this.color = false;
		}
	}

	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}
