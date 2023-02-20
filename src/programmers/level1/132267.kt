package programmers.level1

private class `132267` {
    fun solution(a: Int, b: Int, n: Int): Int {
        var bottle = n
        var res = 0
        while (bottle > a) {
            val bonus = bottle / a * b
            bottle = bottle - bottle / a * a + bonus
            res += bonus
        }

        return if (bottle >= a) res + b else res
    }
}