fun main() {
    fun part1(input: List<String>): Int {
        var dial = 50
        var dial0Counter = 0

        input.forEach { line ->
            val number: Int = (line.substring(startIndex = 1)
                .toInt())

            when (line[0]) {
                'L' -> dial -= number
                'R' -> dial += number
            }

            dial %= 100

            if (dial == 0) {
                dial0Counter++
            }
        }

        return dial0Counter
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(testInput).println()
    part1(input).println()
}
