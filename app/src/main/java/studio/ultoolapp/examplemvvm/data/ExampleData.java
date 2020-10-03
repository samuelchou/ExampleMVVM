package studio.ultoolapp.examplemvvm.data;

import android.os.Handler;

/**
 * 一個簡單的Data Model.
 * 參見： https://ithelp.ithome.com.tw/articles/10192829
 */
public class ExampleData {
    public String name = "Your name";

    public void retrieveData(final OnDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady("Hello, " + name);
            }
        }, 3000);
    }

    public interface OnDataReadyCallback {
        void onDataReady(String data);
    }

}
