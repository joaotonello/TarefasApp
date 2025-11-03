package com.example.tarefas.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TarefaDao_Impl implements TarefaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tarefa> __insertionAdapterOfTarefa;

  private final EntityDeletionOrUpdateAdapter<Tarefa> __deletionAdapterOfTarefa;

  private final EntityDeletionOrUpdateAdapter<Tarefa> __updateAdapterOfTarefa;

  public TarefaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTarefa = new EntityInsertionAdapter<Tarefa>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tarefas` (`id`,`titulo`,`descricao`,`categoria`,`prioridade`,`concluida`,`criadoEm`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tarefa entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getDescricao() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescricao());
        }
        statement.bindString(4, __Categoria_enumToString(entity.getCategoria()));
        statement.bindString(5, __Prioridade_enumToString(entity.getPrioridade()));
        final int _tmp = entity.getConcluida() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getCriadoEm());
      }
    };
    this.__deletionAdapterOfTarefa = new EntityDeletionOrUpdateAdapter<Tarefa>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `tarefas` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tarefa entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfTarefa = new EntityDeletionOrUpdateAdapter<Tarefa>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tarefas` SET `id` = ?,`titulo` = ?,`descricao` = ?,`categoria` = ?,`prioridade` = ?,`concluida` = ?,`criadoEm` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Tarefa entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getDescricao() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescricao());
        }
        statement.bindString(4, __Categoria_enumToString(entity.getCategoria()));
        statement.bindString(5, __Prioridade_enumToString(entity.getPrioridade()));
        final int _tmp = entity.getConcluida() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getCriadoEm());
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object inserir(final Tarefa tarefa, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTarefa.insertAndReturnId(tarefa);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletar(final Tarefa tarefa, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTarefa.handle(tarefa);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object atualizar(final Tarefa tarefa, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTarefa.handle(tarefa);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Tarefa>> observarTodas() {
    final String _sql = "SELECT * FROM tarefas ORDER BY concluida ASC, prioridade DESC, criadoEm DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tarefas"}, new Callable<List<Tarefa>>() {
      @Override
      @NonNull
      public List<Tarefa> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
          final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
          final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
          final int _cursorIndexOfPrioridade = CursorUtil.getColumnIndexOrThrow(_cursor, "prioridade");
          final int _cursorIndexOfConcluida = CursorUtil.getColumnIndexOrThrow(_cursor, "concluida");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criadoEm");
          final List<Tarefa> _result = new ArrayList<Tarefa>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tarefa _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitulo;
            if (_cursor.isNull(_cursorIndexOfTitulo)) {
              _tmpTitulo = null;
            } else {
              _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
            }
            final String _tmpDescricao;
            if (_cursor.isNull(_cursorIndexOfDescricao)) {
              _tmpDescricao = null;
            } else {
              _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
            }
            final Categoria _tmpCategoria;
            _tmpCategoria = __Categoria_stringToEnum(_cursor.getString(_cursorIndexOfCategoria));
            final Prioridade _tmpPrioridade;
            _tmpPrioridade = __Prioridade_stringToEnum(_cursor.getString(_cursorIndexOfPrioridade));
            final boolean _tmpConcluida;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfConcluida);
            _tmpConcluida = _tmp != 0;
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Tarefa(_tmpId,_tmpTitulo,_tmpDescricao,_tmpCategoria,_tmpPrioridade,_tmpConcluida,_tmpCriadoEm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Tarefa>> buscar(final String q) {
    final String _sql = "SELECT * FROM tarefas WHERE titulo LIKE ? OR descricao LIKE ? ORDER BY concluida ASC, prioridade DESC, criadoEm DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    _argIndex = 2;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tarefas"}, new Callable<List<Tarefa>>() {
      @Override
      @NonNull
      public List<Tarefa> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
          final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
          final int _cursorIndexOfCategoria = CursorUtil.getColumnIndexOrThrow(_cursor, "categoria");
          final int _cursorIndexOfPrioridade = CursorUtil.getColumnIndexOrThrow(_cursor, "prioridade");
          final int _cursorIndexOfConcluida = CursorUtil.getColumnIndexOrThrow(_cursor, "concluida");
          final int _cursorIndexOfCriadoEm = CursorUtil.getColumnIndexOrThrow(_cursor, "criadoEm");
          final List<Tarefa> _result = new ArrayList<Tarefa>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Tarefa _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitulo;
            if (_cursor.isNull(_cursorIndexOfTitulo)) {
              _tmpTitulo = null;
            } else {
              _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
            }
            final String _tmpDescricao;
            if (_cursor.isNull(_cursorIndexOfDescricao)) {
              _tmpDescricao = null;
            } else {
              _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
            }
            final Categoria _tmpCategoria;
            _tmpCategoria = __Categoria_stringToEnum(_cursor.getString(_cursorIndexOfCategoria));
            final Prioridade _tmpPrioridade;
            _tmpPrioridade = __Prioridade_stringToEnum(_cursor.getString(_cursorIndexOfPrioridade));
            final boolean _tmpConcluida;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfConcluida);
            _tmpConcluida = _tmp != 0;
            final long _tmpCriadoEm;
            _tmpCriadoEm = _cursor.getLong(_cursorIndexOfCriadoEm);
            _item = new Tarefa(_tmpId,_tmpTitulo,_tmpDescricao,_tmpCategoria,_tmpPrioridade,_tmpConcluida,_tmpCriadoEm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __Categoria_enumToString(@NonNull final Categoria _value) {
    switch (_value) {
      case Trabalho: return "Trabalho";
      case Estudo: return "Estudo";
      case Pessoal: return "Pessoal";
      case Outros: return "Outros";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __Prioridade_enumToString(@NonNull final Prioridade _value) {
    switch (_value) {
      case Alta: return "Alta";
      case Media: return "Media";
      case Baixa: return "Baixa";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private Categoria __Categoria_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "Trabalho": return Categoria.Trabalho;
      case "Estudo": return Categoria.Estudo;
      case "Pessoal": return Categoria.Pessoal;
      case "Outros": return Categoria.Outros;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }

  private Prioridade __Prioridade_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "Alta": return Prioridade.Alta;
      case "Media": return Prioridade.Media;
      case "Baixa": return Prioridade.Baixa;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
