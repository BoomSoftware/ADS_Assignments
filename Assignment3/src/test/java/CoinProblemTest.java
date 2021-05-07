import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinProblemTest {

    private CoinProblem coinProblem;

    @BeforeEach
    public void coinProblemSetup(){
        coinProblem = new CoinProblem();
    }

    @Test
    public void negativeAmountBruteforceTest(){
        int result = coinProblem.calculateBruteforce(-1);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void negativeAmountDynamicTest(){
        int result = coinProblem.calculateDynamic(-1);
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void zeroAmountBruteforceTest(){
        int result = coinProblem.calculateBruteforce(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void zeroAmountDynamicTest(){
        int result = coinProblem.calculateDynamic(0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void amount1BruteforceTest(){
        int result = coinProblem.calculateBruteforce(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void amount1DynamicTest(){
        int result = coinProblem.calculateBruteforce(1);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void amount22BruteforceTest(){
        int result = coinProblem.calculateBruteforce(22);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void amount22DynamicTest(){
        int result = coinProblem.calculateDynamic(22);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void amount8BruteforceTest(){
        int result = coinProblem.calculateBruteforce(8);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void amount8DynamicTest(){
        int result = coinProblem.calculateDynamic(8);
        Assertions.assertEquals(2, result);
    }
}
