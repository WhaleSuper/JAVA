package soccer;

import java.time.LocalDate;

/**
 * Class SoccerTeamControllerSwing implements all functionalities of interface ControllerInterface.
 * And interface SoccerTeamController.
 */
public class SoccerTeamControllerSwing implements ControllerInterface, SoccerTeamController {
  private final SoccerTeamModel model;
  private final SoccerTeamView view;

  private boolean isTeamCreated = false;

  /**
   * The constructor to initialize SoccerTeamControllerSwing.
   *
   * @param model SoccerTeamModel model.
   * @param view SSoccerTeamView view.
   */
  public SoccerTeamControllerSwing(SoccerTeamModel model, SoccerTeamView view)
      throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Error: model is null!");
    }
    if (view == null) {
      throw new IllegalArgumentException("Error: view is null!");
    }

    this.model = model;
    this.view = view;
  }

  /**
   * Method addPlayer to add a player to the team.
   *
   * @throws IllegalArgumentException if the age of the player is under 10 years old.
   */
  @Override
  public void addPlayer() throws IllegalArgumentException {
    String firstName = view.getFirstNameInfo();
    String lastName = view.getLastNameInfo();
    LocalDate dateOfBirth = view.getDataOfBirthInfo();
    Position position = view.getPositionInfo();
    int skillLevel = view.getSkillLevelInfo();

    if (!validatePlayerAge(dateOfBirth)) {
      view.displayError("Error: the age of the player must be under 10 years old!");
    }

    if (!validSkillLevel(skillLevel)) {
      view.displayError("Error: skill level must be from 1 to 5!");
    }

    PlayerImpl p = new PlayerImpl(firstName, lastName, skillLevel, dateOfBirth, position);

    model.addPlayer(p);
    view.clearAllInfo();
  }

  /**
   * Method validatePlayerAge to check if player's age is under 10.
   *
   * @param dateOfBirth LocalDate dateOfBirth.
   * @return boolean.
   */
  private boolean validatePlayerAge(LocalDate dateOfBirth) {
    return LocalDate.now().getYear() - dateOfBirth.getYear() <= 10;
  }

  /**
   * Method validSkillLevel to check if skill level is with 1 - 5.
   *
   * @param skillLevel int the skill level of a player.
   * @return boolean.
   */
  private boolean validSkillLevel(int skillLevel) {
    return skillLevel > 0 && skillLevel < 6;
  }

  /**
   * Method createTeam is to create a team.
   *
   * @throws IllegalArgumentException if the number of players is under 10.
   */
  @Override
  public void createTeam() throws IllegalArgumentException {
    try {
      model.createTeam();
      model.setJerseyNumber();
      isTeamCreated = true;
      view.displayTeamList(generateTeamListHtml());
    } catch (IllegalArgumentException e) {
      view.displayError("There must be at least 10 players to create a team!");
    }
  }

  /**
   * Method getStartingLineup is to create the starting lineup.
   *
   * @throws IllegalArgumentException if invalid position assigned.
   */
  @Override
  public void getStartingLineup() {
    if (!isTeamCreated) {
      view.displayError("Error: the team must be created first!");
      return;
    }

    try {
      model.getStartingLineup();
      view.displayStartingLineup(generateStartingLineupHtml());
    } catch (IllegalArgumentException e) {
      view.displayError("Positions assigned can not create starting lineup!");
    }

  }

  /**
   * Method generateTeamListHtml is to generate a team list String.
   *
   * @return String.
   */
  private String generateTeamListHtml() {
    return "<html>Team list is as follows:<br/>\n"
        + "(Displayed by last name alphabetically.)<br/>\n"
        + "---<br/>\n"
        + model.getTeamStrByLastName().replaceAll("\n", "<br/>") + "<html>";
  }

  /**
   * Method generateStartingLineupHtml is to generate starting lineup String.
   *
   * @return String.
   */
  private String generateStartingLineupHtml() {
    return "<html>Starting lineup is as follows:<br/>\n"
        +  "(Displayed by position.)<br/>\n"
        + "---<br/>\n"
        + model.getStartingLineupStrByPosition().replaceAll("\n", "<br/>") + "<html>";
  }

  /**
   * Method startBuildSoccerTeam is to start to build the soccer team.
   * It connects the model and gives control.
   */
  @Override
  public void startBuildSoccerTeam() {
    this.view.implementControllerInterface(this);
  }

  /**
   * Method exit is to exit the window as user chooses.
   */
  @Override
  public void exit() {
    System.exit(0);
  }

}
