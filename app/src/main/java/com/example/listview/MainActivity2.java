package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    String[] StrlV = new String[20];
    TextView tVX1, tVd, tVn, tVSn;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tVX1 = (TextView) findViewById(R.id.tVX1);
        tVd = (TextView) findViewById(R.id.tVd);
        tVn = (TextView) findViewById(R.id.tVn);
        tVSn = (TextView) findViewById(R.id.tVSn);
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, StrlV);
        listView.setAdapter(adp);

        Intent gi = getIntent();
        Float x1 = gi.getFloatExtra("firstFlt", 0);
        Float d = gi.getFloatExtra("hefreshOrMahpilFlt", 0);
        Boolean handasitOrHeshbonit = gi.getBooleanExtra("handasitOrHeshbonit", false); //true = Handasit   flase = Heshbonit


        DecimalFormat df = new DecimalFormat("#.###"); // פורמט לשלוש ספרות אחרי הנקודה

        for (int i = 0; i<20; i++){
            if (handasitOrHeshbonit)
                StrlV[i] = df.format(x1 * i * d); // חשבונית
            else
                StrlV[i] = df.format(x1*Math.pow(d,i)); //הנדסית

        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void goBack(View view) {
        finish();
    }
}