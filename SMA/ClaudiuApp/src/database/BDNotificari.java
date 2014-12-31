package database;
import tabele.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;


public class BDNotificari extends BDAcces {

	private ArrayList<Notificare> notificari = new ArrayList<Notificare>();
	
	public void notificari(){
		getData("http://zumbatimisoara.com/AppZumbaPHPScripts/getAllNotifications.php");
	}
	public void notificareDupaID(int id){
		getData("http://zumbatimisoara.com/AppZumbaPHPScripts/getNotificationByID.php?id="+id);
	}
	public void notificariMaiNoiDecatData(Timestamp data){
		getData("http://zumbatimisoara.com/AppZumbaPHPScripts/getNotificationsNewerThanDate.php?date="+(data.getTime()*1000));
	}
	public void introducereNotificare(int id, Timestamp data, String titlu, String mesaj){
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	    nameValuePairs.add(new BasicNameValuePair("id",String.valueOf(id)));
	    nameValuePairs.add(new BasicNameValuePair("data",String.valueOf(data.getTime()*1000)));
	    nameValuePairs.add(new BasicNameValuePair("titlu",titlu));
	    nameValuePairs.add(new BasicNameValuePair("mesaj",mesaj));
	    
		putData("http://zumbatimisoara.com/AppZumbaPHPScripts/addNotification.php",nameValuePairs);
	}
		
	
	@Override
	void parse(String result) {
		try{
    		JSONArray jArray = new JSONArray(result);
    		
    		for(int i=0; i< jArray.length();i++){
    			JSONObject json = jArray.getJSONObject(i);
    			Notificare n = new Notificare(json.getInt("ID"),
    										  new Timestamp(json.getLong("Data")),
    										  json.getString("Titlu"),
    										  json.getString("Mesaj"));
    			notificari.add(n);
    		}
    	}
    	catch(Exception e){
    		Log.e("log_tag", "Error parsing data "+e.toString());
    	}
	}
	
	public ArrayList<Notificare> getNotificari(){
		return notificari;
	}

}