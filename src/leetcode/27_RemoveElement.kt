package leetcode

//https://foxtrot.tistory.com/11
private class `27_RemoveElement` {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        var idx = 0
        for (i in nums.indices) {
            if (`val` != nums[i]) {
                nums[idx++] = nums[i]
                k++
            }
        }

        return k
    }
}