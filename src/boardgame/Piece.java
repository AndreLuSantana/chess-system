package boardgame;

public class Piece {//defini��o da Pe�a

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		
		this.board = board;
		position = null;
	}
	protected Board getBoard() {
		return board;
	}
	
	
}
