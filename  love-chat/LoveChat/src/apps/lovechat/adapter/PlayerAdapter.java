package apps.lovechat.adapter;

import java.util.ArrayList;
import java.util.List;

import demo.example.lovechat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import apps.lovechat.base.Player;

public class PlayerAdapter extends ArrayAdapter<Player> {


	Context mContext;
	ArrayList<Player> mListPlayer = new ArrayList<Player>();

	public PlayerAdapter(Context context, int resource, List<Player> objects) {
		super(context, resource, objects);

		this.mContext = context;
		this.mListPlayer = new ArrayList<Player>(objects);
	}

	// Để tránh hiện tượng giật lác trên ListView ta tạo class ViewHolder
	static class ViewHolder {
		TextView txtName, txtSothich, txtTime;
		ImageView imgAva;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder viewHolder;
		if (rowView == null) {
			LayoutInflater inflate = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflate.inflate(R.layout.meet_rows, null);

			viewHolder = new ViewHolder();
			viewHolder.txtName = (TextView) rowView.findViewById(R.id.txtName);
			viewHolder.txtSothich = (TextView) rowView.findViewById(R.id.txtSothich);
			viewHolder.imgAva = (ImageView) rowView.findViewById(R.id.imgAva);
			viewHolder.txtTime = (TextView) rowView.findViewById(R.id.txtTime);
			rowView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Player player = mListPlayer.get(position);
		viewHolder.txtName.setText(player.getName());
		viewHolder.txtSothich.setText(player.getSothich());
		viewHolder.imgAva.setImageResource(player.getAvata());
		viewHolder.txtTime.setText(player.getDatetime());
		
		return rowView;
	}

}
