package demo.example.lovechat;


import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	ActionBar bar;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bar = getActionBar();
		bar.hide();
		TabHost tabHost = getTabHost();
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			TextView t = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
			t.setTextColor(getResources().getColor(R.color.white));
		}
		// Tab meeting
		TabSpec tabMeeting = tabHost.newTabSpec("Meeting");
		tabMeeting.setIndicator("Meeting");
		//tabMeeting.setIndicator("Meeting",getResources().getDrawable(R.drawable.ic_launcher));
		Intent meetting = new Intent(MainActivity.this,MeetActivity.class);
		tabMeeting.setContent(meetting);
		//tab contact
		TabSpec tabContact = tabHost.newTabSpec("Contact");
		tabContact.setIndicator("Contact");
		Intent contact = new Intent (MainActivity.this,ContactActivity.class);
		tabContact.setContent(contact);
		// tab invited
		TabSpec tabInvited = tabHost.newTabSpec("Invited");
		tabInvited.setIndicator("Invited");
		Intent invited = new Intent (MainActivity.this,InvitedActivity.class);
		tabInvited.setContent(invited);
		// tab profile
		TabSpec tabProfile = tabHost.newTabSpec("Profile");
		tabProfile.setIndicator("Profile");
		Intent profile = new Intent (MainActivity.this,ContactActivity.class);
		tabProfile.setContent(profile);
		
		tabHost.addTab(tabMeeting);
		tabHost.addTab(tabContact);
		tabHost.addTab(tabInvited);
		tabHost.addTab(tabProfile);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
