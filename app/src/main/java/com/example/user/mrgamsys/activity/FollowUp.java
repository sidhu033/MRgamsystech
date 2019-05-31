package com.example.user.mrgamsys.activity;

import com.example.user.mrgamsys.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class FollowUp extends AppCompatActivity
{
    Button btnsubmit;
    Spinner spfom;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_up);

        /*Initilization*/
        spfom = findViewById(R.id.spfom);


        ArrayAdapter<CharSequence> fum =ArrayAdapter.createFromResource(this,R.array.fomethod,android.R.layout.simple_spinner_item );

        fum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spfom.setAdapter(fum);


        btnsubmit = findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(i);
            }
        });
    }
}
