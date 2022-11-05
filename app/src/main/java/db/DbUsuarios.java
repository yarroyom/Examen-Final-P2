package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.examenfinalp2.UsuarioActivity2;

import java.util.ArrayList;

import Entidades.usuarios;

public class DbUsuarios extends  DbHelper{
    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarUsuario(String usuario,String Password){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("Usuario", usuario);
            values.put("password", Password);

            id = db.insert(TABLE_USUARIO, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<usuarios> mostrarusuarios() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<usuarios> listausuarios = new ArrayList<>();
        usuarios usuario = null;
        Cursor cursorusuario = null;

        cursorusuario = db.rawQuery(" SELECT * FROM " + TABLE_USUARIO , null);
        if (cursorusuario.moveToFirst()) {
            do {
                usuario = new usuarios();
                usuario.setId(cursorusuario.getInt(0));
                usuario.setUsuario(cursorusuario.getString(1));
                usuario.setPassword_t(cursorusuario.getString(2));
                listausuarios.add(usuario);

            } while (cursorusuario.moveToNext());
        }
        cursorusuario.close();
        return listausuarios;
    }
}

