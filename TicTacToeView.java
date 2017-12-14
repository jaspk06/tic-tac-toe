import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class TicTacToeView implements ActionListener{
  //properties
  JButton buttonboard[][]=new JButton[3][3];
  JButton buttonreset = new JButton("reset");
  JLabel labelwin1 = new JLabel("P1 Wins:");;
  JLabel labelwin2 = new JLabel("P2 Wins:");;
  JLabel labelmessage = new JLabel("");
  JFrame theframe = new JFrame("Tic Tac Toe");
  JPanel thepanel = new JPanel();
  JLabel message = new JLabel();
  
  TicTacToeModel tttmodel;
  int intRow;
  int intCol;
  int intRow1;
  int intCol1;
  int intR;
  int intC;
  
  //ethods
  //local methods for the GUI view
  
  
  //Controller methods that link the view to the model
  public void actionPerformed(ActionEvent evt){
    
    for (intRow =0;intRow<3;intRow++){
      for (intCol=0;intCol<3;intCol++){
        if (evt.getSource()==buttonboard[intRow][intCol]){
          buttonboard[intRow][intCol].setText(tttmodel.getTurn());
          tttmodel.placeMarker(intRow,intCol);
          buttonboard[intRow][intCol].setEnabled(false);
          String strWinner = tttmodel.checkWin();
          if (strWinner.equals("X")){
            message.setText("P1 Wins");
            labelwin1.setText("P1 Wins: "+Integer.toString(tttmodel.getP1Wins()));
            for (intR = 0; intR<3; intR++){
              for (intC = 0; intC<3; intC++){
                buttonboard[intR][intC].setEnabled(false);
                
              }
            }
          }
          else if (strWinner.equals("O")){
            message.setText("P2 Wins");
            labelwin2.setText("P2 Wins: "+Integer.toString(tttmodel.getP2Wins()));
            for (intR = 0; intR<3; intR++){
              for (intC = 0; intC<3; intC++){
                buttonboard[intR][intC].setEnabled(false);
                
              }
            }
          }
          else if (strWinner.equals("C")){
            message.setText("Cat's Game");
            for (intR = 0; intR<3; intR++){
              for (intC = 0; intC<3; intC++){
                buttonboard[intR][intC].setEnabled(false);
                
              }
            }
          }
        }
      }
    }
    if (evt.getSource()==buttonreset){
      tttmodel.resetBoard();
      for (intRow1 =0;intRow1<3;intRow1++){
        for (intCol1=0;intCol1<3;intCol1++){
          buttonboard[intRow1][intCol1].setEnabled(true);
          buttonboard[intRow1][intCol1].setText("");
        }
      }
      message.setText("");
    }
  }
  
  //constructor
  public TicTacToeView(){
    
    //construct the model
    tttmodel = new TicTacToeModel();
    tttmodel.resetBoard();
    
    thepanel.setPreferredSize(new Dimension(300,500));
    thepanel.setLayout(null);
    
    for (intRow =0;intRow<3;intRow++){
      for (intCol=0;intCol<3;intCol++){
        buttonboard[intRow][intCol] = new JButton();
        buttonboard[intRow][intCol].setSize(100,100);
        buttonboard[intRow][intCol].setLocation(intRow*100,intCol*100);
        buttonboard[intRow][intCol].addActionListener(this);
        thepanel.add(buttonboard[intRow][intCol]);
      }
    }
    buttonreset.setSize(100,50);
    buttonreset.setLocation(100,350);
    buttonreset.addActionListener(this);
    thepanel.add(buttonreset);
    
    labelwin1.setSize(100,100);
    labelwin1.setLocation(0,300);
    labelwin1.setHorizontalAlignment(JLabel.RIGHT);
    thepanel.add(labelwin1);
    
    labelwin2.setSize(100,100);
    labelwin2.setLocation(200,300);
    labelwin1.setHorizontalAlignment(JLabel.LEFT);
    thepanel.add(labelwin2);
    
    message.setSize(300,100);
    message.setLocation(0,400);
    message.setHorizontalAlignment(JLabel.CENTER);
    thepanel.add(message);
    
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    
    theframe.setVisible(true);
  }
  
  public static void main (String[]args){
    TicTacToeView tictactoe = new TicTacToeView();
    
    
  }
  
  
}