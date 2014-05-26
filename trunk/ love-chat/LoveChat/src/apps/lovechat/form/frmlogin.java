package apps.lovechat.form;

import demo.example.lovechat.R;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import apps.lovechat.base.IChangeFormListener;
import apps.lovechat.config.eForm;


public class frmlogin extends Fragment
{
	private IChangeFormListener changeFormListener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.frmlogin, container,false);
		Button btnNext=(Button)rootView.findViewById(R.id.btnNext);
		
		btnNext.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				changeFormListener.formChanged(eForm.MAINFORM);				
			}
		});
		return rootView;
	}

	@Override
	public void onAttach(Activity activity)
	{
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		if(activity instanceof IChangeFormListener)
		{
			changeFormListener=(IChangeFormListener)activity;
		}
	}
	
}
