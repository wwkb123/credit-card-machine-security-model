package com.example.ny.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class Pop_verify extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_verify);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        Button r=(Button) findViewById(R.id.button4);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().closeAllPanels();
//                Intent i = new Intent(Pop.this,MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//                startActivity(i);
                finish();
            }
        });
    }


}