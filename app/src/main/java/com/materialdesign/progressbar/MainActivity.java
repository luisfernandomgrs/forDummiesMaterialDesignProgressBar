package com.materialdesign.progressbar;

import androidx.appcompat.app.AppCompatActivity;

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
	}
}