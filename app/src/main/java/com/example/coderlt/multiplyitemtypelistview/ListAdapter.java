package com.example.coderlt.multiplyitemtypelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by coderlt on 2018/1/9.
 */

public class ListAdapter extends ArrayAdapter {
    List<ListItem> mList;
    Context mContext;

    public ListAdapter(){
        this(null,null);
    }

    public ListAdapter(List<ListItem> list, Context context){
        super(context,0,list);
        mList=list;
        mContext=context;
    }

    // 这个 VH 其实可以分解为几个不同的 VH ，但是这里由于布局较简单，就用一个 VH ，在里面分支判断一下，逻辑
    // 显得简单点。
    static class VH{
        TextView tv;
        Button   btn;
        EditText et;
        public VH(View v,int itemType){
            switch (itemType){
                case ListItem.ItemType.TEXT:
                    tv=v.findViewById(R.id.text_item);
                    break;
                case ListItem.ItemType.BUTTON:
                    btn=v.findViewById(R.id.button_item);
                    break;
                case ListItem.ItemType.EDIT:
                    et=v.findViewById(R.id.edit_item);
                    break;
                default:
                    break;
            }
        }
    }

    // 进行数据绑定，并且返回 View，这个过程会对视图渲染有影响
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        View v=null;
        VH  vh=null;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        ListItem item=(ListItem) getItem(position);

        int type=item.getType();
        String name=item.getName();

        switch (type){
            case ListItem.ItemType.TEXT:
                if(convertView==null){
                    v=inflater.inflate(R.layout.text_item,null);
                    vh=new VH(v,ListItem.ItemType.TEXT);
                    v.setTag(vh);
                }else{
                    // listView 内部已经处理，这个convetView要么是null，要么就是对应的 type
                    v=convertView;
                    vh=(VH)convertView.getTag();
                }
                vh.tv.setText(name);
                break;

            case ListItem.ItemType.EDIT:
                if(convertView==null){
                    v=inflater.inflate(R.layout.edit_item,null);
                    vh=new VH(v,ListItem.ItemType.EDIT);
                    v.setTag(vh);
                }else{
                    // listView 内部已经处理，这个convetView要么是null，要么就是对应的 type
                    v=convertView;
                    vh=(VH)convertView.getTag();
                }
                vh.et.setText(name);
                break;

            case ListItem.ItemType.BUTTON:
                if(convertView==null){
                    v=inflater.inflate(R.layout.button_item,null);
                    vh=new VH(v,ListItem.ItemType.BUTTON);
                    v.setTag(vh);
                }else{
                    // listView 内部已经处理，这个convetView要么是null，要么就是对应的 type
                    v=convertView;
                    vh=(VH)convertView.getTag();
                }
                vh.btn.setText(name);
                break;

            default:
                break;
        }
        return v;
    }

    @Override
    public int getItemViewType(int position){
        return mList.get(position).getType();
    }

    @Override
    public int getViewTypeCount(){
        return  mList.size();
    }
}
