package com.example.memo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
//import com.example.memo.Board.BoardActivity;
//import com.example.memo.Diary.DiaryActivity;
//import com.example.memo.Habit.HabitActivity;
//import com.example.memo.MemoActivity;
//import com.example.memo.Planer.PlanerActivity;
import com.example.memo.PlanerActivity;
import com.example.memo.Board.BoardActivity;
import com.example.memo.R.id;
import java.util.HashMap;
//import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;


public final class MainActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_ca_main);
        ((Button)this._$_findCachedViewById(id.btn_diary)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)MainActivity.this, DiaryActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }));
        ((Button)this._$_findCachedViewById(id.btn_habit)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)MainActivity.this, HabitActivity.class);
               MainActivity.this.startActivity(intent);
            }
        }));
        ((Button)this._$_findCachedViewById(id.btn_planer)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
               Intent intent = new Intent((Context)MainActivity.this, PlanerActivity.class);
               MainActivity.this.startActivity(intent);
            }
        }));
        ((Button)this._$_findCachedViewById(id.btn_board)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
               Intent intent = new Intent((Context)MainActivity.this, BoardActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }));
        ((Button)this._$_findCachedViewById(id.btn_memo)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)MainActivity.this, MemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        }));
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}
