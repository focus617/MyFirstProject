package org.zhxu.myfirstapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private Button button_close;
	private Button button_dial;

	ListView contactsView;
	ArrayAdapter<String> adapter;
	List<String> contactsList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	
		Log.i(TAG, "onCreate Method is executed");

		button_close = (Button) findViewById(R.id.button_close);
		button_close.setOnClickListener(new CloseButtonListener());

		button_dial = (Button) findViewById(R.id.button_dial);
		button_dial.setOnClickListener(new DialButtonListener());

		contactsView = (ListView) findViewById(R.id.contacts_view);
//		contactsView.setBackgroundColor((int)R.color.Green);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);
		contactsView.setAdapter(adapter);
		readContacts();
	}

	private void readContacts() {
		Cursor cursor = null;
		try {
			// 查询联系人数据
			cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,
					null);
			while (cursor.moveToNext()) {
				// 获取联系人姓名
				String displayName = cursor
						.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				// 获取联系人手机号
				String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				contactsList.add(displayName + "\n" + number);
				// Log.i(TAG, "Name: "+ displayName + "\tPhonenumber: " +
				// number);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.i(TAG, "Enter exception");
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "onStart Method is executed");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "onRestart Method is executed");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "onResume Method is executed");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "onPause Method is executed");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "onStop Method is executed");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "onDestroy Method is executed");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public class CloseButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this, "Bye", Toast.LENGTH_SHORT).show();
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
			}
			finish();
		}
	}

	public class DialButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			/*
			 * Intent intent = new Intent(Intent.ACTION_DIAL);
			 * intent.setData(Uri.parse("tel:10086"));
			 * startActivity(intent);
			 */

			// 打印主线程的id
			Log.i(TAG, "MainThread id is " + Thread.currentThread().getId());
			Intent intentService = new Intent(MainActivity.this, MyIntentService.class);
			startService(intentService);
		}
	}
}
