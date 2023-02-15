package com.materialdesign.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

	private ProgressBar progress_circular, progress_horizontal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progress_circular = findViewById(R.id.progress_circular);
		progress_circular.setVisibility(View.GONE);

		progress_horizontal = findViewById(R.id.progress_horizontal);
		progress_horizontal.setVisibility(View.GONE);
		progress_horizontal.setProgress(0);
		progress_horizontal.setSecondaryProgress(0);
		progress_horizontal.setMax(100);

		new AsyncCircular().execute();
	}

	public class AsyncCircular extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onPreExecute() {
			progress_circular.setVisibility(View.VISIBLE);
			progress_horizontal.setVisibility(View.VISIBLE);
		}

		@Override
		protected Void doInBackground(Void... voids) {
			for (int i = 0; i < 100; i++) {
				try {
					publishProgress(i);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			progress_horizontal.setProgress(values[0]);
			progress_horizontal.setSecondaryProgress(values[0] + 15);
		}

		@Override
		protected void onPostExecute(Void unused) {
			progress_circular.setVisibility(View.GONE);
			progress_horizontal.setVisibility(View.GONE);
		}
	}
}