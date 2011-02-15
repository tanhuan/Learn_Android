package com.android.learn;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Chp7 extends ListActivity {
	TextView selection;
	String[] items = {"This","is","a", "stupid", "array", "list", "but", 
					"whatever"};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
	private void runExOne() {
        setContentView(R.layout.main);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items));
        selection = (TextView)findViewById(R.id.selection);
	}    
    
    public void onListItemClick(ListView parent, View v, int position, long id) {
    	String str = parent.toString() + ": " + v.toString() + ": " + position + ": " + id;
    	selection.setText(str);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater mf = getMenuInflater();
    	mf.inflate(R.menu.option_menu, menu);
    	return true;
    }
    
	private void runNoEx() {
		setContentView(R.layout.empty_layout);
		Toast.makeText(this, "This exercise is not ready yet", Toast.LENGTH_LONG).show();
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.ex7_1:
    		runExOne();
    		break;
    	case R.id.ex7_2:
    		runNoEx();
    		break;
    	case R.id.ex7_3:
    		runNoEx();
    		break;
		default:
			return super.onOptionsItemSelected(item);
    	}
		return true;
    }


}