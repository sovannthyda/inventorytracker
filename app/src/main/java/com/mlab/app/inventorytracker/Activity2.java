package com.mlab.app.inventorytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity{

    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();

    private TableLayout table;

    EditText edittext1, edittext2, edittext3, texttotal;
    Button buttonadd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        edittext3 = findViewById(R.id.edittext3);

        texttotal = findViewById(R.id.texttotal);

        buttonadd = findViewById(R.id.buttonadd);

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }

    public void add(){
        int total;
        String productname = edittext1.getText().toString();
        int price = Integer.parseInt(edittext2.getText().toString());
        int amount = Integer.parseInt(edittext3.getText().toString());

        total = price * amount;

        data.add(productname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(amount));
        data3.add(String.valueOf(total));

        TableLayout table = findViewById(R.id.table1);
        TableRow row = new TableRow(this);
        TextView t1 = new TextView(this);
        TextView t2 = new TextView(this);
        TextView t3 = new TextView(this);
        TextView t4 = new TextView(this);

        for(int i = 0; i < data.size() ; i++){
            String product = data.get(i);
            String pri = data1.get(i);
            String qty = data2.get(i);
            String tot = data3.get(i);

            t1.setText(product);
            t2.setText(pri);
            t3.setText(qty);
            t4.setText(tot);

        }

        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);

        edittext1.setText("");
        edittext2.setText("");
        edittext3.setText("");
        texttotal.setText("");
        edittext1.requestFocus();
    }

}
