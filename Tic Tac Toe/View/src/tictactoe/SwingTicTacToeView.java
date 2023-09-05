package tictactoe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Java Swing GUI implementation of the TicTacToeView interface.
 */
public class SwingTicTacToeView extends JFrame implements TicTacToeView {
  private final JPanel panel;
  private final JPanel board;
  private final JLabel turnDisplay;
  private final JButton cell00;
  private final JButton cell01;
  private final JButton cell02;
  private final JButton cell10;
  private final JButton cell11;
  private final JButton cell12;
  private final JButton cell20;
  private final JButton cell21;
  private final JButton cell22;

  /**
   * Initializes the window which consists of a label displaying next turn/game status/winner,
   and a 3x3 tic-tac-toe game board.
   * @param caption Caption of the window
   */
  public SwingTicTacToeView(String caption) {
    super(caption);

    setSize(500, 600);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    this.panel.setLayout(boxLayout);
    this.panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

    // set the label to display next turn/game status/winner, etc.
    this.turnDisplay = new JLabel("Turn: X", JLabel.CENTER);
    this.turnDisplay.setFont(new Font("Arial", Font.PLAIN, 20));
    this.turnDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

    // set the 3x3 game board, which will be filled with 9 cells to click
    this.board = new JPanel();
    this.board.setBorder(new EmptyBorder(new Insets(20, 10, 10, 10)));
    GridLayout gridLayout = new GridLayout(3, 3);
    this.board.setLayout(gridLayout);
    this.board.setAlignmentY(Component.CENTER_ALIGNMENT);

    // set the 9 cells for the game board and their respective borders
    this.cell00 = new Cell();
    this.cell00.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
    this.cell01 = new Cell();
    this.cell01.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
    this.cell02 = new Cell();
    this.cell02.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    this.cell10 = new Cell();
    this.cell10.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
    this.cell11 = new Cell();
    this.cell11.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
    this.cell12 = new Cell();
    this.cell12.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    this.cell20 = new Cell();
    this.cell20.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
    this.cell21 = new Cell();
    this.cell21.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
    this.cell22 = new Cell();
    this.cell22.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));

    this.board.add(this.cell00);
    this.board.add(this.cell01);
    this.board.add(this.cell02);
    this.board.add(this.cell10);
    this.board.add(this.cell11);
    this.board.add(this.cell12);
    this.board.add(this.cell20);
    this.board.add(this.cell21);
    this.board.add(this.cell22);

    this.panel.add(this.turnDisplay);
    this.panel.add(this.board);

    this.add(panel);

    this.pack();
    this.setVisible(true);
  }

  /**
   * Private class to create cells in the tic-tac-toe game board. Each cell is a plain blank JButton
   with a fixed size of 100x100 pixels. The player plays the game by clicking a cell to make a move,
   and the cell will be shown as marked by that player if the move is valid.
   */
  private class Cell extends JButton {
    /**
     * Constructor for Cell.
     */
    private Cell() {
      super();
      this.setPreferredSize(new Dimension(100, 100));
      this.setContentAreaFilled(false);
      this.setFont(new Font("Arial", Font.PLAIN, 40));
    }
  }

  @Override
  public void addFeatures(Features f) {
    // connect clicking of each cell with the controller's method, therefore, clicking a certain
    // cell will tell the controller that user wants to make a move in that cell
    this.cell00.addActionListener(e -> f.putMark(0, 0));
    this.cell01.addActionListener(e -> f.putMark(0, 1));
    this.cell02.addActionListener(e -> f.putMark(0, 2));
    this.cell10.addActionListener(e -> f.putMark(1, 0));
    this.cell11.addActionListener(e -> f.putMark(1, 1));
    this.cell12.addActionListener(e -> f.putMark(1, 2));
    this.cell20.addActionListener(e -> f.putMark(2, 0));
    this.cell21.addActionListener(e -> f.putMark(2, 1));
    this.cell22.addActionListener(e -> f.putMark(2, 2));
  }

  @Override
  public void showTurn(String msg) {
    this.turnDisplay.setText(msg);
  }

  @Override
  public void updateBoard(int row, int col, String player) {
    if (row == 0 && col == 0) {
      this.cell00.setText(player);
    } else if (row == 0 && col == 1) {
      this.cell01.setText(player);
    } else if (row == 0 && col == 2) {
      this.cell02.setText(player);
    } else if (row == 1 && col == 0) {
      this.cell10.setText(player);
    } else if (row == 1 && col == 1) {
      this.cell11.setText(player);
    } else if (row == 1 && col == 2) {
      this.cell12.setText(player);
    } else if (row == 2 && col == 0) {
      this.cell20.setText(player);
    } else if (row == 2 && col == 1) {
      this.cell21.setText(player);
    } else if (row == 2 && col == 2) {
      this.cell22.setText(player);
    }
  }

  @Override
  public void showErrorMessage(String msg) {
    JOptionPane.showMessageDialog(this.panel, msg, "Tic-Tac-Toe", JOptionPane.ERROR_MESSAGE);
  }
}
