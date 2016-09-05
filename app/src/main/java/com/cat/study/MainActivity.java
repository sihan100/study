package com.cat.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    private int m_index;

    //----------------------------------------------------------------------------------------------
    //UI
    private TextView tv_txt;
    private Button btn_next;
    //----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    //life cycle methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");

        find();
        render();
        bind();

        if(savedInstanceState!=null)
        {
            m_index = savedInstanceState.getInt(KEY_INDEX);
            Log.i(TAG, "m_index="+m_index);
            tv_txt.setText(String.valueOf(m_index));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        if(outState!=null)
        {
            outState.putInt(KEY_INDEX, m_index);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        destory();
    }

    //----------------------------------------------------------------------------------------------
    //customer methods
    //查找UI元素
    private void find()
    {
        tv_txt = (TextView) findViewById(R.id.tv_txt);
        btn_next = (Button) findViewById(R.id.btn_next);
    }

    //渲染UI
    private void render()
    {

    }

    //注册监听
    private void bind()
    {
        btn_next.setOnClickListener(clickListener);
    }

    //页面销毁
    private void destory()
    {

    }

    private void proc_next()
    {
        Log.i(TAG, "proc_next");
        tv_txt.setText(String.valueOf(++m_index));
    }
    //----------------------------------------------------------------------------------------------

    //Listener
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_next:
                    proc_next();
                    break;
                default:
                    break;
            }
        }
    };
    //----------------------------------------------------------------------------------------------
}
