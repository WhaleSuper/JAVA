package soccer;

/**
 * Class SkillLevelComparator.
 * Implements interface Comparator to compare skill levels of players.
 * And to put them in alphabetical order.
 */
public class ComparatorOfSkillLevel implements SoccerComparator {

  @Override
  public int compare(PlayerImpl p1, PlayerImpl p2) {
    int skillLevelCompare = Integer.compare(p2.getSkillLevel(), p1.getSkillLevel());
    if (skillLevelCompare == 0) {
      return p1.getLastName().compareToIgnoreCase(p2.getLastName());
    }
    return skillLevelCompare;
  }

}