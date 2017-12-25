package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;

/**
 * Created by Bulat Murtazin on 11.12.2017.
 * KPFU ITIS 11-601
 */

public class MainFragment extends Fragment implements MainView {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @NonNull
    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

//        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//
//        MainAdapter adapter = new MainAdapter(makeCurrencies());

        ButterKnife.bind(this, view);


//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);

        MainPresenter mainPresenter=new MainPresenter(this,getActivity());

        mainPresenter.load();


        return view;
    }

    private ArrayList<Currency> makeCurrencies() {
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("Bitcoin", "13000$"));
        currencies.add(new Currency("Dogecoin", "100$"));
        currencies.add(new Currency("Ethereum", "1400$"));
        currencies.add(new Currency("Lightcoin", "2397$"));
        currencies.add(new Currency("Lightcoin", "2397$"));


        return currencies;
    }

    @Override
    public void onLoadingFromInternet(List<OneData> list) {
        onLoaded(list);

    }

    @Override
    public void onLoadingFromDatabase(List<OneData> list) {
onLoaded(list);
    }

    void onLoaded(List<OneData> list){
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());


        ArrayList<Currency> currencies = new ArrayList<>();

        for (OneData d :
                list) {
            currencies.add(new Currency(d.getName(),d.getPriceUsd()));
        }

        MainAdapter adapter = new MainAdapter(currencies);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onEmptyDatabase() {

    }
}
