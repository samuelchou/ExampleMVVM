package studio.ultoolapp.examplemvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import studio.ultoolapp.examplemvvm.R;
import studio.ultoolapp.examplemvvm.databinding.ActivityListBinding;
import studio.ultoolapp.examplemvvm.viewmodel.ListViewModel;

public class ActivityList extends AppCompatActivity {
    private ActivityListBinding binding;
    private ListViewModel listViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewModel = new ListViewModel(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setListModel(listViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listViewModel = null;
    }
}