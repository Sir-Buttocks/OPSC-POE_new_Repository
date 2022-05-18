package gamers.code.digitalcupboard.data.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class Item(

    var primaryKey: Int,
    var name: String,
    var dateAcquired: LocalDate,

    var description: String,

    ):Comparable<Item> {
    lateinit var dateEdited: Date
    override fun compareTo(other: Item): Int {
        if(primaryKey > other.primaryKey) return -1
        if(primaryKey < other.primaryKey) return +1
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (primaryKey != other.primaryKey) return false
        if (name != other.name) return false
        if (dateAcquired != other.dateAcquired) return false
        if (dateEdited != other.dateEdited) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = primaryKey
        result = 31 * result + name.hashCode()
        result = 31 * result + dateAcquired.hashCode()
        result = 31 * result + dateEdited.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}
