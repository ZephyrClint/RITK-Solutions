package com.example.mad_miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_miniproject.database.DBHelper;
import com.example.mad_miniproject.database.ItemsMaster;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    TextView tv_Apptzr_title;
    TextView tv_Breakfast_Apptzr;
    TextView tv_Lunch_Apptzr;
    TextView tv_Dinner_Apptzr;
    TextView tv_apptzr_total;
    TextView tv_apptzr_tot_value;
    Button btn_Next_Apptzr;
    ImageView imageView3;
    ImageButton imageButton27;
    ImageButton imageButton28;
    ImageButton imageButton29;
    ImageButton imageButton30;
    ImageButton imageButton31;
    ImageButton imageButton32;
    ImageButton imageButton33;
    ImageButton imageButton34;
    ImageButton imageButton35;
    ImageView imageView7;

    String id, noOfPeople;
    int ID, number_of_people;

    //navigation
    public void openFourth(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_Apptzr_title = findViewById(R.id.tv_Apptzr_title);
        tv_Breakfast_Apptzr = findViewById(R.id.tv_Breakfast_Apptzr);
        tv_Lunch_Apptzr = findViewById(R.id.tv_Lunch_Apptzr);
        tv_Dinner_Apptzr = findViewById(R.id.tv_Dinner_Apptzr);
        tv_apptzr_total = findViewById(R.id.tv_apptzr_total);
        tv_apptzr_tot_value = findViewById(R.id.tv_apptzr_tot_value);
        btn_Next_Apptzr = findViewById(R.id.btn_Next_Apptzr);
        imageView3 = findViewById(R.id.imageView3);
        imageButton27 = findViewById(R.id.imageButton27);
        imageButton28 = findViewById(R.id.imageButton28);
        imageButton29 = findViewById(R.id.imageButton29);
        imageButton30 = findViewById(R.id.imageButton30);
        imageButton31 = findViewById(R.id.imageButton31);
        imageButton32 = findViewById(R.id.imageButton32);
        imageButton33 = findViewById(R.id.imageButton33);
        imageButton34 = findViewById(R.id.imageButton34);
        imageButton35 = findViewById(R.id.imageButton35);
        imageView7 = findViewById(R.id.imageView7);

//        Intent intent = getIntent();
//        id = intent.getStringExtra("id");
//        noOfPeople = intent.getStringExtra("noOfPeople");
//
//        ID = Integer.getInteger(id);
//        number_of_people = Integer.getInteger(noOfPeople);

    }



    public void saveWrappedBaconOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Wrapped Bacon", 1000, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveFetaBiteOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Feta Bites", 800, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveEndiveOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Walnut Endive", 900, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveSkewerOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Antipasta Skewers", 1250, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveBurrataOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Burrata with Pesto", 1650, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveApricotOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Grilled Apricot", 900, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveHummasOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Veggie & Hummas", 1100, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void savePizzaOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Pizza", 1200, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveShrimpBiteOrder(View view) {

        long inserted;

        DBHelper dbHelper = new DBHelper(this);

        inserted = dbHelper.addApptzrInfo("Shrimp Bites", 890, number_of_people, ID);
        Toast.makeText(this, " "+ inserted, Toast.LENGTH_SHORT).show();

        if (inserted > 0) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }


    public void viewAllAptzr(View view) {
        DBHelper dbhelper = new DBHelper(this);

        List info = dbhelper.readAllApptzr();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selected Appetizer Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

}