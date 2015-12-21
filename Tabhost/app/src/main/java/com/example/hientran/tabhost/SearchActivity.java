package com.example.hientran.tabhost;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hientran on 12/17/2015.
 */
public class SearchActivity extends Activity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // ánh xạ nó
        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.txtsearch);
        initList();


        // bắt sự kiện khi text trong edittext thay đổi
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            // hàm trước khi thay đổi
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {
            }
            @Override
            // hàm trong khi thay đổi
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                if (s.toString().toLowerCase().equals("")) {
                    // reset listview
                    initList();
                } else {
                    // perform search
                    searchItem(s.toString());
                }
            }

            @Override
            //hàm sau khi thay đổi
            public void afterTextChanged(Editable s) {
            }
        });

    }

    public void searchItem(String textToSearch) {
        for (String item : items) {
            if (!item.contains(textToSearch)) {
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList() {
        items = new String[]{"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                "iPhone 4S", "Samsung Galaxy Note 800",
                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(this,
                R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);
    }

}
