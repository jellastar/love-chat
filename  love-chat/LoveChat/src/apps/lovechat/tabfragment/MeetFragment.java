package apps.lovechat.tabfragment;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import apps.lovechat.adapter.PlayerAdapter;
import apps.lovechat.base.Player;
import demo.example.lovechat.R;

public class MeetFragment extends Fragment {
	ArrayList<Player> mLstPlayer = new ArrayList<Player>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_meet, container,	false);	
		
		Player p1 = new Player();
		p1.setName("Leo Messi");
		p1.setSothich("Đa bong");
		p1.setAvata(R.drawable.ava_messi);
		p1.setDatetime("10/10/2014");
		mLstPlayer.add(p1);		
	
		ListView listLegend = (ListView) rootView.findViewById(R.id.lvMeet);		
		PlayerAdapter adapter = new PlayerAdapter(rootView.getContext(),R.layout.meet_rows, mLstPlayer);
		listLegend.setAdapter(adapter);
		return rootView;
	}	
	
	
}
