class Solution {
    public int findKthLargest(int[] nums, int k) {
        // not kth distinct but kth largest element
        // so each one counts.
        // Method1: quickSelect
        // Method2: use PriorityQueue

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = quickSelect(nums, left, right);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[k - 1];
    }

    private int quickSelect(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftIndex = left + 1;
        int rightIndex = right;
        while (leftIndex <= rightIndex) {
            if (nums[rightIndex] >= pivot) {
                swap(nums, leftIndex++, rightIndex);
            } else if (nums[leftIndex] <= pivot) {
                swap(nums, leftIndex, rightIndex--);
            } else {
                leftIndex++;
                rightIndex--;
            }
        }
        swap(nums, left, rightIndex);
        return rightIndex;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
