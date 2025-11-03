package com.example.tarefas.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tarefas.data.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorScreen(
    vm: TarefaViewModel,
    tarefaId: Long?,
    onDone: () -> Unit
) {
    val lista by vm.estado.collectAsStateWithLifecycle()
    val existente = lista.find { it.id == tarefaId } 

    var titulo by remember(existente) { mutableStateOf(existente?.titulo ?: "") }
    var descricao by remember(existente) { mutableStateOf(existente?.descricao ?: "") }
    var categoria by remember(existente) { mutableStateOf(existente?.categoria ?: Categoria.Outros) }
    var prioridade by remember(existente) { mutableStateOf(existente?.prioridade ?: Prioridade.Media) }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(if (existente == null) "Nova Tarefa" else "Editar Tarefa") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = descricao, onValueChange = { descricao = it }, label = { Text("Descrição") }, modifier = Modifier.fillMaxWidth(), minLines = 3)
            Spacer(Modifier.height(8.dp))

            // Categoria dropdown
            ExposedDropdownMenuBox(expanded = false, onExpandedChange = {}) {
                // For simplicity, use a Row of buttons
            }
            Text("Categoria")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Categoria.values().forEach { c ->
                    FilterChip(selected = categoria == c, onClick = { categoria = c }, label = { Text(c.name) })
                }
            }

            Spacer(Modifier.height(8.dp))
            Text("Prioridade")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Prioridade.values().forEach { p ->
                    FilterChip(selected = prioridade == p, onClick = { prioridade = p }, label = { Text(p.name) })
                }
            }

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    if (titulo.isNotBlank()) {
                        val atualizado = (existente ?: Tarefa(titulo = titulo)).copy(
                            titulo = titulo,
                            descricao = descricao,
                            categoria = categoria,
                            prioridade = prioridade
                        )
                        vm.salvar(atualizado)
                        onDone()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Salvar") }
        }
    }
}