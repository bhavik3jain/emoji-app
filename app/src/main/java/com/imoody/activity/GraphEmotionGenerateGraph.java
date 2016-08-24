package com.imoody.activity;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.imoody.R;

import java.util.ArrayList;

public class GraphEmotionGenerateGraph extends Fragment {

    View rootView;
    int timeVal;
    ArrayList<Integer> drawable = new ArrayList<>();
    ArrayList<String> moods = new ArrayList<>();

    public GraphEmotionGenerateGraph() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_graphs_generate, container, false);
        moods = emotion_name();
        drawable = emotion_id();
        if(moods.size() > 0){
            for(int i = moods.size(); i < 5; i++){
                moods.add("");
                drawable.add(R.color.windowBackground);
            }
        }
        else{
            moods = new ArrayList<>();
            drawable = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                moods.add("");
                drawable.add(R.color.windowBackground);
            }
        }
        TextView t0 = (TextView) rootView.findViewById(R.id.user_profile_short_bio1);
        TextView t1 = (TextView) rootView.findViewById(R.id.graphType);

        if (MainActivity.graphChoice == 3) {
            t0.setText("Lifetime Averages");
        }

        switch (MainActivity.dateType) {
            case 1:
                t0.setText("One Day Data");
                timeVal = 1;
                break;
            case 2:
                t0.setText("One Week Data");
                timeVal = 2;
                break;
            case 3:
                t0.setText("One Month Data");
                timeVal = 3;
                break;
            case 4:
                t0.setText("Three Month Data");
                timeVal = 4;
                break;
            case 5:
                t0.setText("Six Month Data");
                timeVal = 5;
                break;
            case 6:
                t0.setText("One Year Data");
                timeVal = 6;
                break;
        }

        switch (MainActivity.graphChoice) {
            case 1:
                t1.setText("Bar Graph");
                if (MainActivity.dateType == 1) {
                    createDailyBarChart();
                } else if (MainActivity.dateType == 2) {
                    createWeekBarChart();
                } else if (MainActivity.dateType == 3) {
                    createMonthBarChart();
                } else if (MainActivity.dateType == 4) {
                    create3MonthBarChart();
                } else if (MainActivity.dateType == 5) {
                    create6MonthBarChart();
                } else if (MainActivity.dateType == 6) {
                    createYearBarChart();
                }
                break;
            case 2:
                t1.setText("Line Chart");
                if (MainActivity.dateType == 1) {
                    createDailyLineChart();
                } else if (MainActivity.dateType == 2) {
                    createWeekLineChart();
                } else if (MainActivity.dateType == 3) {
                    createMonthLineChart();
                } else if (MainActivity.dateType == 4) {
                    create3MonthLineChart();
                } else if (MainActivity.dateType == 5) {
                    create6MonthLineChart();
                } else if (MainActivity.dateType == 6) {
                    createYearLineChart();
                }
                break;
            case 3:
                t1.setText("Pie Chart");
                createPieChart();
                break;
        }
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private int getPieYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '1'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '2'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '3'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '4'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '5'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '6'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '7'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '8'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '9'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == 10) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '10'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == drawable.get(0)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '" + drawable.get(0) + "'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == drawable.get(1)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '" + drawable.get(1) + "'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == drawable.get(2)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '" + drawable.get(2) + "'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == drawable.get(3)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '" + drawable.get(3) + "'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else if (val == drawable.get(4)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE emotion_id = '" + drawable.get(4) + "'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return 0;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            int avg = 0;
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum = sum + Integer.valueOf(arr.get(i));
            }
            avg = sum / arr.size();
            return avg;
        } else {
            return 0;
        }
    }

    private void createPieChart() {
        PieChart pieChart = (PieChart) rootView.findViewById(R.id.piechart);
        pieChart.setVisibility(View.VISIBLE);
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        if (MainActivity.Gcb1Val == 1) {
            int a = getPieYValues(1);
            if (a != 0) {
                entries.add(new Entry(a, 0));
                labels.add("Fear");
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            int a = getPieYValues(2);
            if (a != 0) {
                entries.add(new Entry(a, 1));
                labels.add("Anger");
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            int a = getPieYValues(3);
            if (a != 0) {
                entries.add(new Entry(a, 2));
                labels.add("Sadness");
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            int a = getPieYValues(4);
            if (a != 0) {
                entries.add(new Entry(a, 3));
                labels.add("Joy");
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            int a = getPieYValues(5);
            if (a != 0) {
                entries.add(new Entry(a, 4));
                labels.add("Disgust");
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            int a = getPieYValues(6);
            if (a != 0) {
                entries.add(new Entry(a, 5));
                labels.add("Trust");
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            int a = getPieYValues(7);
            if (a != 0) {
                entries.add(new Entry(a, 6));
                labels.add("Anticipation");
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            int a = getPieYValues(8);
            if (a != 0) {
                entries.add(new Entry(a, 7));
                labels.add("Surprised");
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            int a = getPieYValues(9);
            if (a != 0) {
                entries.add(new Entry(a, 8));
                labels.add("Love");
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            int a = getPieYValues(9);
            if (a != 0) {
                entries.add(new Entry(a, 9));
                labels.add("Remorse");
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            int a = getPieYValues(drawable.get(0));
            if (a != 0) {
                entries.add(new Entry(a, 10));
                labels.add(moods.get(0));
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            int a = getPieYValues(drawable.get(1));
            if (a != 0) {
                entries.add(new Entry(a, 11));
                labels.add(moods.get(1));
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            int a = getPieYValues(drawable.get(2));
            if (a != 0) {
                entries.add(new Entry(a, 12));
                labels.add(moods.get(2));
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            int a = getPieYValues(drawable.get(3));
            if (a != 0) {
                entries.add(new Entry(a, 13));
                labels.add(moods.get(3));
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            int a = getPieYValues(drawable.get(4));
            if (a != 0) {
                entries.add(new Entry(a, 14));
                labels.add(moods.get(4));
            }
        }

        PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(labels, dataset);
        pieChart.setData(data);

        pieChart.setDescription("Shows the Averages of Your Emotions");
    }

    private ArrayList<String> getDayXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT DISTINCT entryTime FROM " + TABLE_NAME + " WHERE entryDate=CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("entryTime"));
                a = a.substring(0, 5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> getDayYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '1'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '2'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '3'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '4'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '5'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '6'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '7'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '8'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '9'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == 10) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '10'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == drawable.get(0)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '"+drawable.get(0)+"'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == drawable.get(1)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '"+drawable.get(1)+"'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == drawable.get(2)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '"+drawable.get(2)+"'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == drawable.get(3)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '"+drawable.get(3)+"'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if (val == drawable.get(4)) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE entryDate = CURRENT_DATE AND emotion_id = '"+drawable.get(4)+"'";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("dataValue")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<String>();
        }
    }

    private void createDailyLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7;
        LineDataSet setComp8, setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getDayXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getDayYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp1.add(new Entry(Integer.valueOf(e1.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getDayYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp2.add(new Entry(Integer.valueOf(e2.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getDayYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp3.add(new Entry(Integer.valueOf(e3.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getDayYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp4.add(new Entry(Integer.valueOf(e4.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getDayYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp5.add(new Entry(Integer.valueOf(e5.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getDayYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp6.add(new Entry(Integer.valueOf(e6.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getDayYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp7.add(new Entry(Integer.valueOf(e7.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getDayYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp8.add(new Entry(Integer.valueOf(e8.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getDayYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp9.add(new Entry(Integer.valueOf(e9.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getDayYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp10.add(new Entry(Integer.valueOf(e10.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getDayYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp11.add(new Entry(Integer.valueOf(e11.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getDayYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp12.add(new Entry(Integer.valueOf(e12.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getDayYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp13.add(new Entry(Integer.valueOf(e13.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getDayYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp14.add(new Entry(Integer.valueOf(e14.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getDayYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp15.add(new Entry(Integer.valueOf(e15.get(i)), i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp10, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void createDailyBarChart() {
        BarChart barChart = (BarChart) rootView.findViewById(R.id.barchart);
        barChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getDayXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getDayYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp1.add(new BarEntry(Integer.valueOf(e1.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getDayYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp2.add(new BarEntry(Integer.valueOf(e2.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getDayYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp3.add(new BarEntry(Integer.valueOf(e3.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getDayYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp4.add(new BarEntry(Integer.valueOf(e4.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getDayYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp5.add(new BarEntry(Integer.valueOf(e5.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getDayYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp6.add(new BarEntry(Integer.valueOf(e6.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getDayYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp7.add(new BarEntry(Integer.valueOf(e7.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getDayYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp8.add(new BarEntry(Integer.valueOf(e8.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getDayYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp9.add(new BarEntry(Integer.valueOf(e9.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getDayYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp10.add(new BarEntry(Integer.valueOf(e10.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getDayYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp11.add(new BarEntry(Integer.valueOf(e11.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getDayYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp12.add(new BarEntry(Integer.valueOf(e12.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getDayYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp13.add(new BarEntry(Integer.valueOf(e13.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getDayYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp14.add(new BarEntry(Integer.valueOf(e14.get(i)), i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getDayYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    valsComp15.add(new BarEntry(Integer.valueOf(e15.get(i)), i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = barChart.getXAxis();
        YAxis ylaxis = barChart.getAxisLeft();
        YAxis yraxis = barChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = barChart.getLegend();
        legend.setWordWrapEnabled(true);

        barChart.setData(data);
        barChart.invalidate();
    }

    private ArrayList<String> getWeekXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT DISTINCT entryDate FROM " + TABLE_NAME + " where entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("entryDate"));
                a = a.substring(5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> getWeekYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '1' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '2' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '3' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '4' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '5' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '6' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '7' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '8' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '9' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if(val == 10){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '10' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(0)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(0)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(1)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(1)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(3)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(3)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(4)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(4)+"' and entryDate between date(CURRENT_DATE, '-7 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<>();
        }
    }

    private void createWeekLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        LineDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getWeekXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getWeekYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getWeekYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getWeekYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getWeekYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getWeekYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getWeekYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getWeekYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getWeekYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getWeekYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getWeekYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getWeekYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getWeekYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getWeekYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getWeekYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getWeekYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new Entry(b, i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void createWeekBarChart() {
        BarChart barChart = (BarChart) rootView.findViewById(R.id.barchart);
        barChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getWeekXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getWeekYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getWeekYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getWeekYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getWeekYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getWeekYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getWeekYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getWeekYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getWeekYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getWeekYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getWeekYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getWeekYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getWeekYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getWeekYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getWeekYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getWeekYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new BarEntry(b, i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp10, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = barChart.getXAxis();
        YAxis ylaxis = barChart.getAxisLeft();
        YAxis yraxis = barChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = barChart.getLegend();
        legend.setWordWrapEnabled(true);

        barChart.setData(data);
        barChart.invalidate();
    }

    private ArrayList<String> getMonthXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT DISTINCT entryDate FROM " + TABLE_NAME + " where entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("entryDate"));
                a = a.substring(5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> getMonthYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '1' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '2' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '3' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '4' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '5' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '6' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '7' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '8' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '9' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if(val == 10){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '10' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(0)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(0)+"' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(1)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(1)+"' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(3)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(3)+"' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(4)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(4)+"' and entryDate between date(CURRENT_DATE, '-28 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<>();
        }
    }

    private void createMonthLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        LineDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getMonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getMonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getMonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getMonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getMonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getMonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getMonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getMonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getMonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getMonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getMonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getMonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getMonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getMonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getMonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getMonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new Entry(b, i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void createMonthBarChart() {
        BarChart lineChart = (BarChart) rootView.findViewById(R.id.barchart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getMonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getMonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getMonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getMonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getMonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getMonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getMonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getMonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getMonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getMonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getMonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getMonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getMonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getMonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getMonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getMonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new BarEntry(b, i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private ArrayList<String> get3MonthXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT DISTINCT entryDate FROM " + TABLE_NAME + " where entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("entryDate"));
                a = a.substring(5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> get3MonthYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '1' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '2' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '3' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '4' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '5' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '6' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '7' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '8' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '9' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if(val == 10){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '10' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(0)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(0)+"' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(1)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(1)+"' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(3)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(3)+"' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(4)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT entryDate, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(4)+"' and entryDate between date(CURRENT_DATE, '-90 days') and CURRENT_DATE GROUP BY entryDate, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<>();
        }
    }

    private void create3MonthLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        LineDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = get3MonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = get3MonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = get3MonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = get3MonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = get3MonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = get3MonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = get3MonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = get3MonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = get3MonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = get3MonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = get3MonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = get3MonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = get3MonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = get3MonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = get3MonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = get3MonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new Entry(b, i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void create3MonthBarChart() {
        BarChart lineChart = (BarChart) rootView.findViewById(R.id.barchart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = get3MonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = get3MonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = get3MonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = get3MonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = get3MonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = get3MonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = get3MonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = get3MonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = get3MonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = get3MonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = get3MonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = get3MonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = get3MonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = get3MonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = get3MonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = get3MonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new BarEntry(b, i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private ArrayList<String> get6MonthXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as vals FROM " + TABLE_NAME + " where entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("vals"));
                a = a.substring(1, 2) + "/" + a.substring(5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> get6MonthYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '1' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '2' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '3' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '4' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '5' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '6' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '7' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '8' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '9' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if(val == 10){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '10' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(0)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(0)+"' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(1)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(1)+"' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(3)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(3)+"' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(4)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(4)+"' and entryDate between date(CURRENT_DATE, '-6 months') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<>();
        }
    }

    private void create6MonthLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        LineDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;

        ArrayList<String> a1 = get6MonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = get6MonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = get6MonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = get6MonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = get6MonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = get6MonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = get6MonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = get6MonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = get6MonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = get6MonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = get6MonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = get6MonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = get6MonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = get6MonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = get6MonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = get6MonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new Entry(b, i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void create6MonthBarChart() {
        BarChart lineChart = (BarChart) rootView.findViewById(R.id.barchart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;

        ArrayList<String> a1 = get6MonthXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = get6MonthYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = get6MonthYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = get6MonthYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = get6MonthYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = get6MonthYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = get6MonthYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = get6MonthYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = get6MonthYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = get6MonthYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = get6MonthYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = get6MonthYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = get6MonthYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = get6MonthYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = get6MonthYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = get6MonthYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new BarEntry(b, i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);

        lineChart.setData(data);
        lineChart.invalidate();
    }

    private ArrayList<String> getYearXValues() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_log";
        String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as vals FROM " + TABLE_NAME + " where entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE";
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String a = cursor.getString(cursor.getColumnIndex("vals"));
                a = a.substring(1, 2) + "/" + a.substring(5);
                arr.add(a);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

    private ArrayList<String> getYearYValues(int val) {
        if (val == 1) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '1' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 2) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '2' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 3) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '3' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 4) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '4' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 5) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '5' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return arr;
        } else if (val == 6) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '6' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 7) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '7' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 8) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '8' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if (val == 9) {
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '9' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        } else if(val == 10){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '10' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(0)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(0)+"' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(1)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(1)+"' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(2)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(2)+"' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(3)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(3)+"' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else if(val == drawable.get(4)){
            ArrayList<String> arr = new ArrayList<>();
            final String TABLE_NAME = "emotion_log";
            String selectQuery = "SELECT distinct strftime('%m %Y', entryDate) as mymonths, emotion_id, avg(dataValue) FROM " + TABLE_NAME + " where emotion_id = '"+drawable.get(4)+"' and entryDate between date(CURRENT_DATE, '-1 years') and CURRENT_DATE GROUP BY mymonths, emotion_id";
            Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);
            if (cursor.getCount() == 0) {
                return arr;
            }
            if (cursor.moveToFirst()) {
                do {
                    arr.add(cursor.getString(cursor.getColumnIndex("avg(dataValue)")));
                } while (cursor.moveToNext());
            }
            cursor.close();

            return arr;
        }
        else{
            return new ArrayList<>();
        }
    }

    private void createYearLineChart() {
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<Entry> valsComp1 = new ArrayList<>();
        ArrayList<Entry> valsComp2 = new ArrayList<>();
        ArrayList<Entry> valsComp3 = new ArrayList<>();
        ArrayList<Entry> valsComp4 = new ArrayList<>();
        ArrayList<Entry> valsComp5 = new ArrayList<>();
        ArrayList<Entry> valsComp6 = new ArrayList<>();
        ArrayList<Entry> valsComp7 = new ArrayList<>();
        ArrayList<Entry> valsComp8 = new ArrayList<>();
        ArrayList<Entry> valsComp9 = new ArrayList<>();
        ArrayList<Entry> valsComp10 = new ArrayList<>();
        ArrayList<Entry> valsComp11 = new ArrayList<>();
        ArrayList<Entry> valsComp12 = new ArrayList<>();
        ArrayList<Entry> valsComp13 = new ArrayList<>();
        ArrayList<Entry> valsComp14 = new ArrayList<>();
        ArrayList<Entry> valsComp15 = new ArrayList<>();
        LineDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        LineDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getYearXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getYearYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getYearYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getYearYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getYearYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getYearYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getYearYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getYearYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getYearYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getYearYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getYearYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getYearYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getYearYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getYearYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getYearYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new Entry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getYearYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new Entry(b, i));
                }
            }
        }

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new LineDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            setComp1.setLineWidth(9f);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new LineDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            setComp2.setLineWidth(9f);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new LineDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            setComp3.setLineWidth(9f);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new LineDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            setComp4.setLineWidth(9f);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new LineDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            setComp5.setLineWidth(9f);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new LineDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            setComp6.setLineWidth(9f);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new LineDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            setComp7.setLineWidth(9f);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new LineDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            setComp8.setLineWidth(9f);
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new LineDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            setComp9.setLineWidth(9f);
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new LineDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            setComp10.setLineWidth(9f);
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new LineDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            setComp11.setLineWidth(9f);
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new LineDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            setComp12.setLineWidth(9f);
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new LineDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            setComp13.setLineWidth(9f);
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new LineDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            setComp14.setLineWidth(9f);
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new LineDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            setComp15.setLineWidth(9f);
            dataSets.add(setComp15);
        }

        LineData data = new LineData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    private void createYearBarChart() {
        BarChart lineChart = (BarChart) rootView.findViewById(R.id.barchart);
        lineChart.setVisibility(View.VISIBLE);
        ArrayList<String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15;
        ArrayList<BarEntry> valsComp1 = new ArrayList<>();
        ArrayList<BarEntry> valsComp2 = new ArrayList<>();
        ArrayList<BarEntry> valsComp3 = new ArrayList<>();
        ArrayList<BarEntry> valsComp4 = new ArrayList<>();
        ArrayList<BarEntry> valsComp5 = new ArrayList<>();
        ArrayList<BarEntry> valsComp6 = new ArrayList<>();
        ArrayList<BarEntry> valsComp7 = new ArrayList<>();
        ArrayList<BarEntry> valsComp8 = new ArrayList<>();
        ArrayList<BarEntry> valsComp9 = new ArrayList<>();
        ArrayList<BarEntry> valsComp10 = new ArrayList<>();
        ArrayList<BarEntry> valsComp11 = new ArrayList<>();
        ArrayList<BarEntry> valsComp12 = new ArrayList<>();
        ArrayList<BarEntry> valsComp13 = new ArrayList<>();
        ArrayList<BarEntry> valsComp14 = new ArrayList<>();
        ArrayList<BarEntry> valsComp15 = new ArrayList<>();
        BarDataSet setComp1, setComp2, setComp3, setComp4, setComp5, setComp6, setComp7, setComp8;
        BarDataSet setComp9, setComp10, setComp11, setComp12, setComp13, setComp14, setComp15;


        ArrayList<String> a1 = getYearXValues();
        if (MainActivity.Gcb1Val == 1) {
            e1 = getYearYValues(1);
            if (e1.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e1.get(i));
                    int b = (int) a;
                    valsComp1.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb2Val == 1) {
            e2 = getYearYValues(2);
            if (e2.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e2.get(i));
                    int b = (int) a;
                    valsComp2.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb3Val == 1) {
            e3 = getYearYValues(3);
            if (e3.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e3.get(i));
                    int b = (int) a;
                    valsComp3.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb4Val == 1) {
            e4 = getYearYValues(4);
            if (e4.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e4.get(i));
                    int b = (int) a;
                    valsComp4.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb5Val == 1) {
            e5 = getYearYValues(5);
            if (e5.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e5.get(i));
                    int b = (int) a;
                    valsComp5.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb6Val == 1) {
            e6 = getYearYValues(6);
            if (e6.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e6.get(i));
                    int b = (int) a;
                    valsComp6.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb7Val == 1) {
            e7 = getYearYValues(7);
            if (e7.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e7.get(i));
                    int b = (int) a;
                    valsComp7.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb8Val == 1) {
            e8 = getYearYValues(8);
            if (e8.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e8.get(i));
                    int b = (int) a;
                    valsComp8.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb9Val == 1) {
            e9 = getYearYValues(9);
            if (e9.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e9.get(i));
                    int b = (int) a;
                    valsComp9.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb10Val == 1) {
            e10 = getYearYValues(10);
            if (e10.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e10.get(i));
                    int b = (int) a;
                    valsComp10.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb11Val == 1) {
            e11 = getYearYValues(drawable.get(0));
            if (e11.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e11.get(i));
                    int b = (int) a;
                    valsComp11.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb12Val == 1) {
            e12 = getYearYValues(drawable.get(1));
            if (e12.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e12.get(i));
                    int b = (int) a;
                    valsComp12.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb13Val == 1) {
            e13 = getYearYValues(drawable.get(2));
            if (e13.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e13.get(i));
                    int b = (int) a;
                    valsComp13.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb14Val == 1) {
            e14 = getYearYValues(drawable.get(3));
            if (e14.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e14.get(i));
                    int b = (int) a;
                    valsComp14.add(new BarEntry(b, i));
                }
            }
        }
        if (MainActivity.Gcb15Val == 1) {
            e15 = getYearYValues(drawable.get(4));
            if (e15.size() != 0) {
                for (int i = 0; i < a1.size(); i++) {
                    double a = Double.valueOf(e15.get(i));
                    int b = (int) a;
                    valsComp15.add(new BarEntry(b, i));
                }
            }
        }

        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();

        if (MainActivity.Gcb1Val == 1) {
            setComp1 = new BarDataSet(valsComp1, "Fear");
            setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp1.setColor(Color.RED);
            dataSets.add(setComp1);
        }
        if (MainActivity.Gcb2Val == 1) {
            setComp2 = new BarDataSet(valsComp2, "Anger");
            setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp2.setColor(Color.CYAN);
            dataSets.add(setComp2);
        }
        if (MainActivity.Gcb3Val == 1) {
            setComp3 = new BarDataSet(valsComp3, "Sadness");
            setComp3.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp3.setColor(Color.GREEN);
            dataSets.add(setComp3);
        }
        if (MainActivity.Gcb4Val == 1) {
            setComp4 = new BarDataSet(valsComp4, "Joy");
            setComp4.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp4.setColor(Color.BLACK);
            dataSets.add(setComp4);
        }
        if (MainActivity.Gcb5Val == 1) {
            setComp5 = new BarDataSet(valsComp5, "Disgust");
            setComp5.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp5.setColor(Color.BLUE);
            dataSets.add(setComp5);
        }
        if (MainActivity.Gcb6Val == 1) {
            setComp6 = new BarDataSet(valsComp6, "Trust");
            setComp6.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp6.setColor(Color.YELLOW);
            dataSets.add(setComp6);
        }
        if (MainActivity.Gcb7Val == 1) {
            setComp7 = new BarDataSet(valsComp7, "Anticipation");
            setComp7.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp7.setColor(Color.LTGRAY);
            dataSets.add(setComp7);
        }
        if (MainActivity.Gcb8Val == 1) {
            setComp8 = new BarDataSet(valsComp8, "Surprise");
            setComp8.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp8.setColor(Color.parseColor("#9C27B0"));
            dataSets.add(setComp8);
        }
        if (MainActivity.Gcb9Val == 1) {
            setComp9 = new BarDataSet(valsComp9, "Love");
            setComp9.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp9.setColor(Color.parseColor("#795548"));
            dataSets.add(setComp9);
        }
        if (MainActivity.Gcb10Val == 1) {
            setComp10 = new BarDataSet(valsComp10, "Remorse");
            setComp10.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp10.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp10);
        }
        if (MainActivity.Gcb11Val == 1) {
            setComp11 = new BarDataSet(valsComp11, moods.get(0));
            setComp11.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp11.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp11);
        }
        if (MainActivity.Gcb12Val == 1) {
            setComp12 = new BarDataSet(valsComp12, moods.get(1));
            setComp12.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp12.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp12);
        }
        if (MainActivity.Gcb13Val == 1) {
            setComp13 = new BarDataSet(valsComp13, moods.get(2));
            setComp13.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp13.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp13);
        }
        if (MainActivity.Gcb14Val == 1) {
            setComp14 = new BarDataSet(valsComp14, moods.get(3));
            setComp14.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp14.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp14);
        }
        if (MainActivity.Gcb15Val == 1) {
            setComp15 = new BarDataSet(valsComp15, moods.get(4));
            setComp15.setAxisDependency(YAxis.AxisDependency.LEFT);
            setComp15.setColor(Color.parseColor("#CDDC39"));
            dataSets.add(setComp15);
        }

        BarData data = new BarData(a1, dataSets);
        XAxis xaxis = lineChart.getXAxis();
        YAxis ylaxis = lineChart.getAxisLeft();
        YAxis yraxis = lineChart.getAxisRight();

        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setTextSize(10f);
        xaxis.setTextColor(Color.parseColor("#3F51B5"));

        ylaxis.setAxisMaxValue(10);
        ylaxis.setAxisMinValue(0);
        ylaxis.setTextSize(10f);
        ylaxis.setTextColor(Color.parseColor("#3E2723"));
        yraxis.setAxisMaxValue(10);
        yraxis.setAxisMinValue(0);
        yraxis.setTextSize(10f);
        yraxis.setTextColor(Color.parseColor("#3E2723"));

        Legend legend = lineChart.getLegend();
        legend.setWordWrapEnabled(true);
        lineChart.setData(data);
        lineChart.invalidate();
    }

    private ArrayList<Integer> emotion_id() {
        ArrayList<Integer> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_custom";
        String selectQuery = "SELECT emotion_id FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getInt(cursor.getColumnIndex("emotion_id")));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return arr;
    }

    private ArrayList<String> emotion_name() {
        ArrayList<String> arr = new ArrayList<>();
        final String TABLE_NAME = "emotion_custom";
        String selectQuery = "SELECT emotion_name FROM " + TABLE_NAME;
        Cursor cursor = MainActivity.mydatabase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                arr.add(cursor.getString(cursor.getColumnIndex("emotion_name")));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return arr;

    }
}
