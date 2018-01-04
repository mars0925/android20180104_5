package com.mars.android20180104_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner sp ,sp2;
    ArrayList<String> str;
    //String str [];
    TextView tv, tv2,tv3;
    Button btn,btn2,btn3;
    EditText ed;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sp = (Spinner)findViewById(R.id.spinner);
        sp2 = (Spinner)findViewById(R.id.spinner2);
         //str = new String[]{"AAA","BBB","CCC"};
        tv = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        ed = (EditText)findViewById(R.id.editText);
        str = new ArrayList<>();
        str.add("AA");
        str.add("BB");
        str.add("CC");
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,str);
        sp.setAdapter(adapter);
        //1.依照選得內容顯示在TEXTVIEW
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //tv.setText(str.get(i));
                tv.setText(sp.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //2.取出選擇的值
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pos = sp.getSelectedItemPosition();//找到選項的索引瑪
                tv2.setText(str.get(pos));//顯示出ArrayList的內容;
            }
        });

        //3.新增選項到Spinner
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            //ArrayList是可以變動的 直接加內容 spinner選項就會改變
            public void onClick(View view) {
                str.add(String.valueOf(ed.getText()));
                adapter.notifyDataSetChanged();//通知Listview內容有改變
            }
        });

        //4.刪除選項
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = sp.getSelectedItemPosition();//找到選項的索引瑪
                str.remove(pos);//刪除listview索引瑪內容
                adapter.notifyDataSetChanged();//通知Listview內容有改變

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str[] = getResources().getStringArray(R.array.cities);//可以取出res的資源
                tv3.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,str[i],Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}


