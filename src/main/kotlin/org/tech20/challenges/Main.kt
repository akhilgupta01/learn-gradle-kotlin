package org.tech20.challenges

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum(x: Int, y: Int) = x + y                                     // 3

fun sum(x: Int, vp: () -> Int) = x + vp()

fun reverse(str: String): String = str.reversed()

val uppercase1: (String) -> String = {str: String -> str.uppercase()}
val uppercase2: (String) -> String = {str -> str.uppercase()}
val uppercase3 = { str: String -> str.uppercase() }
val uppercase4: (String) -> String = {it.uppercase()}
val uppercase5: (String) -> String = ::reverse

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    val sum1 = sum(1) { 2 }
    println("sumResult $sumResult, mulResult $mulResult")
    val numbers = listOf(1, 4, 6 ,7,10)
}