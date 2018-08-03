package Component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class Board extends JPanel implements ActionListener {

	/**
	 * 
	 */
	Square choosenPiece=null;
	
	private static final long serialVersionUID = 1L;
	
	Square[][] squares = new Square[9][9];
	
	Color black = Color.DARK_GRAY;
	Color white = Color.WHITE;
	
	Boolean turn;
	
	public Board() {
		this.setLayout(new GridLayout(8,8));
		initSquare();
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				this.add(squares[i][j]);
			}
		}
		turn = true;
		this.setPreferredSize(new Dimension(800,800));
		this.setVisible(true);
	}
	
	private boolean activePiece(Square selectedSquare) {
		if (selectedSquare.getPiece() != null && selectedSquare.getPiece().getColor() == turn ) {
			this.choosenPiece = selectedSquare;
			this.choosenPiece.setBackground(Color.GREEN);
			return true;
		}
		return false;
	}
	
	private Square findSquare(Object position) {
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j< 9; j++) {
				if (position == squares[i][j]) {
						return squares[i][j];
				}
			}
		}
		return null;
	}
	
	private void rePaintBoard() {
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j< 9; j++) {
				if ((i+j) % 2 == 0) squares[i][j].setBackground(black);
				else squares[i][j].setBackground(white);
			}
		}
	}
	
	public boolean movePiece(int x, int y, Square choosenPiece)
	{
		if (choosenPiece.getPiece().moveValidation(choosenPiece.getPosX(), choosenPiece.getPosY(), x,y,this))
		{
			/*normal move*/
			if (squares[x][y].getPiece()==null)
			{
			squares[x][y].setPiece(choosenPiece.getPiece());
			choosenPiece.setPiece(null);
			changeTurn();
			return true;
			}
			/*attack move*/
			else{ 
				if (squares[x][y].getPiece().getColor()!=choosenPiece.getPiece().getColor())
				{
					squares[x][y].getPiece().kill();
					squares[x][y].setPiece(choosenPiece.getPiece());
					choosenPiece.setPiece(null);
					changeTurn();
					return true;		
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	
	private void initSquare() {
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j< 9; j++) {
				if ((i+j) % 2 == 0) squares[i][j] = new Square(i,j,black);
				else squares[i][j] = new Square(i,j,white);
				squares[i][j].addActionListener(this);
			}
		}
		setPieces();
	}
	
	private void setPieces() {
		squares[8][7].setPiece(new Knight("w"));
		squares[8][2].setPiece(new Knight("w"));
		squares[1][7].setPiece(new Knight("b"));
		squares[1][2].setPiece(new Knight("b"));
		squares[8][6].setPiece(new Bishop("w"));
		squares[8][3].setPiece(new Bishop("w"));
		squares[1][6].setPiece(new Bishop("b"));
		squares[1][3].setPiece(new Bishop("b"));
		squares[8][8].setPiece(new Rook("w"));
		squares[8][1].setPiece(new Rook("w"));
		squares[1][8].setPiece(new Rook("b"));
		squares[1][1].setPiece(new Rook("b"));
		
		// Pawn
		squares[2][6].setPiece(new Pawn("b"));
		squares[2][3].setPiece(new Pawn("b"));
		squares[2][8].setPiece(new Pawn("b"));
		squares[2][1].setPiece(new Pawn("b"));
		squares[2][7].setPiece(new Pawn("b"));
		squares[2][2].setPiece(new Pawn("b"));
		squares[2][4].setPiece(new Pawn("b"));
		squares[2][5].setPiece(new Pawn("b"));
		squares[7][7].setPiece(new Pawn("w"));
		squares[7][2].setPiece(new Pawn("w"));
		squares[7][6].setPiece(new Pawn("w"));
		squares[7][3].setPiece(new Pawn("w"));
		squares[7][8].setPiece(new Pawn("w"));
		squares[7][1].setPiece(new Pawn("w"));
		squares[7][4].setPiece(new Pawn("w"));
		squares[7][5].setPiece(new Pawn("w"));
		//KingQueen
		squares[1][5].setPiece(new King("b"));
		squares[8][5].setPiece(new King("w"));
		squares[1][4].setPiece(new Queen("b"));
		squares[8][4].setPiece(new Queen("w"));
		
	}
	
	public void changeTurn()
	{
		if (turn==true){
			turn=false;
		}
		else 	
			{
			turn=true;
			}
	}
	
	public void actionPerformed(ActionEvent click) {
		/*System.out.println(choosenPiece);*/
		Object position= click.getSource();
		Square selectedSquare = findSquare(position);
		/*if no piece chosen to be move then let the user chose one*/
		if (choosenPiece == null ) {
			activePiece(selectedSquare);
		}
		else {
			movePiece( selectedSquare.getPosX(), selectedSquare.getPosY() , choosenPiece);
			choosenPiece = null;
			rePaintBoard();
		}
		
	}
}
