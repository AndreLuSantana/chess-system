package boardgame;

public class Board {//

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1){
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces  = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumn() {
		return columns;
	}

	public Piece piece (int row, int column) { //m�todo para definir a posi��o da pe�a
		if(!PositionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[row][column];
	}
		
	public Piece piece(Position position) { //m�todo para definir a posi��o da pe�a
		if(!PositionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void PlacePiece(Piece piece, Position position) { // m�todo pra incluir pe�as no tabuleiro
		if(ThereIsAPiece(position)) {
			throw new BoardException("There is a piece on position." + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean PositionExists(int row, int column) {//m�todo auxiliar para verificar a existencia da posi��o no tabiuleiro
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean PositionExists(Position position) {//m�todo que verifica a exist�ncia da posi��o no tabuleiro
		
		return PositionExists(position.getRow(), position.getColumn());
	}
	
	public boolean ThereIsAPiece(Position position) {//m�todo que verifica a existencia de uma pe�a na postii��o informada
		if(!PositionExists(position)) {
			throw new BoardException("Position not on board.");
		}
		return piece(position)!= null;
	}
}
