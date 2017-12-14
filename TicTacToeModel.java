//Data for Tic Tac Toe

public class TicTacToeModel {
  //Properties
  private String strBoard[][] = new String[3][3];
  private int intP1Wins = 0;
  private int intP2Wins = 0;
  private String strTurn = "X";
  private int intTurns = 0; 
  
  //Methods
  
  public int getP1Wins(){
    return intP1Wins; 
  }
  public int getP2Wins(){
    return intP2Wins; 
  }
  public String getTurn(){
    return strTurn; 
  }
  public void placeMarker(int intRow,int intColumn) {
    strBoard[intRow][intColumn] = strTurn; 
    intTurns++;
    if(strTurn.equals("X")){
      strTurn = "O";
    } else {
      strTurn = "X";
    }   
  }
  
  public String checkWin() {
    int intRow;
    int intColumn;
    for(intRow =0;intRow <3;intRow++) {
      if(strBoard[intRow][0].equals(strBoard[intRow][1]) && strBoard[intRow][1].equals(strBoard[intRow][2])) {
        if (strBoard[intRow][0].equals("X")){
          intP1Wins++; 
        }
        else{
          intP2Wins++; 
        }
        return strBoard[intRow][0];
      }
    }
    for(intColumn=0;intColumn<3;intColumn++) {
      if(strBoard[0][intColumn].equals(strBoard[2][intColumn]) && strBoard[1][intColumn].equals(strBoard[2][intColumn])) {
        if (strBoard[0][intColumn].equals("X")){
          intP1Wins++;
        }
        else{
          intP2Wins++;
        }
        return strBoard[0][intColumn];
        }
  }
  if(strBoard[0][0].equals(strBoard[1][1]) && strBoard[1][1].equals(strBoard[2][2])) {
    return strBoard[0][0];
  } else if(strBoard[0][2].equals(strBoard[1][1]) && strBoard[1][1].equals(strBoard[2][0])) {
    return strBoard[0][2];
  }
  if(intTurns >= 9) {
    return "C";
  }
  else{
    return ""; 
  }
  
  }
 public void resetBoard(){
   int intR;
   int intC;
   for (intR = 0; intR<3; intR++){
     for (intC = 0; intC<3; intC++){
       strBoard[intR][intC]="";
       intTurns=0;
       strTurn = "X";
       
     }
   }
 }
 
 
 //Constructor
 public TicTacToeModel() {
   
 }
 }
