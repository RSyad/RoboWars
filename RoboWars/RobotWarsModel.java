import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.concurrent.ThreadLocalRandom;


public class RobotWarsModel
{
    final int DIM_X = 10;   //x-axis
    final int DIM_Y = 10;   //y-axis
    Boolean win = true;     //default value for win
    int tries = 0;          //keep track the number of tries
    public Boolean[][] isFull = new Boolean[DIM_X+1][DIM_Y+1];  //to check wether box is full

   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~getRandom method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
   public int getRandom(){
       return (ThreadLocalRandom.current().nextInt(1,9));//generate random int
   }
   
   
   
   /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~checkWin method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
   public void checkWin(int posx, int posy, int tankpos){
       if(!((posx > -1) && (posx < 10) && (posy > -1) && (posy < 10))){
           win = false;
        }
       else{
           if(isFull[posx+1][posy] && (tankpos == 4)){          //Shoot Right
               win = true;
            }
            else if(isFull[posx-1][posy] && (tankpos == 3)){    //Shoot Left
                win = true;
            }
            else if(isFull[posx][posy+1] && (tankpos == 2)){    //Shoot Down
                win = true;
            }
            else if(isFull[posx][posy-1] && (tankpos == 1)){    //Shoot Up
                win = true;
            }
            else{
                win = false;
            }
        }
    }
    
    
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~clearFull method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void clearFull(){
        //--------------------for loop to clear gameBoard
        for(int j=0; j<DIM_Y; j++){
            for (int i=0; i<DIM_X;i++){          
                isFull[i][j] = false;
            }
        }
    }
}
