class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex);
        quickSort(nums, pIndex + 1, right);
    }
    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));

        swap(nums, left, pivotIndex);
    
        int pivot = nums[left];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
