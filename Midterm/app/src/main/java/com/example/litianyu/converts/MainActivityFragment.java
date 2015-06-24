package com.example.litianyu.converts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    private EditText edit_dollar;
    private TextView txt_num;
    private Button btn_change;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edit_dollar=(EditText)getActivity().findViewById(R.id.edit_dollar);
        txt_num = (TextView)getActivity().findViewById(R.id.txt_num);
        btn_change = (Button)getActivity().findViewById(R.id.btn_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit_dollar.getText().toString();
                if (str!=null&&!str.equals("")){
                    double txt_edit = Double.parseDouble(edit_dollar.getText().toString());
                    double txt_change_num = 439.36*txt_edit;
                    txt_num.setText(String.valueOf(txt_change_num));
                }else{
                    Toast.makeText(getActivity(),"please input the number of dollars",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
