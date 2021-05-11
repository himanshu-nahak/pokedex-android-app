package com.example.zokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewPokemon extends AppCompatActivity {

    public static int pokemon_id;
    public static String pName, genus, pType1, pType2;

    LinearLayout details_layout, typeLL, heightLL, weightLL, aboutLL;
    TextView pTitle, pHeight, pWeight, pFlavorText, pType;
    ImageView pDreamImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pokemon);

        details_layout = findViewById(R.id.details_layout);
        pTitle = findViewById(R.id.pTitle);
        pHeight = findViewById(R.id.pHeight);
        pWeight = findViewById(R.id.pWeight);
        pDreamImage = findViewById(R.id.pDreamImage);
        pFlavorText = findViewById(R.id.pFlavorText);
        pType = findViewById(R.id.pType);
        typeLL = findViewById(R.id.typeLL);
        heightLL = findViewById(R.id.heightLL);
        weightLL = findViewById(R.id.weightLL);
        aboutLL = findViewById(R.id.aboutLL);


        // GET SELECTED POKEMON'S ID
        Bundle bundle = getIntent().getExtras();
        pokemon_id = bundle.getInt("pId", 0);
        pokemon_id++;

        //SEND API REQUEST TO GET POKEMON DETAILS

        RequestQueue queue = Volley.newRequestQueue(ViewPokemon.this);
        String url ="https://pokeapi.co/api/v2/pokemon/"+ pokemon_id +"/";
        System.out.println("URL HIT::::" + url);

        JsonObjectRequest request = new JsonObjectRequest(url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    pType1="";
                    pType2="";


                    String tempName = response.getString("name");
                    pName = tempName.substring(0, 1).toUpperCase() + tempName.substring(1);
                    pTitle.setText(""+pokemon_id+" "+ pName);
                    getSupportActionBar().setTitle(pName);

                    pName = response.getString("name");
                    pHeight.setText(""+(0.1f  * response.getInt("height")) + "m");
                    pWeight.setText(""+(0.1f * response.getInt("weight")) + "kg");

                    //dreamart
                    JSONObject spritesObject = response.getJSONObject("sprites");
                    String front_default = spritesObject.getString("front_default");
                    JSONObject otherObject = spritesObject.getJSONObject("other");
                    JSONObject officialArtworkObject = otherObject.getJSONObject("official-artwork");
                    String officialArtworkFrontDefault = officialArtworkObject.getString("front_default");
                    Glide.with(ViewPokemon.this).load(officialArtworkFrontDefault).into(pDreamImage);


                    // GET POKEMON TYPES
                    JSONArray typesObjectArray = response.getJSONArray("types");
                    JSONObject slot1Object = typesObjectArray.getJSONObject(0);
                    JSONObject type1Object = slot1Object.getJSONObject("type");
                    pType1 = type1Object.getString("name");
                    System.out.println("1..."+pType1);

                    if (typesObjectArray.length() >1 ){
                        JSONObject slot2Object = typesObjectArray.getJSONObject(1);
                        JSONObject type2Object = slot2Object.getJSONObject("type");
                        pType2 = type2Object.getString("name");
                        // TODO Set to TextView
                        pType.setText(pType1.toUpperCase()+ " | " + pType2.toUpperCase());
                    }
                    else
                        pType.setText(pType1.toUpperCase());

                    switch (pType1){
                        case "grass":
                            details_layout.setBackgroundResource(R.drawable.grass_gradient);
                            typeLL.setBackgroundResource(R.drawable.grass_item_card);
                            heightLL.setBackgroundResource(R.drawable.grass_item_card);
                            weightLL.setBackgroundResource(R.drawable.grass_item_card);
                            aboutLL.setBackgroundResource(R.drawable.grass_item_card);
                            break;
                        case "fire":
                            details_layout.setBackgroundResource(R.drawable.fire_gradient);
                            typeLL.setBackgroundResource(R.drawable.fire_item_card);
                            heightLL.setBackgroundResource(R.drawable.fire_item_card);
                            weightLL.setBackgroundResource(R.drawable.fire_item_card);
                            aboutLL.setBackgroundResource(R.drawable.fire_item_card);
                            break;
                        case "water":
                            details_layout.setBackgroundResource(R.drawable.water_gradient);
                            typeLL.setBackgroundResource(R.drawable.water_item_card);
                            heightLL.setBackgroundResource(R.drawable.water_item_card);
                            weightLL.setBackgroundResource(R.drawable.water_item_card);
                            aboutLL.setBackgroundResource(R.drawable.water_item_card);
                            break;
                        case "rock":
                            details_layout.setBackgroundResource(R.drawable.rock_gradient);
                            typeLL.setBackgroundResource(R.drawable.rock_item_card);
                            heightLL.setBackgroundResource(R.drawable.rock_item_card);
                            weightLL.setBackgroundResource(R.drawable.rock_item_card);
                            aboutLL.setBackgroundResource(R.drawable.rock_item_card);
                            break;
                        case "ground":
                            details_layout.setBackgroundResource(R.drawable.ground_gradient);
                            typeLL.setBackgroundResource(R.drawable.ground_item_card);
                            heightLL.setBackgroundResource(R.drawable.ground_item_card);
                            weightLL.setBackgroundResource(R.drawable.ground_item_card);
                            aboutLL.setBackgroundResource(R.drawable.ground_item_card);
                            break;
                        case "bug":
                            details_layout.setBackgroundResource(R.drawable.bug_gradient);
                            typeLL.setBackgroundResource(R.drawable.bug_item_card);
                            heightLL.setBackgroundResource(R.drawable.bug_item_card);
                            weightLL.setBackgroundResource(R.drawable.bug_item_card);
                            aboutLL.setBackgroundResource(R.drawable.bug_item_card);
                            break;
                        case "ice":
                            details_layout.setBackgroundResource(R.drawable.ice_gradient);
                            typeLL.setBackgroundResource(R.drawable.ice_item_card);
                            heightLL.setBackgroundResource(R.drawable.ice_item_card);
                            weightLL.setBackgroundResource(R.drawable.ice_item_card);
                            aboutLL.setBackgroundResource(R.drawable.ice_item_card);
                            break;
                        case "steel":
                            details_layout.setBackgroundResource(R.drawable.steel_gradient);
                            typeLL.setBackgroundResource(R.drawable.steel_item_card);
                            heightLL.setBackgroundResource(R.drawable.steel_item_card);
                            weightLL.setBackgroundResource(R.drawable.steel_item_card);
                            aboutLL.setBackgroundResource(R.drawable.steel_item_card);
                            break;
                        case "electric":
                            details_layout.setBackgroundResource(R.drawable.electric_gradient);
                            typeLL.setBackgroundResource(R.drawable.electric_item_card);
                            heightLL.setBackgroundResource(R.drawable.electric_item_card);
                            weightLL.setBackgroundResource(R.drawable.electric_item_card);
                            aboutLL.setBackgroundResource(R.drawable.electric_item_card);
                            break;

                        case "flying":
                            details_layout.setBackgroundResource(R.drawable.flying_gradient);
                            typeLL.setBackgroundResource(R.drawable.flying_item_card);
                            heightLL.setBackgroundResource(R.drawable.flying_item_card);
                            weightLL.setBackgroundResource(R.drawable.flying_item_card);
                            aboutLL.setBackgroundResource(R.drawable.flying_item_card);
                            break;

                        case "psychic":
                            details_layout.setBackgroundResource(R.drawable.psychic_gradient);
                            typeLL.setBackgroundResource(R.drawable.psychic_item_card);
                            heightLL.setBackgroundResource(R.drawable.psychic_item_card);
                            weightLL.setBackgroundResource(R.drawable.psychic_item_card);
                            aboutLL.setBackgroundResource(R.drawable.psychic_item_card);
                            break;

                        case "ghost":
                            details_layout.setBackgroundResource(R.drawable.ghost_gradient);
                            typeLL.setBackgroundResource(R.drawable.ghost_item_card);
                            heightLL.setBackgroundResource(R.drawable.ghost_item_card);
                            weightLL.setBackgroundResource(R.drawable.ghost_item_card);
                            aboutLL.setBackgroundResource(R.drawable.ghost_item_card);
                            break;

                        case "normal":
                            details_layout.setBackgroundResource(R.drawable.normal_gradient);
                            typeLL.setBackgroundResource(R.drawable.normal_item_card);
                            heightLL.setBackgroundResource(R.drawable.normal_item_card);
                            weightLL.setBackgroundResource(R.drawable.normal_item_card);
                            aboutLL.setBackgroundResource(R.drawable.normal_item_card);
                            break;

                        case "fighting":
                            details_layout.setBackgroundResource(R.drawable.fighting_gradient);
                            typeLL.setBackgroundResource(R.drawable.fighting_item_card);
                            heightLL.setBackgroundResource(R.drawable.fighting_item_card);
                            weightLL.setBackgroundResource(R.drawable.fighting_item_card);
                            aboutLL.setBackgroundResource(R.drawable.fighting_item_card);
                            break;

                        case "dark":
                            details_layout.setBackgroundResource(R.drawable.dark_gradient);
                            typeLL.setBackgroundResource(R.drawable.dark_item_card);
                            heightLL.setBackgroundResource(R.drawable.dark_item_card);
                            weightLL.setBackgroundResource(R.drawable.dark_item_card);
                            aboutLL.setBackgroundResource(R.drawable.dark_item_card);
                            break;

                        case "poison":
                            details_layout.setBackgroundResource(R.drawable.poison_gradient);
                            typeLL.setBackgroundResource(R.drawable.poison_item_card);
                            heightLL.setBackgroundResource(R.drawable.poison_item_card);
                            weightLL.setBackgroundResource(R.drawable.poison_item_card);
                            aboutLL.setBackgroundResource(R.drawable.poison_item_card);
                            break;

                        case "fairy":
                            details_layout.setBackgroundResource(R.drawable.fairy_gradient);
                            typeLL.setBackgroundResource(R.drawable.fairy_item_card);
                            heightLL.setBackgroundResource(R.drawable.fairy_item_card);
                            weightLL.setBackgroundResource(R.drawable.fairy_item_card);
                            aboutLL.setBackgroundResource(R.drawable.fairy_item_card);
                            break;

                        case "dragon":
                            details_layout.setBackgroundResource(R.drawable.dragon_gradient);
                            typeLL.setBackgroundResource(R.drawable.dragon_item_card);
                            heightLL.setBackgroundResource(R.drawable.dragon_item_card);
                            weightLL.setBackgroundResource(R.drawable.dragon_item_card);
                            aboutLL.setBackgroundResource(R.drawable.dragon_item_card);
                            break;


                    }


                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewPokemon.this,"Error Occured", Toast.LENGTH_SHORT).show();
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


                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewPokemon.this,"Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
        queue.add(requestSpeciesData);




    }
}