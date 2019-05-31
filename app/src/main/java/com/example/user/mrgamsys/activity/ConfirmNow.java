package com.example.user.mrgamsys.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.mrgamsys.R;

public class ConfirmNow extends AppCompatActivity implements Spinner.OnItemSelectedListener
{
    EditText spspeciality;
    Spinner spdegree;
    Button btnconsub;
    String name = "sss";

    String[] splist = {"MBBS","BAMS","BDS ","BUMS","BHMS"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_now);

        /*Initilization*/
        spspeciality = findViewById(R.id.spspeciality);
        btnconsub = findViewById(R.id.btnconsub);
        spdegree = findViewById(R.id.spdegree);
        spdegree.setOnItemSelectedListener(this);

        /*setting value of entity*/
        Bundle b = this.getIntent().getExtras();
        Log.e(name,"bundle");
        if(b != null)
        {
            String name = b.getString("noe");
            spspeciality.setHint(name);
        }





        ArrayAdapter<CharSequence> rc =ArrayAdapter.createFromResource(this,R.array.degree,android.R.layout.simple_spinner_item );
        rc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spdegree.setAdapter(rc);




        btnconsub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(ConfirmNow.this, UploadDocuments.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {
        Toast.makeText(getApplicationContext(),splist[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
