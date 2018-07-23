 import java.awt.event.*;
 import java.io.*;
 import java.util.Scanner;

 public class RobotWarsController{
    private RobotWarsView view;    //RobotWarsView object
    private RobotWarsModel model;  //RobotWarsModel object
    final int DIM_X = 10;          //x-axis
    final int DIM_Y = 10;          //y-axis
     
    
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RobotWarsController Overloading Ctor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
     public RobotWarsController(RobotWarsView view, RobotWarsModel model){
         this.view = view;
         this.model = model;
         
         this.view.addingActionListener(new Listener()); //create object from Listener class
         model.clearFull();
     }
     
     
    
     
     public class Listener implements ActionListener{
         String Message, TtlPopup;                      //to be used for popup
         int load_Status=0;                             //indicator if the sequences are loaded
         public String[] copySequence = new String[18]; //array to store sequence to be saved
         public String[] loadSequence = new String[18]; //array to store sequence to be load
         
         
         
       /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Overidding actionPerformed method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/  
         @Override
         public void actionPerformed(ActionEvent evt){
             String in = evt.getActionCommand();  //grab text on button 
             String s;                            //to get sequence
             int i, j;
             //---------------------------Start Button--------------------------------------------------------------------------------------------------------------------//
             if(in.equals("Start")){
               
                 //---------------------------Red Tank---------------------------//
                 if (model.tries == 0){
                     model.clearFull(); //clear gameBoard
                     i = 0;
                     j = 0; 
                     
                     //--------------------for loop to generate sequences for Red Tank
                     for(int index=0; index<18; index++){
                         int random = model.getRandom();     //generate random by calling getRandom method
                         view.btnBoard[i][j].setIcon(null);  //clear Red Tank icon
                         
                         //---------------------------Movement for Red Tank---------------------------//
                         if(random == 1){                            //Move Up
                             j -= 1;
                             if (j < 0){
                                 j += 1;
                               }
                             else {
                                 view.btnBoard[i][j].setIcon(view.tankRedUp); //set Red Tank icon to Up position
                             }
                         }
                         else if(random == 2){                       //Move Down
                             j += 1;
                             if (j > 9) {
                                 j -= 1;
                             }
                             else {
                                 view.btnBoard[i][j].setIcon(view.tankRedDown); //set Red Tank icon to Down position
                             }
                         }
                         else if(random == 3){                       //Move Right
                             i += 1;
                             if (i > 9){
                                 i -= 1;
                             }
                             else{ 
                                view.btnBoard[i][j].setIcon(view.tankRedRight); //set Red Tank icon to Right position
                            }
                         }
                         else if(random == 4){                       //Move Left
                             i -= 1;
                             if (i < 0){
                                 i += 1;
                             }
                             else{
                                 view.btnBoard[i][j].setIcon(view.tankRedLeft); //set Red Tank icon to Left position
                             }
                         }
                         
                         //---------------------------Shooting movement for Red Tank---------------------------//
                         else if(random == 5){                        //Shoot Up
                                    view.btnBoard[i][j].setIcon(view.tankRedSUp); //set Red Tank icon to Up shooting position
                         }
                         else if(random == 6){                        //Shoot Down
                                    view.btnBoard[i][j].setIcon(view.tankRedSDown); //set Red Tank icon to Down shooting position
                         }
                         else if(random == 7){                        //Shoot Right
                                    view.btnBoard[i][j].setIcon(view.tankRedSRight); //set Red Tank icon to Right shooting position
                         }
                         else if(random == 8){                        //Shoot Left
                                    view.btnBoard[i][j].setIcon(view.tankRedSLeft); //set Red Tank icon to Left shooting position
                         }
                         else {
                                    view.btnBoard[i][j].setIcon(view.tankRedRight); //set Red Tank icon to Right position
                         }
                         
                         //---------------------------Applying shooting for Red Tank---------------------------//
                         if(index == 17){
                                model.isFull[i][j] = true;
                         }
                     }
               }
               
               
               //---------------------------Blue Tank---------------------------//
               i = 9;
               j = 9; 
               
               //--------------------for loop to move Blue Tank
               for(int index=0; index<18; index++){
                   if(load_Status==1){
                       s = loadSequence[index];                                  //get sequence from loadSequence array
                    }
                    else{
                        s = (String) view.cBoxChoice[index].getSelectedItem();   //get sequence from user choices
                    }
                    
                   view.btnBoard[i][j].setIcon(null);  //clear Blue Tank icon
                   copySequence[index] = s;            //store user's sequences into copySequence
                   
                   //---------------------------Movement for Blue Tank---------------------------//
                   if(s.equals("Move up")){                                                   //Blue Tank move up                  
                       j -= 1;
                       if (j < 0){
                           Message = "Sequence is out of bound! Try again.\n" + "Number of tries: " + (model.tries+1);
                           TtlPopup = "Error";
                           view.ExceptHandling(Message,TtlPopup,2);
                           view.btnBoard[9][9].setIcon(view.tankBlueUp); //reset Blue Tank icon to initial position
                           //model.tries--;
                           break;
                        }
                        else{
                            view.btnBoard[i][j].setIcon(view.tankBlueUp); //set Blue Tank icon to Up position
                        }
                   }
                   else if(s.equals("Move down")){                                          //Blue Tank move down
                       j += 1;
                       if (j > 9){
                           Message = "Sequence is out of bound! Try again.\n" + "Number of tries: " + (model.tries+1);
                           TtlPopup = "Error";
                           view.ExceptHandling(Message,TtlPopup,2);
                           view.btnBoard[9][9].setIcon(view.tankBlueUp); //reset Blue Tank icon to initial position
                           //model.tries--;
                           break;
                        }
                        else{
                            view.btnBoard[i][j].setIcon(view.tankBlueDown); //set Blue Tank icon to Down position
                        }
                    }
                    else if(s.equals("Move left")){                                       //Blue Tank move left
                        i -= 1;
                        if (i < 0){
                           Message = "Sequence is out of bound! Try again.\n" + "Number of tries: " + (model.tries+1);
                           TtlPopup = "Error";
                           view.ExceptHandling(Message,TtlPopup,2);
                           view.btnBoard[9][9].setIcon(view.tankBlueUp); //reset Blue Tank icon to initial position
                           //model.tries--;
                           break;
                        }
                        else{
                            view.btnBoard[i][j].setIcon(view.tankBlueLeft); //set Blue Tank icon to Left position
                        }
                     }
                     else if(s.equals("Move right")){                                     //Blue Tank move right
                         i += 1;
                         if (i > 9){
                           Message = "Sequence is out of bound! Try again.\n" + "Number of tries: " + (model.tries+1);
                           TtlPopup = "Error";
                           view.ExceptHandling(Message,TtlPopup,2);
                           view.btnBoard[9][9].setIcon(view.tankBlueUp); //reset Blue Tank icon to initial position
                           //model.tries--;
                           break;
                         }
                         else{
                            view.btnBoard[i][j].setIcon(view.tankBlueRight); //set Blue Tank icon to Right position
                         }
                      }
                
                      //---------------------------Shooting movement for Blue Tank---------------------------//
                      else if(s.equals("Shoot up")){                                       //Blue Tank shoot up
                          view.btnBoard[i][j].setIcon(view.tankBlueSUp); //set Blue Tank icon to Up shooting position
                          
                          if(index == 17){
                              model.checkWin(i, j, 1);           //check winning condition
                              winPopup(model.win);               //check win or lose
                              view.btnBoard[i][j].setIcon(null); //clear Blue Tank icon
                          }
                      }
                      else if(s.equals("Shoot down")){                                   //Blue Tank shoot down
                          view.btnBoard[i][j].setIcon(view.tankBlueSDown); //set Blue Tank icon to Down shooting position
                          
                          if(index == 17){
                              model.checkWin(i, j, 2);           //check winning condition
                              winPopup(model.win);               //check win or lose
                              view.btnBoard[i][j].setIcon(null); //clear Blue Tank icon
                          }
                      }
                      else if(s.equals("Shoot left")){                                   //Blue Tank shoot left
                          view.btnBoard[i][j].setIcon(view.tankBlueSLeft); //set Blue Tank icon to Left shooting position
                          
                          if(index == 17){
                              model.checkWin(i, j, 3);           //check winning condition
                              winPopup(model.win);               //check win or lose
                              view.btnBoard[i][j].setIcon(null); //clear Blue Tank icon
                          }
                      }
                      else if(s.equals("Shoot right")){                                  //Blue Tank shoot right
                          view.btnBoard[i][j].setIcon(view.tankBlueSRight); //set Blue Tank icon to Right shooting position
                          
                          if(index == 17){
                              model.checkWin(i, j, 4);           //check winning condition
                              winPopup(model.win);               //check win or lose
                              view.btnBoard[i][j].setIcon(null); //clear Blue Tank icon
                          }
                      }
                
                    if(model.isFull[i][j]){   // Check overlapping
                        Message = "Overlap with Red Tank. Try again.";
                        TtlPopup = "Error";
                        view.ExceptHandling(Message,TtlPopup,2);
                        model.clearFull();                               //clear gameBoard
                        clearIcon();                                     //call clearIcon method
                        view.btnBoard[0][0].setIcon(view.tankRedRight);  //reset Red Tank to initial position
                        view.btnBoard[9][9].setIcon(view.tankBlueUp);    //reset Blue Tank to initial position
                        model.tries = -1;
                        break;
                    }
               }
               
               model.tries++;
            }
        
        
            //---------------------------Reset button------------------------------------------------------------------------------------------------------------------//
            else if(in.equals("Reset")){
                model.clearFull();                               //clear gameBoard
                clearIcon();                                     //call clearIcon method
                view.btnBoard[0][0].setIcon(view.tankRedRight);  //reset Red Tank to initial position
                view.btnBoard[9][9].setIcon(view.tankBlueUp);    //reset Blue Tank to initial position
                model.tries = 0;
                load_Status=0;                                   //change indicator to not loading
            }
            
            //---------------------------Save button------------------------------------------------------------------------------------------------------------------//
            else if(in.equals("Save")){
                try{ 
                    PrintWriter saveFile=new PrintWriter("Sequences.txt"); //open txt file
                    
                    //--------------------for loop to write Strings from copySequence array 
                    for(int n=0; n<18; n++){
                       saveFile.println(copySequence[n]);
                    }
                
                    saveFile.close(); //close txt file
                }
                catch(Exception exc){
                    exc.printStackTrace(); // If there was an error, print the info.
                }
            } 
        
            //---------------------------Load button------------------------------------------------------------------------------------------------------------------//
             else if(in.equals("Load")){
                try{
                    File ReadFile = new File("Sequences.txt"); //open txt file
                    Scanner reading = new Scanner(ReadFile);   //scanner object to read from txt file
                    //reading.useDelimiter(",");
                    
                    //--------------------for loop to read from txt file into loadSequence array
                    for(int n=0; n<18; n++){
                        loadSequence[n] = reading.next(); 
                    }
                    
                    reading.close();  //close txt file
                    load_Status=1;    //indicator change to loaded
                }
                catch(Exception exc){
                exc.printStackTrace(); // If there was an error, print the info.
                }
            }
         }
       
       
       
       /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~clearIcon method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
       public void clearIcon(){
           //--------------------for loop to clear Tank icon
           for(int j=0; j<DIM_Y; j++){
               for (int i=0; i<DIM_X;i++){
                   view.btnBoard[i][j].setIcon(null);
                }
            }
        }
        
        
        
        /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~winPopup method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
       public void winPopup(Boolean winp){
            if(winp==true){
                //if user wins
                Message = "Congratulation! You have won the game.\n" + "Number of tries: " + (model.tries+1);
                TtlPopup = "Result";
                view.ExceptHandling(Message,TtlPopup,1);
                model.clearFull();                               //to clear the gameBoard
                clearIcon();                                     //call clearIcon method
                view.btnBoard[0][0].setIcon(view.tankRedRight);  //reset Red Tank icon to initial position
                view.btnBoard[9][9].setIcon(view.tankBlueUp);    //reset Blue Tank icon to initial position
                model.tries = -1;
            }
            else if(winp==false){
                //if user lose
                Message = "You lost! Try again.\n" + "Number of tries: " + (model.tries+1);
                TtlPopup = "Result";
                view.ExceptHandling(Message,TtlPopup,3);
                view.btnBoard[DIM_X-1][DIM_Y-1].setIcon(view.tankBlueUp); //reset Blue Tank icon to initial position 
            }
         }
        }
    }