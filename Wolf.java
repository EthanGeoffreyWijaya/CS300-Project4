import java.io.File;

public class Wolf extends Animal {
  // path to the wolf image file
  private static final String WOLF = "images" + File.separator + "wolf.png";
  private static int scanRange = 120; // scanning range to look for a rabbit
  // in the neighborhood
  private static int nextID = 1; // identifier of the next Wolf to be created
  private static final String TYPE = "W"; // A String that represents the Wolf type
  private final int ID; // positive number that represents the order of this Wolf
  private int rabbitEatenCount; // Number of rabbits that the current Wolf has eaten so far

  /**
   * Creates a new Wolf object at a random position of the display window
   *
   * @param processing CarrotPatch object which represents the display window
   */
  public Wolf() {
    super(WOLF);

    ID = nextID;
    this.label = TYPE + ID;
    nextID++;
  }

  /**
   * Getter for the number of rabbits eaten by the Wolf object
   * 
   * @return rabbitEatenCount instance field
   */
  public int getRabbitEatenCount() {
    return rabbitEatenCount;
  }

  /**
   * Getter for the scanRange static field.
   * 
   * @return scanRange static field value
   */
  public static int getScanRange() {
    return scanRange;
  }

  /**
   * Moves to the position of the specified rabbit passed as input, and eats it. The eaten rabbit
   * will be removed from the patch and the number of eaten rabbits by this wolf is incremented by
   * one.
   * 
   * @param rabbit rabbit to eat by this wolf
   */
  public void eatRabbit(Rabbit rabbit) {
    // if the mouse is over the current Wolf, release it so the Wolf can move
    // ahead to the position of rabbit and eat it.
    if (isMouseOver()) {
      this.mouseReleased();
    }
    this.setX(rabbit.getX());
    this.setY(rabbit.getY());
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Rabbit
          && rabbit.getLabel().equals(((Animal) processing.objects.get(i)).getLabel())) {
        processing.objects.remove(i);
      }
    }
    rabbitEatenCount++;
  }

  /**
   * Defines the action of this wolf in the carrot patch. This wolf lookup for rabbits in its
   * neighborhood (Wolf.scanRange) and eats the first found rabbit only. This method also displays
   * the number of rabbit eaten by this wolf if any.
   */
  @Override
  public void action() {
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Rabbit
          && this.isClose((Animal) processing.objects.get(i), scanRange)) {
        eatRabbit((Rabbit) processing.objects.get(i));
        break;
      }
    }
    if (rabbitEatenCount > 0)
      displayrabbitEatenCount(); // display rabbitEatenCount
  }

  /**
   * Displays the number of eaten rabbits if any on the top of the Wolf image
   */
  public void displayrabbitEatenCount() {
    processing.fill(0); // specify font color: black
    processing.text(rabbitEatenCount, this.getX(), this.getY() - this.image.height / 2 - 6);
  }

}
