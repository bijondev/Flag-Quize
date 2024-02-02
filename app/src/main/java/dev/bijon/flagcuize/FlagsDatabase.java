package dev.bijon.flagcuize;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FlagsDatabase extends SQLiteOpenHelper {
    public FlagsDatabase(Context context) {
        super(context, "flagquizgame.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS flagquizgametable ('flag_id' INTEGER,flag_name TEXT, flag_image TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS flagquizgametable");
        onCreate(db);
    }
}
