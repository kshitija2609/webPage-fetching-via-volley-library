package com.example.admin.volley_fetching_a_webpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myurl="https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol";
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());

                StringRequest stringRequest=new StringRequest(Request.Method.POST, myurl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("Web","Web page is"+response);
                            }


                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error","Error is"+error);

                    }
                }
                );
                //requestQueue.add(stringRequest);
                MySingleTon.getInstance(MainActivity.this).addToRequestQue(stringRequest);

            }
        });
    }
}
