package com.exam.Riot;

import java.util.Date;

public class Time {
	
	public static final int SEC = 60;
    public static final int MIN = 60;
    public static final int HOUR = 24;
    public static final int DAY = 30;
    public static final int MONTH = 12;
    
    
    
    public static String calculateTime(Date date)
    {

        long curTime = System.currentTimeMillis();
        long regTime = date.getTime();
        long diffTime = (curTime - regTime) / 1000;

        String msg = null;

        if (diffTime < SEC)
        {
            // sec
            msg = diffTime + "����";
        }
        else if ((diffTime /= SEC) < MIN)
        {
            // min
            System.out.println(diffTime);

            msg = diffTime + "����";
        }
        else if ((diffTime /= MIN) < HOUR)
        {
            // hour
            msg = (diffTime ) + "�ð���";
        }
        else if ((diffTime /= HOUR) < DAY)
        {
            // day
            msg = (diffTime ) + "����";
        }
        else if ((diffTime /= DAY) < MONTH)
        {
            // day
            msg = (diffTime ) + "����";
        }
        else
        {
            msg = (diffTime) + "����";
        }

        return msg;
    }
	
	

}
