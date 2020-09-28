package studio.ultoolapp.examplemvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import studio.ultoolapp.examplemvvm.viewmodel.ExampleViewModel;

public class MainActivity extends AppCompatActivity {

    private Button btnRefresh;
    private TextView txtHelloWorld;

    // View Model
    private ExampleViewModel exampleViewModel = new ExampleViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHelloWorld = findViewById(R.id.txtHelloWord);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHelloWorld.setText("HELLO THERE");
                exampleViewModel.refresh();
            }
        });
    }
}