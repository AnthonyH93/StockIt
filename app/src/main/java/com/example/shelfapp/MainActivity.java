package com.example.shelfapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private Button btnOSC;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    View a = findViewById(R.id.btnED);
                    a.setVisibility(View.GONE);
                    View b = findViewById(R.id.btnOSC);
                    b.setVisibility(View.VISIBLE);
                    View c = findViewById(R.id.btnNC);
                    c.setVisibility(View.GONE);
                    View k = findViewById(R.id.introtxt);
                    k.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_employees:
                    mTextMessage.setText(R.string.title_dashboard);
                    View d = findViewById(R.id.btnED);
                    d.setVisibility(View.VISIBLE);
                    View e = findViewById(R.id.btnOSC);
                    e.setVisibility(View.GONE);
                    View f = findViewById(R.id.btnNC);
                    f.setVisibility(View.GONE);
                    View l = findViewById(R.id.introtxt);
                    l.setVisibility(View.GONE);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    View h = findViewById(R.id.btnED);
                    h.setVisibility(View.GONE);
                    View i = findViewById(R.id.btnOSC);
                    i.setVisibility(View.GONE);
                    View j = findViewById(R.id.btnNC);
                    j.setVisibility(View.VISIBLE);
                    View m = findViewById(R.id.introtxt);
                    m.setVisibility(View.GONE);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public void openShelfCheck(View view){
        Intent openNewPage = new Intent(this,ShelfAppCheck.class);
        startActivity(openNewPage);

    }
    public void openEmpData(View view){
        Intent openNewPage = new Intent(this,EmployeeDatabase.class);
        startActivity(openNewPage);

    }
    public void openNotCent(View view){
        Intent openNewPage = new Intent(this,notification_center.class);
        startActivity(openNewPage);

    }
}
