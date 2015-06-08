package test.com.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
	
	Fragment fragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 FragmentTransaction ft = getSupportFragmentManager().beginTransaction();  
	        Mainactivityfragment first = new Mainactivityfragment();  

	        ft.replace(R.id.layout, first);  
	        ft.commit(); 
	}
}
