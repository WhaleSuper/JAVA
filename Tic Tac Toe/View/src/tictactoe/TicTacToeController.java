package tictactoe;

/**
 * Represents a Controller for Tic Tac Toe: handle user moves by executing them using the model;
 * convey move outcomes to the user in some form.
 */
public interface TicTacToeController {

  /**
   * Execute a single game of tic-tac-toe, this method will connect the model with applicable view
   and give control to the controller.
   */
  void playGame();
}
