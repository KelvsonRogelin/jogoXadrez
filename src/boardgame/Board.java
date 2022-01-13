package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows <0 || columns < 0) {
			throw new BoardException("Erro criando tabuleiro, é necessario que tenha pelo menos 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces =  new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionsExists(row, column)) {
			throw new BoardException("posição não está no tabuleiro");
		}
		return pieces[row][column];

	}

	public Piece piece(Position position) {
		if (!positionsExists(position)) {
			throw new BoardException("posição não está no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peça nesta posição" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionsExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionsExists(Position position) {
		return positionsExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {
		if (!positionsExists(position)) {
			throw new BoardException("posição não está no tabuleiro");
		}
		return piece(position) != null;
	}

}
