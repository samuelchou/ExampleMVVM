package studio.ultoolapp.examplemvvm.viewmodel;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import studio.ultoolapp.examplemvvm.data.ExItem;

public class ListViewModel {
    private Activity activity;
    private List<ExItem> items = new ArrayList<>();

    public ListViewModel(Activity activity) {
        this.activity = activity;
        for (int i = 0; i < 30; i++) {
            items.add(new ExItem("Item " + i));
        }
    }

    public void FinishActivity() {
        activity.finish();
    }

    public List<ExItem> getItems() {
        return items;
    }
}
