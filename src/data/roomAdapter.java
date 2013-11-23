package data;

import java.util.ArrayList;

import com.example.ulruru.R;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class roomAdapter extends BaseAdapter {
	
	ArrayList<roomData> list = new ArrayList<roomData>();
	LayoutInflater vi;
	Context context;
	Handler handler;

	public roomAdapter(ArrayList<roomData> list,Context context)
	{
		this.list=list;
		vi = (LayoutInflater)((Context)context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.context=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View v = convertView;
		final roomData _data = list.get(position);
		final int loc = position;
		
	
		if(v==null)
			v = vi.inflate(R.layout.room_row, null);
			
		TextView title,nofp;
		ImageView lock;
		
		title = (TextView)v.findViewById(R.id.rlst_title);
		nofp = (TextView)v.findViewById(R.id.rlst_maxp);
		lock = (ImageView)v.findViewById(R.id.rlst_lock);
		
		
		title.setText(_data.getGamename());
		nofp.setText("Max "+_data.getMax_size()+"Players");
		
		if(_data.getPsswd().length()==0)
			lock.setImageResource(R.drawable.empty);
		
		return v;
	}

}
