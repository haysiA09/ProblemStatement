package com.example.problemstatement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etRev;
    Button btninsert, btnshow;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRev=findViewById(R.id.editText);
        btninsert=findViewById(R.id.buttonInsert);
        btnshow=findViewById(R.id.buttonShowList);
        rg=findViewById(R.id.RadioGroup);
        int selectedButtonid=rg.getCheckedRadioButtonId();
        rb=findViewById(selectedButtonid);



        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelperr db=new DBHelperr(MainActivity.this);
                //insert revision
                db.insertRevision(etRev.getText().toString(),rb.getText().toString());
                db.close();
                Toast toast=Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG);

                toast.show();
            }
        });





    }
}
