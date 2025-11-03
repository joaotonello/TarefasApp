package com.example.tarefas.data

import android.content.Context
import kotlinx.coroutines.flow.Flow

class TarefaRepository(context: Context) {
    private val dao = AppDatabase.get(context).tarefaDao()

    fun observarTodas(): Flow<List<Tarefa>> = dao.observarTodas()
    fun buscar(query: String): Flow<List<Tarefa>> = dao.buscar("%$query%")
    suspend fun inserir(t: Tarefa) = dao.inserir(t)
    suspend fun atualizar(t: Tarefa) = dao.atualizar(t)
    suspend fun deletar(t: Tarefa) = dao.deletar(t)
}