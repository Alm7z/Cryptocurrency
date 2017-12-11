package tony.itis.kpfu.ru.cryptocurrency.model.table;

import android.support.annotation.NonNull;

/**
 * Created by Aizat on 11.12.2017.
 */

public class Table {

    public static final String NAME_TABLE = "data";

    public static final String COLUMN_NAME = "coin";

    public static final String COLUMN_ID = "_id";

    public static final String COLUMN_RANK = "rank";

    public static final String COLUMN_PRICE = "price_usd";

    @NonNull
    public static String getCreateQuery(){
        return "CREATE TABLE " + NAME_TABLE + " (" +
                COLUMN_ID + " TEXT NON NULL PRIMARY KEY" +
                COLUMN_NAME + " TEXT NON NULL," +
                COLUMN_RANK + " TEXT NON NULL," +
                COLUMN_PRICE + " TEXT NON NULL);";
    }

    public static String getSelectQuery(){
        return "SELECT * FROM " + NAME_TABLE +";";
    }
}
