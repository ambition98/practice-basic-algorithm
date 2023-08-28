package leetcode

import java.util.Deque
import java.util.LinkedList

private class `189_RotateArray` {
    fun rotate(nums: IntArray, k: Int): Unit {
        val queue: Deque<Int> = LinkedList()
        nums.forEach {
            queue.addLast(it)
        }

        repeat(k % nums.size) {
            queue.addFirst(queue.removeLast())
        }

        for (i in nums.indices) {
            nums[i] = queue.removeFirst()
        }
    }

//    fun rotate(nums: IntArray, k: Int): Unit {
//        reverseIntArray(nums, 0, nums.lastIndex)
//        reverseIntArray(nums, k % nums.size, nums.lastIndex)
//        reverseIntArray(nums, 0, k % nums.size - 1)
//    }
//
//    private fun reverseIntArray(arr: IntArray, start: Int, end: Int) {
//        var i = start
//        var j = end
//        while (i <= j) {
//            val temp = arr[i]
//            arr[i] = arr[j]
//            arr[j] = temp
//            i++
//            j--
//        }
//    }
}