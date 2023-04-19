package com.example.petclinicdocuments.transport.service

import com.example.petclinicdocuments.transport.dto.OwnerDto
import com.example.petclinicdocuments.transport.dto.PetDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class ConsumerService {
    val mapper = jacksonObjectMapper()
    @KafkaListener(topics = ["owners"], groupId = "message_group_id")
    fun consumeOwner(ownerJson: String/*ownerDto: OwnerDto*/) {
        val ownerDto = mapper.readValue<OwnerDto>(ownerJson)
        println("ownerDto.fullName: ${ownerDto.fullName}")
        println("ownerDto.address: ${ownerDto.address}")
        println("ownerDto.birthday: ${ownerDto.birthday}")
        println("ownerDto.gender: ${ownerDto.gender}")
        println("ownerDto.phone: ${ownerDto.phone}")
        println("Consuming the message: $ownerJson")
    }
    @KafkaListener(topics = ["pets"], groupId = "message_group_id")
    fun consumePet(petJson: String/*ownerDto: OwnerDto*/) {
        val petDto = mapper.readValue<PetDto>(petJson)
        println("Consuming the message: $petDto")
    }
    @KafkaListener(topics = ["services"], groupId = "message_group_id")
    fun consumeService(serviceJson: String/*ownerDto: OwnerDto*/) {
        val serviceDto = mapper.readValue<PetDto>(serviceJson)
        println("Consuming the message: $serviceDto")
    }
    @KafkaListener(topics = ["vets"], groupId = "message_group_id")
    fun consumeVet(vetJson: String/*ownerDto: OwnerDto*/) {
        val vetDto = mapper.readValue<PetDto>(vetJson)
        println("Consuming the message: $vetDto")
    }
}