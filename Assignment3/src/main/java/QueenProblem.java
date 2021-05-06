import java.util.ArrayList;
import java.util.List;

public class QueenProblem {

    private final int[][] board;
    private final int boardSize;
    private List<int[][]> resultList;

    public QueenProblem(int boardSize){
        this.boardSize = boardSize;
        board = new int[boardSize][boardSize];
    }

    public List<int[][]> solve() {
        resultList = new ArrayList<>();
        solveBacktrack(0);
        return resultList;
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

    public void printResult(List<int[][]> boards){
        if(boards.isEmpty()){
            System.out.println("No solution exit!");
            return;
        }

        for(int[][]resultBoard : boards){
            displayHorizontalLine();
            for(int column = 0; column < boardSize ; column++){
                for(int row = 0 ; row < boardSize; row++){
                    System.out.print("| " + getSignRepresentation(resultBoard[row][column]) + " ");
                    if(row == boardSize - 1){
                        System.out.print("|");
                    }
                }
                System.out.println();
                displayHorizontalLine();
            }
            System.out.print("\n");
        }
    }

    private String getSignRepresentation(int sign){
        if(sign == 1){
            return "Q";
        }
        return " ";
    }

    private boolean solveBacktrack(int column){
        if(column >= boardSize) {
            int[][] temp = new int[boardSize][boardSize];
            for(int i = 0 ; i < boardSize ; i++){
                for(int j = 0 ; j < boardSize ; j++){
                    temp[i][j] = board[i][j];
                }
            }
            resultList.add(temp);
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
