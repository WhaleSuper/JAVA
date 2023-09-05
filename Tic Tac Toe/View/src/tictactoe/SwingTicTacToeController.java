package tictactoe;

/**
 * Controller implementation of a tic-tac-toe game for Java Swing view.
 */
public class SwingTicTacToeController implements Features, TicTacToeController {
  private TicTacToe model;
  private TicTacToeView view;

  /**
   * Constructor for a SwingTicTacToeController.
   * @param view a tic-tac-toe game Java Swing view implementation
   * @param model a tic-tac-toe game model implementation
   * @throws IllegalArgumentException if view or model is null
   */
  public SwingTicTacToeController(TicTacToeView view, TicTacToe model)
      throws IllegalArgumentException {
    if (view == null || model == null) {
      throw new IllegalArgumentException("Cannot take any null object.");
    }
    this.model = model;
    this.view = view;
  }

  @Override
  public void playGame() {
    this.view.addFeatures(this);
  }

  @Override
  public void putMark(int row, int col) {
    try {
      if (!this.model.isGameOver()) {
        String player = this.model.getTurn().toString(); // get the current player
        this.model.move(row, col); // tell the model to try to make a move for this player
        view.updateBoard(row, col, player); // tell the view to update game board

        // if after the move, game is over, tell the view to display corresponding message
        if (this.model.isGameOver()) {
          if (this.model.getWinner() == null) {
            view.showTurn("Game is over! Tie game.");
          } else {
            view.showTurn("Game is over! " + model.getWinner() + " wins.");
          }
        } else {
          player = this.model.getTurn().toString(); // otherwise, get into the next turn
          view.showTurn("Turn: " + player);
        }
      } else {
        view.showErrorMessage("Game is over.");
        // if model says game is over, but player tries to make any move after game over,
        // tell view to pop up error message
      }
    } catch (IllegalArgumentException e) {
      view.showErrorMessage("Invalid move.");
      // if model indicates that a player makes any invalid move, tell view to pop up error message
    }
  }
}
