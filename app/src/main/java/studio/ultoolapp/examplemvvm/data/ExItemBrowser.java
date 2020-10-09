package studio.ultoolapp.examplemvvm.data;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class ExItemBrowser {
    private List<ExItem> items = new ArrayList<>();

    private int tmpDummyDataIndex = 0;

    public void FetchData(final OnPrepareListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                items.clear();
                for (int i = tmpDummyDataIndex; i < tmpDummyDataIndex + 30; i++) {
                    items.add(new ExItem("Item " + i));
                }
                tmpDummyDataIndex += 30;
                listener.OnSuccess(items);
            }
        }, 3000);
    }

    public interface OnPrepareListener {
        void OnSuccess(List<ExItem> result);
    }

}
