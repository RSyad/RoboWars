/***************************************************************************************************
Program: RobotWars.java
Course: OOAD
Year: 2016/17 Trimester 1
Group Leader  : AHMAD NAZMI BIN BAHRUDDIN 1142700845 ahmadnazmi14@yahoo.com        017-3418230 
Group Member 1: ARSYAD BIN ANUAR          1142700937 syaads@yahoo.com.my           019-3456645
Group Member 2: AKMAL SAFWAN BIN AB AZIZ  1142701017 akmalsafwanabaziz@gmail.com   011-23744228 
Lecture: TC02
Lab: TT04
***************************************************************************************************/ 


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
