package studio.ultoolapp.examplemvvm.viewmodel;

import android.app.Activity;

public class ListViewModel {
    private Activity activity;

    public ListViewModel(Activity activity) {
        this.activity = activity;
    }

    public void FinishActivity() {
        activity.finish();
    }
}
