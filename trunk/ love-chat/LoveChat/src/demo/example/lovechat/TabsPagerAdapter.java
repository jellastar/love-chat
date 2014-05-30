package demo.example.lovechat;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import apps.lovechat.tabfragment.ChatFragment;
import apps.lovechat.tabfragment.MeetFragment;
import apps.lovechat.tabfragment.ProfileFragment;
import apps.lovechat.tabfragment.SettingFragment;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch (index) {
		case 0:
			return new MeetFragment();
		case 1:
			return new ChatFragment();
		case 2:
			return new ProfileFragment();
		case 3:
			return new SettingFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		return 4;
	}

}
