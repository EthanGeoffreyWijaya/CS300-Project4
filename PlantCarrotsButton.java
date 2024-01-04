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
public class PlantCarrotsButton extends Button {

  /**
   * Creates a new PlantCarrotsButton object at a specified location
   * 
   * @param x X position of the PlantCarrotsButton
   * @param y Y position of the PlantCarrotsButton
   */
  public PlantCarrotsButton(float x, float y) {
    super("Plant Carrots", x, y);
  }

  /**
   * Calls Carrots.plant() when the Plant Carrots button is clicked.
   */
  @Override
  public void mousePressed() {

    // System.out.println("Plant Carrots Button Pressed");
    Carrots.plant();

  }

}
