package com.myandroidhello.myvaca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//FINISH DYNAMIC FIREBASE LISTVIEW

public class DestinationList extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference rootReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference locationReference = rootReference.child("locations");
    private Button btnAdd, btnDelete;
    private EditText et;
    private ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    List<String> locations = new ArrayList<>();
    MainArrayAdapter mainArrayAdapter;
    DataSnapshot locationsSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_list);
        lv = findViewById(R.id.list);
        locations.addAll(Arrays.asList("Los Angeles", "New York", "Detroit"));

        //MainArrayAdapter
        mainArrayAdapter = new MainArrayAdapter(this, locations);
        lv.setAdapter(mainArrayAdapter); //maybe change to adapter

        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            int index = 0;

            for(DataSnapshot childSnapshot: locationsSnapshot.getChildren()){
                if(index == i){
                    DatabaseReference currentLocationReference = childSnapshot.getRef();

                    currentLocationReference.removeValue();
                }
                index++;
            }
        });

        //Buttons
        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                locationReference.push().setValue("Item");
//            }
//        });
        btnDelete = (Button)findViewById(R.id.deleteBtn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = et.getText().toString().toUpperCase();
                if(input.isEmpty()){
                    Toast.makeText(DestinationList.this, "Error: Type in the city to delete", Toast.LENGTH_SHORT).show();;
                }
                adapter.remove(input);
            }
        });
        et = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
    public void onClick(View v)
    {
        locationReference.push().setValue(/*et.toString().trim()*/ "Location"); //Firebase addition here
        String input = et.getText().toString().toUpperCase();
        if(input.length() > 0)
        {
            // add string to the adapter, not the listview
            adapter.add(input);
            // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
        }else{
            Toast.makeText(this, "Entry is empty, type in a location to add to list", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart(){
        super.onStart();

        locationReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                locationsSnapshot = snapshot;
                locations.clear();
                for(DataSnapshot childSnapshot: snapshot.getChildren()){
                    locations.add(childSnapshot.getValue(String.class));
                }
                mainArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}