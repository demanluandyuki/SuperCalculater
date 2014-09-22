package com.joyfulmath.supercalculater;

import com.joyfulmath.supercalculater.ads.AdsHelper;
import com.joyfulmath.supercalculater.ads.BaseAdvertise;
import com.joyfulmath.supercalculater.ads.BaseAdvertise.BaseAdsListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;



public class StartActivity extends Activity implements BaseAdsListener{

	private static final String TAG = "SuperCalculater.StartActivity";
	public BaseAdvertise mAds =null;
	private boolean bNotify = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		mAds = AdsHelper.getCurrentInterface(this);
		mAds.setBaseAdsListener(this);
		mAds.LoadingFullScreenAsync();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onDestroy");
		mAds.StopFullAds();
		super.onDestroy();
	}

	@Override
	public void OnShowingFullAdsCompleted() {
		// TODO Auto-generated method stub
		Log.i(TAG, "OnShowingFullAdsCompleted");
		if(!bNotify)
		{
			Intent intent = new Intent(this,RealEstatentActivity.class);
			startActivity(intent);
			bNotify = true;
			this.finish();
		}

	}
	
}
