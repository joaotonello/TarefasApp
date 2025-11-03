package com.example.tarefas.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarefas.data.Tarefa

sealed interface Destino {
    data object Lista : Destino
    data class Editor(val id: Long? = null) : Destino
}

@Composable
fun TarefaNavHost(
    navController: NavHostController = rememberNavController(),
    vm: TarefaViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = "lista") {
        composable("lista") {
            ListaScreen(
                vm = vm,
                onAdd = { navController.navigate("editor") },
                onEdit = { tarefa -> navController.navigate("editor?id=${tarefa.id}") }
            )
        }
        composable("editor{id?}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            EditorScreen(
                vm = vm,
                tarefaId = id,
                onDone = { navController.popBackStack() }
            )
        }
        composable("editor") {
            EditorScreen(vm = vm, tarefaId = null, onDone = { navController.popBackStack() })
        }
    }
}