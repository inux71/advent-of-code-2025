package Day05

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val blankIndex: Int = input.indexOf("")
        val ranges: List<List<Long>> = input.subList(
            fromIndex = 0,
            toIndex = blankIndex
        ).map { range -> range.split('-')
            .map { it.toLong() }
        }
        val ids: List<Long> = input.subList(
            fromIndex = blankIndex + 1,
            toIndex = input.size
        ).map { it.toLong() }

        var freshIngredients = 0

        ids.forEach { id ->
            for (range in ranges) {
                if (range.first() <= id && id <= range.last()) {
                    freshIngredients++

                    break
                }
            }
        }

        return freshIngredients
    }

    fun part2(input: List<String>): Long {
        val blankIndex: Int = input.indexOf("")
        val ranges: List<MutableList<Long>> = input.subList(
            fromIndex = 0,
            toIndex = blankIndex
        ).map { range -> range.split('-')
            .map { it.toLong() }
            .toMutableList()
        }.sortedBy { it.first() }

        val mergedRanges: MutableList<MutableList<Long>> = mutableListOf()

        ranges.forEach { range ->
            if (mergedRanges.isEmpty()) {
                mergedRanges.add(range)
            } else {
                if (mergedRanges.last().last() < range.first()) {
                    mergedRanges.add(range)
                } else {
                    mergedRanges.last()[1] = maxOf(
                        a = mergedRanges.last()[1],
                        b = range.last()
                    )
                }
            }
        }

        return mergedRanges.sumOf { range -> range.last() - range.first() + 1 }
    }

    val testInput = readInput("Day05/Day05_test")
    val input = readInput("Day05/Day05")

    part1(testInput).println()
    part1(input).println()

    println("-----")

    part2(testInput).println()
    part2(input).println()
}
