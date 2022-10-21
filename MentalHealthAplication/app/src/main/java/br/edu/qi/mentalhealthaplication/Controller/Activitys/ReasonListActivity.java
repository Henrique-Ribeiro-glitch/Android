package br.edu.qi.mentalhealthaplication.Controller.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.qi.mentalhealthaplication.Model.DAO.ReasonDataAccessObject;
import br.edu.qi.mentalhealthaplication.Model.Reason;
import br.edu.qi.mentalhealthaplication.R;

public class ReasonListActivity extends AppCompatActivity {
    private ListView reasonsList;
    private ReasonDataAccessObject objectReasonDataAccessObject;
    private MenuItem menuOptionUpdate, menuOptionDelete;
    private List<Reason> allReasons;
    private List<Reason> filteredReasons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list_reasons);
        reasonsList = findViewById(R.id.reasonsList);
        objectReasonDataAccessObject = new ReasonDataAccessObject(this);
        allReasons = objectReasonDataAccessObject.listAllReasons();
        filteredReasons.addAll(allReasons);
        ArrayAdapter<Reason> adapter = new ArrayAdapter<>(ReasonListActivity.this,
                android.R.layout.simple_list_item_1, filteredReasons);
        reasonsList.setAdapter(adapter);
        registerForContextMenu(reasonsList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_options,menu);
        menuOptionUpdate = menu.findItem(R.id.menuOptionsUpdate);
        menuOptionDelete = menu.findItem(R.id.menuOptionsDelete);

        menuOptionDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo reasonPosition =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Reason objectReasonArrayDelete = filteredReasons.get(reasonPosition.position);

                AlertDialog confirmation = new AlertDialog.Builder(ReasonListActivity.this)
                        .setTitle("Atention!")
                        .setMessage("Do you whant to delete it?")
                        .setNegativeButton("No",null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                allReasons.remove(objectReasonArrayDelete);
                                filteredReasons.remove(objectReasonArrayDelete);
                                objectReasonDataAccessObject.deleteReason(objectReasonArrayDelete);
                                reasonsList.invalidateViews();
                            }
                        }).create();
                confirmation.show();

                return false;
            }
        });

        menuOptionUpdate.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo reasonPosition =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Reason objectReasonArrayUpdate = filteredReasons.get(reasonPosition.position);
                Intent intent = new Intent(ReasonListActivity.this,
                        ReasonUpdateActivity.class);
                intent.putExtra("reason",objectReasonArrayUpdate);
                startActivity(intent);
                finish();
                return false;
            }
        });
    }
}