package test.com.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Mainactivityfragment extends Fragment implements OnClickListener {
	private TextView img_name;
	private Button btn_before;
	private Button btn_next;
	ImageView img;


	private int indexPosition = 0;


	private int[] imgarray = { R.drawable.dog2, R.drawable.dog3,
			R.drawable.dog4, R.drawable.dog5, R.drawable.dog6 };

	private String[] imgName = { "Dog1", "Dog2", "Dog3", "Dog4", "Dog5" };
	int res ;
	public Mainactivityfragment(){}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_layout, container,false);
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		img_name = (TextView) getActivity().findViewById(R.id.img_name);
		btn_before = (Button) getActivity().findViewById(R.id.btn_before);
		btn_next = (Button) getActivity().findViewById(R.id.btn_next);
		img = (ImageView) getActivity().findViewById(R.id.img);
		
		btn_before.setOnClickListener(this);
		btn_next.setOnClickListener(this);

		img_name.setText(imgName[indexPosition]);
		img.setBackgroundResource(imgarray[indexPosition]);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_before:
			Log.e("btn_before----indexPosition01", "" + indexPosition);
			if (indexPosition == 0) {
				Toast.makeText(getActivity(), "this is the first picture",
						Toast.LENGTH_SHORT).show();
				break;
			}

			indexPosition--;
			img.setBackgroundResource(imgarray[indexPosition]);
			img_name.setText(imgName[indexPosition]);
			Log.e("btn_before----indexPosition02", "" + indexPosition);
			break;
		case R.id.btn_next:
			Log.e("btn_next----indexPosition01", "" + indexPosition);
			if (indexPosition == imgarray.length - 1) {
				Toast.makeText(getActivity(), "this is the last picture",
						Toast.LENGTH_SHORT).show();
				break;
			}
			indexPosition++;
			img.setBackgroundResource(imgarray[indexPosition]);
			img_name.setText(imgName[indexPosition]);
			Log.e("btn_next----indexPosition02", "" + indexPosition);
			break;

		default:
			break;
		}
	}
}
