package com.example.projdevmobile10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {

    private static final String DB_NAME = "Usuarios.db";
    private static final int DB_VERSION = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT UNIQUE, " +
                "senha TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public boolean inserirUsuario(String nome, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", nome);
        values.put("email", email);
        values.put("senha", senha);

        try {
            long result = db.insertOrThrow("usuarios", null, values);
            return result != -1;
        } catch (SQLiteConstraintException e) {   // e-mail duplicado, etc.
            return false;
        } catch (SQLiteException e) {             // tabela inexistente ou outro erro
            Log.e("DB_ERROR", "Falha ao inserir", e);
            return false;
        }
    }

    public boolean autenticarUsuario(String email, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios WHERE email = ? AND senha = ?", new String[]{email, senha});
        boolean resultado = cursor.getCount() > 0;
        cursor.close();
        return resultado;
    }
}
