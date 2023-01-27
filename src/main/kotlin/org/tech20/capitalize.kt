package org.tech20

fun main() {
    println(capitalize("This is a sentence where each word Should start with a capital letter."))
}

fun t(word:String):String = word.replaceFirstChar { it.uppercaseChar() }

fun capitalize(str: String): String{
    return str.split(" ")
        .joinToString(" "){t(it)}
}