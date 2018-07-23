import java.util.*;
import javax.swing.*;

/**
 * Write a description of class RobotWars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RobotWars
{
   public static void main (String args[]){
        RobotWarsModel theModel = new RobotWarsModel();
        RobotWarsView theView = new RobotWarsView("Robot Tank Wars");
        RobotWarsController theController = new RobotWarsController(theView,theModel);
        theView.setVisible(true);
    }
   
}
