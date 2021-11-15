package 力扣;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/15 14:28
 * @PROJECT_NAME: JavaProjects
 */
public class p704 {
    public static int search(int[] nums, int target) {
        if(nums == null) return -1;

        if(nums[0] == target) return 0;
        //二分查找
        int high = nums.length - 1;
        int low = 0;
        while(low < high){
            int mid =(low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
                if (nums[high] == target)
                    return high;
            }else{
                low = mid + 1;
                if (nums[low] == target)
                    return low;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,5};
        int i = search(arr, 5);
        System.out.println("i = " + i);
    }
}
