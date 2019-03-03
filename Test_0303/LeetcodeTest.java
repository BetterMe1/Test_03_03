package Test_0303;

/*
33. ������ת��������
 ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��
����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
����Լ��������в������ظ���Ԫ�ء�
����㷨ʱ�临�Ӷȱ����� O(log n) ����

ʾ�� 1:
����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ�� 2:
����: nums = [4,5,6,7,0,1,2], target = 3
���: -1
 */
/*
 * ������
 * ʱ�临�Ӷ��� O(log n) �������ǿ��Կ����ö��ֲ��ң�ÿ�ζ���ָ�����ȵ�һ����һ��Ϊ����
 * �������������ǰ������������������δ֪��ĳ�����Ͻ�������ת������ÿ���зֿ϶�������һ������������ģ�
 * ��ÿ���зֺ��ж�Ŀ��ֵ��λ�ã�ֱ���ҵ�Ŀ��ֵ�����Ҳ���ʱ����-1.
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
//    	if(nums[mid] < nums[r]){//�Ҳ�����
//    		if(target > nums[mid] && target <= nums[r]){//Ŀ��ֵ���Ҳ�
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
34. �����������в���Ԫ�صĵ�һ�������һ��λ��
 ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
����㷨ʱ�临�Ӷȱ����� O(log n) ����
��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:
����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]
ʾ�� 2:
����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]
 */
/*
 * ������
 * ���ζ��ֲ��ң�һ���ҳ�Ŀ��ֵ�ĵ�һ��λ�ã���һ���ҵ�Ŀ��ֵ�����һ��λ�ã�ע�����ж����鳤��Ϊ0��������ֻ��һ�����Ҳ�����Ŀ��ֵʱֱ�ӷ���-1.
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