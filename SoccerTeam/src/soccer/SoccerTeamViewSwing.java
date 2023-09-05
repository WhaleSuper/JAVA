package soccer;

import java.awt.FlowLayout;
import java.awt.Window;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class SoccerTeamViewSwing implements all functionalities of interface SoccerTeamView.
 * And extends JFrame.
 */
public class SoccerTeamViewSwing extends JFrame implements SoccerTeamView {

  private JTextField firstNameText;
  private JTextField lastNameText;
  private JTextField dateOfBirthText;
  private JTextField skillLevelText;
  private JTextField positionText;
  private JButton addPlayerButton;
  private JButton createTeamButton;
  private JButton createStartingLineupButton;
  private JButton exitProgramButton;
  private JLabel firstNameLabel;
  private JLabel lastNameLabel;
  private JLabel dateOfBirthLabel;
  private JLabel positionLabel;
  private JLabel skillLevelLabel;
  private JLabel displayTeamListLabel;
  private JLabel displayStartingLineupLabel;
  private JLabel displayTeamBySkillLevelLabel;
  private JLabel rules;

  private final int width = 630;
  private final int length = 800;
  private final int location = 300;

  /**
   * The constructor to initialize SoccerTeamViewSwing.
   *
   * @param caption the String of window display.
   */
  public SoccerTeamViewSwing(String caption) {
    super(caption);
    this.setLayout(new FlowLayout());
    initializeInputComponents();
    initializeButtonOptionComponents();
    initializeRulesComponents();
    setVisible(true);
  }

  /**
   * Method initializeInputComponents to initialize the components of input.
   * Input includes: first name, last name, date of birth, position, skill level.
   */
  private void initializeInputComponents() {
    setSize(width, length);
    setLocation(location, location);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel firstNameLabel = new JLabel("<html>First Name<html>");
    firstNameText = new JTextField(50);
    this.add(firstNameLabel);
    this.add(firstNameText);

    JLabel lastNameLabel = new JLabel("<html>Last Name<html>");
    lastNameText = new JTextField(50);
    this.add(lastNameLabel);
    this.add(lastNameText);

    JLabel dateOfBirthLabel = new JLabel("Date of Birth (dd/mm/yyyy)");
    dateOfBirthText = new JTextField(50);
    this.add(dateOfBirthLabel);
    this.add(dateOfBirthText);

    JLabel positionLabel = new JLabel("Position");
    positionText = new JTextField(50);
    this.add(positionLabel);
    this.add(positionText);

    JLabel skillLevelLabel = new JLabel("Skill Level");
    skillLevelText = new JTextField(50);
    this.add(skillLevelLabel);
    this.add(skillLevelText);
  }

  /**
   * Method initializeButtonOptionComponents to initialize the components of button.
   * Button options include add player, create team, create starting lineup and exit.
   */
  private void initializeButtonOptionComponents() {
    addPlayerButton = new JButton("Add player                                       "
        + "                            ");
    addPlayerButton.setActionCommand("Add player button");

    createTeamButton = new JButton("Create the team                              "
        + "                             ");
    createTeamButton.setActionCommand("Create soccer team button");

    createStartingLineupButton = new JButton("Create starting lineup                 "
        + "                                 ");
    createStartingLineupButton.setActionCommand("Create starting lineup button");

    exitProgramButton = new JButton("                                     Exit the page: Goodbye!"
        + "                                         ");
    exitProgramButton.setActionCommand("Exit program button");

    this.add(addPlayerButton);
    this.add(createTeamButton);
    this.add(createStartingLineupButton);
    this.add(exitProgramButton);

    displayTeamListLabel = new JLabel("");
    displayStartingLineupLabel = new JLabel("");

    this.add(displayTeamListLabel);
    this.add(displayStartingLineupLabel);
  }

  /**
   * Method initializeRulesComponents to initialize the components of rules.
   * Rules must be followed when running the program.
   */
  private void initializeRulesComponents() {
    JLabel rules = new JLabel("<html>To create a soccer team, "
        + "the following rules must be followed:<br/>\n"
        + "1. The age of a player must be under 10 years old.<br/>"
        + "2. There must be 10 or more players in order to successfully create a team.<br/>"
        + "3. Only after creating a team the starting lineup can be created.<br/>"
        + "4. Starting lineup can not be created if the number of each position is invalid.<br/>"
        + "5. Can not recreate a team or recreate the starting lineup once they're created.<br/>"
        + "\nHave fun!<html>", SwingConstants.LEFT);

    this.add(rules);
  }

  /**
   * Method implementControllerInterface is to implement the interface ControllerInterface.
   *
   * @param i ControllerInterface i.
   */
  @Override
  public void implementControllerInterface(ControllerInterface i) {
    setAction(addPlayerButton, i::addPlayer);
    setAction(createTeamButton, i::createTeam);
    setAction(createStartingLineupButton, i::getStartingLineup);
    setAction(exitProgramButton, i::exit);
  }

  /**
   * Method setAction is to set action for buttons.
   *
   * @param button AbstractButton button.
   * @param action Runnable action.
   */
  private void setAction(AbstractButton button, Runnable action) {
    button.addActionListener(evt -> action.run());
  }


  /**
   * Method getFirstNameInfo is to get the information of first name.
   */
  @Override
  public String getFirstNameInfo() {
    return firstNameText.getText();
  }

  /**
   * Method getLastNameInfo is to get the information of last name.
   */
  @Override
  public String getLastNameInfo() {
    return lastNameText.getText();
  }

  /**
   * Method getDataOfBirthInfo is to get the information of date of birth.
   *
   * @throws IllegalArgumentException if the age of the player is under 10 years old.
   */
  @Override
  public LocalDate getDataOfBirthInfo() {
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String infoDateOfBirth = dateOfBirthText.getText();
    try {
      return LocalDate.parse(infoDateOfBirth, f);
    } catch (DateTimeParseException e) {
      displayError("Invalid DOB. Please enter information again.");
      dateOfBirthText.setText("");
      return null;
    }
  }

  /**
   * Method getPositionInfo is to get the information of position.
   *
   * @throws IllegalArgumentException if not the valid position.
   */
  @Override
  public Position getPositionInfo() {
    String inputText = positionText.getText().trim().toUpperCase();
    try {
      return Position.valueOf(inputText);
    } catch (IllegalArgumentException e) {
      displayError("Error: Invalid position!");
      positionText.setText("");
      return null;
    }
  }

  /**
   * Method getSkillLevelInfo is to get the information of skill level.
   *
   * @throws IllegalArgumentException if skill level not within 1 - 5.
   */
  @Override
  public int getSkillLevelInfo() {
    String inputText = skillLevelText.getText().trim();
    try {
      return Integer.parseInt(inputText);
    } catch (NumberFormatException e) {
      displayError("Error: Invalid skill level!");
      skillLevelText.setText("");
      return 0;
    }
  }

  /**
   * Method clearAllInfo is to clear all input after a player has been successfully added.
   */
  @Override
  public void clearAllInfo() {
    clearTextField(firstNameText);
    clearTextField(lastNameText);
    clearTextField(dateOfBirthText);
    clearTextField(skillLevelText);
    clearTextField(positionText);
  }

  /**
   * Method clearTextField is to clear text field.
   *
   * @param textField JTextField textField.
   */
  private void clearTextField(JTextField textField) {
    textField.setText("");
  }

  /**
   * Method displayError is to display the error message if:
   * The age of the player is above 10 years old.
   * The number of the players added to create a team is not more than 10.
   *
   * @param info String the error message.
   */
  @Override
  public void displayError(String info) {
    JOptionPane.showMessageDialog(this, info, "Soccer Team", JOptionPane.ERROR_MESSAGE);
  }

  /**
   * Method displayTeamList is to display the information of all team players.
   * In the order of last name alphabetically.
   *
   * @param info String information of all team players.
   */
  @Override
  public void displayTeamList(String info) {
    this.displayTeamListLabel.setText(info);
  }

  /**
   * Method displayStartingLineup is to display the information of starting lineup players.
   * In the order of position.
   *
   * @param info String information of starting lineup players.
   */
  @Override
  public void displayStartingLineup(String info) {
    this.displayStartingLineupLabel.setText(info);
  }

}
