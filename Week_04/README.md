使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方
说明：同学们可以将自己的思路、代码写在第 4 周的学习总结中


1. 如例题 中间无序的地方为0，也就是变序数组的最小值。
2. 假设题目一定是半有序的，可以不用考虑完全有序的数组。
3. 要找到最小值，判断条件是 这个值大于前面一个值，用二分查找的话，判断条件可以为 ：
    如果mid刚好这个值，刚需要mid < mid-1
    如果mid刚好是左边的值，则需要 mid > mid+1
4. 半有序数组怎么移动 left 和 right:
    如果mid > left,则说明 最小值在右边
    反之则在左边

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length -1;
        if (nums[0] < nums[right]) {
            return nums[0];
        }
        while (left <= right) {
            int mid = left + (right-left) / 2;    
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid] < nums[mid - 1])
                return nums[mid];
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}