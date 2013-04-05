package com.krl109.scheduler.template;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.krl109.scheduler.R;

public class NewTemplate extends Activity 
{
	Button add_count;
	RadioButton[] rad;
	EditText start_at, increase, tmp_message, tmp_date;
	public String startAt;
	StringBuilder sb;
	Spinner category;
	String[] var = {"Age", "Date", "Month", "Year"};
	String[] cat ={
		"Birthday", "Anniversary", "Other"	
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_template);
		tmp_message = (EditText) findViewById(R.id.tmp_message);
		
		category = (Spinner) findViewById(R.id.frequency);
		ArrayAdapter<String> list = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cat);
		list.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		category.setAdapter(list);
		
		add_count = (Button) findViewById(R.id.btn_data_count);
		add_count.setOnClickListener(new Button.OnClickListener() 
		{
			public void onClick(View v) 
			{
				//untuk buka list template
				addCountDialog();
			}
		});
	}
	
	protected void addCountDialog() 
	{
		final Dialog d = new Dialog(this);
		d.setTitle("Add Data for Count");
		d.setContentView(R.layout.data_count);
				
		Button btn_ok, btn_cancel;
		//rad = (RadioButton) d.findViewById(id)	
		start_at = (EditText) d.findViewById(R.id.start_at);
		increase = (EditText) d.findViewById(R.id.increase);
		increase.setText("1");
		increase.setFocusable(false);
						
				
		btn_ok = (Button) d.findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new Button.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				startAt = start_at.getText().toString();
				d.dismiss();
				Toast.makeText(getBaseContext(),"Start at : " + start_at.getText().toString() + "\n" + "Increase : " + increase.getText().toString(),Toast.LENGTH_SHORT).show();
			}
		});
			
		btn_cancel = (Button) d.findViewById(R.id.btn_cancel);
		btn_cancel.setOnClickListener(new Button.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				d.cancel();
			}
		});
		
		//d.unregisterForContextMenu(btn_ok);
		d.show();
	}

}
