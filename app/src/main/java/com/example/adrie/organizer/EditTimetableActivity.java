package com.example.adrie.organizer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;

public class EditTimetableActivity extends Activity {
    TimetableInformation mTimetableInformation = (TimetableInformation) getApplication();
    @BindViews({R.id.Lv_Monday, R.id.Lv_Tuesday, R.id.Lv_Wednesday, R.id.Lv_Thursday, R.id.Lv_Friday})
    List<ListView> myListViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_timetable);
        ButterKnife.bind(this);
        FileManagement fileManagement = new FileManagement(this, "Timetable");
        setEmptyTimetable();

//        Date h = new Date();
//        Date m = new Date();
//        Class c = new Class("ffffff", "L2.1", "Monday", h, m, "Prof");
//
//        Class c2 = new Class("NOTNULL", "L2.1", "Monday", h, m, "Prof");
//
//        classes.listClasse.add(c2);
//        classes.listClasse.add(c);
//        //instantiate custom adapter
//        MyAdapterMonday adapter = new MyAdapterMonday(classes.listClasse, this);
//
//        //handle listview and assign adapter
//        ListView lViewMonday = (ListView) findViewById(R.id.Lv_Monday);
//
//        lViewMonday.setAdapter(adapter);
    }

    public void setEmptyTimetable() {
        ArrayList<Class> emptyList = new ArrayList<Class>();

        Class empty = new Class("empty", "", "", -1, -1, "");
        emptyList.add(empty);
        MyAdapter adapterMonday = new MyAdapter(emptyList, this, "Monday");
        MyAdapter adapterTuesday = new MyAdapter(emptyList, this, "Tuesday");
        MyAdapter adapterWednesday = new MyAdapter(emptyList, this, "Wednesday");
        MyAdapter adapterThursday = new MyAdapter(emptyList, this, "Thursday");
        MyAdapter adapterFriday = new MyAdapter(emptyList, this, "Friday");
        myListViews.get(0).setAdapter(adapterMonday);
        myListViews.get(1).setAdapter(adapterTuesday);
        myListViews.get(2).setAdapter(adapterWednesday);
        myListViews.get(3).setAdapter(adapterThursday);
        myListViews.get(4).setAdapter(adapterFriday);
    }

    public class MyAdapter extends BaseAdapter implements ListAdapter {
        private ArrayList<Class> list = new ArrayList<Class>();
        private Context context;
        private String name;

        public MyAdapter(ArrayList<Class> list, Context context, String name) {
            this.list = list;
            this.context = context;
            this.name = name;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int pos) {
            return list.get(pos);
        }

        @Override
        public long getItemId(int pos) {
            long op = 0;
            return op;//list.get(pos).get;
            //just return 0 if your list items do not have an Id variable.
        }

        public String getName() {
            return name;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_item_timetable, null);
            }


            //Handle buttons and add onClickListeners
            Button editBtn = (Button) view.findViewById(R.id.bt_timetable_class);
            editBtn.setText(list.get(position).getName());    // LOGICADE POR O NOMEDE CADACLASSE

            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //do something
                    if (list.get(position).getName() == "empty") {
                        Intent intent = new Intent(getApplicationContext(), EditClasseActivity.class);
                        intent.putExtra("DAY", getName());
                        intent.putExtra("STATUS", false);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), getName(), Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), EditClasseActivity.class);
                        intent.putExtra("BUTTON", position);
                        intent.putExtra("STATUS", true);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "notEmpty", Toast.LENGTH_LONG).show();
                    }


                }
            });

            return view;
        }
    }
}
