package soccer;

/**
 * Interface Comparator.
 * To compare different players from three aspects.
 */
public interface SoccerComparator extends java.util.Comparator<PlayerImpl> {
  int compare(PlayerImpl p1, PlayerImpl p2);
}