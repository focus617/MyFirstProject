package com.example.activitytest;

import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity {

	private Button button_click, button_close;
	private EditText editText;
	private TextView textView;
	private ProgressBar progressBar;

	private int input; // use ctrl-shift-s, then r to create get/set
						// automatically

	private final String TAG = "Main";

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_LEFT_ICON);
		setContentView(R.layout.first_layout);

/*		button_click = (Button) findViewById(R.id.button_click);
		button_click.setOnClickListener(new ClickButtonListener());

		button_close = (Button) findViewById(R.id.button_Finish);
		button_close.setOnClickListener(new CloseButtonListener());

		editText = (EditText) findViewById(R.id.edit_text);
		textView = (TextView) findViewById(R.id.text_view);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
*/		Log.i(TAG, "onCreate Method is executed");
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

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.add_item:
			Toast.makeText(this, "Added into record", Toast.LENGTH_SHORT).show();
			String inputText = editText.getText().toString();
			textView.setText(inputText);
			if (progressBar.getVisibility() == View.VISIBLE)
				progressBar.setVisibility(View.GONE);
			break;
		case R.id.remove_item:
			Toast.makeText(this, "Record content is cleared!", Toast.LENGTH_SHORT).show();
			textView.setText("");
			editText.setText("");
			if (progressBar.getVisibility() == View.GONE)
				progressBar.setVisibility(View.VISIBLE);
			break;
		default:
		}
		return true;
	}

	public class CloseButtonListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Toast.makeText(FirstActivity.this, "Bye", Toast.LENGTH_SHORT).show();
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
			}
			finish();
		}
	}

	public class ClickButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			String inputText = editText.getText().toString();
			textView.setText(inputText);
			if (progressBar.getVisibility() == View.VISIBLE)
				progressBar.setVisibility(View.GONE);
			Toast.makeText(FirstActivity.this, "Added into record!", Toast.LENGTH_SHORT).show();
		}

	}

}
