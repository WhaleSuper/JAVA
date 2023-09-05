package soccer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class SoccerTeamImpl implements all functionalities of interface SoccerTeam.
 */
public class SoccerTeamImpl implements SoccerTeamModel {

  private List<PlayerImpl> players;
  private List<PlayerImpl> startingLineup;
  private List<PlayerImpl> benchList;
  private List<PlayerImpl> teamCreated;
  private int minNumPlayer;
  private int maxNumPlayer;

  /**
   * The constructor.
   * Should take no parameters, and initialize the soccer team.
   */
  public SoccerTeamImpl() {
    this.players = new ArrayList<>();
    this.startingLineup = new ArrayList<>();
    this.benchList = new ArrayList<>();
    this.teamCreated = new ArrayList<>();
    this.minNumPlayer = 10;
    this.maxNumPlayer = 20;
  }

  /**
   * Method addPlayer to add a player to the team.
   *
   * @param p PlayerImpl p.
   * @throws IllegalArgumentException if the age of the player is under 10 years old.
   */
  @Override
  public void addPlayer(PlayerImpl p) throws IllegalArgumentException {
    if (p.getAge() > 10) {
      throw new IllegalArgumentException("The soccer team player must be under 10 years old!");
    }
    players.add(p);
  }

  /**
   * Method deletePlayer to delete a player from the team.
   *
   * @param p PlayerImpl p.
   */
  @Override
  public void deletePlayer(PlayerImpl p) {
    players.remove(p);
  }

  /**
   * Method canCreateTeam is to check if the number of players added can create a team.
   *
   * @return If the number of players is equal to or larger than 10, then return true.
   */
  private boolean canCreateTeam() {
    return players.size() >= minNumPlayer;
  }

  /**
   * Method createTeam is to create a team.
   *
   * @return a list of the team players.
   * @throws IllegalArgumentException if the number of players is under 10.
   */
  @Override
  public List<PlayerImpl> createTeam() {

    if (!canCreateTeam()) {
      throw new IllegalArgumentException("To create a team there must be a minimum of 10 players!");
    }

    int numPlayers = players.size();

    if (numPlayers <= maxNumPlayer) {
      teamCreated = new ArrayList<>(players);
    } else {
      teamCreated = new ArrayList<>(players.subList(0, maxNumPlayer));
    }

    teamCreated.sort(new ComparatorOfSkillLevel());

    return teamCreated;
  }

  /**
   * Method getTeamSize is get the size of a team.
   *
   * @return int the size of a team.
   */
  @Override
  public int getTeamSize() {
    int teamSize = this.teamCreated.size();
    return teamSize;
  }

  /**
   * Method setJerseyNumber is to set jersey number for each player in the team.
   * The range of jersey numbers is from 1 to 20.
   */
  @Override
  public void setJerseyNumber() {
    List<Integer> availableNumbers = IntStream.rangeClosed(1, 20)
        .boxed()
        .collect(Collectors.toList());

    Collections.shuffle(availableNumbers);
    Random random = new Random();

    for (PlayerImpl p : teamCreated) {
      if (p.jerseyNumber == 0) {
        int i = random.nextInt(availableNumbers.size());
        int assignedNumber = availableNumbers.get(i);
        availableNumbers.remove(i);
        p.jerseyNumber = assignedNumber;
      }
    }
  }

  /**
   * Method hasMinimumStartingLineup is to check if the team has a valid starting lineup.
   *
   * @return If the team has a valid starting lineup, then return true.
   */
  private boolean hasMinimumStartingLineup(List<List<PlayerImpl>> positionLists) {
    int numDefenders = positionLists.get(Position.DEFENDER.ordinal()).size();
    int numForwards = positionLists.get(Position.FORWARD.ordinal()).size();
    int numGoalkeepers = positionLists.get(Position.GOALKEEPER.ordinal()).size();
    int numMidfielders = positionLists.get(Position.MIDFIELDER.ordinal()).size();

    return numDefenders >= 2
        && numForwards >= 1
        && numGoalkeepers >= 1
        && numMidfielders >= 3;
  }

  /**
   * Method getStartingLineup is to create the starting lineup.
   *
   * @return a list of the starting lineup.
   */
  @Override
  public List<PlayerImpl> getStartingLineup() throws IllegalArgumentException {
    List<List<PlayerImpl>> positionLists = new ArrayList<>();
    for (int i = 0; i < Position.values().length; i++) {
      positionLists.add(new ArrayList<>());
    }

    for (PlayerImpl p : teamCreated) {
      int positionIndex = p.getPosition().ordinal();
      positionLists.get(positionIndex).add(p);
    }

    for (List<PlayerImpl> list : positionLists) {
      list.sort(new ComparatorOfSkillLevel());
    }

    if (hasMinimumStartingLineup(positionLists)) {

      startingLineup.add(positionLists.get(Position.DEFENDER.ordinal()).get(0));
      startingLineup.add(positionLists.get(Position.DEFENDER.ordinal()).get(1));

      startingLineup.add(positionLists.get(Position.FORWARD.ordinal()).get(0));

      startingLineup.add(positionLists.get(Position.GOALKEEPER.ordinal()).get(0));

      startingLineup.add(positionLists.get(Position.MIDFIELDER.ordinal()).get(0));
      startingLineup.add(positionLists.get(Position.MIDFIELDER.ordinal()).get(1));
      startingLineup.add(positionLists.get(Position.MIDFIELDER.ordinal()).get(2));

    } else {
      // startingLineup = teamCreated.subList(0, Math.min(teamCreated.size(), 7));
      throw new IllegalArgumentException("Positions assigned can not create starting lineup!");
    }

    return startingLineup;
  }

  /**
   * Method getAllPlayers() is to get all the players in the team.
   *
   * @return a list of all the players in the team.
   */
  @Override
  public List<PlayerImpl> getAllPlayers() {
    return players;
  }

  /**
   * Method getBenchList() is to get all the bench players in the team.
   *
   * @return a list of all the bench players in the team.
   * @throws IllegalArgumentException if there is no bench player.
   */
  @Override
  public List<PlayerImpl> getBenchList() {
    int teamSize = this.teamCreated.size();
    if (teamSize == 7) {
      throw new IllegalArgumentException("There is no bench player!");
    }

    for (PlayerImpl p : teamCreated) {
      if (! startingLineup.contains(p)) {
        benchList.add(p);
      }
    }

    return benchList;
  }

  /**
   * Method getTeamStrByLastName is to get a String of all players in the team.
   * In the order of last name alphabetically.
   *
   * @return String of the player information.
   */
  @Override
  public String getTeamStrByLastName() {
    List<PlayerImpl> sortedTeam = new ArrayList<>(teamCreated);
    sortedTeam.sort(new ComparatorOfLastName());
    StringBuilder sb = new StringBuilder();
    for (PlayerImpl p : sortedTeam) {
      sb.append(String.format("%s %s, Jersey number: %d\n",
          p.getFirstName(),
          p.getLastName(),
          p.jerseyNumber));
    }

    return sb.toString();
  }

  /**
   * Method getStartingLineupStrByPosition is to get a String of all players in the team.
   * In the order of position.
   *
   * @return String of the player information.
   */
  @Override
  public String getStartingLineupStrByPosition() {
    List<PlayerImpl> sortedPlayers = new ArrayList<>(startingLineup);
    sortedPlayers.sort(new ComparatorOfPosition().thenComparing(new ComparatorOfLastName()));
    StringBuilder sb = new StringBuilder();
    for (PlayerImpl p : sortedPlayers) {
      sb.append(String.format("%s %s, Jersey number: %d, Position: %s\n",
          p.getFirstName(),
          p.getLastName(),
          p.getJerseyNumber(),
          p.getPosition().toString()));
    }

    return sb.toString();
  }

  /**
   * Method getTeamStrBySkillLevel is to get a String of all players in the team.
   * In the order of skill level.
   *
   * @return String of the player information.
   */
  @Override
  public String getTeamStrBySkillLevel() {
    List<PlayerImpl> sortedPlayers = new ArrayList<>(teamCreated);
    sortedPlayers.sort(new ComparatorOfSkillLevel().thenComparing(new ComparatorOfLastName()));
    StringBuilder sb = new StringBuilder();
    for (PlayerImpl p : sortedPlayers) {
      sb.append(String.format("%s %s, Skill level: %d\n", p.getFirstName(),
          p.getLastName(),
          p.getSkillLevel()));
    }

    return sb.toString();
  }

  /**
   * Method toString is to get a String of all players in the team.
   * Information includes first name and last name.
   *
   * @return String of the player information.
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PlayerImpl p : players) {
      sb.append(String.format("%s %s\n", p.getFirstName(), p.getLastName()));
    }

    return sb.toString();
  }

}
