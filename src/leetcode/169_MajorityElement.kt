package leetcode

private class `169_MajorityElement` {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            val prev = map.getOrDefault(it, 0)
            map[it] = prev + 1
        }

        map.forEach {
            if (it.value > nums.size / 2) {
                return it.key
            }
        }

        return -1
    }
}