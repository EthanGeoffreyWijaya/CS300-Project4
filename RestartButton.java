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
public class RestartButton extends Button {

  /**
   * Creates a new RestartButton at the specified location
   * 
   * @param x X position of the RestartButton
   * @param y Y position of the RestartButton
   */
  public RestartButton(float x, float y) {
    super("Restart", x, y);
  }

  /**
   * Removes all Animals and Carrots from the CarrotPatch.objects arraylist when RestartButton is
   * clicked.
   */
  @Override
  public void mousePressed() {

    // System.out.println("Restart Button Pressed");
    Button.processing.removeAll();

  }

}
