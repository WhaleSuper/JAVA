package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class TicTacToeModel to implement TicTacToe, representing the TicTacToe game methods.
 * With methods: move(), getTurn(), isGameOver(), getWinner(), getBoard(), getMarkAt().
 */
public class TicTacToeModel implements TicTacToe {
  private final Player[][] gameBoard;
  private int gameRound;
  private final int maxMoveRowAndColumn;

  /**
   * A single public constructor that takes no arguments.
   * To initialize the TicTacToe board.
   */
  public TicTacToeModel() {
    gameBoard = new Player[3][3];
    gameRound = 1;
    maxMoveRowAndColumn = 3;
  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Position is invalid!");
    } else if (gameBoard[r][c] != null) {
      throw new IllegalArgumentException("Space is occupied!");
    } else if (isGameOver()) {
      throw new IllegalStateException("Game over! Move can not be made!");
    }

    if (gameRound % 2 == 0) {
      gameBoard[r][c] = Player.O;
    } else {
      gameBoard[r][c] = Player.X;
    }
    gameRound++;
  }

  @Override
  public Player getTurn() {
    if (gameRound % 2 == 0) {
      return Player.O;
    } else {
      return Player.X;
    }
    // return gameRound % 2 == 0 ? Player.O : Player.X;
  }

  @Override
  public boolean isGameOver() {
    int minMove = 6;
    int maxMove = 10;
    if (gameRound < minMove) {
      return false;
    } else if (gameRound == maxMove) {
      return true;
    }
    return getWinner() != null;
  }

  @Override
  public Player getWinner() {
    for (int i = 0; i < maxMoveRowAndColumn; i++) {
      if (gameBoard[i][0] != null) {
        if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2]) {
          return gameBoard[i][2];
        }
      }
    }

    for (int j = 0; j < maxMoveRowAndColumn; j++) {
      if (gameBoard[0][j] != null) {
        if (gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j]) {
          return gameBoard[2][j];
        }
      }
    }

    if (gameBoard[1][1] != null) {
      if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]
          || gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2]) {
        return gameBoard[1][1];
      }
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    Player[][] newBoard = new Player[3][3];
    for (int i = 0; i < maxMoveRowAndColumn; i++) {
      for (int j = 0; j < maxMoveRowAndColumn; j++) {
        newBoard[i][j] = gameBoard[i][j];
      }
    }
    return newBoard;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (r < 0 || r > 2 || c < 0 || c > 2) {
      throw new IllegalArgumentException("Space is occupied or the position is invalid!");
    }
    if (gameBoard[r][c] == null) {
      return null;
    }
    return gameBoard[r][c];
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    //return Arrays.stream(getBoard()).map(
    //        row -> " " + Arrays.stream(row).map(
    //            p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
    //.collect(Collectors.joining("\n-----------\n"));
    // This is the equivalent code as above, but using iteration, and still using
    // the helpful built-in String.join method.

    List<String> rows = new ArrayList<>();
    for (Player[] row : getBoard()) {
      List<String> rowStrings = new ArrayList<>();
      for (Player p : row) {
        if (p == null) {
          rowStrings.add(" ");
        } else {
          rowStrings.add(p.toString());
        }
      }
      rows.add(" " + String.join(" | ", rowStrings));
    }
    return String.join("\n-----------\n", rows);

  }
}

