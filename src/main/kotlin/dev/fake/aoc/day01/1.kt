package dev.fake.aoc.day01

import _01_realInputs
import kotlin.math.abs

fun main() {
    val lines = _01_realInputs.split('\n')
    var l = IntArray(lines.size) { 0 }
    var r = IntArray(lines.size) { 0 }
    lines.forEachIndexed { i, line ->
        l[i] = line.split(" ").first().toInt()
        r[i] = line.split(" ").last().toInt()
    }
    l.sort()
    r.sort()
    var count = 0
    for (i in lines.indices) {
        count += abs(l[i] - r[i])
    }
    println(count)
}