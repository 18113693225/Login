package com.lj.apps.login.utils.tool;

import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lj.apps.login.R;

import java.lang.ref.WeakReference;

public class SampleSnackBar {

    private SampleSnackBar() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static WeakReference<Snackbar> snackBarWeakReference;


    /**
     * 显示短时snackbar
     *
     * @param parent 父视图(CoordinatorLayout或者DecorView)
     * @param text   文本
     */
    public static void showShortSnackBar(View parent, CharSequence text) {
        showSnackBar(parent, text, Snackbar.LENGTH_SHORT, 0, 0, null, -1, null);
    }


    /**
     * 显示短时snackbar
     *
     * @param parent    父视图(CoordinatorLayout或者DecorView)
     * @param text      文本
     * @param textColor 文本颜色
     * @param bgColor   背景色
     */
    public static void showShortSnackBar(View parent, CharSequence text, int textColor, int bgColor) {
        showSnackBar(parent, text, Snackbar.LENGTH_SHORT, textColor, bgColor, null, -1, null);
    }

    /**
     * 显示短时snackbar
     *
     * @param parent          父视图(CoordinatorLayout或者DecorView)
     * @param text            文本
     * @param textColor       文本颜色
     * @param bgColor         背景色
     * @param actionText      事件文本
     * @param actionTextColor 事件文本颜色
     * @param listener        监听器
     */
    public static void showShortSnackBar(View parent, CharSequence text, int textColor, int bgColor,
                                         CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackBar(parent, text, Snackbar.LENGTH_SHORT, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    /**
     * 显示长时snackbar
     *
     * @param parent 视图(CoordinatorLayout或者DecorView)
     * @param text   文本
     */
    public static void showLongSnackBar(View parent, CharSequence text) {
        showSnackBar(parent, text, Snackbar.LENGTH_LONG, 0, 0, null, -1, null);
    }

    /**
     * 显示长时snackbar
     *
     * @param parent    视图(CoordinatorLayout或者DecorView)
     * @param text      文本
     * @param textColor 文本颜色
     * @param bgColor   背景色
     */
    public static void showLongSnackBar(View parent, CharSequence text, int textColor, int bgColor) {
        showSnackBar(parent, text, Snackbar.LENGTH_LONG, textColor, bgColor, null, -1, null);
    }

    /**
     * 显示长时snackbar
     *
     * @param parent          视图(CoordinatorLayout或者DecorView)
     * @param text            文本
     * @param textColor       文本颜色
     * @param bgColor         背景色
     * @param actionText      事件文本
     * @param actionTextColor 事件文本颜色
     * @param listener        监听器
     */
    public static void showLongSnackBar(View parent, CharSequence text, int textColor, int bgColor,
                                        CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackBar(parent, text, Snackbar.LENGTH_LONG, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    /**
     * 显示自定义时长snackbar
     *
     * @param parent    父视图(CoordinatorLayout或者DecorView)
     * @param text      文本
     * @param duration  自定义时长
     * @param textColor 文本颜色
     * @param bgColor   背景色
     */
    public static void showIndefiniteSnackBar(View parent, CharSequence text, int duration, int textColor, int bgColor) {
        showSnackBar(parent, text, duration, textColor, bgColor, null, -1, null);
    }

    /**
     * 显示自定义时长snackbar
     *
     * @param parent          父视图(CoordinatorLayout或者DecorView)
     * @param text            文本
     * @param duration        自定义时长
     * @param textColor       文本颜色
     * @param bgColor         背景色
     * @param actionText      事件文本
     * @param actionTextColor 事件文本颜色
     * @param listener        监听器
     */
    public static void showIndefiniteSnackBar(View parent, CharSequence text, int duration, int textColor, int bgColor,
                                              CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        showSnackBar(parent, text, duration, textColor, bgColor,
                actionText, actionTextColor, listener);
    }

    /**
     * 设置snackbar文字和背景颜色
     *
     * @param parent          父视图(CoordinatorLayout或者DecorView)
     * @param text            文本
     * @param duration        显示时长
     * @param textColor       文本颜色
     * @param bgColor         背景色
     * @param actionText      事件文本
     * @param actionTextColor 事件文本颜色
     * @param listener        监听器
     */
    private static void showSnackBar(View parent, CharSequence text, int duration, int textColor, int bgColor,
                                     CharSequence actionText, int actionTextColor, View.OnClickListener listener) {
        switch (duration) {
            default:
            case Snackbar.LENGTH_SHORT:
            case Snackbar.LENGTH_LONG:
                snackBarWeakReference = new WeakReference<>(Snackbar.make(parent, text, duration));
                break;
            case Snackbar.LENGTH_INDEFINITE:
                snackBarWeakReference = new WeakReference<>(Snackbar.make(parent, text, Snackbar.LENGTH_INDEFINITE).setDuration(duration));
        }
        if (textColor != 0 && bgColor != 0) {
            View view = snackBarWeakReference.get().getView();
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(textColor);
            view.setBackgroundColor(bgColor);
        }
        if (actionText != null && actionText.length() > 0 && listener != null) {
            snackBarWeakReference.get().setActionTextColor(actionTextColor);
            snackBarWeakReference.get().setAction(actionText, listener);
        }
        snackBarWeakReference.get().show();
    }

    /**
     * 为snackbar添加布局
     * <p>在show...Snackbar之后调用</p>
     *
     * @param layoutId 布局文件
     * @param index    位置(the position at which to add the child or -1 to add last)
     */
    public static void addView(int layoutId, int index) {
        Snackbar snackbar = snackBarWeakReference.get();
        if (snackbar != null) {
            View view = snackbar.getView();
            Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) view;
            View child = LayoutInflater.from(view.getContext()).inflate(layoutId, null);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_VERTICAL;
            layout.addView(child, index, params);
        }
    }

    /**
     * 取消snackbar显示
     */
    public static void dismissSnackBar() {
        if (snackBarWeakReference != null && snackBarWeakReference.get() != null) {
            snackBarWeakReference.get().dismiss();
            snackBarWeakReference = null;
        }
    }

}
