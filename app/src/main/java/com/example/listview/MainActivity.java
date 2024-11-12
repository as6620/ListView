package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE = 1234;
    Button btnHeshbonit,btnHandasit,btnNext;
    EditText eTFirst, eTHefreshOrMahpil;
     boolean handasitOrHeshbonit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        eTFirst.setVisibility(View.INVISIBLE);
        eTHefreshOrMahpil.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);

    }

    private void initView() {
        btnHeshbonit = (Button) findViewById(R.id.btnHeshbonit);
        btnHandasit = (Button) findViewById(R.id.btnHandasit);
        btnNext = (Button) findViewById(R.id.btnNext);
        eTFirst = (EditText) findViewById(R.id.eTFirst);
        eTHefreshOrMahpil = (EditText) findViewById(R.id.eTHefreshOrMahpil);
    }

    public void goHandasit(View view) {
        eTFirst.setHint("רשום את המספר הראשון בסדרה ההנדסית");
        eTHefreshOrMahpil.setHint("רשום את המכפיל בסדרה ההנדסית");
        eTFirst.setVisibility(View.VISIBLE);
        eTHefreshOrMahpil.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        handasitOrHeshbonit = true;
    }

    public void goHeshbonit(View view) {
        eTFirst.setHint("רשום את המספר הראשון בסדרה החשבונית");
        eTHefreshOrMahpil.setHint("רשום את ההפרש בסדרה החשבונית");
        eTFirst.setVisibility(View.VISIBLE);
        eTHefreshOrMahpil.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        handasitOrHeshbonit = false;
    }

    public void goNext(View view) {
        String firstStr = eTFirst.getText().toString();
        String hefreshOrMahpilStr = eTHefreshOrMahpil.getText().toString();

        if (firstStr.isEmpty() | firstStr.equals("-") | firstStr.equals("-.") | firstStr.equals("+") | firstStr.equals("+.") | hefreshOrMahpilStr.isEmpty() | hefreshOrMahpilStr.equals("-") | hefreshOrMahpilStr.equals("-.") | hefreshOrMahpilStr.equals("+") | hefreshOrMahpilStr.equals("+."))
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        else {
            float firstFlt = Float.parseFloat(firstStr);
            float hefreshOrMahpilFlt = Float.parseFloat(hefreshOrMahpilStr);

            Intent si = new Intent(this, MainActivity2.class);
            si.putExtra("firstFlt", firstFlt);
            si.putExtra("hefreshOrMahpilFlt", hefreshOrMahpilFlt);
            si.putExtra("handasitOrHeshbonit", handasitOrHeshbonit);
            startActivityForResult(si, REQUEST_CODE);

        }
    }



}