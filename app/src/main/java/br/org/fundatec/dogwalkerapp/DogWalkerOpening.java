package br.org.fundatec.dogwalkerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DogWalkerOpening extends AppCompatActivity {

    private String[] ongNomes = new String[]{"PatasDadas", "101viralatas", "OngTeste3"};
    private Spinner sp;
    private Button mBtnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_walker_opening);
        mBtnBuscar = (Button)findViewById(R.id.btnBuscar);

        /*FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("pets/01");
        myRef.setValue("Duda");
        DatabaseReference myRef1 = database.getReference("pets/02");
        myRef1.setValue("Panda");
        DatabaseReference myRef2 = database.getReference("pets/03");
        myRef2.setValue("Urso");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("GREGORY", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("GREGORY", "Failed to read value.", error.toException());
            }
        });*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ongNomes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner sp = (Spinner) findViewById(R.id.spinnerONG);
        sp.setAdapter(adapter);

        mBtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DogWalkerOpening.this, DogWalkerMenu.class));
            }
        });
    }
}
