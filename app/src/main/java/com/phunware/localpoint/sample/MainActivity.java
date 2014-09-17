/*
 * Copyright 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.phunware.localpoint.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.digby.localpoint.sdk.core.impl.LPLocalpointService;

public class MainActivity extends ActionBarActivity {


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.phunware.localpoint.sample.R.layout.main);
		LPLocalpointService service = LPLocalpointService.getInstance(getApplicationContext());
		service.setLocalNotificationListener(new LPLocalNotificationListener(getApplicationContext()));

		service.start();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(com.phunware.localpoint.sample.R.menu.main, menu);

		// Calling super after populating the menu is necessary here to ensure
		// that the
		// action bar helpers have a chance to handle this event.
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(this, "Tapped home", Toast.LENGTH_SHORT).show();
			break;

		case com.phunware.localpoint.sample.R.id.menu_refresh:
			Toast.makeText(this, "Fake refreshing...", Toast.LENGTH_SHORT)
					.show();
			getActionBarHelper().setRefreshActionItemState(true);
			getWindow().getDecorView().postDelayed(new Runnable() {
				@Override
				public void run() {
					getActionBarHelper().setRefreshActionItemState(false);
				}
			}, 1000);
			break;

//		case R.id.menu_search:
//			Toast.makeText(this, "Tapped search", Toast.LENGTH_SHORT).show();
//			break;
//
//		case R.id.menu_share:
//			Toast.makeText(this, "Tapped share", Toast.LENGTH_SHORT).show();
//			break;
		case com.phunware.localpoint.sample.R.id.menu_locations:
			Toast.makeText(this, "Tapped locations", Toast.LENGTH_SHORT).show();
			Intent locationIntent = new Intent(getApplicationContext(),
					LPLocationActivity.class);
			startActivity(locationIntent);
			break;
		case com.phunware.localpoint.sample.R.id.menu_offer:
			Toast.makeText(this, "Tapped offer", Toast.LENGTH_SHORT).show();
			Intent offerIntent = new Intent(getApplicationContext(),
					LPMessageActivity.class);
			startActivity(offerIntent);
			break;
		case com.phunware.localpoint.sample.R.id.menu_attribute:
			Toast.makeText(this, "Tapped offer", Toast.LENGTH_SHORT).show();
			Intent attrIntent = new Intent(getApplicationContext(),
					LPAttributeActivity.class);
			startActivity(attrIntent);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
