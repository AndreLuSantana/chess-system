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
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[row][column];
	}
		
	public Piece piece(Position position) { //m�todo para definir a posi��o da pe�a
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board.");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) { // m�todo pra incluir pe�as no tabuleiro
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a piece on position." + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on board.");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	private boolean positionExists(int row, int column) {//m�todo auxiliar para verificar a existencia da posi��o no tabiuleiro
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {//m�todo que verifica a exist�ncia da posi��o no tabuleiro
		
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {//m�todo que verifica a existencia de uma pe�a na postii��o informada
		if(!positionExists(position)) {
			throw new BoardException("Position not on board.");
		}
		return piece(position)!= null;
	}
}
