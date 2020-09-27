package ru.cutepool.egeikt.model

class TextBlock(private val text: String) : BlockTask {
    override fun getBlock(): String {
        return text
    }
}