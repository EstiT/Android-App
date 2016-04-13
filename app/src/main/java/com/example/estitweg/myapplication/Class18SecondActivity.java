package com.example.estitweg.task18;

import android.util.Log;
import android.view.ActionMode;
import android.view.MenuItem;
import com.example.estitweg.myapplication.R;

/**
 * Created by estitweg on 21-03-14.
 */
public class Class18SecondActivity {

    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.create_new) {
            Log.v("Class18", "Second Activity context menu selected");
            mode.finish();
            return true;
        }
        return true;
    }
}
