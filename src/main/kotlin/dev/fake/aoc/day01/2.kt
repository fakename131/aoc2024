package dev.fake.aoc.day01

import _01_realInputs

fun main() {
    val lines = _01_realInputs.split('\n');
    var l = IntArray(lines.size) { 0 }
    var r = IntArray(lines.size) { 0 }
    lines.forEachIndexed { i, line ->
        l[i] = line.split(" ").first().toInt()
        r[i] = line.split(" ").last().toInt()
    }
    var count = 0;
    for (i in lines.indices) {
        count += l[i] * r.count { id -> id == l[i] }
    }
    println(count)
}