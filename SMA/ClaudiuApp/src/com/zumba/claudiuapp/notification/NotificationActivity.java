package com.zumba.claudiuapp.notification;

import com.zumba.claudiuapp.R;
import com.zumba.claudiuapp.notification.admin.SendNotification;
import com.zumba.claudiuapp.notification.admin.SentNotifications;

import database.BDUtilizatori;
import android.content.Intent;
//import android.content.res.Resources;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class NotificationActivity extends TabActivity {
	
	private void createTabs() {
		//Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
		
		Intent newNotif = new Intent(this, NewNotifications.class);
		TabSpec tabSpecNewNotif = tabHost.newTabSpec("New Notifications");
		tabSpecNewNotif.setContent(newNotif)
		               //.setIndicator("News Notification", resources.getDrawable(R.drawable.<<icon_id>>);
					   .setIndicator("New Notifications");
		
		Intent readNotif = new Intent(this, NewNotifications.class);
		TabSpec tabSpecReadNotif = tabHost.newTabSpec("Read Notifications");
		tabSpecReadNotif.setContent(readNotif)
						//.setIndicator("Read Notification", resources.getDrawable(R.drawable.<<icon_id>>);
						.setIndicator("Read Notifications");
		
		Intent musicNotif = new Intent(this, NewSongs.class);
		TabSpec tabSpecMusicNotif = tabHost.newTabSpec("Songs Notifications").setContent(musicNotif);
		tabSpecMusicNotif.setContent(musicNotif)
						 //.setIndicator("Music Notification", resources.getDrawable(R.drawable.<<icon_id>>);
						 .setIndicator("Music Notification");
		
		Intent allMissedNotif = new Intent(this, NewSongs.class);
		TabSpec tabSpecAllMissedNotif = tabHost.newTabSpec("Songs Notifications");
		tabSpecAllMissedNotif.setContent(allMissedNotif)
						 //.setIndicator("All Missed Notification", resources.getDrawable(R.drawable.<<icon_id>>);
						 .setIndicator("All Missed Notification");
	
		
		// load the tabs
		tabHost.addTab(tabSpecNewNotif);
		tabHost.addTab(tabSpecReadNotif);
		tabHost.addTab(tabSpecAllMissedNotif);
		tabHost.addTab(tabSpecMusicNotif);
		
		tabHost.setCurrentTab(0);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		Bundle b = getIntent().getExtras();
		int user_id = b.getInt("USER_ID");
		
		BDUtilizatori bd = new BDUtilizatori();
		bd.utilizatorDupaID(user_id);
		
		if (1 == 1) {//bd.getUtilizatori().get(0).getE_instructor()) {
			createAdminTabs();
		}
		else {
			createTabs();
		}
	}

	private void createAdminTabs() {
		//Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
		Intent sendNotification = new Intent(this, SendNotification.class);
		TabSpec tabSpecSendNotfication = tabHost.newTabSpec("Send Notification").setContent(sendNotification);
		tabSpecSendNotfication.setIndicator("Send Notification");
		
		Intent sentNotification = new Intent(this, SentNotifications.class);
		TabSpec tabSpecSentNotfication = tabHost.newTabSpec("Sent Notification").setContent(sentNotification);
		tabSpecSentNotfication.setIndicator("Sent Notification");
		
		tabHost.addTab(tabSpecSendNotfication);
		tabHost.addTab(tabSpecSentNotfication);
		tabHost.setCurrentTab(0);
	}
}
