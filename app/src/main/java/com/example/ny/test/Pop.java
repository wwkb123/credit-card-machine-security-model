package com.example.ny.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.provider.ContactsContract.CommonDataKinds.*;

/**
 * Created by ny on 1/20/2017.
 */

public class Pop extends Activity {
    EditText code;
    public String Combination = "";
    public String confirmation;
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
    /*private void sendEmail(String addr, String message){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[]
    }*/
    public String getRand(){
        return Combination;
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        ////////////////Verification///////////////////
        code = (EditText) findViewById(R.id.editText2);
        Random rand = new Random();
        int a,b,c,d,e,f;
        a = rand.nextInt(9);
        b = rand.nextInt(9);
        c = rand.nextInt(9);
        d = rand.nextInt(9);
        e = rand.nextInt(9);
        f = rand.nextInt(9);
        Combination = Combination.concat(Integer.toString(a)).concat(Integer.toString(b)).concat(Integer.toString(c));
        Combination = Combination.concat(Integer.toString(d)).concat(Integer.toString(e)).concat(Integer.toString(f));
        sendSMS("9174368930",Combination);

        ////////////////EndVerification///////////////
        Button y=(Button) findViewById(R.id.button2);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmation = code.getText().toString();
                if(confirmation.compareTo(Combination)== 0){
                    startActivity(new Intent(Pop.this,Pop_verify.class));
                }
                else{
                    startActivity(new Intent(Pop.this,Pop_decline.class));
                }
            }
        });
        Button n=(Button) findViewById(R.id.button3);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Pop.this,MainActivity.class));
            }
        });
    }


}
