package br.edu.qi.mentalhealthaplication.Model.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import br.edu.qi.mentalhealthaplication.Model.DB.DataBaseConection;
import br.edu.qi.mentalhealthaplication.Model.Plan;

public class PlanDataAccessObject {
    private DataBaseConection dataBaseConection;
    private SQLiteDatabase dataBase;
    public PlanDataAccessObject(Context context) {
        this.dataBaseConection = new DataBaseConection(context);
        this.dataBase = this.dataBaseConection.getWritableDatabase();
    }
    public void registerPlan(Plan planObject){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("title", planObject.getTitle());
        fieldValues.put("text", planObject.getText());
        this.dataBase.insert("table_plan",null,fieldValues);
    }
    public List<Plan> listAllPlans(){
        List<Plan> allPlans = new ArrayList<>();
        String [] fields = {"id","title","text"};
        Cursor cursor = dataBase.query("table_plan",fields,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            Plan objectPlan = new Plan();
            objectPlan.setId(cursor.getInt(0));
            objectPlan.setTitle(cursor.getString(1));
            objectPlan.setText(cursor.getString(2));
            allPlans.add(objectPlan);
        }
        return allPlans;
    }
    public void updatePlan(Plan planObject){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("title",planObject.getTitle());
        fieldValues.put("text",planObject.getText());
        String [] id = {String.valueOf(planObject.getId())};
        this.dataBase.update("table_plan",fieldValues,"id = ?",id);
    }
    public void deletePlan(Plan planObject){
        String [] id = {String.valueOf(planObject.getId())};
        this.dataBase.delete("table_plan","id = ?",id);
    }
}