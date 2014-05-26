package demo.example.lovechat;

import com.facebook.Session;
import com.facebook.SessionState;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity
{

	private Button btnLogin;
	private Session.StatusCallback statusCallback = new SessionStatusCallback();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btnLogin=(Button)findViewById(R.id.login_button);
		
		btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View view) { onClickLogin(); }
        });
		// start Facebook Login
		
		Session session = Session.getActiveSession();
        if (session == null) {
            if (savedInstanceState != null) {
                session = Session.restoreSession(this, null, statusCallback, savedInstanceState);
            }
            if (session == null) {
                session = new Session(this);
            }
            Session.setActiveSession(session);
            if (session.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
                session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
            }
        }
        onLoginSuccess();
	}
	
	 private void onClickLogin() {
	        Session session = Session.getActiveSession();
	        if (!session.isOpened() && !session.isClosed()) {
	            session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
	        } else {
	            Session.openActiveSession(this, true, statusCallback);
	        }
	    }
	
	@Override
	protected void onStart()
	{
		super.onStart();
        Session.getActiveSession().addCallback(statusCallback);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
        Session.getActiveSession().removeCallback(statusCallback);    
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
    }

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
        Session session = Session.getActiveSession();
        Session.saveSession(session, outState);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	private void onLoginSuccess()
	{
		Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_LONG).show();
	}
	private class SessionStatusCallback implements Session.StatusCallback {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
        	onLoginSuccess();
        }
    }
	

}
