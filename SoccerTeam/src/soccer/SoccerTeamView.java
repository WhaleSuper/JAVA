package soccer;

import java.time.LocalDate;

/**
 * Interface SoccerTeamView.
 * Is the interface of soccer team view.
 */
public interface SoccerTeamView {

  /**
   * Method implementControllerInterface.
   * Is to implement the ControllerInterface.
   *
   * @param i ControllerInterface implementation.
   */
  void implementControllerInterface(ControllerInterface i);

  /**
   * Method getFirstNameInfo is to get the input of first name.
   *
   * @return String the first name information.
   */
  String getFirstNameInfo();

  /**
   * Method getLastNameInfo is to get the input of last name.
   *
   * @return String the last name information.
   */
  String getLastNameInfo();

  /**
   * Method getDataOfBirthInfo is to get the input of date of birth.
   *
   * @return LocalDate the date of birth information.
   */
  LocalDate getDataOfBirthInfo();

  /**
   * Method getSkillLevelInfo is to get the skill level of a player.
   *
   * @return int the skill level information.
   */
  int getSkillLevelInfo();

  /**
   * Method getPositionInfo is to get the position of a player.
   *
   * @return Position the position information.
   */
  Position getPositionInfo();

  /**
   * Method displayError is to display the error message if:
   * The age of the player is above 10 years old.
   * The number of the players added to create a team is not more than 10.
   *
   * @param info String the error message.
   */
  void displayError(String info);

  /**
   * Method displayTeamList is to display the information of all team players.
   * In the order of last name alphabetically.
   *
   * @param info String information of all team players.
   */
  void displayTeamList(String info);

  /**
   * Method displayStartingLineup is to display the information of starting lineup players.
   * In the order of position.
   *
   * @param info String information of starting lineup players.
   */
  void displayStartingLineup(String info);

  /**
   * Method clearAllInfo is to clear all input information of team players.
   */
  void clearAllInfo();

}
