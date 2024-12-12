package dev.fake.aoc.day04

import _04_realInputs

fun main() {
    val ipt = _04_realInputs
    val lines = ipt.split('\n')
    var count = 0
    for (y in 0..lines.size - 3) {
        for (x in 0..lines[0].length - 3) {
            val square = arrayOf(
                lines[y].substring(x, x + 3),
                lines[y + 1].substring(x, x + 3),
                lines[y + 2].substring(x, x + 3)
            ).joinToString("\n")
            println(square)
            if (isValid(square)) count++
            println()
        }
    }
    println(count)
}

fun isValid(square : String) : Boolean {
    var count = 0
    val grave = "${square[0]}${square[5]}${square[10]}"
    val aigu = "${square[8]}${square[5]}${square[2]}"
    if (grave == "MAS") count++
    if (grave == "SAM") count++
    if (aigu == "MAS") count++
    if (aigu == "SAM") count++
    return count == 2
}