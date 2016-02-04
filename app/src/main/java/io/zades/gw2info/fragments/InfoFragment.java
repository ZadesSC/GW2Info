package io.zades.gw2info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import io.zades.gw2info.R;
import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment
{
	private TextView mTextInfoDesc;
	private static final String desc =  "All associated images and text are trademarks of NCSOFT Corporation";


	public InfoFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_info, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);

		((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("About");

		mTextInfoDesc = (TextView) getView().findViewById(R.id.text_info_description);
		mTextInfoDesc.setText(desc);




	}

}
