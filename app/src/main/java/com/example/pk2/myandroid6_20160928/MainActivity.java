package com.example.pk2.myandroid6_20160928;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
2016-10-01 by pk
 */
public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bhelp;
    private String myTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();

        myTitle = getString(R.string.Bmi_App);

        setContentView(R.layout.activity_main);


        findViews();
        bhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this).setTitle("BMI 說明")
                        .setMessage("體重（kg)/身高的平方（m)")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }


    private void findViews() {
        edWeight = (EditText) findViewById(R.id.ed_weight);
        edHeight = (EditText) findViewById(R.id.ed_Height);
        bhelp = (Button) findViewById(R.id.b_button);
    }

    public void bmi(View V) {
        String w = this.edWeight.getText().toString();
        String h = this.edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float heigth = Float.parseFloat(h);
        float bmi = weight / (heigth * heigth);
        Log.d("BMI", String.valueOf(bmi));  //使用 logcat 記錄
    //    Toast.makeText(this, "hello "+String.valueOf(bmi) , Toast.LENGTH_LONG).show();
        //使用浮動訊息 會自動消失

   //  new AlertDialog.Builder(this).setMessage(bmi+"").setTitle("BMI計算結果").setNeutralButton("Cancel",null).setPositiveButton("ok",null).show();
                //使用類似alert訊息


        String myWord1 = "This is a pen.";
        String myWord2 = "This is a book.";
        Bundle  bag = new Bundle();
        bag.putString(getString(R.string.myWord1),myWord1);
        bag.putString(getString(R.string.myWord2),myWord2);
        bag.putFloat(getString(R.string.MY_BMI),bmi);
        //傳資料先用 Intent
        Intent intent = new Intent(this,pk2.class);
        //intent.putExtra("MY_BMI",bmi);
        //改用 Bundle
        intent.putExtras(bag);
        startActivity(intent);

    }

    @Override
    protected void onStop() {
        super.onStop(); 
        Toast.makeText(this,"onStop11", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy1",Toast.LENGTH_LONG).show();


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart11",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause1",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart1",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume1",Toast.LENGTH_LONG).show();
    }
}