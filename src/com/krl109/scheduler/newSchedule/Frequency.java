package com.krl109.scheduler.newSchedule;

public class Frequency {
	String frequency;
	int frequencyTimes;
	
	public int frequencyTimes(){
		if (frequency == "hourly")
			return frequencyTimes = 1;
		else if (frequency == "2 hourly")
			return frequencyTimes = 2;
		else if (frequency == "4 hourly")
			return frequencyTimes = 4;
		else if (frequency == "6 hourly")
			return frequencyTimes = 6;
		else if (frequency == "8 hourly")
			return frequencyTimes = 8;
		else if (frequency == "12 hourly")
			return frequencyTimes = 12;
		else if (frequency == "daily")
			return frequencyTimes = 1;
		else if (frequency == "weekly")
			return frequencyTimes = 1;
		else if (frequency == "2 weekly")
			return frequencyTimes = 2;
		else if (frequency == "3 weekly")
			return frequencyTimes = 3;
		else if (frequency == "monthly")
			return frequencyTimes = 1;
		else if (frequency == "2 monthly")
			return frequencyTimes = 2;
		else if (frequency == "3 monthly")
			return frequencyTimes = 3;
		else if (frequency == "4 monthly")
			return frequencyTimes = 4;
		else if (frequency == "6 monthly")
			return frequencyTimes = 6;
		return frequencyTimes;
	}
}
