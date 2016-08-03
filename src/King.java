import java.util.ArrayList;

public class King extends Piece {
	private boolean isCheck;
	private Position[] changeInPosition = { new Position(1, 0), new Position(-1, 0), new Position(0, 1),
			new Position(0, -1), new Position(1, 1), new Position(1, -1), new Position(-1, 1), new Position(-1, -1) };

	public King(PieceType type, boolean isWhite, Position p) {
		super(type, isWhite, p);
		isCheck = false;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public Position getQueenSide() {
		Position location;
		if (this.isWhite()) {
			location = new Position(1, 3);
		} else {
			location = new Position(8, 3);
		}
		return location;
	}

	public Position getKingSide() {
		Position location;
		if (this.isWhite()) {
			location = new Position(1, 7);
		} else {
			location = new Position(8, 7);
		}
		return location;
	}

	public ArrayList<Position> getMovement(Piece[][] board, boolean isCapture) {
		Position p = this.getCurrentPosition();
		ArrayList<Position> possiblePositions = new ArrayList<Position>();
		for (Position pos : changeInPosition) {
			Position newPos = new Position(p.getRank() + pos.getRank(), p.getFile() + pos.getFile());
			if (newPos.isValid()) {
				if ((isCapture && board[newPos.getRank()][newPos.getFile()] != null)
						|| (!isCapture && board[newPos.getRank()][newPos.getFile()] == null)) {
					possiblePositions.add(newPos);
				}
			}
		}
		return possiblePositions;
	}

}
