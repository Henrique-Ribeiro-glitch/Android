package br.edu.qi.mentalhealthaplication.Model.DB;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DataBaseConection extends SQLiteOpenHelper {
    private static final String NAME = "dataBase";
    private static final int VERSION = 1;
    public DataBaseConection(Context context) {
        super(context, NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        dataBase.execSQL(
                "create table table_user(" +
                        "id integer primary key autoincrement," +
                        "name varchar(50)," +
                        "password varchar(16))"
        );
        dataBase.execSQL(
                "create table table_reason(" +
                        "id integer primary key autoincrement," +
                        "title varchar(50)," +
                        "text varchar(50))"
        );
        dataBase.execSQL(
                "create table table_plan(" +
                        "id integer primary key autoincrement," +
                        "title varchar(50)," +
                        "text varchar(50))"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int index, int index1) {
    }
}
