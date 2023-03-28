package programmers.level2

import java.util.StringTokenizer

private class `64065` {
    fun solution(s: String): IntArray {
        val res = ArrayList<Int>()
        val sList = s.substring(2 until s.lastIndex-1).split("},{").sortedWith(compareBy { it.length })
        val set = HashSet<Int>()
        sList.forEach {
            // println(it)
            val st = StringTokenizer(it, ",")
            while (st.hasMoreTokens()) {
                val i = st.nextToken().toInt()
                if (!set.contains(i)) {
                    set.add(i)
                    res.add(i)
                }
            }
        }

        return res.toIntArray()
    }
}