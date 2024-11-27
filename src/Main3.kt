data class Person(val name: String, val age: Int)

data class Apartment(
    val apartmentNumber: Int,
    val residents: List<Person>,
    val isRented: Boolean
)

class Building(private val apartments: List<Apartment>) {

    fun findResidentsOlderThan(age: Int): List<Person> {
        val result = mutableListOf<Person>()
        for (apartment in apartments) {
            for (resident in apartment.residents) {
                if (resident.age >= age) {
                    result.add(resident)
                }
            }
        }
        return result
    }

    fun findRentedApartments(): List<Apartment> {
        val rented = mutableListOf<Apartment>()
        for (apartment in apartments) {
            if (apartment.isRented) {
                rented.add(apartment)
            }
        }
        return rented
    }
}

fun main() {
    // Створюємо мешканців
    val residents1 = listOf(Person("Іван", 32), Person("Марія", 28))
    val residents2 = listOf(Person("Олександр", 45))
    val residents3 = listOf(Person("Ольга", 37), Person("Андрій", 50))
    val residents4 = listOf(Person("Софія", 22))

    val apartments = listOf(
        Apartment(1, residents1, false), // Не здається
        Apartment(2, residents2, true),  // Здається
        Apartment(3, residents3, false), // Не здається
        Apartment(4, residents4, true)   // Здається
    )

    val building = Building(apartments)

    val ageThreshold = 30
    val olderResidents = building.findResidentsOlderThan(ageThreshold)
    println("Мешканці, яким не менше $ageThreshold років:")
    if (olderResidents.isEmpty()) {
        println("Немає таких мешканців.")
    } else {
        for (resident in olderResidents) {
            println("Ім'я: ${resident.name}, Вік: ${resident.age}")
        }
    }

    println("\nКвартири, що здаються в оренду:")
    val rentedApartments = building.findRentedApartments()
    if (rentedApartments.isEmpty()) {
        println("Немає квартир, що здаються.")
    } else {
        for (apartment in rentedApartments) {
            println("Квартира №${apartment.apartmentNumber}")
        }
    }
}
