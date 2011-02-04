package ht.android.learn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class Chp5 extends Activity implements OnCheckedChangeListener,
											  OnClickListener {
    CheckBox cb;
    Button bttn;
	TextView tv;
	EditText et;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(this);
        
        bttn = (Button)findViewById(R.id.button);
        bttn.setOnClickListener(this);
        
        tv = (TextView)findViewById(R.id.display);
        et = (EditText)findViewById(R.id.textField);
    }

	private void displayText() {
		tv.setText(et.getText().toString());
	}

	public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
		if (isChecked) {
			cb.setText("This check box is checked");
		} else {
			cb.setText("This check box is unchecked");
		}
	}

	public void onClick(View view) {
		displayText();
	}
}