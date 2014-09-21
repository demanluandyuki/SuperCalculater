package com.joyfulmath.supercalculater.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseAdvertise {

	public static final int TYPE_AD_APPLIST = 1;
	public static final int TYPE_AD_INSERT = 2;
	public static final int TYPE_AD_BANNER = 3;
	public static final int MSG_SHOW_BANNER = 10;
	public static final int MSG_SHOW_FULL_COMPLETED = 11;
	public static final int DELAY_SHOWING_FULL = 5000;
	Context mContext;
	ViewGroup mViewGrop = null;
	AdsHandle mhandle = null;
	BaseAdsListener mListener = null;
	public BaseAdvertise(Context context) {
		mContext = context;
		mhandle = new AdsHandle();
	}

	public abstract void init();

	public abstract void exit();

	public abstract void preLoad(int type);

	public abstract boolean isLoaded(int type);

	public abstract View showAppWidget();

	public abstract void showAppWall();

	public abstract void setBanner(ViewGroup container);

	public abstract void showBanner();
	
	public abstract void LoadingFullScreenAsync();
	public abstract void StopFullAds();
	
	
	public void ChangeActivity(Context newContext)
	{
		mContext = newContext;
	}

	public void showBannerAsync() {
		Message msg = mhandle.obtainMessage();
		msg.what = MSG_SHOW_BANNER;
		mhandle.sendMessage(msg);
	}
	
	public void setBaseAdsListener(BaseAdsListener listener)
	{
		mListener = listener;
	}
	
	public void endFullAdsAuto(int millsec)
	{
		Message msg = mhandle.obtainMessage();
		msg.what = MSG_SHOW_FULL_COMPLETED;
		if(millsec !=0)
		{
			mhandle.sendMessageDelayed(msg, millsec);
		}
		else
		{
			mhandle.sendMessage(msg);
		}
	}
	
	public class AdsHandle extends Handler {

		public AdsHandle() {
			super(Looper.getMainLooper());
		}

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case MSG_SHOW_BANNER:
				showBanner();
				break;
			case MSG_SHOW_FULL_COMPLETED:
				if(mListener!=null)
				{
					mListener.OnShowingFullAdsCompleted();
					StopFullAds();
				}
				break;
			}
		}
	}
	
	public interface BaseAdsListener{
		public void OnShowingFullAdsCompleted();
	}

}
