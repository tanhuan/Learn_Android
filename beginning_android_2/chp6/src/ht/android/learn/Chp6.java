package ht.android.learn;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Chp6 extends Activity implements OnCheckedChangeListener {
	
	RadioGroup orientation;
	RadioGroup gravity;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    /* Activities for each exercise */
    public void exOne(int viewIndex) {
    	setContentView(viewIndex);
        orientation = (RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        
        gravity = (RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
    } 
    
    public void exTwo(int viewIndex) {
    	setContentView(viewIndex);
    }
    
    public void exThree(int viewIndex) {
    	setContentView(viewIndex);
    }
    
    public void noEx(int index) {
    	setContentView(R.layout.empty_layout);
    	Toast.makeText(this, "Ex " + index + " is not done yet!", Toast.LENGTH_LONG).show();
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.omenu, menu);
		return true;
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.ex6_1:
    		exOne(R.layout.main);
    		break;
    	case R.id.ex6_2:
    		exTwo(R.layout.relative_layout);
    		break;
    	case R.id.ex6_3:
    		exThree(R.layout.scroll_view);
    		break;
		default:
			return super.onOptionsItemSelected(item);
    	}
    	
    	return true;
    }
    
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.horizontal:
			orientation.setOrientation(LinearLayout.HORIZONTAL);
			break;
		
		case R.id.vertical:
			orientation.setOrientation(LinearLayout.VERTICAL);
			break;
		
		case R.id.left:
			gravity.setGravity(Gravity.LEFT);
			break;
		
		case R.id.middle:
			gravity.setGravity(Gravity.CENTER);
			break;
		
		case R.id.right:
			gravity.setGravity(Gravity.RIGHT);
			break;
		}
	}
}