package sunflower.apps.lovechat;

import demo.example.lovechat.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import apps.lovechat.base.IChangeFormListener;
import apps.lovechat.config.eForm;
import apps.lovechat.form.frmlogin;
import apps.lovechat.form.frmmain;


public class LoveChatActivity extends FragmentActivity implements IChangeFormListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_love_chat);
		
		if (findViewById(R.id.fragment_container) != null) {
			
			android.support.v4.app.Fragment fragment = getView(eForm.LOGIN);            

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
           

            // Add the fragment to the 'fragment_container' FrameLayout
			getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();
        }	
	}
	
	private void ChangeView(eForm form)
	{
		// update the main content by replacing fragments
		android.support.v4.app.Fragment fragment = getView(form);
		if(fragment!=null)
		{			
			getSupportFragmentManager().beginTransaction()			
            .replace(R.id.fragment_container, fragment).commit();		
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.love_chat, menu);
		return true;
	}
	private android.support.v4.app.Fragment getView(eForm form)
	{
		android.support.v4.app.Fragment result=null;
		switch(form)
		{
		case LOGIN:
			result= new frmlogin();	
			break;
		case MAINFORM:
			result= new frmmain();	
			break;
			//default: return null;
		default:
			result=null;
			break;
		}
		return result;
	}

	@Override
	public void formChanged(eForm form)
	{
		ChangeView(form);		
	}
}