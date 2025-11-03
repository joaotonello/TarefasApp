package com.example.tarefas.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TarefaDao {
    @Query("SELECT * FROM tarefas ORDER BY concluida ASC, prioridade DESC, criadoEm DESC")
    fun observarTodas(): Flow<List<Tarefa>>

    @Query("SELECT * FROM tarefas WHERE titulo LIKE :q OR descricao LIKE :q ORDER BY concluida ASC, prioridade DESC, criadoEm DESC")
    fun buscar(q: String): Flow<List<Tarefa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(tarefa: Tarefa): Long

    @Update
    suspend fun atualizar(tarefa: Tarefa)

    @Delete
    suspend fun deletar(tarefa: Tarefa)
}