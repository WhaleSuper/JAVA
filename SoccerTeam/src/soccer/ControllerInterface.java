package soccer;

/**
 * Interface ControllerInterface.
 * The SoccerTeamController implements ControllerInterface.
 */
public interface ControllerInterface {

  /**
   * Method addPlayer to add a player to the team.
   *
   * @throws IllegalArgumentException if the age of the player is under 10 years old.
   */
  void addPlayer() throws IllegalArgumentException;

  /**
   * Method createTeam is to create a team.
   *
   * @throws IllegalArgumentException if the number of players is under 10.
   */
  void createTeam() throws  IllegalArgumentException;

  /**
   * Method getStartingLineup is to create the starting lineup.
   */
  void getStartingLineup();

  /**
   * Method exit is to exit the window as user chooses.
   */
  void exit();
}
