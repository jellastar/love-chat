package demo.example.lovechat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import demo.example.lovechat.MainFragment;
import android.os.Bundle;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;

public class LoginActivity extends FragmentActivity
{

	private MainFragment mainfragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		if(savedInstanceState==null){
			mainfragment= new MainFragment();
			getSupportFragmentManager().beginTransaction()
			.add(android.R.id.content, mainfragment).commit();
		}
		else {
			mainfragment =(MainFragment) getSupportFragmentManager()
					.findFragmentById(android.R.id.content);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
