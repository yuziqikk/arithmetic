package 搜索.二分;

/**
 * @Package: 搜索.二分
 * @Author: YuZiQiKK
 * @Created: 8/5/2024 下午5:07
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5, 5, 6};
        int target = 4;
        System.out.println("Target's right bound index: " + rightBound(nums, target));
        System.out.println("Target's index: " + binarySearch(nums, target));
    }

    //找target，数组中没有target则返回比 target小一个的数的下标
    public static int binarySearch(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    // 寻找target右侧最接近的元素索引
    public static int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
