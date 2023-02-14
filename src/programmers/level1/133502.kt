package programmers.level1

import java.util.*

private class `133502` {
    fun solution(ingredient: IntArray): Int {
        val stack = Stack<Int>()
        var res = 0
        ingredient.forEach {
            stack.push(it)
            if (stack.size >= 4 &&
                stack[stack.lastIndex] == 1 &&
                stack[stack.lastIndex - 1] == 3 &&
                stack[stack.lastIndex - 2] == 2 &&
                stack[stack.lastIndex - 3] == 1) {

                res++
                repeat(4) { stack.pop() }
            }
        }

        return res
    }
}