package soccer;

/**
 * Enum class Position.
 * Has four choices of the player's position.
 * Can be arranged in order number from 1 to 4.
 */
public enum Position {

  DEFENDER(2),
  FORWARD(4),
  GOALKEEPER(1),
  MIDFIELDER(3);

  int order;

  private Position(int order) {
    this.order = order;
  }

  /**
   * Method getOrder is to get the order of the position from 1 to 4.
   *
   * @return int the order number of the position.
   */
  public int getOrder() {
    return this.order;
  }
}
