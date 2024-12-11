package dev.fake.aoc.day02

import _02_realInputs
import kotlin.math.abs
import kotlin.math.sign

fun main() {
    val reports = _02_realInputs.split('\n')
    var count = 0
    rpt@ for (report in reports) {
        val levels : IntArray = report.split(' ').stream().mapToInt { s -> s.toInt() }.toArray()
        if (checkReport(levels)) {
            count++
            continue
        }
        for (i in levels.indices) {
            if (checkReport(levels.clone().copyOfRange(0,i) + levels.clone().copyOfRange(i + 1, levels.size))) {
                count++
                continue@rpt
            }
        }
    }
    println(count)
}

fun checkReport(levels : IntArray) : Boolean {
    val dir = (levels[1] - levels[0]).sign
    for (i in levels.indices) {
        if (i == 0) continue
        val diff = levels[i] - levels[i-1]
        if (diff.sign != dir) return false
        if (diff == 0) return false
        if (abs(diff) > 3) return false
    }
    return true
}