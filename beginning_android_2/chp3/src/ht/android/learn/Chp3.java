package ht.android.learn;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class Chp3 extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	Button btn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button)findViewById(R.id.button);
        
        btn.setOnClickListener(this);
        updateTime();
        
    }

	private void updateTime() {
		// TODO Auto-generated method stub
		btn.setText("Chp3:\n" + new Date().toString());
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		updateTime();
	}
}