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
    String[] strLV = new String[20];
    float[] fltLV= new float[20];
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

        tVn.setVisibility(View.INVISIBLE);
        tVSn.setVisibility(View.INVISIBLE);

        Intent gi = getIntent();
        Float x1 = gi.getFloatExtra("firstFlt", 0);
        Float d = gi.getFloatExtra("hefreshOrMahpilFlt", 0);
        Boolean handasitOrHeshbonit = gi.getBooleanExtra("handasitOrHeshbonit", false); //true = Heshbonit  flase = Handasit


        DecimalFormat df = new DecimalFormat("#.###"); // פורמט לשלוש ספרות אחרי הנקודה

        for (int i = 0; i < 20; i++) {
            if (handasitOrHeshbonit) {
                fltLV[i] = x1 + i * d; // חשבונית
            } else {
                fltLV[i] = (float) (x1 * Math.pow(d, i)); // הנדסית
            }
            strLV[i] = df.format(fltLV[i]);
        }


        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strLV);
        listView.setAdapter(adp);

        //נתונים קבועים
        tVX1.setText("X1 = " + df.format(x1));
        tVd.setText("d = " + df.format(d));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int n = position + 1;
        float Sn = 0;

        for (int i = 0; i < n; i++) {
            Sn += fltLV[i];
        }

        DecimalFormat df = new DecimalFormat("#.###");
        tVn.setText("n = " + n);
        tVSn.setText("Sn = " + df.format(Sn));

        tVn.setVisibility(View.VISIBLE);
        tVSn.setVisibility(View.VISIBLE);
    }

    public void goBack(View view) {
        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}