package programmers.level2

import java.util.*

//https://school.programmers.co.kr/learn/courses/30/lessons/76502
private class `76502` {
    fun solution(s: String): Int {
        val sb = StringBuilder(s)
        var res = 0
        repeat(s.length - 1) {
            if (checkBracket(sb.toString()))
                res++

            sb.append(sb[0])
            sb.deleteCharAt(0)
        }

        return res
    }

    fun checkBracket(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            if (it == '(' || it == '{' || it == '[') {
                stack.push(it)
                return@forEach
            }

            if (stack.isEmpty() && (it == ')' || it == '}' || it == ']'))
                return false

            if (stack.peek() == '(' && it == ')' ||
                stack.peek() == '{' && it == '}' ||
                stack.peek() == '[' && it == ']') {

                stack.pop()
            } else {
                return false
            }


        }

        return stack.isEmpty()
    }
}