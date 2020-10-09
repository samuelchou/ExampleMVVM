package studio.ultoolapp.examplemvvm.viewmodel;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

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

    public void updateList(List<ExItem> newItems) {
        // 透過DiffUtil.Callback與Result進行Adapter資料的智慧更新
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new RepoDiffCallback(this.itemList, newItems));
        this.itemList.clear();
        this.itemList.addAll(newItems);
        result.dispatchUpdatesTo(this);
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

    static class RepoDiffCallback extends DiffUtil.Callback {
        // DiffUtil.Callback類，實作四種方法，並允許使用DiffResult更新至RecyclerView Adapter
        // 參見： https://juejin.im/entry/6844903539387400206, https://www.jianshu.com/p/b9af71778b0d
        private List<ExItem> mOldList;
        private List<ExItem> mNewList;

        RepoDiffCallback(List<ExItem> oldList, List<ExItem> newList) {
            this.mOldList = oldList;
            this.mNewList = newList;
        }

        @Override
        public int getOldListSize() {
            return mOldList != null ? mOldList.size() : 0;
        }

        @Override
        public int getNewListSize() {
            return mNewList != null ? mNewList.size() : 0;
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            int oldId = mOldList.get(oldItemPosition).id;
            int newId = mNewList.get(newItemPosition).id;
            return Objects.equals(oldId, newId);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            ExItem oldItem = mOldList.get(oldItemPosition);
            ExItem newItem = mNewList.get(newItemPosition);
            return Objects.equals(oldItem, newItem);
        }
    }
}
