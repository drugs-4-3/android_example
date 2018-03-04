package com.example.michal.myapplication;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private GridView gv1;
    private int elementsCount = 10;

    private void alignScroll() {
        int firstPos = gv1.getFirstVisiblePosition();
        int lastPos = gv1.getLastVisiblePosition();
        // if last element reached - let user see it
        if (lastPos == elementsCount - 1) {
            gv1.smoothScrollToPosition(lastPos);
        }
        else {
            gv1.smoothScrollToPosition(firstPos);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LayoutInflater li = getLayoutInflater();
        gv1 = findViewById(R.id.gv1);

        gv1.setAdapter(new ImageAdapter(getApplicationContext(), li, elementsCount));

        gv1.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == SCROLL_STATE_IDLE) {
                    alignScroll();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }
}
