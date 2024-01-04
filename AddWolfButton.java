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
public class AddWolfButton extends Button {

  /**
   * Creates a new AddWolfButton at the specified location
   * 
   * @param x X position of the AddWolfButton
   * @param y Y position of the AddWolfButton
   */
  public AddWolfButton(float x, float y) {
    super("Add Wolf", x, y);
  }

  /**
   * Adds a new Wolf object to the CarrotPatch.objects arraylist when AddWolfButton is clicked.
   */
  @Override
  public void mousePressed() {

    // System.out.println("Add Wolf Button Pressed");
    Button.processing.objects.add(new Wolf());

  }

}
