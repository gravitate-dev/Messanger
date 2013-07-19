package com.jessica.messager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String tag = "MainActivity";
	private EditText input;
	private Editable value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		input = new EditText(this);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void displaySetMessage() {
		new AlertDialog.Builder(MainActivity.this)
	    .setTitle("Update Message")
	    .setMessage("Enter a message")
	    .setView(input)
	    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            value = input.getText(); 
	        }
	    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int whichButton) {
	            // Do nothing.
	        }
	    }).show();
	}
	
	
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction()==MotionEvent.ACTION_DOWN)
			Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
		return false;
		
	};
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getTitle().toString().equals("Set"))
		{
			displaySetMessage();
		} else if (item.getTitle().toString().equals("Display")) {
			Toast.makeText(MainActivity.this, value, Toast.LENGTH_LONG).show();
		}
		
		return super.onMenuItemSelected(featureId, item);
	}
}
