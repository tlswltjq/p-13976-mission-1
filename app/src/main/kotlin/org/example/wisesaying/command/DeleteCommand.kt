package org.example.wisesaying.command

import org.example.wisesaying.repository.WiseSayingRepository

class DeleteCommand : Command {
    override val name: String = "삭제"

    override fun execute(commandLine: List<String>) {
        if (commandLine.isEmpty()) {
            println("삭제할 명언의 ID를 입력해주세요.")
            return
        }

        val id = commandLine.get(0).toIntOrNull()
        if (id == null) {
            println("유효하지 않은 ID입니다.")
            return
        }

        if (WiseSayingRepository.delete(id)) {
            println("ID $id 명언이 삭제되었습니다.")
        } else {
            println("ID $id 명언은 존재하지 않습니다..")
        }
    }
}