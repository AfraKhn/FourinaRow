package com.example.fourinarow;

public class GameMain implements IGameMain {
    private String [][] board = new String[6][7];
    private int [][] index= new int[6][7];
    private String turn = Blue;
    private int tawOnBoard = 0;//the number of taws placed
    private int currentColumn = -1;
    private int currentRow = -1;

    GameMain (){
        int c = 0;
        for(int i = 0 ; i<6 ; i++){
            for (int j = 0 ; j<7 ; j++){
                index[i][j]=c;
                board[i][j]="";
                c++;
            }
        }

    }
    public String getTurn(){
        return turn;
    }

    public int put(int j){
        int result = -1;
        for(int i = 5 ; i>=0 ; i--){
            if(board[i][j].equals("")){
                result = index[i][j];
                board[i][j]=turn;
                tawOnBoard++;
                currentRow = i;
                currentColumn= j;
                break;
            }
        }
        return result;
    }

    public boolean didDraw(){
        return tawOnBoard==42;
    }

    public boolean didWin(){
        if(horizontalCheck())return true;
        else if (verticalCheck())return true;
        else if(rightDiameterCheck())return true;
        else if(leftDiameterCheck())return true;
        else {
            changeTurn();
            return false;
        }
    }

    private boolean horizontalCheck() {
        int count = 0;
        int i = currentRow;
        //i sabet j ziad : be samte rast
        for(int j=currentColumn; j<7 && count<4 ; j++){
            if(board[i][j].equals(turn)){
                count++;
            }
            else break;
        }
        if(count!=4){
           count--; //khode khoone 2 bar shemorde nashe
            //i sabet j kam : be samte chap
            for(int j=currentColumn; j>=0 && count<4 ; j--){
                if(board[i][j].equals(turn)){
                    count++;
                }
                else break;
            }
        }
        return count==4;
    }

    private boolean verticalCheck() {
        int count = 0;
        int j = currentColumn;
        //j sabet i ziad : be samte bala
        for(int i=currentRow ; i<6 && count<4 ; i++){
            if(board[i][j].equals(turn)){
                count++;
            }
            else break;
        }
        if(count!=4){
            count--; //khode khoone 2 bar shemorde nashe
            //j sabet i kam : be samte paein
            for(int i=currentRow ; i>=0 && count<4 ; i--){
                if(board[i][j].equals(turn)){
                    count++;
                }
                else break;
            }
        }
        return count==4;
    }

    private boolean rightDiameterCheck() {
        int count = 0;
        int i = currentRow;
        int j = currentColumn;
        // i-- j++ : besamte bala
        for(i=currentRow ; i>=0 && j<7 && count<4 ; i-- ){
            if(board[i][j].equals(turn)){
                count++;
                j++;
            }
            else break;
        }
        if(count!=4){
            count--;//khode khoone 2 bar shemorde nashe
            j=currentColumn;
            // i++ j-- : besamte paein
            for(i=currentRow ; i<6 && j>=0 && count<4 ; i++ ){
                if(board[i][j].equals(turn)){
                    count++;
                    j--;
                }
                else break;
            }
        }
        return count==4;
    }

    private boolean leftDiameterCheck() {
        int count = 0;
        int i = currentRow;
        int j = currentColumn;
        // i++ j++ : besamte bala
        for(i=currentRow ; i<6 && j<7 && count<4 ; i++ ){
            if(board[i][j].equals(turn)){
                count++;
                j++;
            }
            else break;
        }
        if(count!=4){
            count--;//khode khoone 2 bar shemorde nashe
            j=currentColumn;
            // i-- j-- : besamte paein
            for(i=currentRow ; i>=0 && j>=0 && count<4 ; i--){
                if(board[i][j].equals(turn)){
                    count++;
                    j--;
                }
                else break;
            }
        }
        return count==4;
    }

    private void changeTurn() {
        if(turn.equals(Blue)){
            turn=Red;
        }
        else turn=Blue;
    }

}
