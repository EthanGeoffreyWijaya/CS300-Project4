
public class AddRabbitButton extends Button {

  /**
   * Creates a new AddRabbitButton at the specified location
   * 
   * @param x X position of the AddRabbitButton
   * @param y Y position of the AddRabbitButton
   */
  public AddRabbitButton(float x, float y) {
    super("Add Rabbit", x, y);

  }

  /**
   * Adds a new Rabbit object to the CarrotPatch.objects arraylist when AddRabbitButton is clicked.
   */
  @Override
  public void mousePressed() {

    // System.out.println("Add Rabbit Button Pressed");
    Button.processing.objects.add(new Rabbit());

  }

}
