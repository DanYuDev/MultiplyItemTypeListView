package com.example.coderlt.multiplyitemtypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG=getClass().getName();
    private ListView listView;
    private ListAdapter listAdapter;
    private List<ListItem> list;

    private ListItem[] array=new ListItem[]{new ListItem("余丹",ListItem.ItemType.TEXT),
                        new ListItem("玩文洋",ListItem.ItemType.BUTTON),
                        new ListItem("硕哥", ListItem.ItemType.EDIT),
                        new ListItem("程千书", ListItem.ItemType.BUTTON),
                        new ListItem("丹姐", ListItem.ItemType.TEXT),
                        new ListItem("老王", ListItem.ItemType.TEXT)};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();
        listView=findViewById(R.id.list_view);
        listAdapter=new ListAdapter(Arrays.asList(array),this);
        listView.setAdapter(listAdapter);
    }
}
