package dev.fake.aoc.day04

import _04_realInputs

fun main() {
    val ipt = _04_realInputs
    val lines = ipt.split('\n')
    var count = 0
    count += horizontal(lines)
    count += vertical(lines)
    count += grave(lines)
    count += aigu(lines)
    println(count)
}

fun horizontal(lines : List<String>) : Int {
    var count = 0
    for (line in lines) {
        count += Regex("XMAS").findAll(line).count()
        count += Regex("SAMX").findAll(line).count()
    }
    return count
}

fun vertical(lines : List<String>) : Int {
    var columns : MutableList<String> = mutableListOf()
    for (i in 0..lines[0].length-1) { columns.add("") }
    for (line in lines) {
        for (ci in line.toCharArray().indices) {
            columns[ci] += line[ci]
        }
    }
    return horizontal(columns)
}

fun grave(lines : List<String>) : Int {
    var diagonals : MutableList<String> = mutableListOf()
    val lineLength = lines[0].length
    var blank = ""
    for (i in 1..lineLength) { blank += " " }
    for (i in 0..lineLength + lines.size - 1) { diagonals.add(blank) }
    val center = (lineLength + lines.size - 1) / 2
    for ((i, line) in lines.withIndex()) {
        for ((j, c) in line.toCharArray().withIndex()) {
            var diagonal = diagonals[center + i - j]
            diagonal = diagonal.substring(0, j) + c + diagonal.substring(j + 1)
            diagonals[center + i - j] = diagonal
        }
    }
    return horizontal(diagonals)
}

fun aigu(lines : List<String>) : Int {
    return grave(lines.reversed())
}
