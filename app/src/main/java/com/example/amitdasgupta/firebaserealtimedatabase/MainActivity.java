package com.example.amitdasgupta.firebaserealtimedatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
      EditText et;
    Button bt;
    Spinner spinner;
    DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        df= FirebaseDatabase.getInstance().getReference("artist");
        et=(EditText)findViewById(R.id.editTextName);
        bt=(Button)findViewById(R.id.buttonAddArtist);
        spinner=(Spinner)findViewById(R.id.spinnerArtist);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et.getText().toString();
                String gene=spinner.getSelectedItem().toString();
                if(!TextUtils.isEmpty(name))
                {
                    String id=df.push().getKey();
                    Artist artist=new Artist(id,name,gene);
                    df.child(id).setValue(artist).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                                Toast.makeText(MainActivity.this,"Data is inserted into database",Toast.LENGTH_SHORT).show();
                        }
                    });

                }
                else
                    Toast.makeText(MainActivity.this,"Artist must have a name",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
