package com.azanini.uno.dto

import com.azanini.uno.entities.CardNumber
import com.azanini.uno.entities.CardType
import com.azanini.uno.entities.Color

data class CardDto(val id: Long?, val cardType: CardType, val number: CardNumber = CardNumber.ZERO, val color: Color) {

}