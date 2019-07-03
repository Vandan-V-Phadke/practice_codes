package heaps;

/**
 * How many distinct Max Heap can be made from n distinct integers
 *
 * In short, you have to ensure the following properties for the max heap :
 *
 * Heap has to be a complete binary tree ( A complete binary tree is a binary
 * tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible. )
 *
 * Every node is greater than all its children
 * Let us take an example of 4 distinct integers.
 * Without loss of generality let us take 1 2 3 4 as our 4 distinct integers
 *
 * Following are the possible max heaps from these 4 numbers :
 *
 *          4
 *        /  \
 *       3   2
 *      /
 *     1
 *          4
 *        /  \
 *       2   3
 *      /
 *     1
 *         4
 *        /  \
 *       3   1
 *      /
 *     2
 * These are the only possible 3 distinct max heaps possible for 4 distinct elements.
 *
 * Implement the below function to return the number of distinct Max Heaps
 * that is possible from n distinct elements.
 *
 * As the final answer can be very large output your answer modulo 1000000007
 *
 * Input Constraints : n <= 100
 *
 * TODO
 *
 */
public class WaysToFormMaxHeap {

    public static void main(String[] args){
        System.out.println(getNumberLeftSubtree(10));
    }

    public static int getNumberLeftSubtree(int n){
        int currentPow = 2;
        int left = 0;
        while (n > currentPow){
            n = n - currentPow;
            left += (currentPow / 2);
            currentPow = currentPow * 2;
        }

        if (n > (currentPow / 2))
            left += currentPow / 2;
        else
            left += n;

        return left;
    }


}
