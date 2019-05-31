package com.example.user.mrgamsys.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mrgamsys.R;


public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Button btnconfirm,btnconlat;
    Spinner regcategory;
    TextView txtcat;
    String[] regcat = { "Doctor", "GYM", "Wellness Center", "EECP Center", "Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        btnconfirm = findViewById(R.id.btnconfirm);
        btnconlat =findViewById(R.id.btnconlat);
        txtcat = findViewById(R.id.txtcat);

        regcategory = findViewById(R.id.regcategory);               //spineer
        regcategory.setOnItemSelectedListener(this);


/*

        ArrayAdapter<CharSequence> rc =ArrayAdapter.createFromResource(this,R.array.regcategory,android.R.layout.simple_spinner_item );
        rc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regcategory.setAdapter(rc);
*/

        //creating  the arrayadapter instance having regcategory

        ArrayAdapter aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,regcat);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regcategory.setAdapter(aa);


        btnconfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nofentity = regcategory.getSelectedItem().toString();

                Intent i = new Intent(Registration.this, ConfirmNow.class);
                Bundle b = new Bundle();
                b.putString("noe",nofentity);
                i.putExtras(b);
                startActivity(i);
            }
        });


        btnconlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Registration.this, FollowUp.class);
                startActivity(i);
            }
        });
    }
    /*END OF ON CREATE*/


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {
        Toast.makeText(getApplicationContext(),regcat[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
