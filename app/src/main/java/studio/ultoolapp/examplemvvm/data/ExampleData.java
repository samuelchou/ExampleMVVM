package studio.ultoolapp.examplemvvm.data;

import android.os.Handler;

/**
 * 一個簡單的Data Model.
 * 參見： https://ithelp.ithome.com.tw/articles/10192829
 */
public class ExampleData {
    public void retrieveData(final OnDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady("New Data");
            }
        }, 3000);
    }

    public interface OnDataReadyCallback {
        void onDataReady(String data);
    }

}
