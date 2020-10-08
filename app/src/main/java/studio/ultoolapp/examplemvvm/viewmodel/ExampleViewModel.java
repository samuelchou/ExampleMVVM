package studio.ultoolapp.examplemvvm.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import studio.ultoolapp.examplemvvm.R;
import studio.ultoolapp.examplemvvm.data.ExampleData;
import studio.ultoolapp.examplemvvm.view.ActivityList;

/**
 * 一個簡單的View Model.
 * 參見： https://ithelp.ithome.com.tw/articles/10192829
 */
public class ExampleViewModel extends BaseObservable {
    private ExampleData exampleData = new ExampleData();

    public final ObservableField<String> mData = new ObservableField<>();
    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private Context context;

    public ExampleViewModel(Context context) {
        this.context = context.getApplicationContext();
    }

    public void refresh() {
        isLoading.set(true);
        exampleData.retrieveData(new ExampleData.OnDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                String greetings;
                if (data != null && !data.equals(""))
                    greetings = context.getString(R.string.msg_greetings_with_name, data);
                else greetings = context.getString(R.string.msg_greetings);
                mData.set(greetings);
                isLoading.set(false);
            }
        });
    }

    public void StartListActivity(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, ActivityList.class);
        context.startActivity(intent);
    }

    @Bindable
    public void setName(CharSequence charSequence) {
        exampleData.name = charSequence.toString();
    }

    public CharSequence getName() {
        return exampleData.name;
    }

}
