package org.zhxu.myfirstapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

	private static final String SvrTAG = "MyIntentService";

	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub
		Log.i(SvrTAG, "Service: Service created");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		Log.i(SvrTAG, "ServiceThread id is " + Thread.currentThread().getId());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(SvrTAG, "Service: onDestroy executed");
	}
}
