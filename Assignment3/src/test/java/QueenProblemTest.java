import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class QueenProblemTest {

    private QueenProblem queenProblem;

    @Test
    public void noSolutionTest(){
        queenProblem = new QueenProblem(3);
        List<int[][]> result = queenProblem.solve();

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void solutionForSize4Test(){
        queenProblem = new QueenProblem(4);
        List<int[][]> result = queenProblem.solve();

        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void compareSolutionForSize4Test(){
        queenProblem = new QueenProblem(4);
        List<int[][]> result = queenProblem.solve();

        int[][] expectedResult1 = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0},
        };

        int[][] expectedResult2 = {
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
        };

        Assertions.assertTrue(Arrays.deepEquals(result.get(1), expectedResult1));
        Assertions.assertTrue(Arrays.deepEquals(result.get(0), expectedResult2));
    }

}
