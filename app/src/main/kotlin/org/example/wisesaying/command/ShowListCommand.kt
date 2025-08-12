package org.example.wisesaying.command

import org.example.wisesaying.repository.WiseSayingRepository

class ShowListCommand : Command {
    override val name: String = "목록"

    override fun execute(params: List<String>) {
        println("번호 / 작가 / 명언")
        println("-----------------------")
        WiseSayingRepository.getAll().forEach { wiseSaying ->
            println("${wiseSaying.id} / ${wiseSaying.author} / \"${wiseSaying.content}\"")
        }Q
    }
}