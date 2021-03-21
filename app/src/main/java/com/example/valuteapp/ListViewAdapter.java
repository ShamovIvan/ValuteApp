package com.example.valuteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class ListViewAdapter  extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> valuteList;
    Context context;

    public ListViewAdapter(Context context, int listLayout , int field, ArrayList<JSONObject> valuteList) {
        super(context, listLayout, field, valuteList);
        this.context = context;
        this.listLayout = listLayout;
        this.valuteList = valuteList;
    }

    /*
    "ID": "R01010",
    "NumCode": "036",
    "CharCode": "AUD",
    "Nominal": 1,
     "Name": "Австралийский доллар",
     "Value": 57.6007,
     "Previous": 56.5078
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listViewItem = inflater.inflate(listLayout, null, false);
        TextView ID = listViewItem.findViewById(R.id.textViewID);
        TextView NumCode = listViewItem.findViewById(R.id.textViewNumCode);
        TextView CharCode = listViewItem.findViewById(R.id.textViewCharCode);
        TextView Nominal = listViewItem.findViewById(R.id.textViewNominal);
        TextView Name = listViewItem.findViewById(R.id.textViewName);
        TextView Value = listViewItem.findViewById(R.id.textViewValue);
        TextView Previous = listViewItem.findViewById(R.id.textViewPrevious);

        try{
            ID.setText("Valute ID: " + valuteList.get(position).getString("ID"));
            NumCode.setText("NumCode: " + valuteList.get(position).getString("NumCode"));
            CharCode.setText("CharCode: " + valuteList.get(position).getString("CharCode"));
            Nominal.setText("Nominal: " + valuteList.get(position).getString("Nominal"));
            Name.setText("Name: " + valuteList.get(position).getString("Name"));
            Value.setText("Value: " + valuteList.get(position).getString("Value"));
            Previous.setText("Previous: " + valuteList.get(position).getString("Previous"));
        }catch (JSONException je){
            je.printStackTrace();
        }
        return listViewItem;
    }

}