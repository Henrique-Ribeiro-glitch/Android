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

import br.edu.qi.mentalhealthaplication.Model.DAO.PlanDataAccessObject;
import br.edu.qi.mentalhealthaplication.Model.Plan;
import br.edu.qi.mentalhealthaplication.R;

public class PlanListActivity extends AppCompatActivity {
    private ListView plansList;
    private PlanDataAccessObject objectPlanDataAccessObject;
    private MenuItem menuOptionUpdate, menuOptionDelete;
    private List<Plan> allPlans;
    private List<Plan> filteredPlans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list_plan);
        plansList = findViewById(R.id.plansList);
        objectPlanDataAccessObject = new PlanDataAccessObject(this);
        allPlans = objectPlanDataAccessObject.listAllPlans();
        filteredPlans.addAll(allPlans);
        ArrayAdapter<Plan> adapter = new ArrayAdapter<>(PlanListActivity.this,
                android.R.layout.simple_list_item_1, filteredPlans);
        plansList.setAdapter(adapter);
        registerForContextMenu(plansList);
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
                AdapterView.AdapterContextMenuInfo planPosition =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Plan objectPlanArrayDelete = filteredPlans.get(planPosition.position);
                AlertDialog confirmation = new AlertDialog.Builder(PlanListActivity.this)
                        .setTitle("Atention!")
                        .setMessage("Do you whant to delete it?")
                        .setNegativeButton("No",null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                allPlans.remove(objectPlanArrayDelete);
                                filteredPlans.remove(objectPlanArrayDelete);
                                objectPlanDataAccessObject.deletePlan(objectPlanArrayDelete);
                                plansList.invalidateViews();
                            }
                        }).create();
                confirmation.show();
                return false;
            }
        });

        menuOptionUpdate.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo planPosition =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                Plan objectPlanArrayUpdate = filteredPlans.get(planPosition.position);
                Intent intent = new Intent(PlanListActivity.this,
                        PlanUpdateActivity.class);
                intent.putExtra("plan",objectPlanArrayUpdate);
                startActivity(intent);
                finish();
                return false;
            }
        });
    }
}