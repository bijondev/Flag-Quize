package dev.bijon.flagcuize;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FlagsDAO {

    public ArrayList<FlagsModel> getRandomQuizeTenQuistions(FlagsDatabase fd) {
        ArrayList<FlagsModel> modelArryList = new ArrayList<>();
        SQLiteDatabase liteDatabese = fd.getWritableDatabase();
        Cursor cursor = liteDatabese.rawQuery("Select * from flagquizgametable ORDER BY RANDOM() LIMIT 10", null);

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagName = cursor.getColumnIndex("flag_name");
        int flagImage = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext()) {
            FlagsModel model = new FlagsModel(
                    cursor.getInt(flagIdIndex),
                    cursor.getString(flagName),
                    cursor.getString(flagImage)
            );
            modelArryList.add(model);
        }
        return modelArryList;
    }

    public ArrayList<FlagsModel> getRandomQuizeThreeOptions(FlagsDatabase fd, int flag_id) {
        ArrayList<FlagsModel> modelArryList = new ArrayList<>();
        SQLiteDatabase liteDatabese = fd.getWritableDatabase();
        Cursor cursor = liteDatabese.rawQuery("Select * from flagquizgametable WHERE flag_id != "+flag_id+" ORDER BY RANDOM() LIMIT 3", null);

        int flagIdIndex = cursor.getColumnIndex("flag_id");
        int flagName = cursor.getColumnIndex("flag_name");
        int flagImage = cursor.getColumnIndex("flag_image");

        while (cursor.moveToNext()) {
            FlagsModel model = new FlagsModel(
                    cursor.getInt(flagIdIndex),
                    cursor.getString(flagName),
                    cursor.getString(flagImage)
            );
            modelArryList.add(model);
        }
        return modelArryList;
    }
}
