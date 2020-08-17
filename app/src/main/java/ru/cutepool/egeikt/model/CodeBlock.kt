package ru.cutepool.egeikt.model

class CodeBlock(private val code: List<String>) : BlockTask {

    override fun getBlock(): List<String> {
        return code
    }
}