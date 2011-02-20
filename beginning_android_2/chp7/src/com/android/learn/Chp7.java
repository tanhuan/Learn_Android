package com.android.learn;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Chp7 extends ListActivity implements OnItemSelectedListener, TextWatcher {
	TextView selection;
	AutoCompleteTextView actv;
	String[] items = {"This","is","a", "stupid", "array", "list", "but", 
					"whatever", "I", "will", "need", "much", "more", "elements",
					"than", "this", "pronouciations", "long word"};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
	private void runExOne() {
        setContentView(R.layout.main);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,items));
        selection = (TextView)findViewById(R.id.selection); 
	}
	
	private void runExTwo() {
		setContentView(R.layout.spinner);
        selection = (TextView)findViewById(R.id.selection);
		Spinner spinner = (Spinner)findViewById(R.id.spinner);
		spinner.setOnItemSelectedListener(this);
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,items);
		
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(aa);
	}
	
	private void runExThree() {
		setContentView(R.layout.grid_layout);
        selection = (TextView)findViewById(R.id.selection);
		GridView gv = (GridView)findViewById(R.id.grid);
		gv.setAdapter(new FunnyLookingAdapter(this, android.R.layout.simple_list_item_1, items));
		gv.setOnItemSelectedListener(this);

		gv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(Chp7.this, "resource: " + arg2, Toast.LENGTH_SHORT).show();		
			}		
		});
	}

    public void onListItemClick(ListView parent, View v, int position, long id) {
    	String str = "Position: " + position + ": " + id + "\n";
    	str = str + items[position];
    	selection.setText(str);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater mf = getMenuInflater();
    	mf.inflate(R.menu.option_menu, menu);
    	return true;
    }
    
    private void runExFour() {
    	
    	setContentView(R.layout.autocomplete_view);
    	selection = (TextView)findViewById(R.id.selection);
    	
    	actv = (AutoCompleteTextView)findViewById(R.id.auto_complete);
    	actv.addTextChangedListener(this);
    	actv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items));
    	
    }
    
	private void runNoEx() {
		//setContentView(R.layout.empty_layout);
		Toast.makeText(this, "This exercise is not ready yet", Toast.LENGTH_LONG).show();
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.ex7_1:
    		runExOne();
    		break;
    	case R.id.ex7_2:
    		runExTwo();
    		break;
    	case R.id.ex7_3:
    		runExThree();
    		break;
    	case R.id.ex7_4:
    		runExFour();
    		break;
		default:
			return super.onOptionsItemSelected(item);
    	}
		return true;
    }

	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		selection.setText(items[position]);
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		selection.setText("Nothing selected!");
	}

	
	@SuppressWarnings("rawtypes")
	private class FunnyLookingAdapter extends ArrayAdapter {
		Context ctxt;
		
		@SuppressWarnings("unchecked")
		FunnyLookingAdapter(Context ctxt, int resource,
				String[] items) {
			super(ctxt, resource, items);

			this.ctxt = ctxt;
		}


		public View getView(int position, View convertView, ViewGroup parent) {
			TextView label = (TextView)convertView;
			
			if (convertView == null) {
				convertView = new TextView(ctxt);
				label = (TextView) convertView;
			}
			label.setText(items[position]);

			return label;
		}
	}


	public void afterTextChanged(Editable arg0) {

	}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		
	}

	public void onTextChanged(CharSequence s, int start, int before, int count) {
		selection.setText(actv.getText());
	}
    
}