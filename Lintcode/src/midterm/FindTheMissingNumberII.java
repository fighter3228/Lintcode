package midterm;

import java.util.Arrays;

public class FindTheMissingNumberII {
    public static int findMissing2(int n, String str) {
        // Write your code here
        int[] nums = new int[n];
        for(int i = 0; i < str.length(); i++){
            if(Integer.valueOf(str.substring(i, i+2)) <= n){
                if(nums[Integer.valueOf(str.substring(i, i+2))-1] == 0){
                    nums[Integer.valueOf(str.substring(i, i+2))-1] = Integer.valueOf(str.substring(i, i+2));
                    i++;
                } else {
                    nums[Integer.valueOf(str.substring(i, i+1))-1] = Integer.valueOf(str.substring(i, i+1));
                }
            } else {
                nums[Integer.valueOf(str.substring(i, i+1))-1] = Integer.valueOf(str.substring(i, i+1));
            }
        }
        
        Arrays.sort(nums);
        int xor = 0;
        int i = 0;
        for(; i < nums.length; i++){
            System.out.print(nums[i] + ", ");
            xor = xor^i^nums[i];
        }
        
        return xor^i;
    }
    
    public static void main(String...strings){
        String str = "19201234567891011121314151618";
        int n = 20;
        
//        String str = "0123457";
//        int n = 9;
        System.out.print(findMissing2(n, str));
    }
}
