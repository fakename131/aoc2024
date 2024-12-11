package dev.fake.aoc.day03

import _03_realInputs
import kotlin.text.Regex

fun main() {
    val dos = _03_realInputs.split("do()")
    var count = 0
    for (doo in dos) {
        count += subCount(doo.split("don't()").first())
    }
    println(count)
}

fun subCount(input: String) : Int {
    val regex = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)")
    var count = 0
    regex.findAll(input).forEach { result ->
        with (result.value) {
            with (substring(4, length - 1).split(',').map { s -> s.toInt() }.toIntArray()) {
                count += get(0) * get(1)
            }

        }
    }
    return count
}
