package com.example.shelfapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.HttpURLConnection;

public class ShelfAppCheck extends AppCompatActivity {

    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf_app_check);
        output = (TextView) findViewById(R.id.outputtext);
        Button btnSS = (Button) findViewById(R.id.btnSS);

        btnSS.setOnClickListener(new OnClickListener() {
                @Override
                        public void onClick(View v){

                                new doit().execute();
            }
        });
    }

    public class doit extends AsyncTask<Void,Void,Void>{
            String wordsText;
        @Override
        protected Void doInBackground(Void...params){

            try {
                Document doc = Jsoup.connect("http://bc6b65ec.ngrok.io/stockits/string/5c974b672f02264964e672e3.html").get();
                wordsText=doc.text();
                output.setText(wordsText);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    /*
    Button btnSearch;
    TextView txtoutput;
    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = (Button) findViewById(R.id.btnSS);
        txtoutput = (TextView) findViewById(R.id.outputtext);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("http://bc6b65ec.ngrok.io/stockits/");
            }
        });


    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            //pd = new ProgressDialog(ShelfAppCheck.this);
            //pd.setMessage("Please wait");
            //pd.setCancelable(false);
            //pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url = new URL(//url here");
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader json = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //if (pd.isShowing()){
            //    pd.dismiss();
            //}
            txtoutput.setText(result);
        }
    }
    */
}
