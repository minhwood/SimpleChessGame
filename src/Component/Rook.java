package Component;

import javax.swing.ImageIcon;

public class Rook extends Piece{

	public Rook (String color) {
		super();
		if (color == "w") {
			icon = new ImageIcon(WHITE_ROOK_ICON);
			this.color = true;
		}
		else if (color == "b") {
			icon = new ImageIcon(BLACK_ROOK_ICON);
			this.color = false;
		}
	}
	
	@Override
	public boolean basicRuleCheck(int posx, int posy, int x, int y) {
		if ((x ==posx) && (y==posy))
			return false;
		else
		{
			if (x<9 && x>=1 && y<9 && y>=1)
			{
			if (posx==x)
				return true;
			else if (posy==y)
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean moveValidation(int posx, int posy, int x, int y, Board board) {
		if (basicRuleCheck(posx, posy, x,y))
		{
			/*not allow the piece to move on top of the same color piece*/
			if  ( board.squares[x][y].getPiece()!=null && board.squares[x][y].getPiece().getColor()==color)
			{
				return false;
			}
			else{
				/*check if there is any piece on the way*/
				for (int i=1;i<9;i++)
				{
					for (int j=1;j<9;j++)
					{
						if (board.squares[i][j].getPiece() != null)
							{
								if (basicRuleCheck(posx , posy , i,j))
								{
									if (((posy<j) && (j<y)) || ((posy>j) && (j>y)))
									{
										return false;
									}
									else if (((posx<i) && (i<x)) || ((posx>i) && (i>x)))
									{
										return false;
									}
								}
							}
					}
				}
			}
		}
		else return false;
		return true;
	}
	
}
