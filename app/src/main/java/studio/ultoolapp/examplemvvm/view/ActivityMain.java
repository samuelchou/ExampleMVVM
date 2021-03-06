package studio.ultoolapp.examplemvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import studio.ultoolapp.examplemvvm.R;
import studio.ultoolapp.examplemvvm.databinding.ActivityMainBinding;
import studio.ultoolapp.examplemvvm.viewmodel.ExampleViewModel;

public class ActivityMain extends AppCompatActivity {

    // Data Binding
    private ActivityMainBinding binding;

    // View Model
    private ExampleViewModel exampleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exampleViewModel = new ExampleViewModel(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(exampleViewModel);
        exampleViewModel.setName(getString(R.string.name_user_default));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exampleViewModel = null;
    }
}