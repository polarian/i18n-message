package io.polarian.message

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import java.util.Locale


@SpringBootApplication
class MessageApplication(val messageSource: MessageSource) {

    @Value("\${spring.messages.locale}")
    private lateinit var locale: String

    @Bean
    fun init() = CommandLineRunner {
        println(messageSource.getMessage("00001", null, Locale(locale)) + " " + messageSource.getMessage("00001", null, Locale.getDefault()))
        println(messageSource.getMessage("10002", null, Locale(locale)) + " " + messageSource.getMessage("10002", null, Locale.getDefault()))
    }
}

fun main(args: Array<String>) {
    runApplication<MessageApplication>(*args)
}
