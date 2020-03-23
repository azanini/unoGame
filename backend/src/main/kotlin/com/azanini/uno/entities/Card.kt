package com.azanini.uno.entities

import com.azanini.uno.dto.CardDto
import javax.persistence.*

@Entity
class Card(@field:Enumerated(EnumType.STRING) val cardType: CardType, @field:Enumerated(EnumType.STRING) val number: CardNumber = CardNumber.ZERO, @field:Enumerated(EnumType.STRING) val color: Color) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun toDto(): CardDto {
        return CardDto(this.id, cardType, number, color)
    }
}

enum class CardType {
    COMMON, REVERT, SKIP, CHANGE_COLOR, DRAW_2, DRAW_4
}

enum class Color(val rgbColor: String) {
    GREEN("55AA55"),
    YELLOW("FFAA00"),
    RED("FF5555"),
    BLUE("5555FF")
}

enum class CardNumber {
    ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}