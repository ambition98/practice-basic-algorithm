package programmers.level2

private class `84512` {
    val words = "AEIOU"
    var cnt = 0
    var finded = false

    fun solution(word: String): Int {
        for (i in 0..4) {
            if (words[i] < word[0]) {
                cnt += 781
                continue
            }

            dfs(word, words[i].toString())
            if (finded) break
        }

        return cnt
    }

    fun dfs(target: String, word: String) {
        cnt++

        if (word == target) finded = true
        if (word.length == 5) {
            return
        }

        for (i in 0..4) {
            if (finded) break
            dfs(target, word + words[i])
        }

        return
    }
}