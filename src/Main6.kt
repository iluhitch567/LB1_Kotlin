fun validateCard(cardNumber: String): Boolean {
    val digits = cardNumber.map { it.toString().toInt() }
    val checksum = digits.reversed().mapIndexed { index, digit ->
        if (index % 2 == 1) {
            val doubled = digit * 2
            if (doubled > 9) doubled - 9 else doubled
        } else {
            digit
        }
    }.sum()

    return checksum % 10 == 0
}


fun main() {
    println("Введіть 16-значний номер банківської картки:")
    val cardInput = readLine()

    if (cardInput != null && cardInput.length == 16 && cardInput.all { it.isDigit() }) {
        val isCardValid = validateCard(cardInput)
        if (isCardValid) {
            println("Картка валідна.")
        } else {
            println("Картка невалідна.")
        }
    } else {
        println("Будь ласка, введіть коректний 16-значний номер картки.")
    }
}

