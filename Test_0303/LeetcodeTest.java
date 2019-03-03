package Test_0303;

/*
33. 搜索旋转排序数组
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。

示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 */
/*
 * 分析：
 * 时间复杂度是 O(log n) 级别，我们可以考虑用二分查找，每次都将指定长度的一组数一分为二，
 * 由于搜索数组是按照升序排序的数组在未知的某个点上进行了旋转，所以每次切分肯定至少有一边数组是有序的，
 * 在每次切分后判断目标值的位置，直到找到目标值，或找不到时返回-1.
 */
//public class LeetcodeTest {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] nums = {4,5,6,7,0,1,2};
//		int target = 0;
//		System.out.println(So.search(nums, target));
//	}
//}
//class Solution {
//    public int search(int[] nums, int target) {
//    	return search(nums, 0, nums.length-1, target);
//    }
//    private int search(int[] nums, int l, int r,int target){
//    	if(l > r){
//    		return -1;
//    	}
//    	int mid = (l+r)/2;
//    	if(nums[mid] == target){
//    		return mid;
//    	}
//    	if(nums[mid] < nums[r]){//右侧有序
//    		if(target > nums[mid] && target <= nums[r]){//目标值在右侧
//    			return search(nums, mid+1, r, target);
//    		}else{
//    			return search(nums, l, mid-1, target);
//    		}
//    	}else{
//    		if(target < nums[mid] && target >= nums[l]){
//    			return search(nums, l, mid-1, target);
//    		}else{
//    			return search(nums, mid+1, r, target);
//    		}
//    	}
//    }
//}
/*
34. 在排序数组中查找元素的第一个和最后一个位置
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
/*
 * 分析：
 * 两次二分查找，一次找出目标值的第一个位置，另一次找到目标值的最后一个位置，注意先判断数组长度为0，或数组只有一个数且不等于目标值时直接返回-1.
 */
public class LeetcodeTest {
	public static void main(String[] args) {
		Solution So = new Solution();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] res = So.searchRange(nums, target);
		System.out.println(res[0] + " " + res[1]);
	}
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int[] res = new int[] {-1,-1};
    	if(nums.length != 0 && (!(nums.length ==1 && nums[0] != target))){
    		res[0] = searchLeft(nums, 0, nums.length-1,target);
    		if(res[0] != -1){
    			res[1] = searchRight(nums, 0, nums.length-1,target);
    		}
    	}
    	return res;
    }
    private int searchLeft(int[] nums, int l, int r,int target){
    	if(l > r || (l == r && target != nums[l])){
    		return -1;
    	}else if(l == r){
    		return l;
    	}
    	int mid = (l+r)/2;
    	if(target < nums[mid]){
    		return searchLeft(nums, l, mid-1, target);
    	}else if(target > nums[mid]){
    		return searchLeft(nums, mid+1, r, target);
    	}else{
    		return searchLeft(nums, l, mid, target);
    	}
    }
    private int searchRight(int[] nums, int l, int r,int target){
    	if(l > r || (l == r && target != nums[l])){
    		return -1;
    	}else if(l == r){
    		return r;
    	}
    	int mid = (l+r+1)/2;
    	if(target < nums[mid]){
    		return searchRight(nums, l, mid-1, target);
    	}else if(target > nums[mid]){
    		return searchRight(nums, mid+1, r, target);
    	}else{
    		return searchRight(nums, mid, r, target);
    	}
    }
}