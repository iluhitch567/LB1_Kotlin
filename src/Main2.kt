
fun main() {

    val numbers = listOf(3, 8, 15, 22, 10, 35, 7, 9, 14)

    val firstSequence = numbers.filter { it % 2 == 0 || it > 10 }.toMutableList()

    val secondSequence = numbers.filter { it % 2 != 0 || it % 5 == 0 }.toMutableList()

    if (firstSequence.size < 6) {
        repeat(6 - firstSequence.size) {
            firstSequence.add(firstSequence.getOrNull(2) ?: 0)
        }
    }
    if (secondSequence.size < 6) {
        repeat(6 - secondSequence.size) {
            secondSequence.add(secondSequence.getOrNull(2) ?: 0)
        }
    }

    println("Оригінальна послідовність: $numbers")
    println("Перша послідовність (парні або >10): $firstSequence")
    println("Друга послідовність (непарні або кратні 5): $secondSequence")

}
