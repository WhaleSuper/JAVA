import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import tictactoe.Player;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeModel;



/**
 * Test cases for the TicTacToe model. Verifying that game state is properly managed, and
 * all game actions are properly validated.
 */
public class TicTacToeModelTest {

  private TicTacToe ttt1 = new TicTacToeModel();

  @Test
  public void testMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
  }

  // 3.11 Test if a horizontal win properly ends the game.
  @Test
  public void testHorizontalWin() {
    ttt1.move(0, 0); // X takes upper left
    assertFalse(ttt1.isGameOver());
    ttt1.move(1, 0); // O takes middle left
    ttt1.move(0, 1); // X takes upper middle
    assertNull(ttt1.getWinner());
    ttt1.move(2, 0); // O takes lower left
    ttt1.move(0, 2); // X takes upper right
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
    assertEquals(" X | X | X\n"
        + "-----------\n"
        + " O |   |  \n"
        + "-----------\n"
        + " O |   |  ", ttt1.toString());
  }

  // 3.12 Test if a vertical win properly ends the game.
  @Test
  public void testVerticalWin() {
    ttt1.move(0, 0); // X takes upper left
    assertFalse(ttt1.isGameOver());
    ttt1.move(0, 1); // O takes middle left
    ttt1.move(1, 0); // X takes upper middle
    assertNull(ttt1.getWinner());
    ttt1.move(0, 2); // O takes lower left
    ttt1.move(2, 0); // X takes upper right
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
    assertEquals(" X | O | O\n"
        + "-----------\n"
        + " X |   |  \n"
        + "-----------\n"
        + " X |   |  ", ttt1.toString());
  }

  // 3. 13 Test if a diagonal win properly ends the game.
  @Test
  public void testDiagonalWin() {
    diagonalWinHelper();
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.O, ttt1.getWinner());
    assertEquals(" X | X | O\n"
        + "-----------\n"
        + " X | O |  \n"
        + "-----------\n"
        + " O |   |  ", ttt1.toString());
  }

  // set up situation where game is over, O wins on the diagonal, board is not full
  private void diagonalWinHelper() {
    ttt1.move(0, 0); // X takes upper left
    assertFalse(ttt1.isGameOver());
    ttt1.move(2, 0); // O takes lower left
    ttt1.move(1, 0); // X takes middle left
    assertNull(ttt1.getWinner());
    ttt1.move(1, 1); // O takes center
    ttt1.move(0, 1); // X takes upper middle
    ttt1.move(0, 2); // O takes upper right
  }

  @Test
  public void testInvalidMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    assertEquals(Player.X, ttt1.getMarkAt(0, 0));
    try {
      ttt1.move(0, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      ttt1.move(-1, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testMoveAttemptAfterGameOver() {
    diagonalWinHelper();
    ttt1.move(2, 2); // 2,2 is an empty position
  }

  // 3.14 Test if a tied game (called a Cat's game) properly ends the game.
  @Test
  public void testCatsGame() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(1, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 2);
    ttt1.move(0, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 2);
    ttt1.move(2, 0);
    assertTrue(ttt1.isGameOver());
    assertNull(ttt1.getWinner());
    assertEquals(" X | O | X\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " X | X | O", ttt1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtRow() {
    ttt1.getMarkAt(-12, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtCol() {
    ttt1.getMarkAt(0, -30);
  }

  // 3.16 Test the getBoard method.
  @Test
  public void testGetBoard() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    assertEquals(Player.X, bd[0][0]);
    assertEquals(Player.O, bd[1][1]);
    assertEquals(Player.X, bd[0][1]);

    // attempt to cheat by mutating board returned by getBoard()
    // check correct preconditions
    assertEquals(Player.O, bd[2][0]);
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    bd[2][0] = Player.X;  // mutate
    // check correct post conditions
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    Player[][] bd2 = ttt1.getBoard();
    assertEquals(Player.O, bd2[2][0]);
  }

  // 3.15 test case where board is full AND there is a winner with getWinner method.
  @Test
  public void testFullBoardAndGetWinner() {
    ttt1.move(0, 0);
    ttt1.move(0, 1);
    ttt1.move(0, 2);
    ttt1.move(1, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 0);
    ttt1.move(2, 2);
    assertTrue(ttt1.isGameOver());
    assertEquals(Player.X, ttt1.getWinner());
    assertEquals(" X | O | X\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " O | X | X", ttt1.toString());

    try {
      ttt1.move(0, 0);
      fail("Board is full! Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Board is full!", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  // Test that verifies the valid and invalid getTurn method.
  @Test
  public void testGetTurnMethod() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(0, 1);
    assertNotEquals(Player.O, ttt1.getTurn());
  }

  // Test that verifies the valid isGameOver method.
  @Test
  public void testValidIsGameOverMethod() {
    diagonalWinHelper();
    assertTrue(ttt1.isGameOver());
  }

  // Test that verifies the getMarkAt method.
  @Test
  public void testGetMarkAt() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    assertEquals(Player.X, bd[0][0]);
    assertEquals(Player.O, bd[1][1]);
    assertEquals(Player.X, bd[0][1]);

    // attempt to cheat by mutating board returned by getBoard()
    // check correct preconditions
    assertEquals(Player.O, bd[2][0]);
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    assertNotEquals(Player.X, ttt1.getMarkAt(2, 0));
  }

  // Test that verifies the toString method.
  @Test
  public void testToStringMethod() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(0, 1);
    assertEquals(Player.X, ttt1.getTurn());
    ttt1.move(0, 2);
    ttt1.move(1, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 0);
    ttt1.move(2, 2);
    assertEquals(" X | O | X\n"
        + "-----------\n"
        + " O | O | X\n"
        + "-----------\n"
        + " O | X | X", ttt1.toString());
  }

  // 3.2 Test to verify that the game starts with Player X.
  @Test
  public void testStartPlayer() {
    ttt1.move(0, 0);
    Player[][] bd = ttt1.getBoard();
    assertEquals("X", bd[0][0].toString());
  }

  // 3.3 Test that the player whose turn it is changes when the move() method is called.
  @Test
  public void testTurnChangeAfterMove() {
    ttt1.move(0, 0);
    assertEquals(Player.O, ttt1.getTurn());
    ttt1.move(0, 1);
    assertEquals(Player.X, ttt1.getTurn());
  }

  // 3.4 Test that a move cannot be made to an invalid row and/or column.
  @Test
  public void testInvalidRowOrColumnMove() {
    ttt1.move(0, 0);
    try {
      ttt1.move(-8, 0);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
    try {
      ttt1.move(0, 8);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  // 3.5 Test that a move cannot be made to a square that is already filled in.
  @Test
  public void testInvalidOccupiedMove() {
    ttt1.move(1, 1);
    try {
      ttt1.move(1, 1);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  // 3.6 Test that a move cannot be made after the game is over
  @Test
  public void testInvalidMoveAfterGameOver() {
    ttt1.move(0, 0);
    ttt1.move(0, 1);
    ttt1.move(0, 2);
    ttt1.move(1, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 0);
    ttt1.move(2, 2);
    try {
      ttt1.move(1, 1);
      fail("Invalid move should have thrown exception");
    } catch (IllegalArgumentException iae) {
      //assertEquals("Position occupied", iae.getMessage());
      assertTrue(iae.getMessage().length() > 0);
    }
  }

  // 3.7 Test that the getMarkAt method returns the correct value.
  @Test
  public void testValidGetMarkAt() {
    diagonalWinHelper();
    Player[][] bd = ttt1.getBoard();
    assertEquals(Player.O, ttt1.getMarkAt(2, 0));
    assertNotEquals(Player.X, ttt1.getMarkAt(2, 0));
  }

  // 3.8 Test the getMarkAt method throws an exception for an invalid row and/or column.
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidGetMarkAtColumnAndRow() {
    ttt1.getMarkAt(10, 0);
    ttt1.getMarkAt(0, 10);
  }

  // 3.9 Test if the isGameOver method returns true when the game is over.
  @Test
  public void testValidIsGameOver() {
    ttt1.move(0, 0);
    ttt1.move(0, 1);
    ttt1.move(0, 2);
    ttt1.move(1, 1);
    ttt1.move(2, 1);
    ttt1.move(1, 0);
    ttt1.move(1, 2);
    ttt1.move(2, 0);
    ttt1.move(2, 2);
    assertTrue(ttt1.isGameOver());
  }

  // 3.10 Test if the isGameOver method returns false when the game is not over.
  @Test
  public void testInvalidIsGameOverMethod() {
    ttt1.move(0, 0);
    ttt1.move(0, 1);
    ttt1.move(0, 2);
    ttt1.move(1, 1);
    ttt1.move(2, 1);
    ttt1.move(2, 2);
    assertFalse(ttt1.isGameOver());
  }

}

