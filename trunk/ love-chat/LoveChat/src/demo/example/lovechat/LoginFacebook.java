package demo.example.lovechat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFacebook extends Activity {
	private static String API_ID = "256542287861204"; 
	private Facebook facebook;
	@SuppressWarnings("deprecation")
	private AsyncFacebookRunner fbrunner;
	private SharedPreferences ref;
	TextView tx;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_facebook);
		facebook = new Facebook(API_ID);
		fbrunner = new AsyncFacebookRunner(facebook);
		tx = (TextView) findViewById(R.id.view);
	}
	public void login(View v)
	{
		loginFacebook();
//		Intent login = new Intent(LoginFacebook.this,MainActivity.class);
//		startActivity(login);
	}
	@SuppressWarnings("deprecation")
	public void  loginFacebook() {
		ref = getPreferences(MODE_PRIVATE);
		String acces_token = ref.getString("access_token", null);
		long acces_expires = ref.getLong("access_expires", 0);
		if(acces_token != null)
		{
			facebook.setAccessToken(acces_token);
		}
		if(acces_expires!=0)
		{
			facebook.setAccessExpires(acces_expires);
		}
		if(!facebook.isSessionValid())
			facebook.authorize(this, new String[]  {"email","publish_stream"}, 
					new DialogListener() {
						
						public void onFacebookError(FacebookError e) {
							// TODO Auto-generated method stub
						}
						
						public void onError(DialogError e) {
							// TODO Auto-generated method stub
							
						}
						
						public void onComplete(Bundle values) {
							// TODO Auto-generated method stub
							SharedPreferences.Editor editor = ref.edit();
							editor.putString("access_token", facebook.getAccessToken());
							editor.putLong("access_expires", facebook.getAccessExpires());
							editor.commit();
						}
						
						public void onCancel() {
							// TODO Auto-generated method stub
							
						}
					});
					
	}
	public void getProFileUser()
	{
		fbrunner.request("me", new RequestListener() {
			
			@Override
			public void onMalformedURLException(MalformedURLException e, Object state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onIOException(IOException e, Object state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFileNotFoundException(FileNotFoundException e, Object state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFacebookError(FacebookError e, Object state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onComplete(String response, Object state) {
				// TODO Auto-generated method stub
				String json = response;
				
				try {
					JSONObject profile = new JSONObject(json);
					final String name = profile.getString("name");
					final String id = profile.getString("id");
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							tx.append(name + id);
						}
					});
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	}
}



