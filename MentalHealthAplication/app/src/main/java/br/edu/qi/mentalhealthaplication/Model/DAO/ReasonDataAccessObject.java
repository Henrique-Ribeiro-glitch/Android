package br.edu.qi.mentalhealthaplication.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.qi.mentalhealthaplication.Model.DB.DataBaseConection;
import br.edu.qi.mentalhealthaplication.Model.Reason;

public class ReasonDataAccessObject {
    private DataBaseConection dataBaseConection;
    private SQLiteDatabase dataBase;
    public ReasonDataAccessObject(Context context) {
        this.dataBaseConection = new DataBaseConection(context);
        this.dataBase = this.dataBaseConection.getWritableDatabase();
    }
    public void registerReason(Reason objectReason){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("title",objectReason.getTitle());
        fieldValues.put("text",objectReason.getText());
        this.dataBase.insert("table_reason",null,fieldValues);
    }

    public List<Reason> listAllReasons(){
        List<Reason> allReasons = new ArrayList<>();
        String [] fields = {"id","title","text"};
        Cursor cursor = dataBase.query("table_reason",fields,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            Reason objectReason = new Reason();
            objectReason.setId(cursor.getInt(0));
            objectReason.setTitle(cursor.getString(1));
            objectReason.setText(cursor.getString(2));
            allReasons.add(objectReason);
        }
        return allReasons;
    }

    public void updateReason(Reason objectReason){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("title",objectReason.getTitle());
        fieldValues.put("text",objectReason.getText());
        String [] id = {String.valueOf(objectReason.getId())};
        this.dataBase.update("table_reason",fieldValues,"id = ?", id);
    }

    public void deleteReason(Reason objectReason){
        String [] id = {String.valueOf(objectReason.getId())};
        this.dataBase.delete("table_reason","id = ?", id);
    }
}
