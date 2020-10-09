package studio.ultoolapp.examplemvvm.viewmodel;

import android.app.Activity;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import studio.ultoolapp.examplemvvm.data.ExItem;
import studio.ultoolapp.examplemvvm.data.ExItemBrowser;

public class ListViewModel {
    private Activity activity;
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    private final MutableLiveData<List<ExItem>> items = new MutableLiveData<>();
    private ExItemBrowser itemBrowser;

    public ListViewModel(Activity activity) {
        this.activity = activity;
        itemBrowser = new ExItemBrowser();
    }

    public void FinishActivity() {
        activity.finish();
    }

    public MutableLiveData<List<ExItem>> getItems() {
        return items;
    }

    public void FetchItems() {
        isLoading.set(true);
        itemBrowser.FetchData(new ExItemBrowser.OnPrepareListener() {
            @Override
            public void OnSuccess(List<ExItem> result) {
                isLoading.set(false);
                items.setValue(result);
            }
        });
    }
}
