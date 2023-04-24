package programmers.level2

import java.util.*

private class `154539` {
    fun solution(numbers: IntArray): IntArray {
        val res = IntArray(numbers.size) { -1 }
        val stack = LinkedList<Int>()

        numbers.forEachIndexed { i, n ->
            while (stack.isNotEmpty() && numbers[stack.peek()] < n) {
                res[stack.pop()] = n
            }
            stack.push(i)
        }

        return res
    }
}