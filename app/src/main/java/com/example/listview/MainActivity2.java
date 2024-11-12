package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listView);

        Intent gi = getIntent();
        Float x1 = gi.getFloatExtra("firstFlt", 0);
        Float d = gi.getFloatExtra("hefreshOrMahpilFlt", 0);
        Boolean handasitOrHeshbonit = gi.getBooleanExtra("handasitOrHeshbonit"); //true = Handasit   flase = Heshbonit


        Intent gi = new Intent();
        gi.putExtra("x1", x1);
        gi.putExtra("x2", x2);
        setResult(RESULT_OK, gi);
        finish();

        if(handasitOrHeshbonit) {
            Float[] lV = new Float[20];
            for (int i = 0; i < lV.length; i++) {
                lV[i] = (float) (x1*d^i-1);
            }
        }

    }
}