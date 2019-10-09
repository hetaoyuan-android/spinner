package com.yuan.testallmodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinnerSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinnerSimple = findViewById(R.id.spinner_simple);
        ChangeSpinner(mSpinnerSimple);
        mSpinnerSimple.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.e("spinner", "" + position);
                String s = mSpinnerSimple.getSelectedItem().toString();
                Log.e("spinner", "" + s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void ChangeSpinner(View v){
        mSpinnerSimple.setDropDownWidth(400); //下拉宽度
        mSpinnerSimple.setDropDownHorizontalOffset(100); //下拉的横向偏移
        mSpinnerSimple.setDropDownVerticalOffset(100); //下拉的纵向偏移
        //mSpinnerSimple.setBackgroundColor(AppUtil.getColor(instance,R.color.wx_bg_gray)); //下拉的背景色
        //spinner mode ： dropdown or dialog , just edit in layout xml
        //mSpinnerSimple.setPrompt("Spinner Title"); //弹出框标题，在dialog下有效


        String[] spinnerItems = {"10","200","400"};
        //自定义选择填充后的字体样式
        //只能是textview样式，否则报错：ArrayAdapter requires the resource ID to be a TextView
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this,
                R.layout.item_select, spinnerItems);
        //自定义下拉的字体样式
        spinnerAdapter.setDropDownViewResource(R.layout.item_drop);
        //这个在不同的Theme下，显示的效果是不同的
        //spinnerAdapter.setDropDownViewTheme(Theme.LIGHT);
        mSpinnerSimple.setAdapter(spinnerAdapter);
    }


}
