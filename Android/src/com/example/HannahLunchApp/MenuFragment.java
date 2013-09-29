package com.example.HannahLunchApp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MenuFragment extends Fragment {

    List<ParseObject> queriedObjects;
    String displayString;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menufragment, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        return view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new RemoteDataTask().execute();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("MenuForm");
            query.orderByDescending("_created_at");
            query.setLimit(1);

            try {
                queriedObjects = query.find();
            } catch (ParseException e) {
                Log.d(e.toString(), "");
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void result) {
            if(queriedObjects != null && queriedObjects.size() > 0){
                String jsonString = (String)queriedObjects.get(0).get("form");
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    displayString = jsonObject.getString("monday.main");
                    textView.setText(displayString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            else{

            }
        }
    }
}

