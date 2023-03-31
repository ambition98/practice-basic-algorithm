package programmers.level2

private class `42578` {
    fun solution(clothes: Array<Array<String>>) =
        clothes.groupBy { it[1] }
            .values
            .fold(1) { acc, arr -> acc * (arr.size + 1) } - 1
}