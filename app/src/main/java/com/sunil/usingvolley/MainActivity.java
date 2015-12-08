package com.sunil.usingvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String urlstring;         // string request url
    String urlstringjsonarray;          // json array request url
    String urlstringjsonarray1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ---------------------------------------string request ----------------------------------------------------------

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlstring, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("response message ", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("some ", "error occured");
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);

        //----------------------------------json request ---------------------------------------------------------------

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlstringjsonarray, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("respons jsonarray is ", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);

        // -------------------------------- post request -----------------------------------------------------------------

        JsonArrayRequest jsonArrayRequest1 = new JsonArrayRequest(Request.Method.POST, urlstringjsonarray1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("new responsed jsonarray is ", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String, String> params = new HashMap<>();
                // the POST parameters:
                params.put("cid", "3");
                //params.put("network", "tutsplus");
                return params;
                //return super.getParams();
            }
        };
        Volley.newRequestQueue(this).add(jsonArrayRequest1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
