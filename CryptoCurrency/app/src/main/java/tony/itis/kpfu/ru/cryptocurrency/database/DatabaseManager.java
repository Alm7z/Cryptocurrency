package tony.itis.kpfu.ru.cryptocurrency.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.util.ArrayList;
import java.util.List;

import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import tony.itis.kpfu.ru.cryptocurrency.entity.OneData;
import tony.itis.kpfu.ru.cryptocurrency.database.table.Table;

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

    //Щас бы DatabaseManager без select писать, да Айзат?

    public Observable<List<OneData>> getSelectQuery() {
        Log.d("Alm","getArgsSelectQuery");

        return Observable.create(new Action1<Emitter<List<OneData>>>() {
            @Override
            public void call(Emitter<List<OneData>> listEmitter) {
                //
                Log.d("Alm","DB select call");
                final Cursor c = database.query(Table.getSelectQuery());

                List<OneData> answ = new ArrayList<OneData>();

                Log.d("Alm","DB select call2");
                while (c.moveToNext()) {

                    //Log.d("Alm","moveToNext");

                    answ.add(new OneData(){{
                        setId(c.getString(c.getColumnIndex(Table.COLUMN_ID)));
                        setName(c.getString(c.getColumnIndex(Table.COLUMN_NAME)));
                        setRank (c.getString(c.getColumnIndex(Table.COLUMN_RANK)));
                        setPriceUsd (c.getString(c.getColumnIndex(Table.COLUMN_PRICE)));

                    }});

                }
                Log.d("Alm","DB select call3");
                c.close();
                //
                listEmitter.onNext(answ);
                Log.d("Alm","DB select call4");
            }
        }, Emitter.BackpressureMode.NONE);

    }

}
