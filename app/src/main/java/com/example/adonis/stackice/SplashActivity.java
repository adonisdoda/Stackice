package com.example.adonis.stackice;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.adonis.stackice.InicialActivity;
import com.example.adonis.stackice.Model.Propaganda;
import com.example.adonis.stackice.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity implements Serializable {

    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private static List<Propaganda> list = new ArrayList<>();
    DatabaseReference ReferenciaPropagandas = database.child("Propagandas");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        propagandas();
        IniciaNovaActivity();


    }

    public void IniciaNovaActivity()
    {
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run() {

                    Intent intent = new Intent(getApplicationContext(),InicialActivity.class);
                    intent.putExtra("Lista",(Serializable) list);
                    startActivity(intent);

                }
            },3000);

    }

    public void propagandas()
    {
        ReferenciaPropagandas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {

                for (DataSnapshot childDataSnapshot: dataSnapshot.getChildren() ) {

                    Propaganda propaganda = new Propaganda(childDataSnapshot.getValue().toString());
                    list.add(propaganda);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError)
            {
            }
        });

    }
}
