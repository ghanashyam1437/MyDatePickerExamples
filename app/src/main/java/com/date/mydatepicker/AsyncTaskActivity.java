package com.date.mydatepicker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;


import org.apache.http.NameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GHANASHYAM-PC on 7/31/2016.
 */
public class AsyncTaskActivity extends AsyncTask<Void, Void, Void> {
    private ProgressDialog pDialog;
    private String url;
    private Activity activity;
    private JSONArray jsonArray;
    private JSONParser jsonParser;

    public AsyncTaskActivity(Activity activity, String url) {
        this.url = url;
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... params) {
        List<NameValuePair> valuePairs = new ArrayList<>();
        jsonParser = new JSONParser();
        String json = jsonParser.makeHttpRequest(url, "POST", valuePairs);
        try {
            jsonArray = new JSONArray(json);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        pDialog.setMessage("Please Wait......");
        pDialog.setIndeterminate(false);
        pDialog = new ProgressDialog(activity);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
        if (pDialog != null) {
            pDialog = null;
        }
        if (jsonArray != null) {
            onComplete(jsonArray);
        } else {
            onFailure("Invalid data found, check with adminstrator.");
        }
    }

    public void onComplete( JSONArray arry) {

    }

    public void onFailure(String s) {

    }

}
