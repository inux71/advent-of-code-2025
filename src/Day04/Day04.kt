package Day04

import println
import readInput

fun main() {
    fun countAccessedPaperRolls(
        input: MutableList<StringBuilder>,
        repeat: Boolean
    ): Int {
        var accessedPaperRolls = 0

        input.forEachIndexed { y, line ->
            line.forEachIndexed { x, c ->
                if (c == '@') {
                    var adjacentPaperRolls = 0

                    // top-left
                    if (y > 0 && x > 0 && (input[y - 1][x - 1] == '@' || input[y - 1][x - 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // top
                    if (y > 0 && (input[y - 1][x] == '@' || input[y - 1][x] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // top-right
                    if (y > 0 && x < (line.length - 1) && (input[y - 1][x + 1] == '@' || input[y - 1][x + 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // right
                    if (x < (line.length - 1) && (input[y][x + 1] == '@' || input[y][x + 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // bottom-right
                    if (y < (input.size - 1) && x < (line.length - 1) && (input[y + 1][x + 1] == '@' || input[y + 1][x + 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // bottom
                    if (y < (input.size - 1) && (input[y + 1][x] == '@' || input[y + 1][x] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // bottom-left
                    if (y < (input.size - 1) && x > 0 && (input[y + 1][x - 1] == '@' || input[y + 1][x - 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    // left
                    if (x > 0 && (input[y][x - 1] == '@' || input[y][x - 1] == 'x')) {
                        adjacentPaperRolls++
                    }

                    if (adjacentPaperRolls < 4) {
                        accessedPaperRolls++

                        input[y][x] = 'x'
                    }
                }
            }
        }

        if (repeat) {
            if (accessedPaperRolls == 0) {
                return 0
            } else {
                input.forEach { line ->
                    repeat(times = line.length) { i ->
                        if (line[i] == 'x') {
                            line[i] = '.'
                        }
                    }
                }

                return accessedPaperRolls + countAccessedPaperRolls(
                    input = input,
                    repeat = true
                )
            }
        } else {
            return accessedPaperRolls
        }
    }

    fun part1(input: List<String>): Int {
        val mutableInput = input.map { StringBuilder(it) }
            .toMutableList()

        return countAccessedPaperRolls(
            input = mutableInput,
            repeat = false
        )
    }

    fun part2(input: List<String>): Int {
        val mutableInput = input.map { StringBuilder(it) }
            .toMutableList()

        return countAccessedPaperRolls(
            input = mutableInput,
            repeat = true
        )
    }

    val testInput = readInput("Day04/Day04_test")
    val input = readInput("Day04/Day04")
    part1(testInput).println()
    part1(input).println()

    println("-----")

    part2(testInput).println()
    part2(input).println()
}
