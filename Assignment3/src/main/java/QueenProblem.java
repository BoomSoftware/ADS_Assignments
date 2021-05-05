public class QueenProblem {

    private int[][] board;
    private int boardSize;

    public QueenProblem(int boardSize){
        this.boardSize = boardSize;
        board = new int[boardSize][boardSize];
    }

    public void printResult(){
        displayHorizontalLine();
        for(int column = 0; column < boardSize ; column++){
            for(int row = 0 ; row < boardSize; row++){
                System.out.print("| " + getSignRepresentation(board[row][column]) + " ");
                if(row == boardSize - 1){
                    System.out.print("|");
                }
            }
            System.out.println();
            displayHorizontalLine();

        }
        System.out.print("\n");
    }

    private void displayHorizontalLine(){
        for(int c = 0; c < boardSize ; c++){
            System.out.print("+---");
            if(c == boardSize - 1){
                System.out.print("+");
            }
        }
        System.out.println();
    }

    private String getSignRepresentation(int sign){
        if(sign == 1){
            return "1";
        }
        return " ";
    }

    public void solve(){
        if(boardSize <= 3){
            System.out.println("No existing solution for this size of board");
        }
        solveBacktrack(0);
    }


    private boolean solveBacktrack(int column){
        if(column >= boardSize) {
            printResult();
        }

        for(int i = 0; i < boardSize; i++){
            if(isPlaceOkay(i, column)) {
                insertTempQueen(i, column);

                if(solveBacktrack(column + 1)){
                    return true;
                }
                removeTempQueen(i, column);
            }
        }
        return false;
    }

    private boolean isPlaceOkay(int row, int column){

        for(int i = 0 ; i < column; i++){
            if(board[row][i] == 1)
                return false;
        }

        int i,j;

        for (i = row, j = column; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = column; j >= 0 && i < boardSize; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private void insertTempQueen(int row, int column){
        board[row][column] = 1;
    }

    private void removeTempQueen(int row, int column){
        board[row][column] = 0;
    }

}
