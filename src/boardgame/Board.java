package boardgame;

public class Board {//

	private int rows;
	private int column;
	private Piece[][] pieces;
	
	public Board(int rows, int column) {
	
		this.rows = rows;
		this.column = column;
		pieces  = new Piece[rows][column];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Piece piece (int row, int column) {//m�todo para definir a posi��o da pe�a
		return pieces[row][column];
	}
		
	public Piece piece(Position position) {//m�todo para definir a posi��o da pe�a
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void PlacePiece(Piece piece, Position position) {// m�todo pra incluir pe�as no tabuleiro
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
