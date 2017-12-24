package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bulat Murtazin on 17.12.2017.
 * KPFU ITIS 11-601
 */

public class CalcFragment extends Fragment {

    @BindView(R.id.reverse)
    public ImageView reverse;

    @BindView(R.id.first_currency)
    public TextView currency1;

    @BindView(R.id.second_currency)
    public TextView currency2;

    @BindView(R.id.settings)
    public ImageButton settings;

    public static CalcFragment newInstance() {
        Bundle args = new Bundle();
        CalcFragment fragment = new CalcFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;
    }
}
