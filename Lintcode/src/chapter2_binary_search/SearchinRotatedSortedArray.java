package chapter2_binary_search;

public class SearchinRotatedSortedArray {

    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    
    //looked at renegade's solution: https://discuss.leetcode.com/topic/3538/concise-o-log-n-binary-search-solution/16
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) { // eg. 3,4,5,6,1,2
                if (target > nums[mid] || target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            } else { // eg. 5,6,1,2,3,4
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        if (start == end && target != nums[start])
            return -1;
        return start;

    }

}
