package Component;

import javax.swing.ImageIcon;

public class Pawn extends Piece {
	
	private boolean didFirstJump;
	
	public Pawn(String color) {
		super();
		this.didFirstJump = false;
		if (color == "w") {
			icon = new ImageIcon(WHITE_PAWN_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_PAWN_ICON);
			this.color = false;
		}
	}
	
	private boolean firstRule(int posx, int posy, int x , int y) {
		return false;
	}
	
	private boolean secondRule() {
		return false;
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
