package org.example.wisesaying

import org.example.wisesaying.command.*

data class WiseSaying(
    val id: Int,
    val content: String,
    val author: String
)

fun run() {
    println("== 명언 앱 ==")

    var isExit = false

    val commands = mapOf<String, Command>(
        "등록" to RegisterCommand(),
        "종료" to ExitCommand { isExit = true },
        "목록" to ShowListCommand(),
        "삭제" to DeleteCommand(),
    )

    while (!isExit) {
        print("명령) ")
        val input = readLine() ?: ""
        val commandParts = input.split("?", limit = 2)
        val commandName = commandParts[0]
        var commandParams: List<String> = emptyList()
        if (commandParts.size > 1) {
            val queryString = commandParts[1]
            if (!queryString.contains("=")) {
                println("유효하지 않은 명령입니다.")
                continue
            }
            val params = queryString.split("&").associate {
                val (key, value) = it.split("=", limit = 2)
                key to value
            }
            params["id"]?.let { commandParams = listOf(it) }
        }

        val command = commands[commandName]

        if (command != null) {
            command.execute(commandParams)
        } else {
            println("유효하지 않은 명령입니다.")
        }
    }
}