package com.example.miawmiawneega;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    public static final String URL = "http://192.168.1.153/nyoba/select.php";
    public static Bitmap[] bitmaps;
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> items = new ArrayList<Data>();
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        list = (ListView) findViewById(R.id.list);
        adapter = new Adapter(MainActivity.this, items);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener(this);

        swipe.post(new Runnable() {
            @Override
            public void run(){
                swipe.setRefreshing(true);
                items.clear();
                adapter.notifyDataSetChanged();
                callVolley();
            }
        });
    }

    @Override
    public void onRefresh() {
        items.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }

    private void callVolley() {
        items.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        JsonArrayRequest jArr = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Data item = new Data();

                        item.setPic(obj.getString("pic"));
                        item.setId(obj.getString("id"));
                        item.setNama(obj.getString("nama"));
                        item.setAlamat(obj.getString("alamat"));
                        item.setTgl_lahir(obj.getString("tgl_lahir"));

                        items.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                adapter.notifyDataSetChanged();

                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error: " + error.getMessage());
                swipe.setRefreshing(false);
            }
    });

        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mRequestQueue.add(jArr);

    }


}

