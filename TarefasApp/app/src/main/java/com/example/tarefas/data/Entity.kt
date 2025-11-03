package com.example.tarefas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Categoria { Trabalho, Estudo, Pessoal, Outros }
enum class Prioridade { Alta, Media, Baixa }

@Entity(tableName = "tarefas")
data class Tarefa(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val titulo: String,
    val descricao: String = "",
    val categoria: Categoria = Categoria.Outros,
    val prioridade: Prioridade = Prioridade.Media,
    val concluida: Boolean = false,
    val criadoEm: Long = System.currentTimeMillis()
)