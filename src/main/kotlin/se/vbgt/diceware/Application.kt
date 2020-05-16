package se.vbgt.diceware

fun main() {

    val wordRoll = List(5){ Dice.rollDice() }
    val mappedWord = DiceWareUtil.mapWords(wordRoll)
    println(mappedWord)

    val wordRolls = Array(3) { run { List(5) { Dice.rollDice() } } }
    val mappedWords = DiceWareUtil.mapWords(*wordRolls)
    mappedWords.forEach { println(it) }
}