package com.example.zokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PokemonInfo extends AppCompatActivity {

    TextView pTitle, pHeight, pWeight, pFlavorText, pGenus , pType;
    public static String pName, genus, pType1, pType2;
    public static int pokemon_id;
    ImageView pDreamImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_info);

        pTitle = findViewById(R.id.pTitle);
        pHeight = findViewById(R.id.pHeight);
        pWeight = findViewById(R.id.pWeight);
        pDreamImage = findViewById(R.id.pDreamImage);
        pFlavorText = findViewById(R.id.pFlavorText);
        pGenus = findViewById(R.id.pGenus);
        pType = findViewById(R.id.pType);

        // GET SELECTED POKEMON'S ID
        Bundle bundle = getIntent().getExtras();
        pokemon_id = bundle.getInt("pId", 0);
        pokemon_id++;

        //SEND API REQUEST TO GET POKEMON DETAILS

        RequestQueue queue = Volley.newRequestQueue(PokemonInfo.this);
        String url ="https://pokeapi.co/api/v2/pokemon/"+ pokemon_id +"/";
        System.out.println("URL HIT::::" + url);

        JsonObjectRequest request = new JsonObjectRequest(url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    pType1="";
                    pType2="";

                    pName = response.getString("name");
                    pTitle.setText(""+pokemon_id+" "+ pName);
                    getSupportActionBar().setTitle(pName);

                    pName = response.getString("name");
                    pHeight.setText(""+(0.1f  * response.getInt("height")) + "m");
                    pWeight.setText(""+(0.1 * response.getInt("weight")) + "kg");

                    //dreamart
                    JSONObject spritesObject = response.getJSONObject("sprites");
                    String front_default = spritesObject.getString("front_default");
                    JSONObject otherObject = spritesObject.getJSONObject("other");
                    JSONObject officialArtworkObject = otherObject.getJSONObject("official-artwork");
                    String officialArtworkFrontDefault = officialArtworkObject.getString("front_default");
                    Glide.with(PokemonInfo.this).load(officialArtworkFrontDefault).into(pDreamImage);


                    // GET POKEMON TYPES
                    JSONArray typesObjectArray = response.getJSONArray("types");
                    JSONObject slot1Object = typesObjectArray.getJSONObject(0);
                    JSONObject type1Object = slot1Object.getJSONObject("type");
                    pType1 = type1Object.getString("name");


                    if (typesObjectArray.length() >1 ){
                        JSONObject slot2Object = typesObjectArray.getJSONObject(1);
                        JSONObject type2Object = slot2Object.getJSONObject("type");
                        pType2 = type2Object.getString("name");
                        // TODO Set to TextView
                        pType.setText(pType1.toUpperCase()+ " | " + pType2.toUpperCase());
                    }
                    else
                        pType.setText(pType1.toUpperCase());

                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PokemonInfo.this,"Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
        String urlSpecies = "https://pokeapi.co/api/v2/pokemon-species/" + pokemon_id + "/";


        JsonObjectRequest requestSpeciesData = new JsonObjectRequest(urlSpecies,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray flavor_text_entriesArray = response.getJSONArray("flavor_text_entries");
                    JSONObject flavorTextEntry = flavor_text_entriesArray.getJSONObject(1);
                    String flavorText = flavorTextEntry.getString("flavor_text");
                    flavorText = flavorText.replace("\n", " ");
                    flavorText = flavorText.replace("\\u000", " ");

                    pFlavorText.setText(flavorText);

                    JSONArray generaObject = response.getJSONArray("genera");
                    JSONObject generaEntry = generaObject.getJSONObject(7);
                    genus = generaEntry.getString("genus");
                    pGenus.setText(pName + " is a "+genus.toUpperCase());


                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PokemonInfo.this,"Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
        queue.add(requestSpeciesData);








    }


}