package br.org.fundatec.dogwalkerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class DogWalkerMenu extends AppCompatActivity {

    private ListView listview;
    ArrayList<Dog> dogs = new ArrayList<Dog>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_walker_menu);
        listview = (ListView)findViewById(R.id.listView);
        load();
    }

    protected void load(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("listapets");
        /*Dog dog1 = new Dog();
        dog1.name = "Raul Dog";
        dog1.imgDog = "http://tudosobrecachorros.com.br/wp-content/uploads/cachorro-independente.jpg";
        Dog dog2 = new Dog();
        dog2.name = "Duda";
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add( dog1 );
        dogs.add( dog2 );*/



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                dogs.clear();
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Log.e("LISTA", postSnapshot.getKey());
                    dogs.add(postSnapshot.getValue(Dog.class));
                }
                final ArrayAdapter<Dog> adapterTimeline = new DogAdapter(DogWalkerMenu.this, android.R.layout.simple_list_item_1, dogs);
                listview.setAdapter(adapterTimeline);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("GREGORY", "Failed to read value.", error.toException());
            }
        });
    }
}
