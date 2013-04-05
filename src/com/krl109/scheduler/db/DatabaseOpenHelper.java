package com.krl109.scheduler.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseOpenHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "scheduler-krl3.db";
	private static final String TABLE_NAME = "schedule";
	private static final String TABLE2_NAME = "template";
	private static final String TABLE3_NAME = "schedule_alert";
	private static final String TABLE4_NAME = "count";
	
	
	public static final String SCHEDULE_COLUMN_ID = "id";
	public static final String SCHEDULE_COLUMN_TIMEMILLIST = "timemillist";
	public static final String SCHEDULE_COLUMN_DATETIME = "datetime";
	public static final String SCHEDULE_COLUMN_RECIPIENT = "recipient";
	public static final String SCHEDULE_COLUMN_MESSAGE = "message";
	public static final String SCHEDULE_COLUMN_FREQUENCY = "frequency";
	public static final String SCHEDULE_COLUMN_REMAINING = "remaining";
	public static final String SCHEDULE_COLUMN_STATUS = "status";
	public static final String SCHEDULE_COLUMN_FT = "freqtimes";
	
	public static final String TEMPLATE_COLUMN_ID = "tmp_id";
	public static final String TEMPLATE_COLUMN_MESSAGE = "message";
	public static final String TEMPLATE_COLUMN_NAME = "tmp_name";
	public static final String TEMPLATE_COLUMN_VAR = "tmp_var";
	public static final String TEMPLATE_COLUMN_CAT = "tmp_cat";
	
	public static final String ALERT_COLUMN_ID = "sett_id";
	public static final String ALERT_COLUMN_RINGTONE = "alert_ring";
	public static final String ALERT_COLUMN_ALERT = "alert";
	public static final String ALERT_COLUMN_STATUS = "alert_status";
	
	public static final String COUNT_COLUMN_ID = "count_id";
	public static final String COUNT_COLUMN_ID_TEMPLATE = "count_id_template";
	public static final String COUNT_COLUMN_COUNT = "count";

	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL("CREATE TABLE " + TABLE_NAME + "("
				+ SCHEDULE_COLUMN_ID + " INTEGER PRIMARY KEY, "
				+ SCHEDULE_COLUMN_TIMEMILLIST + " INT, "
				+ SCHEDULE_COLUMN_DATETIME + " STRING, "
				+ SCHEDULE_COLUMN_RECIPIENT + " STRING, " 
				+ SCHEDULE_COLUMN_MESSAGE + " STRING, " 
				+ SCHEDULE_COLUMN_FREQUENCY + " STRING, " 
				+ SCHEDULE_COLUMN_REMAINING + " INT, " 
				+ SCHEDULE_COLUMN_STATUS + " STRING, " 
				+ SCHEDULE_COLUMN_FT + " INT, " 
				+ TEMPLATE_COLUMN_ID + " INT, "
				+ ALERT_COLUMN_ID + " INT, "
				+ COUNT_COLUMN_ID + " INT " +")");
		
		database.execSQL("CREATE TABLE " + TABLE2_NAME + "("
				+ TEMPLATE_COLUMN_ID + " INTEGER PRIMARY KEY, "
				+ TEMPLATE_COLUMN_NAME + " STRING, "
				+ TEMPLATE_COLUMN_CAT + " STRING, "
				+ TEMPLATE_COLUMN_MESSAGE + " STRING "
				+ TEMPLATE_COLUMN_VAR + " STRING "
				+ ")");
		
		database.execSQL("CREATE TABLE " + TABLE3_NAME + "("
				+ ALERT_COLUMN_ID + " INTEGER PRIMARY KEY, "
				+ ALERT_COLUMN_ALERT + " STRING, "
				+ ALERT_COLUMN_RINGTONE + " STRING " 
				+ ALERT_COLUMN_STATUS + " BOOLEAN "
				+ ")");
		
		database.execSQL("CREATE TABLE " + TABLE4_NAME + "("
				+ COUNT_COLUMN_ID + " INTEGER PRIMARY KEY, "
				+ COUNT_COLUMN_ID_TEMPLATE + " STRING, "
				+ COUNT_COLUMN_COUNT + " STRING " 		//%AGE% | %YEAR% | %DATE% | %MONTH% 
				+ ")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		// handle database schema upgrades
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + TABLE3_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + TABLE4_NAME);
		onCreate(database);
	}

}
