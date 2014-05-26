package sunflower.apps.lovechat;

import demo.example.lovechat.R;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import apps.lovechat.base.IChangeFormListener;
import apps.lovechat.config.eForm;
import apps.lovechat.form.frmlogin;
import apps.lovechat.form.frmmain;


public class LoveChatActivity extends Activity implements IChangeFormListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_love_chat);	
		
		if(savedInstanceState==null)
		{
			ChangeView(eForm.MAINFORM);
		}		
		
	}
	
	private void ChangeView(eForm form)
	{
		// update the main content by replacing fragments
		Fragment fragment = getView(form);
		if(fragment!=null)
		{			
			getFragmentManager().beginTransaction()			
            .replace(R.id.content_frame, fragment).commit();		
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.love_chat, menu);
		return true;
	}
	private Fragment getView(eForm form)
	{
		Fragment result=null;
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