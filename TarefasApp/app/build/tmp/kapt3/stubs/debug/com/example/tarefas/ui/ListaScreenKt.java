package com.example.tarefas.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a@\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a8\u0006\u000e"}, d2 = {"ListaScreen", "", "vm", "Lcom/example/tarefas/ui/TarefaViewModel;", "onAdd", "Lkotlin/Function0;", "onEdit", "Lkotlin/Function1;", "Lcom/example/tarefas/data/Tarefa;", "TarefaItem", "tarefa", "onToggle", "", "onDelete", "app_debug"})
public final class ListaScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void ListaScreen(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.ui.TarefaViewModel vm, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdd, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.tarefas.data.Tarefa, kotlin.Unit> onEdit) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TarefaItem(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa tarefa, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onToggle, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
}