import org.junit.Test;
import tictactoe.SwingTicTacToeController;
import tictactoe.SwingTicTacToeView;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;
import tictactoe.TicTacToeView;

/**
 * Test case for the tic-tac-toe controller for Java Swing view.
 */
public class SwingTicTacToeControllerTest {

  /**
   * To test that an Illegal Argument Exception will be thrown if the model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    TicTacToe m = null;
    TicTacToeView v = new SwingTicTacToeView("Tic Tac Toe");
    TicTacToeController c = new SwingTicTacToeController(v, m);
  }

  /**
   * To test that an Illegal Argument Exception will be thrown if the view is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidView() {
    TicTacToe m = new TicTacToeModel();
    TicTacToeView v = null;
    TicTacToeController c = new SwingTicTacToeController(v, m);
  }
}
