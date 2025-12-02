package Day02

import println
import readInput

fun main() {
    fun part1(input: List<String>): Long {
        val ranges: List<List<String>> = input[0].split(',')
            .map { range -> range.split('-') }
        var sum = 0L

        ranges.forEach { range ->
            val start: Long = range.first()
                .toLong()
            val stop: Long = range.last()
                .toLong()

            val numbers: List<String> = (start until (stop + 1)).map { it.toString() }

            numbers.forEach { number ->
                val substring: String = number.take(number.length / 2)
                val count: Int = Regex(substring).findAll(number)
                    .count()

                if (count == 2 && count * substring.length == number.length) {
                    sum += number.toLong()
                }
            }
        }

        return sum
    }

    fun part2(input: List<String>): Long {
        val ranges: List<List<String>> = input[0].split(',')
            .map { range -> range.split('-') }
        var sum = 0L

        ranges.forEach { range ->
            val start: Long = range.first()
                .toLong()
            val stop: Long = range.last()
                .toLong()

            val numbers: List<String> = (start until (stop + 1)).map { it.toString() }

            numbers.forEach { number ->
                for (i in number.length / 2 downTo 1) {
                    val substring: String = number.take(i)
                    val count: Int = Regex(substring).findAll(number)
                        .count()

                    if (count >= 2 && count * substring.length == number.length) {
                        sum += number.toLong()

                        break
                    }
                }
            }
        }

        return sum
    }

    val testInput = readInput("Day02/Day02_test")
    val input = readInput("Day02/Day02")
    part1(testInput).println()
    part1(input).println()

    part2(testInput).println()
    part2(input).println()
}
