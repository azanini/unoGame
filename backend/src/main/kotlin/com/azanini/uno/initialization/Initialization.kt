package com.azanini.uno.initialization

import com.azanini.uno.entities.Card
import com.azanini.uno.entities.CardNumber
import com.azanini.uno.entities.CardType
import com.azanini.uno.entities.Color
import com.azanini.uno.services.CardService
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CardInitialization(@field:Autowired val cardService: CardService) : InitializingBean {

    override fun afterPropertiesSet() {
        cardService.deleteAll()
        Color.values().toList().forEach { color ->
            // Zero has to be instantiated only 1 time
            cardService.save(Card(CardType.COMMON, CardNumber.ZERO, color))
            // The rest, 2 times
            CardNumber.values().toList().filter { number -> CardNumber.ZERO != number }.forEach { number ->
                cardService.save(Card(CardType.COMMON, number, color))
                cardService.save(Card(CardType.COMMON, number, color))
            }
        }

    }

}