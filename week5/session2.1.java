import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int n = arr.size();
        
        // 1. Maximum Subarray - Kadane's Algorithm
        int maxEndingHere = arr.get(0);
        int maxSoFar = arr.get(0);
        
        // 2. Maximum Subsequence - sum of positives
        int maxElement = arr.get(0);
        int positiveSum = 0;
        boolean hasPositive = false;
        
        if (arr.get(0) > 0) {
            positiveSum = arr.get(0);
            hasPositive = true;
        }
        
        for (int i = 1; i < n; i++) {
            int x = arr.get(i);
            
            // Kadane
            maxEndingHere = Math.max(x, maxEndingHere + x);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            
            // Subsequence
            if (x > 0) {
                positiveSum += x;
                hasPositive = true;
            }
            maxElement = Math.max(maxElement, x);
        }
        
        int maxSubsequence = hasPositive ? positiveSum : maxElement;
        
        return Arrays.asList(maxSoFar, maxSubsequence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }
            List<Integer> ans = maxSubarray(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
        sc.close();
    }
}
output
10 10
10 11
