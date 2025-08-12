package org.example.wisesaying.command

class ExitCommand(private val onExit: () -> Unit) : Command {
    override val name: String = "종료"

    override fun execute(params: List<String>) {
        println("명언 앱을 종료합니다.")
        onExit()
    }
}