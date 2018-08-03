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
	
	
	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		if (this.color == false) {
			if (didFirstJump == true && x == posx + 2 ) {
				return false;
			}
			else {
				if ((x == posx + 2 && posy == y) || (x == posx + 1 && posy == y )) {
					return true;
				}
				else if ((x == posx + 1 && y == posy + 1) || (x == posx + 1 && y == posy - 1)) {
					return true;
				}
				else return false;
			}
		}
		else if (this.color == true) {
			if (didFirstJump == true && x == posx - 2 ) {
				return false;
			}
			else {
				if ((x == posx - 2 && posy == y) || (x == posx - 1 && posy == y )) {
					return true;
				}
				else if ((x == posx - 1 && y == posy + 1) || (x == posx - 1 && y == posy - 1)) {
					return true;
				}
				else return false;
			}
		}
		return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		if (basicRuleCheck(posx,posy,x,y) == true) {
			if (this.color == false) {
				if ((x == posx + 2 && posy == y) || (x == posx + 1 && posy == y )) {
					if (board.squares[x][y].getPiece() != null) {
						return false;
					}
					else {
						didFirstJump = true;
						return true;
					}
				}
				else if ((x == posx + 1 && y == posy + 1) || (x == posx + 1 && y == posy - 1)) {
					if (board.squares[x][y].getPiece() != null && board.squares[x][y].getPiece().getColor() != this.color) {
						didFirstJump = true;
						return true;
					}
					else return false;
				}
				else return false;
			}
			else if (this.color == true) {
				if ((x == posx - 2 && posy == y) || (x == posx - 1 && posy == y )) {
					if (board.squares[x][y].getPiece() != null) {
						return false;
					}
					else {
						didFirstJump = true;
						return true;
					}
				}
				else if ((x == posx - 1 && y == posy + 1) || (x == posx - 1 && y == posy - 1)) {
					if (board.squares[x][y].getPiece() != null && board.squares[x][y].getPiece().getColor() != this.color) {
						didFirstJump = true;
						return true;
					}
					else return false;
				}
				else return false;
			}
		}
		return false;
	}

}
