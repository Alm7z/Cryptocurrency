package tony.itis.kpfu.ru.cryptocurrency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
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

    @BindView(R.id.table_layout)
    public TableLayout tableLayout;

    private String randNo[]={"1","2","3","4","5","6","7","8","9",".","0","DEL"};
    private int BOOKSHELF_ROWS = 4;
    private int BOOKSHELF_COLUMNS = 3;
    private int curr = 0;

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

        for (int i = 0; i < BOOKSHELF_ROWS; i++) {

            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));
            tableRow.setGravity(Gravity.CENTER);


            for (int j = 0; j < BOOKSHELF_COLUMNS; j++) {
                Button button = new Button(getActivity());
                button.setTextSize(40);
                button.setGravity(Gravity.CENTER);


                button.setId(curr);
                final int id_ = button.getId();


                button.setText(randNo[curr]);
                curr++;
                tableRow.addView(button, j);
            }
            tableLayout.addView(tableRow, i);
        }


        return view;
    }
}
