package programmers.level2

private class `87390` {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val res = IntArray((right - left).toInt() + 1) { 0 }
        var idx = 0
        for (i in left..right) {
            val row = (i / n).toInt()
            val col = (i % n).toInt()

            if (row > col) {
                // println("i: ${row + 1}")
                res[idx++] = row + 1
            } else {
                // println("i: ${col + 1}")
                res[idx++] = col + 1
            }
        }

        return res
    }
}