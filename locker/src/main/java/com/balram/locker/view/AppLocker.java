package com.balram.locker.view;

import android.app.Application;
import android.content.Context;

import com.balram.locker.main.AppLockImpl;
import com.balram.locker.utils.Locker;

public class AppLocker {

	private volatile static AppLocker instance;
	private Locker curAppLocker;

	public static AppLocker getInstance() {
		synchronized (AppLocker.class) {
			if (instance == null) {
				instance = new AppLocker();
			}
		}
		return instance;
	}

	public void enableAppLock(Context context) {
		if (curAppLocker == null) {
			curAppLocker = new AppLockImpl(context);
		}
		curAppLocker.enable();
	}

	public boolean isAppLockEnabled() {
		if (curAppLocker == null) {
			return false;
		} else {
			return true;
		}
	}

	public void setAppLock(Locker appLocker) {
		if (curAppLocker != null) {
			curAppLocker.disable();
		}
		curAppLocker = appLocker;
	}

	public Locker getAppLock() {
		return curAppLocker;
	}
}
