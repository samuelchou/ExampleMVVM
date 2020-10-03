package studio.ultoolapp.examplemvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import studio.ultoolapp.examplemvvm.data.ExampleData;

/**
 * 一個簡單的View Model.
 * 參見： https://ithelp.ithome.com.tw/articles/10192829
 */
public class ExampleViewModel extends BaseObservable {
    private ExampleData exampleData = new ExampleData();

    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    public void refresh() {
        isLoading.set(true);
        exampleData.retrieveData(new ExampleData.OnDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                mData.set(data);
                isLoading.set(false);
            }
        });
    }

    @Bindable
    public void setName(CharSequence charSequence) {
        exampleData.name = charSequence.toString();
    }

    public CharSequence getName() {
        return exampleData.name;
    }

}
