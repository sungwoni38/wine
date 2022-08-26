package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class BlogActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView img_before = findViewById(R.id.img_before);
        img_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        expandableListView = (ExpandableListView) findViewById(R.id.mylist);
        myGroup temp = new myGroup("카테고리 선택");
        temp.child.add("일 상");
        temp.child.add("와인평");
        DataList.add(temp);

        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), R.layout.group_row,R.layout.child_row, DataList);
        expandableListView.setIndicatorBounds(width-50, width); //코드 삭제 시 화살표 위치가 바뀜.
        expandableListView.setAdapter(adapter);
    }
}