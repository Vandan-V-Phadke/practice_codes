package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner
 * of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant
 * knight (K) was initially positioned in the top-left room and must fight his way through
 * the dungeon to rescue the princess. The knight has an initial health point represented
 * by a positive integer. If at any point his health point drops to 0 or below, he dies
 * immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses
 * health (negative integers) upon entering these rooms; other rooms are
 * either empty (0’s) or contain magic orbs that increase the knight’s
 * health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only
 * rightward or downward in each step.
 *
 * Write a function to determine the knight’s minimum initial health so that he is able
 * to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at
 * least 7 if he follows the optimal path
 *
 * RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * Dungeon Princess: Example 1
 *
 * Input arguments to function:
 * Your function will get an M*N matrix (2-D array) as input which represents the 2D grid as described in the question. Your function should return an integer corresponding to the knight’s minimum initial health required.
 */
public class DungeonPrincess {

    public static void main(String[] args){
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(-2, -3, 3));
        arr.add(Arrays.asList(-5, -10, 1));
        arr.add(Arrays.asList(10, 30, -5));
        System.out.println(getMaxHealth(arr));
    }

    // TODO Check this method again
    public static int getMaxHealth(List<List<Integer>> mat){
        int m = mat.size(), n = mat.get(0).size();
        int dp[][] = new int[m][n];

        dp[m-1][n-1] = mat.get(m-1).get(n-1) > 0? 1:
                Math.abs(mat.get(m-1).get(n-1)) + 1;

        for (int i = m-2; i >= 0; i--)
            dp[i][n-1] = Math.max(dp[i+1][n-1] - mat.get(i).get(n-1), 1);
        for (int j = n-2; j >= 0; j--)
            dp[m-1][j] = Math.max(dp[m-1][j+1] - mat.get(m-1).get(j), 1);

        // fill the table in bottom-up fashion
        for (int i=m-2; i>=0; i--)
        {
            for (int j=n-2; j>=0; j--)
            {
                int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min_points_on_exit - mat.get(i).get(j), 1);
            }
        }

        return dp[0][0];
    }
}
