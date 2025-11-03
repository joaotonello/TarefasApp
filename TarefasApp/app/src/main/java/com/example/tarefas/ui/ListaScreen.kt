package com.example.tarefas.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.tarefas.data.Categoria
import com.example.tarefas.data.Prioridade
import com.example.tarefas.data.Tarefa
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaScreen(
    vm: TarefaViewModel,
    onAdd: () -> Unit,
    onEdit: (Tarefa) -> Unit
) {
    val tarefas by vm.estado.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Minhas Tarefas") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) { Text("+") }
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(12.dp).fillMaxSize()) {
            // Search & filters
            var query by remember { mutableStateOf("") }
            OutlinedTextField(
                value = query,
                onValueChange = { query = it; vm.setQuery(it) },
                placeholder = { Text("Buscar por título ou descrição") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            Text("Categorias", style = MaterialTheme.typography.labelLarge)
            FlowRow(mainAxisSpacing = 8.dp, crossAxisSpacing = 8.dp) {
                Categoria.values().forEach { c ->
                    FilterChip(
                        selected = false,
                        onClick = { vm.toggleCategoria(c) },
                        label = { Text(c.name) }
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Text("Prioridade", style = MaterialTheme.typography.labelLarge)
            FlowRow(mainAxisSpacing = 8.dp, crossAxisSpacing = 8.dp) {
                Prioridade.values().forEach { p ->
                    FilterChip(
                        selected = false,
                        onClick = { vm.togglePrioridade(p) },
                        label = { Text(p.name) }
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                var showDone by remember { mutableStateOf(true) }
                Switch(checked = showDone, onCheckedChange = { showDone = it; vm.setMostrarConcluidas(it) })
                Text("Mostrar concluídas", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(Modifier.height(8.dp))

            if (tarefas.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Nenhuma tarefa encontrada.")
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(tarefas, key = { it.id }) { t ->
                        TarefaItem(
                            tarefa = t,
                            onToggle = { vm.marcarConcluida(t, it) },
                            onEdit = { onEdit(t) },
                            onDelete = { vm.deletar(t) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TarefaItem(
    tarefa: Tarefa,
    onToggle: (Boolean) -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = tarefa.concluida, onCheckedChange = onToggle)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .clickable { onEdit() }
            ) {
                Text(tarefa.titulo, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                if (tarefa.descricao.isNotBlank()) {
                    Text(tarefa.descricao, style = MaterialTheme.typography.bodySmall, maxLines = 2, overflow = TextOverflow.Ellipsis)
                }
                Text("${tarefa.categoria} • ${tarefa.prioridade}", style = MaterialTheme.typography.labelMedium)
            }
            TextButton(onClick = onDelete) { Text("Excluir") }
        }
    }
}