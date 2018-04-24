package com.example.gamma.lab05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    Intent i;
    private NetworkManager networkManager;
    String toke;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("Sesion", MODE_PRIVATE);
        networkManager = NetworkManager.getInstance(this);
        i = new Intent(this, formula.class);




    }

    public void onLoginClick(View view) {
        EditText email = (EditText) findViewById(R.id.Email);
        String mail = email.getText().toString();
        EditText password = (EditText) findViewById(R.id.Password);
        String pass = password.getText().toString();

        try {
            networkManager.login(mail, pass, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    getForms();
                    String forms = response.toString();
                    String toke = NetworkManager.token;
                    toke = NetworkManager.token;
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("sesion", toke );
                    editor.commit();
                    i.putExtra("respon", forms);
                    i.putExtra("token", toke);
                    startActivity(i);



                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO: Handle error
                    System.out.println(error);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }


    private void getForms(){
        networkManager.getForms(new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                System.out.println(error);
            }
        });
    }
}
