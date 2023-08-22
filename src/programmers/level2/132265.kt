package programmers.level2

private class `132265` {
    class Solution {
        fun solution(topping: IntArray): Int {
            val set1 = mutableSetOf<Int>()
            val set2 = topping.toMutableSet()
            val map = mutableMapOf<Int, Int>()
            var res = 0

            topping.forEach {
                val prev = map.getOrDefault(it, 0)
                map[it] = prev + 1
            }

            topping.forEach {
                if (set2.contains(it)) {
                    val prev = map.getOrDefault(it, 0)
                    map[it] = prev - 1
                }

                if (map.getOrDefault(it, 0) < 1) set2.remove(it)

                set1.add(it)

                if (set1.size == set2.size) {
                    res++
                }
            }

            return res
        }
    }
}