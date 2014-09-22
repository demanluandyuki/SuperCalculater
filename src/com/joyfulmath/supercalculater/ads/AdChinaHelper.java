package com.joyfulmath.supercalculater.ads;

import com.adchina.android.ads.AdManager;
import com.adchina.android.ads.api.AdFsListener;
import com.adchina.android.ads.api.AdFullScreen;
import com.adchina.android.ads.api.AdView;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class AdChinaHelper extends BaseAdvertise implements AdFsListener {

	private final static String TAG = "SuperCalculater.AdChinaHelper";
	private final String ADBANNER_ID = "2205937";
	private final String ADFULL_ID = "2205942";
	private final String ADINSERT_ID = "2205944";
	private final String ADVIDEO_ID = "2205943";

	private Activity mActivity = null;
	AdView adView = null;
	private AdFullScreen adFs = null;

	public AdChinaHelper(Context context) {
		super(context);
		mActivity = (Activity) context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AdManager.setEnableLbs(true); // �Ƿ���lbs��ȷ��涨λ
		AdManager.setRelateScreenRotate(mContext, true); // �Ƿ������Ļ��ת
		AdManager.setAnimation(true); // bannerչʾ�Ƿ���Ҫ����
		AdManager.setLogMode(false); // ��ʾ������־������ʱ��ر�
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void preLoad(int type) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLoaded(int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View showAppWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showAppWall() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBanner(ViewGroup container) {
		// TODO Auto-generated method stub
		mViewGrop = container;
		adView = new AdView(mActivity, ADBANNER_ID, false, false);
		adView.setAdRefreshTime(30); // ˢ��ʱ��
		adView.setAdReferenceSize(640, 100); // �������ȡ�Ĺ��ߴ�
	}

	@Override
	public void showBanner() {
		// TODO Auto-generated method stub
		mViewGrop.addView(adView);
		adView.start();
	}

	@Override
	public void LoadingFullScreenAsync() {
		// TODO Auto-generated method stub
		Log.i(TAG, "LoadingFullScreenAsync");
		adFs = new AdFullScreen(mActivity, ADFULL_ID);
		adFs.setAdFsListener(this);
		adFs.start(); // ��������������ص��ӿ���չʾȫ��
		endFullAdsAuto(8000);
	}

	@Override
	public void onClickFullScreenAd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDisplayFullScreenAd() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onDisplayFullScreenAd");
	}

	@Override
	public void onEndFullScreenLandpage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailedToReceiveFullScreenAd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinishFullScreenAd() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onFinishFullScreenAd");
		endFullAdsAuto(0);
	}

	@Override
	public void onReceiveFullScreenAd() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onReceiveFullScreenAd");
		if (adFs != null)
		{
			Log.i(TAG, "showFs");
			adFs.showFs();
		}
	}

	@Override
	public void onStartFullScreenLandPage() {
		// TODO Auto-generated method stub
		Log.i(TAG, "onStartFullScreenLandPage");
	}

	@Override
	public void StopFullAds() {
		// TODO Auto-generated method stub
		Log.i(TAG, "StopFullAds");
		if (adFs != null) {
			adFs.stop();
			adFs = null;
		}

	}

}
