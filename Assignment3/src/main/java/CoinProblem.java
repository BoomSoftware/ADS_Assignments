import java.util.HashMap;

public class CoinProblem {
    private final int[] coins;
    public static HashMap<Integer, Integer> coinMap;

    public CoinProblem() {
        coins = new int[]{1, 7, 10, 22};
    }

    public int calculateBruteforce(int amount) {
        return findMinRecursiveBruteforce(amount);
    }

    public int calculateDynamic(int amount) {
        coinMap = new HashMap<>();
        int result = findMinRecursiveDynamic(amount);
        printMap();
        return result;
    }

    private int findMinRecursiveBruteforce(int amount) {
        if (amount == 0) return 0;
        if (amount < 0 ) return -1;
        int minValue = 0;

        for (int coin : coins) {
            if (coin <= amount) {
                int temp = findMinRecursiveBruteforce(amount - coin);
                if(minValue == 0){
                    minValue = temp + 1;
                }

                if (temp + 1 < minValue) {
                    minValue = temp + 1;
                }
            }
        }
        return minValue;
    }

    private int findMinRecursiveDynamic(int amount){
        if (amount == 0) return 0;
        if (amount < 0 ) return -1;

        if(coinMap.get(amount) != null){
            return coinMap.get(amount);
        }

        int minValue = 0;

        for (int coin : coins) {
            if (coin <= amount) {
                int temp = findMinRecursiveDynamic(amount - coin);
                if(minValue == 0){
                    minValue = temp + 1;
                }

                if (temp + 1 < minValue) {
                    minValue = temp + 1;
                }
            }
        }
        coinMap.put(amount, minValue);
        return minValue;
    }

    private void printMap(){
        System.out.println("Dynamic approach table:");
        String leftAlignFormat = "| %-11s | %-12d |%n";
        System.out.format("+-------------+--------------+%n");
        System.out.format("| amount      | min(amount)  |%n");
        System.out.format("+-------------+--------------+%n");
        for(int key : coinMap.keySet()){
            System.out.format(leftAlignFormat, key, coinMap.get(key));
        }
        System.out.format("+-------------+--------------+%n");
    }
}
