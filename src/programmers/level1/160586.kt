package programmers.level1

//https://school.programmers.co.kr/learn/courses/30/lessons/160586
private class `160586` {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        val map = HashMap<Char, Int>()
        val res = ArrayList<Int>()
        keymap.forEach { s ->
            s.forEachIndexed { index, c ->
                if (map.contains(c)) {
                    if (map.getValue(c) > index + 1) {
                        map[c] = index + 1
                    }
                } else {
                    map[c] = index + 1
                }
            }
        }

        for (s in targets) {
            var cnt = 0
            for (c in s) {
                if (!map.contains(c)) {
                    cnt = -1
                    break
                } else {
                    cnt += map.getValue(c)
                }
            }
            res.add(cnt)
        }

        return res.toIntArray()
    }
}