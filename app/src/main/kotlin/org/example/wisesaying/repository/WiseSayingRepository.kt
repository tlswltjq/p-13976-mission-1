package org.example.wisesaying.repository

import org.example.wisesaying.WiseSaying

object WiseSayingRepository {
    private val wiseSayings = mutableListOf<WiseSaying>()
    private var nextId = 1

    fun add(content: String, author: String): WiseSaying {
        val wiseSaying = WiseSaying(nextId++, content, author)
        wiseSayings.add(wiseSaying)
        return wiseSaying
    }

    fun getAll(): List<WiseSaying> {
        return wiseSayings.toList()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }

    fun delete(id: Int): Boolean {
        return wiseSayings.removeIf { it.id == id }
    }

    fun update(id: Int, newAuthor: String?, newContent: String?): Boolean {
        val wiseSaying = findById(id)
        return wiseSaying?.let {
            if (newAuthor != null) {
                it.author = newAuthor
            }
            if (newContent != null) {
                it.content = newContent
            }
            true
        } ?: false
    }
}