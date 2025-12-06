package Day06

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val numbers: List<List<Long>> = input.dropLast(n = 1)
            .map { line ->
                line.split(" ")
                    .filter { it.isNotBlank() }
                    .map { it.toLong() }
            }

        val transposed: List<List<Long>> = numbers[0].indices
            .map { column ->
                numbers.map { row -> row[column] }
            }

        val operators: List<String> = input.last()
            .split(" ")
            .filter { it.isNotBlank() }

        return transposed.mapIndexed { index, numbers ->
            if (operators[index] == "+") {
                numbers.sum()
            } else {
                numbers.reduce { acc, lng -> acc * lng }
            }
        }.sum()
    }

    fun part2(input: List<String>): Long {
        val operators: List<String> = input.last()
            .split(" ")
            .filter { it.isNotBlank() }

        val numbers: List<String> = input.dropLast(n = 1)
        val preparedNumbers: List<String> = numbers.map { n -> n.padEnd(length = numbers.maxOf { it.length }, padChar = ' ') }

        val columnNumbers: MutableList<List<Long>> = mutableListOf()
        val chunk: MutableList<Long> = mutableListOf()

        repeat(times = preparedNumbers[0].length) { index ->
            var number = ""

            for (i in 0 until preparedNumbers.size) {
                number += preparedNumbers[i][index]
            }

            number = number.trim()

            if (number == "") {
                columnNumbers.add(chunk.toList())

                chunk.clear()
            } else {
                chunk.add(number.toLong())
            }
        }

        columnNumbers.add(chunk.toList())

        return columnNumbers.mapIndexed { index, numbers ->
            if (operators[index] == "+") {
                numbers.sum()
            } else {
                numbers.reduce { acc, lng -> acc * lng }
            }
        }.sum()
    }

    val testInput = readInput("Day06/Day06_test")
    val input = readInput("Day06/Day06")

    part1(testInput).println()
    part1(input).println()

    println("-----")

    part2(testInput).println()
    part2(input).println()
}
