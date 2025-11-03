package com.example.tarefas.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/example/tarefas/data/TarefaDao;", "", "atualizar", "", "tarefa", "Lcom/example/tarefas/data/Tarefa;", "(Lcom/example/tarefas/data/Tarefa;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buscar", "Lkotlinx/coroutines/flow/Flow;", "", "q", "", "deletar", "inserir", "", "observarTodas", "app_debug"})
@androidx.room.Dao()
public abstract interface TarefaDao {
    
    @androidx.room.Query(value = "SELECT * FROM tarefas ORDER BY concluida ASC, prioridade DESC, criadoEm DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.tarefas.data.Tarefa>> observarTodas();
    
    @androidx.room.Query(value = "SELECT * FROM tarefas WHERE titulo LIKE :q OR descricao LIKE :q ORDER BY concluida ASC, prioridade DESC, criadoEm DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.tarefas.data.Tarefa>> buscar(@org.jetbrains.annotations.NotNull()
    java.lang.String q);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object inserir(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa tarefa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object atualizar(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa tarefa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deletar(@org.jetbrains.annotations.NotNull()
    com.example.tarefas.data.Tarefa tarefa, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}