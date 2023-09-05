package soccer;

import java.time.LocalDate;
import java.time.Period;

/**
 * Class PlayerImpl.
 * To represent the soccer team player.
 * Implements interface Player.
 */
public class PlayerImpl implements Player {
  LocalDate dateOfBirth;
  Position position;
  int jerseyNumber;
  private String firstName;
  private String lastName;
  private int skillLevel;

  /**
   * Constructor of the class PlayerImpl.
   *
   * @param firstName String player's first name.
   * @param lastName String player's last name.
   * @param skillLevel int the skill level of a player.
   * @param dateOfBirth the date of birth of the player.
   * @param pos Position the player's position.
   *
   */
  public PlayerImpl(String firstName, String lastName, int skillLevel, LocalDate dateOfBirth,
                    Position pos) {
    if (skillLevel > 5 || skillLevel < 1) {
      throw new IllegalArgumentException("Skill level must be within 1 to 5!");
    }
    this.jerseyNumber = 0;
    this.firstName = firstName;
    this.lastName = lastName;
    this.skillLevel = skillLevel;
    this.dateOfBirth = dateOfBirth;
    this.position = pos;
  }

  public int getJerseyNumber() {
    return this.jerseyNumber;
  }

  @Override
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Override
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  @Override
  public int getAge() {
    LocalDate currentDate = LocalDate.now();
    return Period.between(this.dateOfBirth, currentDate).getYears();
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position pos) {
    this.position = pos;
  }

  @Override
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Method setSkillLevel is to set the skill level of the player.
   *
   * @param skillLevel the int of skill level.
   */
  public void setSkillLevel(int skillLevel) throws IllegalArgumentException {
    if (skillLevel > 5 || skillLevel < 1) {
      throw new IllegalArgumentException("Skill level must be within 1 to 5!");
    }
    this.skillLevel = skillLevel;
  }

}
