package Component;

import javax.swing.ImageIcon;

public class Knight extends Piece {
	
	public Knight(String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_KNIGHT_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_KNIGHT_ICON);
			this.color = false;
		}
	}

	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		if (posx==x && posy==y)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
			if (basicRuleCheck(posx, posy, x,y))
			{
				/*not allow the piece to move on top of the same color piece*/
				if  ( board.squares[x][y].getPiece()!=null && board.squares[x][y].getPiece().getColor()==this.color)
				{
					return false;
				}
				else{
					if(x == posx-2 && y == posy-1)
					{
						return true;
					}
					else if(x == posx-2 && y == posy+1)
					{
						return true;
					}
					else if(x == posx+2 && y == posy+1)
					{
						return true;
					}
					else if(x == posx+2 && y == posy-1)
					{
						return true;
					}
					else if(x == posx-1 && y == posy+2)
					{
						return true;
					}
					else if(x == posx-1 && y == posy-2)
					{
						return true;
					}
					else if(x == posx+1 && y == posy+2)
					{
						return true;
					}
					else if(x == posx+1 && y == posy-2)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
			}
			else return false;
		}
}
