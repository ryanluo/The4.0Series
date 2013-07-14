package com.ryan.the40series;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InternalStore extends Activity{
	
	Button save;
	EditText fileName, entry;
	String FILENAME, JOUR;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.internal);
		save = (Button) findViewById(R.id.bSave);
		save.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					FILENAME = fileName.getText().toString();
					if(FILENAME.contentEquals("")){
						FILENAME = "TITTY";
					}
					JOUR = entry.getText().toString();
					
					try {
						FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
						fos.write(JOUR.getBytes());
						fos.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		});
		fileName = (EditText) findViewById(R.id.editText1);
		entry = (EditText) findViewById(R.id.editText2);
	}

}
