package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.text.format.*;

public class MainActivity extends Activity
{
	
	public void run()
	{
		recreate();
		
		try{Thread.sleep(1000);} catch (Exception e){}
		
	}

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		TextView tv = new TextView(this);
        super.onCreate(savedInstanceState);
        String nextbell="err";
		Time t = new Time();
		
	    t.setToNow();
		int regular[][] = {
		{437,445,500,508,563,571,626,634,689,697,727,735,790,798,853},
		
		{437,445,553,561,583,591,699,707,737,745,853}};
		
		int hours = t.hour,
			minutes = t.minute;
		int i,type;
		if (t.weekDay==1||t.weekDay==2||t.weekDay==5)
			type=0;
			else
			type=1;
			
		for (i=0;i<15;i++){
			if (regular[type][i]>minutes+(hours*60))
			{
				nextbell=new String("Time till next bell:  "+(regular[type][i]-(minutes+hours*60))+"\n");
				i=15;
			}
		}
		nextbell += "Time to end of day:  "+(853-(minutes+hours*60));

		char hel[] = nextbell.toCharArray();

		tv.setText(hel,0,nextbell.length());
		setContentView(tv);
		//new Thread(this).start();
		
		}
		@Override
		public void onUserInteraction()
		{
			recreate();
		}
    
}

