package array_linked_list.two_pointers.binary_search;

// 81. Search in Rotated Sorted Array II
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int leftMin = nums[0];
        int rightMax = nums[nums.length - 1];
        if(target < leftMin && target > rightMax){
            return false;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(value == target){
                return true;
            }
            if(target == nums[left] || target == nums[right]){
                return true;
            }

            while(left<= right && nums[left] == nums[right]){
                left++;
                right--;
            }

            if(left > right){
                break;
            }
            leftMin = nums[left];
            rightMax = nums[right];
            if (value < target){
                if(target >= leftMin) {
                    if(value >= leftMin){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if(value >= leftMin){

                    } else {
                        left = middle + 1;
                    }
                }
            } else if (value > target){
                if(target >= leftMin) {
                    if(value >= leftMin){
                        right = middle - 1;
                    } else {

                    }
                } else {
                    if(value >= leftMin){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
        }

        return false;
    }
}


class Solution81_attempt1 {
    public boolean search(int[] nums, int target) {
        int leftMin = nums[0];
        int rightMax = nums[nums.length - 1];
        if(target < leftMin && target > rightMax){
            return false;
        }

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int value = nums[middle];

            while(left<= right && nums[left] == nums[right]){
                if(nums[left] == target){
                    return true;
                }
                left++;
                right--;
            }

            if(left > right){
                break;
            }

            leftMin = nums[left];
            if (value < target){
                if(target >= leftMin) {
                    if(value >= leftMin){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if(value >= leftMin){

                    } else {
                        left = middle + 1;
                    }
                }
            } else if (value > target){
                if(target >= leftMin) {
                    if(value >= leftMin){
                        right = middle - 1;
                    } else {

                    }
                } else {
                    if(value >= leftMin){
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            } else if(value == target){
                return true;
            }
        }

        return false;
    }
}

class Solution81_attempt2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right){
            while(left <= right && nums[left] == nums[right]){
                if (nums[left] == target) {
                    return true;
                } else {
                    left++;
                    right--;
                }
            }
            if(left > right){
                return false;
            }

            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if(target >= nums[left]){
                if(value >= nums[left]){
                    if(value == target){
                        return true;
                    } else if (value < target){
                        left = middle + 1;
                    } else if (value > target){
                        right = middle - 1;
                    }
                } else {
                    right = middle - 1;
                }
            } else {
                if(value >= nums[left]){
                    left = middle + 1;
                } else {
                    if(value == target){
                        return true;
                    } else if (value < target){
                        left = middle + 1;
                    } else if (value > target){
                        right = middle - 1;
                    }
                }
            }
        }

        return false;
    }
}

class Solution81_attempt3 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right && nums[left] == nums[right]) {
            if (nums[left] == target) {
                return true;
            } else {
                left++;
                right--;
            }
        }
        if (left > right) {
            return false;
        }
        int leftMin = nums[left];
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = nums[middle];
            if (target >= leftMin) {
                if (value >= leftMin) {
                    if (value == target) {
                        return true;
                    } else if (value < target) {
                        left = middle + 1;
                    } else if (value > target) {
                        right = middle - 1;
                    }
                } else {
                    right = middle - 1;
                }
            } else {
                if (value >= leftMin) {
                    left = middle + 1;
                } else {
                    if (value == target) {
                        return true;
                    } else if (value < target) {
                        left = middle + 1;
                    } else if (value > target) {
                        right = middle - 1;
                    }
                }
            }
        }

        return false;
    }
}