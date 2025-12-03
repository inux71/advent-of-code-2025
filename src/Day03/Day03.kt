package Day03

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0

        input.forEach { line ->
            val (index, value) = line.withIndex()
                .maxBy { it.value }

            if (index == line.length - 1) {
                val substring: String = line.take(index)
                val secondLargestDigit: Char = substring.max()
                val number: Int = "$secondLargestDigit$value".toInt()

                sum += number
            } else {
                val substring: String = line.substring(startIndex = index + 1)
                val secondLargestDigit: Char = substring.max()
                val number: Int = "$value$secondLargestDigit".toInt()

                sum += number
            }
        }

        return sum
    }

    // doesn't work
    fun part2(input: List<String>): Long {
        val mutableInput = input.map { StringBuilder(it) }
            .toMutableList()

        var sum = 0L

        mutableInput.forEachIndexed { index, line ->
            val largestDigitIndices = mutableListOf<Int>()

            repeat(times = 12) {
                val largestDigitIndex: Int = line.lastIndexOf(line.max()) // this is wrong

                mutableInput[index][largestDigitIndex] = '0'

                largestDigitIndices.add(largestDigitIndex)
            }

            val number: Long = largestDigitIndices.sorted()
                .map { i -> input[index][i] }
                .joinToString(separator = "")
                .toLong()

            sum += number
        }

        return sum
    }

    val testInput = readInput("Day03/Day03_test")
    val input = readInput("Day03/Day03")
    part1(testInput).println()
    part1(input).println()

    println("-----")

    part2(testInput).println()
    part2(input).println()
}