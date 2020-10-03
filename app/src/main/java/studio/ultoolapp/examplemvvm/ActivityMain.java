package studio.ultoolapp.examplemvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import studio.ultoolapp.examplemvvm.databinding.ActivityMainBinding;
import studio.ultoolapp.examplemvvm.viewmodel.ExampleViewModel;

public class ActivityMain extends AppCompatActivity {

    // Data Binding
    private ActivityMainBinding binding;

    // View Model
    private ExampleViewModel exampleViewModel = new ExampleViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(exampleViewModel);
    }
}