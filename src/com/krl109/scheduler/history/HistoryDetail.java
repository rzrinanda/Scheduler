package com.krl109.scheduler.history;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.krl109.scheduler.R;

public class HistoryDetail extends Activity 
{
	TextView sent_at, recipient, status, content;
	public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_detail);
    }
}