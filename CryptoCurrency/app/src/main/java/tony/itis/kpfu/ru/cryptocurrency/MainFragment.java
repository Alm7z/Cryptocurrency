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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bulat Murtazin on 11.12.2017.
 * KPFU ITIS 11-601
 */

public class MainFragment extends Fragment {

    @BindView(R.id.recycler_view)
    private RecyclerView recyclerView;

    private MainAdapter adapter;

    private LinearLayoutManager manager;

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

        ButterKnife.bind(view);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());

        adapter = new MainAdapter();

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
