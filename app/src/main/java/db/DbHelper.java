package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private  static final int DATABASE_VERSION=1;
    public   static final String DATABASE_NOMBRE="Registro.db";
    public   static final String TABLE_USUARIO="t_usuario";




    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIO+ "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "usuario TeXT NOT NULL,"+
                "password TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("DROP TABLE " + TABLE_USUARIO);
onCreate(sqLiteDatabase);



    }
}
