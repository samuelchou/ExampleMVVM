package studio.ultoolapp.examplemvvm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import studio.ultoolapp.examplemvvm.databinding.ActivityMainBinding;
import studio.ultoolapp.examplemvvm.viewmodel.ExampleViewModel;

public class MainActivity extends AppCompatActivity {

    // Data Binding
    private ActivityMainBinding binding;

    // View Model
    private ExampleViewModel exampleViewModel = new ExampleViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtHelloWord.setText("HELLO THERE");
                exampleViewModel.refresh();
            }
        });
    }
}