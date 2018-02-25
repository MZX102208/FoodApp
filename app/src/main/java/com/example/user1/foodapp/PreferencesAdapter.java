package com.example.user1.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * Created by SriramHariharan on 2/25/18.
 */

public class PreferencesAdapter extends BaseAdapter implements View.OnClickListener{

    /**
     * Created by SriramHariharan on 2/25/18.
     */
        private Context context;
        private List<String> fbids;
        private static LayoutInflater inflater = null;


        public PreferencesAdapter(Context context, List<String> per){
            this.context = context;
            this.fbids = per;

            inflater = (LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public int getCount() {
            return fbids.size();
        }
        public Object getItem(int position) {
            return fbids.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public class Holder
        {
            TextView name;
            CheckBox check;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            Holder holder = new Holder();
            View rowView;
            rowView = inflater.inflate(R.layout.preference_layout, null);
            holder.name = rowView.findViewById(R.id.preferencename);
            holder.name.setText(fbids.get(position));
            holder.check = rowView.findViewById(R.id.prefcheck);
            return rowView;
        }

    @Override
    public void onClick(View view) {

    }
}
