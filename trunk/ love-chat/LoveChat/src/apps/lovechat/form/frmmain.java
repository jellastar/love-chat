package apps.lovechat.form;

import demo.example.lovechat.R;
import demo.example.lovechat.R.id;
import demo.example.lovechat.R.layout;
import android.annotation.SuppressLint;
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

public class frmmain extends Fragment
{
	private IChangeFormListener formChangeListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity)
	{
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if(activity instanceof IChangeFormListener)
		{
			formChangeListener=(IChangeFormListener)activity;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.frmmain, container, false);
		
		Button btnBack=(Button)rootView.findViewById(R.id.btnBack);
		
		btnBack.setOnClickListener(new OnClickListener()
		{			
			@Override
			public void onClick(View arg0)
			{
				formChangeListener.formChanged(eForm.LOGIN);				
			}
		});
		
		return rootView;
	}
	
}
