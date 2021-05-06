import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueenProblem queenProblem = new QueenProblem(4);
        List<int[][]> resultList = queenProblem.solve();
        queenProblem.printResult(resultList);
    }
}
