package com.spam;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class SpamActivity extends Activity {

	EditText phoneNum = null;
	EditText numTxt = null;
	EditText message = null;
	Button spam = null;
	Button finish = null;
	String theNumber = null;
	int theText = 0;
	String theMessage = null;
	SmsManager sms = null;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);                

		phoneNum = (EditText)findViewById(R.id.phoneNum);
		phoneNum.setInputType(InputType.TYPE_CLASS_NUMBER);
		numTxt = (EditText)findViewById(R.id.numTxt);
		numTxt.setInputType(InputType.TYPE_CLASS_NUMBER);
		message = (EditText)findViewById(R.id.message);
		spam = (Button)findViewById(R.id.spam);
		finish = (Button)findViewById(R.id.finish);

		spam.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) { 
				theNumber = phoneNum.getText().toString();
				theMessage = message.getText().toString();  

				try {
					theText = Integer.parseInt(numTxt.getText().toString());
				} catch(Exception e) {
				} 

				if (theNumber != null && theMessage != null){
					for (int i = 0; i < theText; i++) {

						theNumber = Integer.toString(8049750 + i);
						System.out.println(theNumber);
						sendSMS("954"+theNumber, "Hey, how are you?");
						//						Toast msg = Toast.makeText(SpamActivity.this, "Message #"+(i+1)+" Sent to "+"407"+theNumber, Toast.LENGTH_SHORT);
						//						msg.show();
					}
				}
			}
		});

		finish.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});

	}

	public void sendSMS(String phoneNumber, String message) {        
		//		PendingIntent pi = PendingIntent.getActivity(this, 0,
		//				new Intent(this, SpamActivity.class), 0);                
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, phoneNumber, message, null, null);        
	}    

}