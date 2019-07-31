package com.chad.library.adapter.base.util;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;

import java.util.WeakHashMap;

public class TouchEventUtil {

    @NonNull
    public static String getTouchAction(int actionId) {
        String actionName = "Unknow:id=" + actionId;
        switch (actionId) {
            case MotionEvent.ACTION_DOWN:
                actionName = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                actionName = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                actionName = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                actionName = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                actionName = "ACTION_OUTSIDE";
                break;
        }
        return actionName;
    }

    @NonNull
    private static WeakHashMap<View, Long> clickMap = new WeakHashMap<>();

    public static boolean isFastClick(View view) {
        long currentTime = SystemClock.uptimeMillis();
        Long lastClickTime = clickMap.get(view);
        long lagTime = currentTime - (lastClickTime == null ? 0 : lastClickTime);
        if (lagTime > 0 && lagTime < 400)
            return true;
        clickMap.put(view, currentTime);
        return false;
    }


}
