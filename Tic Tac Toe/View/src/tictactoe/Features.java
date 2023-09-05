package tictactoe;

/**
 * Interface for features of a tic-tac-toe controller for Swing view. The controller should
 implement this interface to inherit the features and get connected with the view.
 */
public interface Features {

  /**
   * Puts mark in the corresponding cell (represented by a row and column) on a 3x3 tic-tac-toe game
   board showed by a Java Swing view. The mark will be X/O depending on the player's turn.
   * @param row the row of the cell to be marked by the current player
   * @param col the column of the cell to be marked by the current player
   */
  void putMark(int row, int col);
}
