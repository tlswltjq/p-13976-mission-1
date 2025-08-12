package org.example.wisesaying

import org.example.wisesaying.command.Command
import org.example.wisesaying.command.RegisterCommand
import org.example.wisesaying.command.ExitCommand
import org.example.wisesaying.command.ShowListCommand

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
        "목록" to ShowListCommand()
    )

    while (!isExit) {
        print("명령) ")
        val input = readLine() ?: ""
        val parts = input.split(" ")
        val commandName = parts[0]
        val commandParams = parts.drop(1)

        val command = commands[commandName]

        if (command != null) {
            command.execute(commandParams)
        } else {
            println("유효하지 않은 명령입니다.")
        }
    }
}