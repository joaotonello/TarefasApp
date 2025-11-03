package com.example.tarefas.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarefas.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class Filtros(
    val query: String = "",
    val categorias: Set<Categoria> = emptySet(),
    val prioridades: Set<Prioridade> = emptySet(),
    val mostrarConcluidas: Boolean = true
)

class TarefaViewModel(app: Application) : AndroidViewModel(app) {

    private val repo = TarefaRepository(app)

    private val filtros = MutableStateFlow(Filtros())
    private val fonte = MutableStateFlow<List<Tarefa>>(emptyList())

    val estado: StateFlow<List<Tarefa>> =
        combine(filtros, fonte) { f, base ->
            base.filter { t ->
                (f.mostrarConcluidas || !t.concluida) &&
                        (f.categorias.isEmpty() || t.categoria in f.categorias) &&
                        (f.prioridades.isEmpty() || t.prioridade in f.prioridades) &&
                        (f.query.isBlank() || t.titulo.contains(f.query, true) || t.descricao.contains(f.query, true))
            }.sortedWith(
                compareBy<Tarefa> { it.concluida }
                    .thenByDescending { it.prioridade }
                    .thenByDescending { it.criadoEm }
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            repo.observarTodas().collect { lista ->
                fonte.value = lista
            }
        }
    }

    fun setQuery(q: String) { filtros.value = filtros.value.copy(query = q) }
    fun toggleCategoria(c: Categoria) {
        val set = filtros.value.categorias.toMutableSet()
        if (!set.add(c)) set.remove(c)
        filtros.value = filtros.value.copy(categorias = set)
    }
    fun togglePrioridade(p: Prioridade) {
        val set = filtros.value.prioridades.toMutableSet()
        if (!set.add(p)) set.remove(p)
        filtros.value = filtros.value.copy(prioridades = set)
    }
    fun setMostrarConcluidas(v: Boolean) { filtros.value = filtros.value.copy(mostrarConcluidas = v) }

    fun salvar(t: Tarefa) = viewModelScope.launch {
        if (t.id == 0L) repo.inserir(t) else repo.atualizar(t)
    }
    fun deletar(t: Tarefa) = viewModelScope.launch { repo.deletar(t) }
    fun marcarConcluida(t: Tarefa, done: Boolean) = viewModelScope.launch { repo.atualizar(t.copy(concluida = done)) }
}
