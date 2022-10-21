package br.edu.qi.mentalhealthaplication.Model.DAO;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.qi.mentalhealthaplication.Model.DB.DataBaseConection;
import br.edu.qi.mentalhealthaplication.Model.User;

public class UserDataAccessObject {
    private DataBaseConection dataBaseConection;
    private SQLiteDatabase dataBase;

    public UserDataAccessObject(Context context) {
        this.dataBaseConection = new DataBaseConection(context);
        this.dataBase = this.dataBaseConection.getWritableDatabase();
    }

    public void userRegister(User objectUser){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("name",objectUser.getName());
        fieldValues.put("password",objectUser.getPassword());
        this.dataBase.insert("table_user",null,fieldValues);
    }

    public List<User> listAllUsers(){
        List<User> allUsers = new ArrayList<>();
        String [] fields = {"id","name","password"};
        Cursor cursor = dataBase.query("table_user",fields,null,null,
                null,null,null);
        while (cursor.moveToNext()){
            User objectUser = new User();
            objectUser.setId(cursor.getInt(0));
            objectUser.setName(cursor.getString(1));
            objectUser.setPassword(cursor.getString(2));
            allUsers.add(objectUser);
        }
        return allUsers;
    }

    public void updateUser(User objectUser){
        ContentValues fieldValues = new ContentValues();
        fieldValues.put("name",objectUser.getName());
        fieldValues.put("password",objectUser.getPassword());
        String [] id = {String.valueOf(objectUser.getId())};
        this.dataBase.update("table_user",fieldValues,"id = ?",id);
    }

    public void deleteUser(User objectUser){
        String [] id = {String.valueOf(objectUser.getId())};
        this.dataBase.delete("table_user","id = ?",id);
    }
}
