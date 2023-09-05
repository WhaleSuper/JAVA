package soccer;

/**
 * Class PositionComparator.
 * Implements interface Comparator to compare position of players.
 * And to put them in alphabetical order.
 */
public class ComparatorOfPosition implements SoccerComparator {
  @Override
  public int compare(PlayerImpl p1, PlayerImpl p2) {
    int positionCompare = Integer.compare(p1.getPosition().getOrder(), p2.getPosition().getOrder());
    if (positionCompare == 0) {
      return p1.getLastName().compareToIgnoreCase(p2.getLastName());
    }
    return positionCompare;
  }

}