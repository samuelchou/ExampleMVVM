package studio.ultoolapp.examplemvvm.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import studio.ultoolapp.examplemvvm.R;
import studio.ultoolapp.examplemvvm.data.ExItem;
import studio.ultoolapp.examplemvvm.databinding.ActivityListBinding;
import studio.ultoolapp.examplemvvm.viewmodel.ItemAdapter;
import studio.ultoolapp.examplemvvm.viewmodel.ListViewModel;

public class ActivityList extends AppCompatActivity {
    private ActivityListBinding binding;
    private ListViewModel listViewModel;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewModel = new ListViewModel(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setListModel(listViewModel);

        itemAdapter = new ItemAdapter(new ArrayList<ExItem>());
        // 觀察模式：綁定adapter(View) 與View Model
        listViewModel.getItems().observe(this, new Observer<List<ExItem>>() {
            @Override
            public void onChanged(List<ExItem> items) {
                itemAdapter.updateList(items);
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(itemAdapter);

        // 更新資料
        listViewModel.FetchItems();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        listViewModel = null;
    }
}