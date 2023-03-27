package programmers.level1

private class `172928` {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var x = -1
        var y = -1
        for (i in park.indices) {
            for (j in park[0].indices) {
                if (park[i][j] == 'S') {
                    x = i
                    y = j
                }
            }
            if (x != -1 && y != -1)
                break
        }

        routes.forEach {
            val route = it.split(" ")
            val direction = getDirection(route[0][0])
            var nx = x
            var ny = y

            println("p: $x, $y")
            var isPossible = true
            for (i in 0 until route[1].toInt()) {
                nx += direction.first
                ny += direction.second
                if (nx !in park.indices || ny !in park[0].indices || park[nx][ny] == 'X') {
                    isPossible = false
                    break
                }
            }
            if (isPossible) {
                x = nx
                y = ny
            }
        }

        return intArrayOf(x, y)
    }

    fun getDirection(c: Char): Pair<Int, Int> {
        return when (c) {
            'N' -> Pair(-1, 0)
            'S' -> Pair(1, 0)
            'W' -> Pair(0, -1)
            else -> Pair(0, 1)
        }
    }
}