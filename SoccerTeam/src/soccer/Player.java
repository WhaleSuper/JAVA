package soccer;

import java.time.LocalDate;

/**
 * Interface class Player.
 * To represent a Player.
 * Include methods to return the player's information about first name, last name, date of birth,
 * skill level, position in the team.
 */
public interface Player {

  /**
   * Method getFirstName is to get the player's first name.
   *
   * @return String the first name.
   */
  String getFirstName();

  /**
   * Method getLastName is to get the player's last name.
   *
   * @return String the last name.
   */
  String getLastName();

  /**
   * Method getDateOfBirth is to get the player's date of birth.
   *
   * @return LocalDate the date of birth.
   */
  LocalDate getDateOfBirth();

  /**
   * Method getAge is to get the player's age.
   *
   * @return int the age.
   */
  int getAge();

  /**
   * Method getPosition is to get the player's position in the team.
   *
   * @return Position the position.
   */
  Position getPosition();

  /**
   * Method getSkillLevel is to get the player's skill level.
   *
   * @return int the skill level.
   */
  int getSkillLevel();

}

