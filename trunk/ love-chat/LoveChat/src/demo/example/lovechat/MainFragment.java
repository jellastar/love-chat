package demo.example.lovechat;

import java.util.Arrays;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.Session.StatusCallback;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

	private String TAG = "MainFragment";
	private UiLifecycleHelper uiHelper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uiHelper = new UiLifecycleHelper(getActivity(), statusback);
	    uiHelper.onCreate(savedInstanceState);
	    
	    Session se= Session.getActiveSession();
	    if (se != null &&
	           (se.isOpened() || se.isClosed()) ) {
	        onSessionStateChange(se, se.getState(), null);
	    }

	    uiHelper.onResume();
	}
	
	private Session.StatusCallback statusback  = new StatusCallback() {
		
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			onSessionStateChange(session,state, exception);
			
		}
		
	}; 
	
	private void onClickLogin(){
		 Session session = Session.getActiveSession();
		    if (!session.isOpened() && !session.isClosed()) {
		        session.openForRead(new Session.OpenRequest(this)
		            .setPermissions(Arrays.asList("public_profile"))
		            .setCallback(statusback));
		    } else {
		        Session.openActiveSession(getActivity(), this, true, statusback);
		    }
	}
	
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		if (state.isOpened()) {
	        Log.i(TAG, "Logged in...");
	    } else if (state.isClosed()) {
	        Log.i(TAG, "Logged out...");
	    }
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_login, container, false);
		
		LoginButton authButton = (LoginButton) v.findViewById(R.id.btnLogin);
		authButton.setFragment(this);
		authButton.setReadPermissions(Arrays.asList("user_likes","user_status"));
		return v;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		 uiHelper.onActivityResult(requestCode, resultCode, data);
		 Session.getActiveSession().onActivityResult(getActivity(), requestCode, resultCode, data);
	        if (Session.getActiveSession().isOpened()) {
	            // Request user data and show the results
	            Request.executeMeRequestAsync(Session.getActiveSession(), new Request.GraphUserCallback() {

	                @Override
	                public void onCompleted(GraphUser user, Response response) {
	                    // TODO Auto-generated method stub
	                    if (user != null) {
	                        // Display the parsed user info
	                        Log.v(TAG, "Response : " + response);
	                        Log.v(TAG, "UserID : " + user.getId());
	                        Log.v(TAG, "UserName : " + user.getUsername());

	                    }
	                }

	            });
	        }
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		uiHelper.onDestroy();
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		uiHelper.onPause();
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		uiHelper.onResume();
	}
	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}
	
	

}
