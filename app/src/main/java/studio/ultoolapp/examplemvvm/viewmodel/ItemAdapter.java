package studio.ultoolapp.examplemvvm.viewmodel;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import studio.ultoolapp.examplemvvm.data.ExItem;
import studio.ultoolapp.examplemvvm.databinding.ItemListExampleBinding;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    // https://ithelp.ithome.com.tw/articles/10193830

    private List<ExItem> itemList;

    public ItemAdapter(List<ExItem> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemListExampleBinding binding = ItemListExampleBinding.inflate(layoutInflater, parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindWith(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemListExampleBinding binding;

        public ItemViewHolder(@NonNull ItemListExampleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindWith(ExItem item) {
            binding.setItem(item);
            binding.executePendingBindings();
            // 即刻更新資料到Layout上。參見： https://stackoverflow.com/questions/53043412/android-why-use-executependingbindings-in-recyclerview
        }
    }
}
