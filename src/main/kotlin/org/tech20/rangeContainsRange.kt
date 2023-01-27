package org.tech20

fun main() {
    println(containsRange(5..7, 5..7)) // true)
    println(containsRange(1..12, 5..7))// true
    println(containsRange(5..8, 5..9)) // false

    //addUpTo
    println(addUpTo(3))

    println(getIndex(listOf("A", "B", "C"), "D"))

    println(countDown(4))

    println(countUpAndDown(2))

    formatTrainRoute(listOf("Luton")) // "Train is calling at Luton"
    formatTrainRoute(listOf("Luton", "Harpenden")) // "Train is calling at Luton and Harpenden"
    formatTrainRoute(listOf("Luton", "Harpenden", "London")) // "Train is calling at Luton, Harpenden and London"

    println(getAllPairs(2))

    println(countUniqueValues(arrayOf(-2, -1, -1, 0, 1)))

    println(printNumber(5))
    println(printNumber(0))
}

fun printNumber(n: Int): List<Int> {
    return when(n){
        0 -> emptyList()
        else -> (n downTo 1).toList()
    }
}

fun countUniqueValues(values: Array<Int>): Int {
    return values.toSet().size
}

fun getAllPairs(n: Int): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in 0..n)
        for (j in 0..n){
            pairs.add(Pair(i,j))
        }
    return pairs
}

fun formatTrainRoute(stationList: List<String>):String {
    var res = ""
    stationList.forEach {
        res += when(it){
            stationList.first() -> it
            stationList.last() -> " and $it"
            else -> ", $it"
        }
    }
    println("Train is calling at $res")
    return "Train is calling at $res"
}



fun containsRange(range1: IntRange, range2: IntRange): Boolean {
    return range2.first >= range1.first && range2.last <= range1.last
}

fun addUpTo(n: Int): Int{
    val numbers = mutableListOf<Int>()
    for (i in 1..n){
        numbers.add(i)
    }
    return numbers.sum()
}

fun getIndex(strList: List<String>, str: String): Int{
    strList.forEachIndexed { index, s -> if(s == str) return index }
    return -1
}

fun countDown(n:Int):List<Int>{
    val list = mutableListOf<Int>()
    for (i in n downTo 0){
        list.add(i)
    }
    return list
}

fun countUpAndDown(n:Int):List<Int>{
    return (0 until n).toList() + (n downTo 0).toList()
}

