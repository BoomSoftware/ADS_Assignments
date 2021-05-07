import java.util.List;

public class Main {
    public static void main(String[] args) {
        QueenProblem queenProblem = new QueenProblem(4);
        List<int[][]> resultList = queenProblem.solve();
        System.out.println("Available solutions for the queen problem:");
        queenProblem.printResult(resultList);

        CoinProblem coinProblem = new CoinProblem();
        System.out.println("Minimum coin number using dynamic programming: " + coinProblem.calculateDynamic(16));
        System.out.println("Minimum coin number using bruteforce: " + coinProblem.calculateBruteforce(16));
    }
}
