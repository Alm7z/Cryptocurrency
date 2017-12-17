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
    private ImageView reverse;

    @BindView(R.id.first_currency)
    private TextView currency1;

    @BindView(R.id.second_currency)
    private TextView currency2;

    @BindView(R.id.settings)
    private ImageButton settings;

    public CalcFragment newInstance() {
        Bundle args = new Bundle();
        CalcFragment fragment = new CalcFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator_fragment, container, false);

        ButterKnife.bind(view);

        return view;
    }
}
