package tony.itis.kpfu.ru.cryptocurrency;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import static android.R.interpolator.linear;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b;
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String randNo[]={"1","2","3","4","5","6","7","8","9",".","0","DEL"};

            int BOOKSHELF_ROWS = 4;
            int BOOKSHELF_COLUMNS = 3;
            int curr = 0;

            TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);

            for (int i = 0; i < BOOKSHELF_ROWS; i++) {

                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT));

                for (int j = 0; j < BOOKSHELF_COLUMNS; j++) {
                    Button button = new Button(this);


                    button.setId(curr);
                    final int id_ = button.getId();


                    button.setText(randNo[curr]);
                    curr++;
                    tableRow.addView(button, j);
                }
                tableLayout.addView(tableRow, i);
            }



        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case 0:
                //text view set 1
                break;
            case 1:
                //text view set 2
                break;
            case 2:
                //text view set 3
                break;
            case 3:
                //text view set 4
                break;
            case 4:
                //text view set 5
                break;
            case 5:
                //text view set 6
                break;
            case 6:
                //text view set 7
                break;
            case 7:
                //text view set 8
                break;
            case 8:
                //text view set 9
                break;
            case 9:
                //textView set .
                break;
            case 10:
                //textView set 0
                break;
            case 11:
                //textView Delete
                break;



        }
    }
}




