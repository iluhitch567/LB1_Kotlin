fun main() {
    val sampleText = """
        Програмування є захопливим, і Kotlin робить його ще кращим. Досліджуйте програмування! 
        Цей текст ілюструє, як часто певні слова зустрічаються у тексті. 
        Наприклад, слово 'програмування' повторюється кілька разів: програмування програмування програмування.
    """.trimIndent()

    val targetChar = 'п'

    val wordsBeginningWithChar = findWordsBeginningWithChar(sampleText, targetChar)
    println("Слова, що починаються на '$targetChar':")
    println(wordsBeginningWithChar)

    val frequencyMap = computeWordFrequency(sampleText)
    println("\nЧастота появи всіх слів у тексті:")
    println(frequencyMap)

    val sortedFrequency = arrangeByFrequency(frequencyMap)
    println("\nСлова у порядку збільшення частоти:")
    println(sortedFrequency)
}

fun findWordsBeginningWithChar(text: String, char: Char): List<String> {
    return text.split(Regex("\\s+"))
        .map { it.trim().lowercase().replace(Regex("[^\\p{L}\\p{Nd}]"), "") }
        .filter { it.startsWith(char) && it.isNotEmpty() }
}

fun computeWordFrequency(text: String): Map<String, Int> {
    return text.split(Regex("\\s+"))
        .map { it.trim().lowercase().replace(Regex("[^\\p{L}\\p{Nd}]"), "") }
        .filter { it.isNotEmpty() }
        .groupingBy { it }.eachCount()
}

fun arrangeByFrequency(wordFrequency: Map<String, Int>): List<Pair<String, Int>> {
    return wordFrequency.entries.sortedBy { it.value }.map { it.toPair() }
}
