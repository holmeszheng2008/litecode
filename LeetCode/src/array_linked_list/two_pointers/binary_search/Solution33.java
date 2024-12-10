package array_linked_list.two_pointers.binary_search;

// 33. Search in Rotated Sorted Array
public class Solution33 {
    public int search(int[] nums, int target) {
        int leftMin = nums[0];
        int rightMax = nums[nums.length - 1];
        if(target == leftMin){
            return 0;
        } else if (target == rightMax){
            return nums.length - 1;
        } else if (target < leftMin && target > rightMax){
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(target > nums[middle]) {
                if(nums[middle] <= rightMax){
                    if(target <= rightMax){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if(target > rightMax){
                        left = middle + 1;
                    } else {
                        return -1;
                    }
                }
            } else if (target == nums[middle]){
                return middle;
            } else if (target < nums[middle]){
                if(nums[middle] <= rightMax){
                    if(target <= rightMax){
                        right= middle - 1;
                    } else {
                        return -1;
                    }
                } else {
                    if(target > rightMax){
                        right = middle -1;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }

        return -1;
    }
}


class Solution33_attempt1 {
    public int search(int[] nums, int target) {
        int leftMin = nums[0], rightMax = nums[nums.length - 1];
        if(leftMin <= rightMax){
            int left = 0, right = nums.length - 1;
            while(left <= right) {
                int middle = left + (right- left) / 2;
                if(nums[middle] == target){
                    return middle;
                } else if (nums[middle] < target){
                    left = middle + 1;
                } else if (nums[middle] > target){
                    right = middle - 1;
                }
            }

            return -1;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(value >= leftMin){
                if(target == value){
                    return middle;
                } else if (target > value){
                    left = middle + 1;
                } else if (target < value){
                    if(target >= leftMin) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
            } else if (value <= rightMax){
                if(target == value) {
                    return middle;
                } else if (target > value){
                    if(target <= rightMax){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else if (target < value){
                    right = middle - 1;
                }
            }
        }

        return -1;
    }
}

class Solution33_attempt2 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int leftMin = nums[0], rightMax = nums[n-1];
        if(target < leftMin && target > rightMax){
            return -1;
        }

        int left = 0, right = n-1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(target >= leftMin){
                if(value >= leftMin){
                    if(value == target){
                        return middle;
                    } else if (value < target){
                        left = middle + 1;
                    } else if (value > target){
                        right = middle - 1;
                    }
                } else {
                    right = middle - 1;
                }
            } else {
                if(value >= leftMin){
                    left = middle + 1;
                } else {
                    if(value == target){
                        return middle;
                    } else if (value < target){
                        left = middle + 1;
                    } else if (value > target){
                        right = middle - 1;
                    }
                }
            }
        }

        return -1;
    }
}