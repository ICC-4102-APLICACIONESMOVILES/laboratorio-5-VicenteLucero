package com.example.gamma.lab05;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
    private NetworkManager networkManager;
    String toke;
    String sesion;
    String formas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkManager = NetworkManager.getInstance(this);



    }

    public void onLoginClick(View view){
        EditText email = (EditText)findViewById(R.id.Email);
        String mail = email.getText().toString();
        EditText password = (EditText)findViewById(R.id.Password);
        String pass = password.getText().toString();

        try {
            networkManager.login(mail, pass, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    getForms();
                    String toke = NetworkManager.token;

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
        toke = NetworkManager.token;
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(toke, sesion );
        editor.apply();
        //formas = getForms(new Response.Listener<JSONObject>();


    }

    public void onLOGOUTClick(View view)
    {

        SharedPreferences.Editor editor = pref.edit();
        editor.remove(toke);
        editor.apply();

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
        //return response;
    }
}
