import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import soccer.ComparatorOfLastName;
import soccer.ComparatorOfPosition;
import soccer.ComparatorOfSkillLevel;
import soccer.PlayerImpl;
import soccer.Position;
import soccer.SoccerTeamImpl;

/**
 * JUnit test for class SoccerTeamImpl.
 */
public class SoccerTeamImplTest {
  PlayerImpl p1 = new PlayerImpl("Adrian", "Williams", 5,
      LocalDate.of(2014, 01, 01), Position.GOALKEEPER);
  PlayerImpl p2 = new PlayerImpl("Alisson", "Becker", 4,
      LocalDate.of(2015, 02, 02), Position.GOALKEEPER);
  PlayerImpl p3 = new PlayerImpl("Caoimhin", "Rathskeller", 5,
      LocalDate.of(2016, 03, 03), Position.GOALKEEPER);
  PlayerImpl p4 = new PlayerImpl("Joe", "Gomez", 4,
      LocalDate.of(2014, 02, 02), Position.DEFENDER);
  PlayerImpl p5 = new PlayerImpl("Virgil", "Disk", 4,
      LocalDate.of(2015, 04, 04), Position.DEFENDER);
  PlayerImpl p6 = new PlayerImpl("Nathaniel", "Phillips", 5,
      LocalDate.of(2016, 05, 05), Position.DEFENDER);
  PlayerImpl p7 = new PlayerImpl("Kostas", "Arnold", 3,
      LocalDate.of(2014, 03, 31), Position.DEFENDER);
  PlayerImpl p8 = new PlayerImpl("Calvin", "Ramsay", 2,
      LocalDate.of(2014, 12, 01), Position.DEFENDER);
  PlayerImpl p9 = new PlayerImpl("Andy", "Robertson", 1,
      LocalDate.of(2015, 12, 02), Position.DEFENDER);
  PlayerImpl p10 = new PlayerImpl("Thiago", "Alcantara", 5,
      LocalDate.of(2014, 11, 01), Position.MIDFIELDER);
  PlayerImpl p11 = new PlayerImpl("James", "Milner", 4,
      LocalDate.of(2015, 11, 01), Position.MIDFIELDER);
  PlayerImpl p12 = new PlayerImpl("Naby", "Keita", 3,
      LocalDate.of(2016, 11, 01), Position.MIDFIELDER);
  PlayerImpl p13 = new PlayerImpl("Jordan", "Henderson", 5,
      LocalDate.of(2014, 10, 01), Position.MIDFIELDER);
  PlayerImpl p14 = new PlayerImpl("Alex", "Chamberlain", 2,
      LocalDate.of(2015, 10, 01), Position.MIDFIELDER);
  PlayerImpl p15 = new PlayerImpl("Curtis", "Jones", 3,
      LocalDate.of(2016, 10, 01), Position.MIDFIELDER);
  PlayerImpl p16 = new PlayerImpl("Harvey", "Elliott", 5,
      LocalDate.of(2014, 9, 01), Position.MIDFIELDER);
  PlayerImpl p17 = new PlayerImpl("Arthur", "Melo", 4,
      LocalDate.of(2015, 9, 01), Position.MIDFIELDER);
  PlayerImpl p18 = new PlayerImpl("Stefan", "Bajcetic", 1,
      LocalDate.of(2016, 9, 01), Position.MIDFIELDER);
  PlayerImpl p19 = new PlayerImpl("Roberto", "Firmino", 5,
      LocalDate.of(2014, 8, 01), Position.FORWARD);
  PlayerImpl p20 = new PlayerImpl("Mohamed", "Salah", 4,
      LocalDate.of(2015, 8, 01), Position.FORWARD);
  PlayerImpl p21 = new PlayerImpl("Cody", "Gakpo", 3,
      LocalDate.of(2016, 8, 01), Position.FORWARD);
  PlayerImpl p22 = new PlayerImpl("Cody", "Gakpo", 3,
      LocalDate.of(2010, 8, 01), Position.FORWARD);
  PlayerImpl p23 = new PlayerImpl("Cody", "Gakpo", 3,
      LocalDate.of(1900, 8, 01), Position.FORWARD);

  private SoccerTeamImpl soccerTeam;

  /**
   * Test setup.
   */
  @Before
  public void setup() {
    soccerTeam = new SoccerTeamImpl();
  }

  /**
   * Test valid method addPlayer.
   */
  @Test
  public void testAddPlayer() {
    soccerTeam.addPlayer(p1);
    List<PlayerImpl> players = soccerTeam.getAllPlayers();
    assertEquals(1, players.size());
    assertEquals(p1, players.get(0));
    soccerTeam.addPlayer(p2);
    List<PlayerImpl> players2 = soccerTeam.getAllPlayers();
    assertEquals(2, players2.size());
    assertEquals(p2, players2.get(1));
  }

  /**
   * Test invalid method addPlayer.
   */
  @Test (expected = IllegalArgumentException.class)
    public void testAddPlayerWithInvalidAge() {
    soccerTeam.addPlayer(p22);
    soccerTeam.addPlayer(p23);
  }

  /**
   * Test valid method deletePlayer.
   */
  @Test
  public void testDeletePlayer() {
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p14);
    soccerTeam.deletePlayer(p10);
    soccerTeam.addPlayer(p8);
    List<PlayerImpl> players = soccerTeam.getAllPlayers();
    assertEquals(2, players.size());
  }

  /**
   * Test invalid method createTeam.
   */
  @Test
  public void testCreateTeamWithNotEnoughPlayers1() {
    assertThrows(IllegalArgumentException.class, soccerTeam::createTeam);
  }

  /**
   * Test invalid method createTeam: not enough players.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testCreateTeamWithNotEnoughPlayers2() {
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    List<PlayerImpl> team = soccerTeam.createTeam();
  }

  /**
   * Test valid method createTeam.
   */
  @Test
  public void testCreateTeamWithEnoughPlayers() {
    soccerTeam.addPlayer(p20);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p18);
    soccerTeam.addPlayer(p17);
    soccerTeam.addPlayer(p16);
    soccerTeam.addPlayer(p15);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p7);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p9);
    soccerTeam.addPlayer(p10);
    List<PlayerImpl> team = soccerTeam.createTeam();
    assertEquals(20, team.size());
  }

  /**
   * Test valid method createTeam: with more than enough players.
   */
  @Test
  public void testCreateTeamWthMoreThanMaxPlayers() {
    soccerTeam.addPlayer(p20);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p18);
    soccerTeam.addPlayer(p17);
    soccerTeam.addPlayer(p16);
    soccerTeam.addPlayer(p15);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p7);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p9);
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p21);
    List<PlayerImpl> team = soccerTeam.createTeam();
    assertEquals(20, team.size());
  }

  /**
   * Test valid method getTeamSize.
   */
  @Test
  public void testGetTeamSize() {
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p21);
    List<PlayerImpl> team = soccerTeam.createTeam();
    assertEquals(10, team.size());
  }

  /**
   * Test valid method setJerseyNumber.
   */
  @Test
  public void testSetJerseyNumber() {
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p21);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p18);
    soccerTeam.createTeam();
    soccerTeam.setJerseyNumber();
    List<PlayerImpl> team = soccerTeam.getAllPlayers();
    for (PlayerImpl p : team) {
      assertTrue(p.getJerseyNumber() >= 1 && p.getJerseyNumber() <= 20);
    }
  }

  /**
   * Test valid method getStartingLineup.
   */
  @Test
  public void testGetStartingLineup() {
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p7);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p21);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p18);
    soccerTeam.createTeam();
    List<PlayerImpl> startingLineup = soccerTeam.getStartingLineup();
    assertEquals(7, startingLineup.size());
  }

  /**
   * Test valid method getBenchList.
   */
  @Test
  public void testGetBenchList() {
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p10);
    soccerTeam.addPlayer(p21);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p18);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p9);
    soccerTeam.createTeam();
    soccerTeam.getStartingLineup();
    List<PlayerImpl> benchList = soccerTeam.getBenchList();
    assertEquals(4, benchList.size());
  }

  /**
   * Test invalid method getBenchList.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGetBenchListWithNoBench() {
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p11);
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p3);
    soccerTeam.createTeam();
    soccerTeam.getStartingLineup();
    List<PlayerImpl> benchList = soccerTeam.getBenchList();
  }

  /**
   * Test valid method toString.
   */
  @Test
  public void testToString() {
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p20);
    List<PlayerImpl> team = soccerTeam.createTeam();
    String expected = "Roberto Firmino\n"
        + "Jordan Henderson\n"
        + "Nathaniel Phillips\n"
        + "Adrian Williams\n"
        + "Alisson Becker\n"
        + "Virgil Disk\n"
        + "Joe Gomez\n"
        + "Mohamed Salah\n"
        + "Naby Keita\n"
        + "Alex Chamberlain\n";
    StringBuilder actual = new StringBuilder();
    for (PlayerImpl p : team) {
      actual.append(String.format("%s %s\n", p.getFirstName(), p.getLastName()));
    }
    assertEquals(expected, actual.toString());
  }

  /**
   * Test valid method getTeamStrByLastName.
   */
  @Test
  public void testGetTeamStrByLastName() {
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p20);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p9);
    soccerTeam.addPlayer(p10);
    List<PlayerImpl> team = soccerTeam.createTeam();
    soccerTeam.setJerseyNumber();
    team.sort(new ComparatorOfLastName());
    StringBuilder expected = new StringBuilder();
    for (PlayerImpl p : team) {
      expected.append(String.format("%s %s, Jersey number: %d\n",
          p.getFirstName(),
          p.getLastName(),
          p.getJerseyNumber()));
    }
    String actual = soccerTeam.getTeamStrByLastName();
    assertEquals(expected.toString(), actual);
  }

  /**
   * Test valid method getStartingLineupStrByPosition.
   */
  @Test
  public void testGetStartingLineupStrByPosition() {
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p20);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p9);
    soccerTeam.addPlayer(p10);
    soccerTeam.createTeam();
    soccerTeam.setJerseyNumber();
    List<PlayerImpl> startingLineup = soccerTeam.getStartingLineup();
    startingLineup.sort(new ComparatorOfPosition());
    StringBuilder expected = new StringBuilder();
    for (PlayerImpl p : startingLineup) {
      expected.append(String.format("%s %s, Jersey number: %d, Position: %s\n",
          p.getFirstName(),
          p.getLastName(),
          p.getJerseyNumber(),
          p.getPosition()));
    }
    String actual = soccerTeam.getStartingLineupStrByPosition();
    assertEquals(expected.toString(), actual);
  }

  /**
   * Test valid method getTeamStrBySkillLevel.
   */
  @Test
  public void testGetTeamStrBySkillLevel() {
    soccerTeam.addPlayer(p1);
    soccerTeam.addPlayer(p2);
    soccerTeam.addPlayer(p4);
    soccerTeam.addPlayer(p5);
    soccerTeam.addPlayer(p6);
    soccerTeam.addPlayer(p12);
    soccerTeam.addPlayer(p13);
    soccerTeam.addPlayer(p14);
    soccerTeam.addPlayer(p19);
    soccerTeam.addPlayer(p20);
    soccerTeam.addPlayer(p8);
    soccerTeam.addPlayer(p9);
    soccerTeam.addPlayer(p10);
    soccerTeam.createTeam();
    List<PlayerImpl> team = soccerTeam.createTeam();
    team.sort(new ComparatorOfSkillLevel().thenComparing(new ComparatorOfLastName()));
    StringBuilder expected = new StringBuilder();
    for (PlayerImpl p : team) {
      expected.append(String.format("%s %s, Skill level: %d\n", p.getFirstName(),
          p.getLastName(),
          p.getSkillLevel()));
    }
    String actual = soccerTeam.getTeamStrBySkillLevel();
    assertEquals(expected.toString(), actual);
  }

}
