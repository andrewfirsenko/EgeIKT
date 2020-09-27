package ru.cutepool.egeikt.model

data class Task(
    val id: Int,
    val number: Int,
    val body: List<BlockTask>,
    val answer: List<BlockTask>
)