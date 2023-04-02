package programmers.level2

private class `131701` {
    fun solution(elements: IntArray): Int {
        var len = 0
        val set = HashSet<Int>()
        repeat (elements.size) {
            var idx = 0
            len++

            for (i in elements.indices) {
                var sum = 0
                for (j in i until i + len) {
                    sum += elements[j % elements.size]
                }
                set.add(sum)
                sum = 0
                if (len == elements.size) break
            }
        }

        return set.size
    }
}