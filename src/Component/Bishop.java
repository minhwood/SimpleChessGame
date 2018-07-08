package Component;

import javax.swing.ImageIcon;

public class Bishop extends Piece {

	public Bishop (String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_BISHOP_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_BISHOP_ICON);
			this.color = false;
		}
	}
	
	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		if (x!=posx && y!=posy)
		{
			if (x<9 && x>=1 && y<9 && y>=1)
			{
				if (Math.abs(posx-x)==Math.abs(posy-y))
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		int xOffset,yOffset;
		if (basicRuleCheck(posx, posy, x, y))
		{
			/*not allow the piece to move on top of the same color piece*/
			if  ( board.squares[x][y].getPiece()!=null && board.squares[x][y].getPiece().getColor()==this.color)
			{
				return false;
			}
			else{
				if (posx<x)
					xOffset=1;
				else xOffset=-1;
				

				if (posy<y)
					yOffset=1;
				else yOffset=-1;
				
				/*check if there is any piece on the way*/
				int j=posy+yOffset;
				for (int i=posx+xOffset; i!=x; i+=xOffset)
				{
					 if (board.squares[i][j].getPiece()!=null)
					 {
							 return false;
					 }
				j=j+yOffset;
				}
			}
		}
		else return false;
		return true;
	}
	
}
