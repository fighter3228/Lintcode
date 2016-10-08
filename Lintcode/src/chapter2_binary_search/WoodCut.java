package chapter2_binary_search;

import java.util.Arrays;

/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee
 * you could have equal or more than k pieces with the same length. What is the longest length you
 * can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
 * 
 * Notice
 * 
 * You couldn't cut wood into float length.
 */
public class WoodCut {

    /**
     * @param L
     *            : Given n pieces of wood with length L[i]
     * @param k
     *            : An integer return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        Arrays.sort(L);
        // first find the range of the length of the wood
        int left = 0, right = L.length - 1, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            int validCnt = computeValidPieces(L, mid);
            if (validCnt == k) {
                return L[mid];
            } else if (validCnt < k) {
                left = mid;
            } else {
                right = mid;
                break;
            }
        }
        int leftCnt = computeValidPieces(L, left);
        int rightCnt = computeValidPieces(L, right);
        
        if(rightCnt > k){
            return binarySearch(L, right, L.length-1);
        }
        
        if(leftCnt < k){
            return binarySearch(L, 0, left);
        }

        // then find the exact length of the wood
        return 0;
    }

    private int binarySearch(int[] l, int start, int end) {
        
        return 0;
    }

    private int computeValidPieces(int[] L, int pos) {
        int cutLen = L[pos], validCnt = 0;
        for (int i = 0; i < L.length; i++) {
            validCnt += L[i] / cutLen;
        }
        return validCnt;
    }

    public static void main(String... strings) {
        WoodCut test = new WoodCut();
        int[] L = new int[] { 232, 124, 456 };
        int k = 7;
        System.out.println(test.woodCut(L, k));
    }

}
