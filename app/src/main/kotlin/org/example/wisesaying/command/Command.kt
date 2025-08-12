package org.example.wisesaying.command

interface Command {
    val name: String
    fun execute(params: List<String>)
}