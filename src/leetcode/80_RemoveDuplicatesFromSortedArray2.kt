package leetcode

private class `80_RemoveDuplicatesFromSortedArray2` {
    fun removeDuplicates(nums: IntArray): Int {
        var dup = false
        var idx = 0
        var prev = -1

        for (i in nums.indices) {
            if (!dup || prev != nums[i]) {
                nums[idx++] = nums[i]
                if (dup) {
                    dup = false
                } else if (prev == nums[i]) {
                    dup = true
                }
            }
            prev = nums[i]
        }

        return nums.size - (nums.size - idx)
    }
}