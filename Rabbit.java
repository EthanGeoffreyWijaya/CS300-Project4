//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Carrot Patch Project
// Course:   CS 300 Spring 2021
//
// Author:   Ethan Geoffrey Wijaya
// Email:    egwijaya@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.util.Objects;

public class Rabbit extends Animal {
  private static final String RABBIT = "images" + File.separator + "rabbit.png";
  private static final String TYPE = "R"; // A String that represents the rabbit type
  private static int hopStep = 70; // one hop step
  private static int scanRange = 175; // scan range to watch out for threats
  private static int nextID = 1; // class variable that represents the identifier
  // of the next rabbit to be created
  private final int ID; // positive number that represents the order of this rabbit

  /**
   * Creates a new rabbit object located at a random position of the display window
   */
  public Rabbit() {
    // Set rabbit drawing parameters
    super(RABBIT);
    // Set rabbit identification fields
    ID = nextID;
    this.label = TYPE + ID; // String that identifies the current rabbit
    nextID++;
  }

  /**
   * getter of Rabbit.scanRange static field
   * 
   * @return scanRange static field
   */
  public static int getScanRange() {
    return scanRange;
  }

  /**
   * getter of Rabbit.hopStep static field
   * 
   * @return hopStep static field
   */
  public static int getHopStep() {
    return hopStep;
  }

  /**
   * Gets the first carrot in the patch. If the carrot is in the Rabbit hopStep range, the rabbit
   * eats it. It sets its position to the (x,y) position of the carrot and the carrot will be
   * removed from the Carrot Patch. Otherwise, the rabbit moves one hopStep towards that carrot. If
   * no carrot found (meaning Carrots.getFirstCarrot() returns false), the rabbit does nothing.
   */
  public void hopTowardsCarrot() {
    int[] carrot = Carrots.getFirstCarrot();
    int newX;
    int newY;
    int distance;
    int xComp;
    int yComp;

    if (carrot != null) {
      if (this.isClose(carrot[1], carrot[2], hopStep)) {
        this.setY(carrot[2]);
        this.setX(carrot[1]);
        Carrots.remove(carrot[0]);
      } else {
        distance = (int) distance(carrot[1], carrot[2]);
        xComp = carrot[1] - this.getX();
        yComp = carrot[2] - this.getY();

        newX = this.getX() + (hopStep * xComp / distance);
        newY = this.getY() + (hopStep * yComp / distance);

        this.setX(newX);
        this.setY(newY);
      }
    }
  }

  /**
   * Calls hopTowardsCarrot() when the Rabbit is clicked.
   */
  @Override
  public void mousePressed() {
    super.mousePressed();
    hopTowardsCarrot();
  }

  /**
   * This method watches out for wolves. Checks if there is a wolf in the Rabbit.scanRange of this
   * Rabbit.
   *
   * @return true if the current rabbit is close to at least one wolf
   */
  public boolean watchOutForWolf() {
    for (int i = 0; i < processing.objects.size(); i++) {
      if (processing.objects.get(i) instanceof Wolf
          && this.isClose((Animal) processing.objects.get(i), scanRange)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Watches out for a wolf and display a Warning message "WOLF!" if there is any wolf in its
   * neighborhood.
   */
  @Override
  public void action() {
    if (watchOutForWolf()) {
      // this.setScaredImage();
      processing.fill(0); // specify font color: black
      processing.text("WOLF!", this.getX(), this.getY() - this.image.height / 2 - 6);
    }
  }

}
