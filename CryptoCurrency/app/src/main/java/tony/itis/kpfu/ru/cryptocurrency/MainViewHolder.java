package tony.itis.kpfu.ru.cryptocurrency;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bulat Murtazin on 11.12.2017.
 * KPFU ITIS 11-601
 */

public class MainViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.icon)
    public ImageView icon;

    @BindView(R.id.name)
    public TextView name;

    @BindView(R.id.coin_price)
    public TextView coinPrice;

    @BindView(R.id.splitter)
    public View splitter;

    public MainViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
