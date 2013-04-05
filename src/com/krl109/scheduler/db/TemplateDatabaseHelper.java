package com.krl109.scheduler.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TemplateDatabaseHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "scheduler-krl3.db";
	private static final String TABLE2_NAME = "template";

	public static final String TEMPLATE_COLUMN_ID = "tmp_id";
	public static final String TEMPLATE_COLUMN_MESSAGE = "message";
	public static final String TEMPLATE_COLUMN_NAME = "tmp_name";
	public static final String TEMPLATE_COLUMN_VAR = "tmp_var";
	public static final String TEMPLATE_COLUMN_CAT = "tmp_cat";
	
	private DatabaseOpenHelper openHelper;
	private SQLiteDatabase database;
	//private Schedule schedule;

	public TemplateDatabaseHelper(Context context) {
		openHelper = new DatabaseOpenHelper(context);
	}
	
	public void saveTemplateRecord(long timeMilist, String[] data) {
		database = openHelper.getWritableDatabase();
	
		ContentValues contentValues = new ContentValues();
		contentValues.put(TEMPLATE_COLUMN_NAME, timeMilist);
		contentValues.put(TEMPLATE_COLUMN_CAT, timeMilist);
		contentValues.put(TEMPLATE_COLUMN_MESSAGE, timeMilist);
		contentValues.put(TEMPLATE_COLUMN_VAR, timeMilist);
		database.insert(TABLE2_NAME, null, contentValues);
		
		Log.e("saved", "sucess");
	}
	
	public Cursor getAllTemplateRecords(){
		// select all data in database -> timerecords
		return database.rawQuery("select * from " + TABLE2_NAME, null);
	}
	
	public Cursor getTemplateList()
	{
		database = openHelper.getReadableDatabase();
		return database.rawQuery("select * from " + TABLE2_NAME, null);
	}
	
	Schedule getOneTemplate(int id){		
		database = openHelper.getReadableDatabase();
		Cursor cursor = database.rawQuery("select * from " + TABLE2_NAME + " where tmp_id='" + id +"'", null);
		if(cursor != null)
			cursor.moveToFirst();
		Schedule schedule = new Schedule(cursor.getLong(1), cursor.getString(2), cursor.getString(3));
		Log.e("TimeListDatabaseHelper", cursor.getString(2));
		return schedule;
	}
}