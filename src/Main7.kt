package ex7

interface Candidate {
    val fullName: String
    val jobTitle: String
    fun applyFor(position: Position): Boolean
}

class Individual(override val fullName: String, override val jobTitle: String) : Candidate {
    override fun applyFor(position: Position): Boolean {
        return jobTitle.equals(position.requiredTitle, ignoreCase = true)
    }

    override fun toString(): String {
        return "Ім'я: $fullName, Професія: $jobTitle"
    }
}

data class Position(val requiredTitle: String, val compensation: Double, var isOpen: Boolean = true)

class JobAgency {
    private val positions = mutableListOf<Position>()
    private val candidates = mutableListOf<Candidate>()

    fun addPosition(position: Position) {
        positions.add(position)
        println("Додано вакансію: $position")
    }

    fun addCandidate(candidate: Candidate) {
        candidates.add(candidate)
        println("Додано шукача роботи: $candidate")
    }

    fun displayOpenPositions() {
        println("Доступні вакансії:")
        positions.filter { it.isOpen }.forEach { println(it) }
    }

    fun matchCandidates() {
        for (candidate in candidates) {
            val matchedPosition = positions.find { it.isOpen && candidate.applyFor(it) }
            if (matchedPosition != null) {
                println("${candidate.fullName} отримує роботу: ${matchedPosition.requiredTitle} з зарплатою ${matchedPosition.compensation}")
                matchedPosition.isOpen = false
            } else {
                println("${candidate.fullName} не знайдено відповідної вакансії.")
            }
        }
    }
}

fun main() {
    val agency = JobAgency()
    val position1 = Position("Розробник", 1500.0)
    val position2 = Position("Художник", 1200.0)
    val position3 = Position("Технік", 1800.0)

    agency.addPosition(position1)
    agency.addPosition(position2)
    agency.addPosition(position3)

    val individual1 = Individual("Анна", "Розробник")
    val individual2 = Individual("Сергій", "Художник")
    val individual3 = Individual("Олег", "Лікар")

    agency.addCandidate(individual1)
    agency.addCandidate(individual2)
    agency.addCandidate(individual3)

    agency.displayOpenPositions()

    agency.matchCandidates()
}