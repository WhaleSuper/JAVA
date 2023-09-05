package soccer;

import java.util.List;

/**
 * Interface SoccerTeam.
 * To include methods of creating the soccer team.
 */
public interface SoccerTeamModel {

  /**
   * Method createTeam is to create a U10 soccer team.
   * The minimum number of players is 10 and the maximum number of players is 20.
   *
   * @return a list of team players.
   */
  List<PlayerImpl> createTeam();

  /**
   * Method getTeamSize is to get the size of the soccer team successfully created.
   * The team size should be within 10 to 20.
   *
   * @return int the size of the team.
   */
  int getTeamSize();

  /**
   * Method addPlayer is to add a player to the team.
   *
   * @param player a class PlayerImpl player.
   * @throws IllegalArgumentException if the player is over ten years old.
   */
  void addPlayer(PlayerImpl player) throws IllegalArgumentException;

  /**
   * Method deletePlayer is to delete a player from the team.
   *
   * @param player a class PlayerImpl player.
   */
  void deletePlayer(PlayerImpl player);

  /**
   * Method setJerseyNumber is to set jersey number for each player in the team.
   */
  void setJerseyNumber();

  /**
   * Method getAllPlayers is to get all players in the team.
   *
   * @return a list of all players in the team.
   */
  List<PlayerImpl> getAllPlayers();

  /**
   * Method getBenchList is to get all bench players in the team.
   *
   * @return a list of all bench players in the team.
   */
  List<PlayerImpl> getBenchList();

  /**
   * Method getStartingLineup is to create the starting lineup in the team.
   *
   * @return a list of starting lineup players.
   */
  List<PlayerImpl> getStartingLineup();

  /**
   * Method getTeamStrByLastName is to get a list of all players in the team
   * by last name alphabetically.
   *
   * @return String a String of information of all players in the team.
   */
  String getTeamStrByLastName();

  /**
   * Method getStartingLineupStrByPosition is to get a list of all players
   * in the team in position order.
   *
   * @return String a String of information of all players in the team.
   */
  String getStartingLineupStrByPosition();

  /**
   * Method getTeamStrBySkillLevel is to get a list of all players in the team in skill level order.
   *
   * @return String a String of information of all players in the team.
   */
  String getTeamStrBySkillLevel();

}
