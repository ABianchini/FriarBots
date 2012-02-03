package org.serviterobotics.friarbots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

public class BotsActivity extends Activity {
	public static final String SCOUT_DATA = "scoutData";
	
	public static final String MANUAL_UPDATES = "manUp";
	public static final String SCOUT_DATA_OFF_DEF = "off_def";
	
	public String teamNumberJSON = "herp";
	public String numPlayedWithJSON;
	public String offDefJSON;
	public String crossMethodJSON;
	public String otherNotesJSON = "herp";
	public String numBalanceJSON;
	public String balanceRankJSON = "herp";
	public String balanceOrderJSON;
	public String oppBalanceExistJSON;
	
	
	public void popIt(int title, int msg){
        new AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(msg)
        .setNegativeButton("Close", new OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {}
        }).show();
    }
	
	public JSONObject readTeamInfo() {
		StringBuilder builder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://twitter.com/statuses/user_timeline/vogella.json");
		try {
			HttpResponse response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(BotsActivity.class.toString(), "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			return new JSONObject(builder.toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return new JSONObject();
		}
	}
	
}

