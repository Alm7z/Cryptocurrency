package tony.itis.kpfu.ru.cryptocurrency;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Bulat Murtazin on 11.12.2017.
 * KPFU ITIS 11-601
 */

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<Currency> currencyList;

    public MainAdapter(ArrayList<Currency> currencies) {
        this.currencyList = currencies;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        Currency currency = currencyList.get(position);

        holder.coinPrice.setText(currency.getValue());
        holder.name.setText(currency.getName());

        Glide.with(holder.itemView.getContext())
                .load(currency.getPicUrl())
                .transition(withCrossFade(3000))
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }
}
