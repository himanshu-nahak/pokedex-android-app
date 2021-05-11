package com.example.zokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();

        gridView = findViewById(R.id.grid_view);

        gridView.setAdapter(new ImageAdapter(this));



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
//                Intent intent = new Intent(getApplicationContext(), PokemonInfo.class);
                Intent intent = new Intent(getApplicationContext(), ViewPokemon.class);

                Bundle bundle = new Bundle();
                bundle.putInt("pId", position);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }
}