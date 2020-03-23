package com.azanini.uno.controllers

import com.azanini.uno.dto.CardDto
import com.azanini.uno.services.CardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardController(@field:Autowired val cardService: CardService) {

    @GetMapping
    fun postUser(): ResponseEntity<List<CardDto>> {
        val cardList = cardService.getAll().map { x -> x.toDto() }.toList()
        return ResponseEntity(cardList, HttpStatus.OK)
    }
}