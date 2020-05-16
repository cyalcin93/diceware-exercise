package se.vbgt.diceware

import java.io.File

object DiceWareUtil {

    fun mapWords(vararg wordRoll: List<Int>): Map<List<Int>, String> {
        require(wordRoll.isNotEmpty())
        wordRoll.forEach { require(it.size == 5) }

        // värt att filtrera ut med först? \d{5}\t.+
        val map = mutableMapOf<List<Int>, String>()
        wordRoll.forEach {
            val number = it.joinToString("")
            File("src/main/resources/se/vbgt/diceware/diceware.wordlist.asc").forEachLine { line ->
                if(line.matches("${number}\\t.+".toRegex())) {
                    map[it] = line.replace("${number}\\t".toRegex(), "")
                }
            }
        }

        return map
    }

    fun randomLetter(horizontalDice: Int, verticalDice: Int): Char =
        arrayOf (
            arrayOf('~', '!', '#', '$', '%', '^'),
            arrayOf('&', '*', '(', ')', '-', '='),
            arrayOf('+', '[', ']', '\\', '{', '}'),
            arrayOf(':', ';', '"', '\'', '<', '>'),
            arrayOf('?', '/', '0', '1', '2', '3'),
            arrayOf('4', '5', '6', '7', '8', '9')
        )[verticalDice - 1][horizontalDice - 1]
}
