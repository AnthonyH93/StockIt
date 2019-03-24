package com.example.shelfapp;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;


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
                Document doc = Jsoup.connect("https://www.instructables.com/id/How-To-Create-An-Android-App-With-Android-Studio/").get();
                wordsText=doc.text();
                output.setText(wordsText);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}
