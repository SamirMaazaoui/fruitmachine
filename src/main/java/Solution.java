import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int fruit(final String[][] reels, final int[] spins) {

        Integer[] spinIndexs = new Integer[3];
        List<String> refReel = Arrays.asList("Wild", "Star", "Bell", "Shell", "Seven", "Cherry", "Bar", "King", "Queen", "Jack");
        int score = 0;
        for (int i = 0; i < spins.length; i++) {
            spinIndexs[i] = refReel.indexOf(reels[i][spins[i]]);
        }
        if (isSameThreeSpin(spinIndexs)) {
            score = (10 - spinIndexs[1]) * 10;
        } else {
            score = getScore(spinIndexs);
        }
        System.out.println("Score : "+score);
        return score;

    }

    private static boolean isSameThreeSpin(Integer[] spins) {
        return spins[0] == spins[1] && spins[1] == spins[2];
    }

    private static Integer getScore(Integer[] spins) {
        if (spins[0] == spins[1] && spins[1] != spins[2]) {
            if (spins[2] == 0) {
                return (10 - spins[1]) * 2;
            }
            return (10 - spins[1]);
        }
        if (spins[1] == spins[2] && spins[2] != spins[0]) {
            if (spins[0] == 0) {
                return (10 - spins[1]) * 2;
            }
            return (10 - spins[1]);
        }
        if (spins[0] == spins[2] && spins[2] != spins[1]) {
            if (spins[1] == 0) {
                return (10 - spins[0]) * 2;
            }
            return (10 - spins[0]);
        }
        return 0;
    }

}