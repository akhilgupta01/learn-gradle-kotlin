package org.tech20

fun main() {
    println(findOddNumbers(listOf(3,6,7,8,55,67)))
}

fun findOddNumbers(numbers: List<Int>): List<Int>{
    return numbers.filter { it % 2 != 0 }
}