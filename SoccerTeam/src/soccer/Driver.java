package soccer;

import java.time.LocalDate;

/**
 * Driver class for SoccerTeamImpl.
 */
public class Driver {

  /**
   * Main part for driver class.
   *
   * @param args the param.
   */
  public static void main(String[] args) {

    SoccerTeamImpl team = new SoccerTeamImpl();

    PlayerImpl p1 = new PlayerImpl("Adrian", "Williams", 5,
        LocalDate.of(2014, 01, 01), Position.GOALKEEPER);
    PlayerImpl p2 = new PlayerImpl("Alisson", "Becker", 4,
        LocalDate.of(2015, 02, 02), Position.GOALKEEPER);
    PlayerImpl p4 = new PlayerImpl("Joe", "Gomez", 4,
        LocalDate.of(2014, 02, 02), Position.DEFENDER);
    PlayerImpl p5 = new PlayerImpl("Virgil", "Disk", 4,
        LocalDate.of(2015, 04, 04), Position.DEFENDER);
    PlayerImpl p6 = new PlayerImpl("Nathaniel", "Phillips", 5,
        LocalDate.of(2016, 05, 05), Position.DEFENDER);
    PlayerImpl p7 = new PlayerImpl("Kostas", "Arnold", 3,
        LocalDate.of(2014, 03, 31), Position.DEFENDER);
    PlayerImpl p10 = new PlayerImpl("Thiago", "Alcantara", 5,
        LocalDate.of(2014, 11, 01), Position.MIDFIELDER);
    PlayerImpl p11 = new PlayerImpl("James", "Milner", 4,
        LocalDate.of(2015, 11, 01), Position.MIDFIELDER);
    PlayerImpl p12 = new PlayerImpl("Naby", "Keita", 3,
        LocalDate.of(2016, 11, 01), Position.MIDFIELDER);
    PlayerImpl p13 = new PlayerImpl("Jordan", "Henderson", 5,
        LocalDate.of(2014, 10, 01), Position.MIDFIELDER);
    PlayerImpl p18 = new PlayerImpl("Stefan", "Bajcetic", 1,
        LocalDate.of(2016, 9, 01), Position.MIDFIELDER);
    PlayerImpl p19 = new PlayerImpl("Roberto", "Firmino", 5,
        LocalDate.of(2014, 8, 01), Position.FORWARD);


    team.addPlayer(p1);
    team.addPlayer(p2);
    team.addPlayer(p4);
    team.addPlayer(p5);
    team.addPlayer(p6);
    team.addPlayer(p7);
    team.addPlayer(p10);
    team.addPlayer(p11);
    team.addPlayer(p12);
    team.addPlayer(p13);
    team.addPlayer(p18);
    team.addPlayer(p19);

    team.createTeam();
    team.getStartingLineup();
    team.setJerseyNumber();

    System.out.println("\n-------------------------------\n"
        + "Team players after sorting by last name:\n");
    System.out.println(team.getTeamStrByLastName());

    System.out.println("\n-------------------------------\n"
        + "Team players after sorting by position:\n");
    System.out.println(team.getStartingLineupStrByPosition());

    System.out.println("\n-------------------------------\n"
        + "Team players after sorting by skill level.\n"
        + "Players with the same skill level are presented by last name alphabetically:\n");
    System.out.println(team.getTeamStrBySkillLevel());

  }
}
