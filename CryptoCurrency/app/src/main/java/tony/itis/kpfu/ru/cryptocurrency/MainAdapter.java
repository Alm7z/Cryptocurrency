package tony.itis.kpfu.ru.cryptocurrency;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bulat Murtazin on 11.12.2017.
 * KPFU ITIS 11-601
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<Currency> currencyList;

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        //TODO entity for currency
        Currency currency = currencyList,get(position);

        //TODO get text for views
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }
}
