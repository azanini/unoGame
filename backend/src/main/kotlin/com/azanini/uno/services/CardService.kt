package com.azanini.uno.services

import com.azanini.uno.entities.Card
import com.azanini.uno.repositories.CardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

abstract class BaseEntityService<ENTITY, ID_TYPE>(private val repository: CrudRepository<ENTITY, ID_TYPE>) {

    fun save(entity: ENTITY): ENTITY {
        return repository.save(entity)
    }

    fun delete(entity: ENTITY) {
        repository.delete(entity)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun getById(entityId: ID_TYPE): ENTITY? {
        val optional = repository.findById(entityId)
        return if (optional.isPresent) optional.get() else null
    }

    fun getAll(): List<ENTITY> {
        return repository.findAll().toList()
    }

}

@Service
class CardService(cardRepository: CardRepository) : BaseEntityService<Card, Long>(cardRepository) {


}