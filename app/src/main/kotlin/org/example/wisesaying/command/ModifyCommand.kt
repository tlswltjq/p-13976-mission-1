package org.example.wisesaying.command

import org.example.wisesaying.repository.WiseSayingRepository
import org.example.wisesaying.WiseSaying // WiseSaying 클래스 임포트

class ModifyCommand : Command {
    override val name: String = "수정"

    override fun execute(commandLine: List<String>) {
        if (commandLine.isEmpty()) {
            println("수정할 명언의 ID를 입력해주세요. (예: 수정?id=1)")
            return
        }

        val idString = commandLine.getOrNull(0)
        val id = idString?.toIntOrNull()

        if (id == null) {
            println("명언 ID는 숫자여야 합니다.")
            return
        }

        val existingWiseSaying = WiseSayingRepository.findById(id)

        if (existingWiseSaying == null) {
            println("ID $id 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존): ${existingWiseSaying.content}")
        print("명언 : ")
        val newContent = readLine() ?: ""

        println("작가(기존): ${existingWiseSaying.author}")
        print("작가 : ")
        val newAuthor = readLine() ?: ""

        val updated = WiseSayingRepository.update(id, newAuthor, newContent)

        if (updated) {
            println("ID $id 명언이 수정되었습니다.")
        } else {
            // 이 경우는 findById에서 이미 처리되었으므로, 사실상 여기에 도달하지 않음
            println("ID $id 명언은 존재하지 않습니다.")
        }
    }
}