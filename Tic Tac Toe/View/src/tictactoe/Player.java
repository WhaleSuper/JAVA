package tictactoe;

/**
 * This enum represents the Player X and O of a tic-tac-toe game.
 */
public enum Player { X {
    @Override public String toString() {
      return "X";
    }
  }, O {
    @Override public String toString() {
      return "O";
    }
  }
}
