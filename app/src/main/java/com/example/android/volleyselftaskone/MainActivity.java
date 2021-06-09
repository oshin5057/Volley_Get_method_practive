package com.example.android.volleyselftaskone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.volleyselftaskone.adapter.RecyclerViewAdapter;
import com.example.android.volleyselftaskone.model.Hero;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mAdapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        heroList = new ArrayList<>();

        loadHeroList();
    }

    private void loadHeroList() {

        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray heroArray = jsonObject.getJSONArray("heroes");
                            for (int i = 0; i < heroArray.length(); i++) {
                                JSONObject heroJsonObject = heroArray.getJSONObject(i);

                                Hero hero = new Hero(heroJsonObject.getString("name"), heroJsonObject.getString("imageurl"));
                                heroList.add(hero);

                            }
                            mAdapter = new RecyclerViewAdapter(heroList, getApplicationContext());
                            mRecyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}