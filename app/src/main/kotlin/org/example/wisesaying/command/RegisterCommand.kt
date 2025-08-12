package org.example.wisesaying.command

import org.example.wisesaying.repository.WiseSayingRepository

class RegisterCommand : Command {
    override val name: String = "등록"

    override fun execute(params: List<String>) {
        print("명언 : ")
        val content = readLine() ?: ""
        print("작가 : ")
        val author = readLine() ?: ""

        val newWiseSaying = WiseSayingRepository.add(content, author)
        println("${newWiseSaying.id}번 명언이 등록되었습니다.")
    }
}


