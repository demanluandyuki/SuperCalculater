package com.joyfulmath.supercalculater.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class AdsHelper {

	public static BaseAdvertise getCurrentInterface(Context context)
	{
		BaseAdvertise mAds = new HelpBaseAdvertise(context);
		return mAds;
	}
	
	public static class HelpBaseAdvertise extends BaseAdvertise
	{

		public HelpBaseAdvertise(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void init() {
			// TODO Auto-generated method stub
			
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
			
		}

		@Override
		public void showBanner() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
