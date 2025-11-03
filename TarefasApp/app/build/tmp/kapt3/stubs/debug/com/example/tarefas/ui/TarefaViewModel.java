package com.example.tarefas.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/tarefas/ui/TarefaViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "estado", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/tarefas/data/Tarefa;", "getEstado", "()Lkotlinx/coroutines/flow/StateFlow;", "filtros", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/tarefas/ui/Filtros;", "fonte", "repo", "Lcom/example/tarefas/data/TarefaRepository;", "deletar", "Lkotlinx/coroutines/Job;", "t", "marcarConcluida", "done", "", "salvar", "setMostrarConcluidas", "", "v", "setQuery", "q", "", "toggleCategoria", "c", "Lcom/example/tarefas/data/Categoria;", "togglePrioridade", "p", "Lcom/example/tarefas/data/Prioridade;", "app_debug"})
public final class TarefaViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.tarefas.data.TarefaRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.tarefas.ui.Filtros> filtros = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.tarefas.data.Tarefa>> fonte = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.tarefas.data.Tarefa>> estado = null;
    
    public TarefaViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.tarefas.data.Tarefa>> getEstado() {
        return null;
    }
    
    public final void setQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String q) {
    }
    
    public final void toggleCategoria(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Categoria c) {
    }
    
    public final void togglePrioridade(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Prioridade p) {
    }
    
    public final void setMostrarConcluidas(boolean v) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job salvar(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa t) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deletar(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa t) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job marcarConcluida(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa t, boolean done) {
        return null;
    }
}