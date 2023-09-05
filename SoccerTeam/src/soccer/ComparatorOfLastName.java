package soccer;

/**
 * Class LastNameComparator.
 * Implements interface Comparator to compare last name of players.
 * And to put them in alphabetical order.
 */
public class ComparatorOfLastName implements SoccerComparator {
  @Override
  public int compare(PlayerImpl p1, PlayerImpl p2) {
    return p1.getLastName().compareToIgnoreCase(p2.getLastName());
  }
}