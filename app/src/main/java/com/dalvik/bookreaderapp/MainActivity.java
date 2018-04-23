package com.dalvik.bookreaderapp;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dalvik.bookreaderapp.adapter.BookAdapter;
import com.dalvik.bookreaderapp.model.Book;
import com.dalvik.bookreaderapp.utils.PermissionUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alckon on 22/04/16.
 * Copyright Todos los Derechos Reservados | Dalvik 2016
 * Desarrollador: Osmar I. Cancino <o.cancinodiaz@gmail.com>
 */

public class MainActivity extends AppCompatActivity {

    private Gson gson = new Gson();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1;

    PermissionUtils permissionUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        getData();
    }

    private void initComponents() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        lManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lManager);

        permissionUtils = new PermissionUtils();

    }

    public void getData() {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url ="http://YOU_SERVER_URL/movil/web/get_books.php";
        JsonObjectRequest req = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int status = response.getInt("estado");
                            if(status == 1) {
                                JSONArray booksResponse = response.getJSONArray("libros");
                                Book[] booksArray = gson.fromJson(response != null ? booksResponse.toString() : null, Book[].class);

                                ArrayList<Book> books = new ArrayList<>(Arrays.asList(booksArray));

                                adapter = new BookAdapter(MainActivity.this, books);
                                recyclerView.setAdapter(adapter);
                            } else {
                                Toast.makeText(getApplicationContext(), response.getString("mensaje"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });
        requestQueue.add(req);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Snackbar.make(urlTextInputLayout, "Permission Granted, Now you can write storage.", Snackbar.LENGTH_LONG).show();
                } else {
                    //Snackbar.make(urlTextInputLayout, "Permission Denied, You cannot access storage.", Snackbar.LENGTH_LONG).show();
                }
                break;
        }
    }

}
