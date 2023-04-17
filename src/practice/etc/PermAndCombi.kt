package practice.etc

private class PermAndCombi {
    fun main() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val r = 3
        println("--- 조합 ---")
        noDupCombi(arr, r)
        println("\n\n--- 중복 조합 ---")
        dupCombi(arr, r)
        println("\n\n--- 순열 ---")
        noDupPerm(arr, r)
        println("\n\n--- 중복순열 ---")
        dupPerm(arr, r)
    }

    fun noDupCombi(arr: IntArray, r: Int, idx: Int = 0, temp: ArrayList<Int> = ArrayList(),
                   visited: BooleanArray = BooleanArray(arr.size)) {
        if (temp.size == r) {
            println("[${temp.joinToString(", ")}]")
            return
        }

        for (i in idx..arr.lastIndex) {
            if (!visited[i]) {
                visited[i] = true
                temp.add(arr[i])
                noDupCombi(arr, r, i + 1, temp, visited)
                temp.removeLast()
                visited[i] = false
            }
        }
    }

    fun dupCombi(arr: IntArray, r: Int, idx: Int = 0, temp: ArrayList<Int> = ArrayList()) {
        if (temp.size == r) {
            println("[${temp.joinToString(", ")}]")
            return
        }

        for (i in idx..arr.lastIndex) {
            temp.add(arr[i])
            dupCombi(arr, r, i, temp)
            temp.removeLast()
        }
    }

    fun noDupPerm(arr: IntArray, r: Int, temp: ArrayList<Int> = ArrayList(), visited: BooleanArray = BooleanArray(arr.size)) {
        if (temp.size == r) {
            println("[${temp.joinToString(", ")}]")
            return
        }

        for (i in arr.indices) {
            if (!visited[i]) {
                visited[i] = true
                temp.add(arr[i])
                noDupPerm(arr, r, temp, visited)
                temp.removeLast()
                visited[i] = false
            }
        }
    }

    fun dupPerm(arr: IntArray, r: Int, temp: ArrayList<Int> = ArrayList()) {
        if (temp.size == r) {
            println("[${temp.joinToString(", ")}]")
            return
        }

        for (i in arr.indices) {
            temp.add(arr[i])
            dupPerm(arr, r, temp)
            temp.removeLast()
        }
    }
}