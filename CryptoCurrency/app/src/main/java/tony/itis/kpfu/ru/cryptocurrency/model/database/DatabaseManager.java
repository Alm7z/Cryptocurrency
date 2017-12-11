package tony.itis.kpfu.ru.cryptocurrency.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tony.itis.kpfu.ru.cryptocurrency.model.entity.OneData;
import tony.itis.kpfu.ru.cryptocurrency.model.table.Table;

/**
 * Created by Aizat on 11.12.2017.
 */

public class DatabaseManager {

    private BriteDatabase database;

    private List <OneData> a;

    public DatabaseManager(@NonNull Context context) {
        SqlBrite sqlBrite = SqlBrite.create();
        database = sqlBrite.wrapDatabaseHelper(new DatabaseHelper(context), Schedulers.io());
    }

    @NonNull
    public Observable<Long> getTableClearQuery(){
        return Observable.just((long)database.delete(Table.NAME_TABLE, null));
    }
    @NonNull
    public Observable<Long> getTableInsertQuery(@NonNull List<OneData> oneDatas){
        return Observable
                .from(oneDatas)
                .map(new Func1<OneData, Long>() {
                    @Override
                    public Long call(OneData oneData) {
                        ContentValues contentValues = new ContentValues();

                        contentValues.put(Table.COLUMN_ID,oneData.getId());
                        contentValues.put(Table.COLUMN_NAME,oneData.getName());
                        contentValues.put(Table.COLUMN_RANK,oneData.getRank());
                        contentValues.put(Table.COLUMN_PRICE,oneData.getPriceUsd());

                        return database.insert(Table.NAME_TABLE, contentValues);
                    }
                });
    }
}
