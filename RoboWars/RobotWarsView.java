import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.event.ActionListener;

public class RobotWarsView extends JFrame{
    final int DIM_X = 10;   //x-axis
    final int DIM_Y = 10;   //y-axis
    
    //--------------------Loading Images for Blue & Red Tanks for all positions
    ImageIcon tankBlueLeft = new ImageIcon("TankBlueLeft.png");
    ImageIcon tankBlueRight = new ImageIcon("TankBlueRight.png");
    ImageIcon tankBlueUp = new ImageIcon("TankBlueUp.png");
    ImageIcon tankBlueDown = new ImageIcon("TankBlueDown.png");
    
    ImageIcon tankBlueSLeft = new ImageIcon("TankBlueShootLeft.png");
    ImageIcon tankBlueSRight = new ImageIcon("TankBlueShootRight.png");
    ImageIcon tankBlueSUp = new ImageIcon("TankBlueShootUp.png");
    ImageIcon tankBlueSDown = new ImageIcon("TankBlueShootDown.png");
    
    ImageIcon tankRedLeft = new ImageIcon("TankRedLeft.png");
    ImageIcon tankRedRight = new ImageIcon("TankRedRight.png");
    ImageIcon tankRedUp = new ImageIcon("TankRedUp.png");
    ImageIcon tankRedDown = new ImageIcon("TankRedDown.png");
    
    ImageIcon tankRedSLeft = new ImageIcon("TankRedShootLeft.png");
    ImageIcon tankRedSRight = new ImageIcon("TankRedShootRight.png");
    ImageIcon tankRedSUp = new ImageIcon("TankRedShootUp.png");
    ImageIcon tankRedSDown = new ImageIcon("TankRedShootDown.png");
    
    //--------------------Inserting Strings into Choice array
    private static final String[] Choice = { "Move up", "Move down", "Move left", "Move right", "Shoot up", "Shoot down", "Shoot left", "Shoot right"};
    
    //--------------------Inserting Strings into Sequence array
    private static final String[] Sequence = { "Sequence 1", "Sequence 2", "Sequence 3", "Sequence 4", "Sequence 5", "Sequence 6",
                                               "Sequence 7", "Sequence 8", "Sequence 9", "Sequence 10", "Sequence 11", "Sequence 12", 
                                               "Sequence 13", "Sequence 14", "Sequence 15", "Sequence 16","Sequence 17", "Sequence 18"};
                                               
    //--------------------Inserting String into btnName array
    private static final String[] btnName = {"Start","Reset","Save","Load"};
    
    //--------------------Creating JLabel for Instructions
    JLabel Instructions = new JLabel("<html><br>You are required to give sequence for the Blue Tank to move.<br>" +
                                        "Your goal is to move and to shoot at the Red Tank in the least<br> number of tries. " +
                                        "The lesser the number of tries, the better.<br> Good Luck !<br><br><br></html>");
    
    //--------------------Creating JLabel for Sequence array                                    
    JLabel[] lblSequence = new JLabel[18];
    
    //--------------------Creating JComboBox for Choice array
    JComboBox[] cBoxChoice = new JComboBox[18];
    
    //--------------------Creating JButton for gameBoard 2D array
    JButton[][] btnBoard = new JButton[DIM_X][DIM_Y];
    
    //--------------------Creating JButton for btnName array 
    JButton[] btnOption = new JButton[4];
    
    
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~RobotWarsView Overloading Ctor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public RobotWarsView(String title){
        //--------------------Calling JFrame Ctor
        super(title);
        
        //--------------------Creating JPanel for gameBoard using GridLayout
        JPanel gameBoard = new JPanel(new GridLayout(DIM_X,DIM_Y));
        
        //--------------------Creating JPanel for Window using GridLayout
        JPanel Window = new JPanel(new GridLayout(1,1));
        
        //--------------------Creating JPanel for Menu using FlowLayout
        JPanel Menu = new JPanel(new FlowLayout());
        
        //--------------------Creating JPanel for pnlBtn using GridLayout
        JPanel pnlBtn = new JPanel(new GridLayout(1,4, 30, 0));       
        
        //---------------------------Game Board Panel---------------------------//
        //--------------------for loop to add JButton for gameBoard
        for(int j=0; j<DIM_Y; j++){
            for (int i=0; i<DIM_X;i++){
                btnBoard[i][j] = new JButton();  
                gameBoard.add(btnBoard[i][j]);
            }
        }   
        btnBoard[0][0].setIcon(tankRedRight);  //Tank Red initial position
        btnBoard[9][9].setIcon(tankBlueUp); //Tank Blue initial position
        add(gameBoard); //add gameBoard into JFrame
        Window.add(gameBoard);	//add gameBoard into Window panel
        
        //---------------------------Menu Panel---------------------------//
        
        Menu.add(Instructions); //add Instructions JLabel into Menu panel
        
        //--------------------for loop to add ComboBox with labels
        for(int i=0; i<18; i++){
            lblSequence[i] = new JLabel(Sequence[i]);
            Menu.add(lblSequence[i]);
            cBoxChoice[i] = new JComboBox<String>(Choice);
            Menu.add(cBoxChoice[i]);
        }
        
        //--------------------for loop to add btnOption with labels
        for(int i=0; i<4; i++){
            btnOption[i] = new JButton(btnName[i]);
            pnlBtn.add(btnOption[i]);  
        }
        
        Menu.add(pnlBtn);//add pnlBtn into Menu panel
        Window.add(Menu);//add Menu into Window panel
        
        add(Window);//add window into JFrame
        setSize(DIM_X*80,DIM_Y*55);
        //setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~addingActionListener method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void addingActionListener(ActionListener listening){
        //--------------------for loop to add ActionListener for gameBoard buttons
        for(int j=0; j<DIM_Y; j++){
            for (int i=0; i<DIM_X;i++){
                btnBoard[i][j].addActionListener(listening);
            }
        } 
        
        //--------------------for loop to add ActionListener for ComboBox buttons
        for(int i=0; i<18; i++){
            cBoxChoice[i].addActionListener(listening); 
        }
        
        //--------------------for loop to add ActionListener for btnOption buttons
        for(int i=0; i<4; i++){
            btnOption[i].addActionListener(listening);    
        }
    }
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Exception Handling method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void ExceptHandling(String Msg,String TtlPopup,int typePopup){
        if(typePopup==1){
            JOptionPane.showMessageDialog(this, Msg, TtlPopup, JOptionPane.PLAIN_MESSAGE);//handling plain message
        }
        else if(typePopup==2){
            JOptionPane.showMessageDialog(this, Msg, TtlPopup, JOptionPane.ERROR_MESSAGE);//handling error message
        }
        else if(typePopup==3){
            JOptionPane.showMessageDialog(this, Msg, TtlPopup, JOptionPane.WARNING_MESSAGE);//handling warning message
        }
    }
}