package tictactoe;

/**
 * Interface for view for a tic-tac-toe game.
 */
public interface TicTacToeView {

  /**
   * Add the tic-tac-toe controller to the view.
   * @param f the implementation of controller
   */
  void addFeatures(Features f);

  /**
   * Displays who's the next turn to the player during the game. Once the game ends, display who
   is the winner or tie game if there is no winner.
   * @param msg the message indicating the next player or game is over
   */
  void showTurn(String msg);

  /**
   * Updates the game board to reflect a move made by the player.
   * @param row the row of the cell that the player takes a move
   * @param col the column of the cell that the player takes a move
   * @param player X/O string representation of the player who made the move
   */
  void updateBoard(int row, int col, String player);

  /**
   * Displays a popup message box to the player for errors/invalid moves.
   * @param msg the error message to be shown to player
   */
  void showErrorMessage(String msg);
}
