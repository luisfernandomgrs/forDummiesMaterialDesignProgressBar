package com.materialdesign.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

	private ProgressBar progress_circular;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progress_circular = findViewById(R.id.progress_circular);
		progress_circular.setVisibility(View.GONE);

		new AsyncCircular().execute();
	}

	public class AsyncCircular extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onPreExecute() {
			progress_circular.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(Void... voids) {

			for (int i = 0; i < 40; i++) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void unused) {
			progress_circular.setVisibility(View.GONE);
		}
	}
}