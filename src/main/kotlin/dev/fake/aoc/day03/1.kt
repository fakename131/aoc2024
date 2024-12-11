package dev.fake.aoc.day03

import _03_realInputs
import kotlin.text.Regex

fun main() {
    val regex = Regex("mul\\([0-9]{1,3},[0-9]{1,3}\\)")
    var count = 0;
    regex.findAll(_03_realInputs).forEach { result ->
        with (result.value) {
            with (substring(4, length - 1).split(',').map { s -> s.toInt() }.toIntArray()) {
                count += get(0) * get(1)
            }

        }
    }
    println(count)
}

