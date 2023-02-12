package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/155652
private class `1556521` {
    fun solution(s: String, skip: String, index: Int): String {
        val set = HashSet<Char>()
        val sb = StringBuilder()
        skip.forEach { set.add(it) }
        s.forEach { sb.append(convert(it, set, index)) }

        return sb.toString()
    }

    fun convert(c: Char, set: HashSet<Char>, index: Int): Char {
        var target = c
        var cnt = 0
        while (true) {
            val next = if (target + 1 > 'z') 'a' else target + 1
            if (!set.contains(next)) {
                cnt++
            }
            target++
            if (target > 'z') target = 'a'
            if (cnt >= index) break
        }

        return target
    }
}