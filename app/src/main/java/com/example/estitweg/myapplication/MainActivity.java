package com.example.estitweg.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.ActionMode;
import android.widget.Button;
import android.widget.EditText;
import android.view.MenuInflater;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

import android.view.View.OnLongClickListener;
import com.example.estitweg.myapplication.R;


public class MainActivity extends Activity {
    private ActionMode mActionMode = null;
    private Button button;
    private String SWITCH = "Switch";
    private String SWITCH_BACK = "Switch Back";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] FRUITS = { "apple", "orange", "banana","kiwi","mango","cherries","peach","pear"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, FRUITS);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        autoCompleteTextView.setAdapter(adapter);

        final Button aButton = (Button) findViewById(R.id.abutton1);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "This is a simple toast";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });

        final Button aButton1 = (Button) findViewById(R.id.abutton2);
        aButton1.setBackgroundResource(R.color.colorAccent);
        aButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastlayout, (ViewGroup) findViewById(R.id.toast_layout_root));
                ImageView image = (ImageView)layout.findViewById(R.id.image);
                // You must create new image asset in res directory
                image.setImageResource(R. mipmap.ic_launcher);
                TextView text = (TextView) layout.findViewById(R.id.textView);
                text.setText("I'm a toast!");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }});


        this.findViewById(R.id.button).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }
                mActionMode = startActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });

        button = (Button)this.findViewById(R.id.abutton);
        //add listener to button
        button.setOnClickListener(new View.OnClickListener() {
            // handle event
            public void onClick(View view) {
                //Start new activity
                if (button.getText().equals(SWITCH)) {
                    button.setText(SWITCH_BACK);
                } else if (button.getText().equals(SWITCH_BACK)) {
                    button.setText(SWITCH);
                }
                Intent myIntent = new Intent(view.getContext(), SecondActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

    }
    public void onStart() {
// Log.i(Tag-String, Message_String);
        Log.i("myActivity", "Activity is being started");
        super.onStart();
    }

    public void onDestroy() {
// Log.i(Tag-String, Message_String);
        Log.i("myActivity", "Activity is being destroyed");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.action_settings) {// nothing to do
        } else if (item.getItemId() == R.id.create_new) {
            intent = new Intent(getApplicationContext(), com.example.estitweg.myapplication.SecondActivity.class);
            startActivityForResult(intent, 0);
        } else {
            Log.v("Class18", "Invalid Menu id");
            return super.onOptionsItemSelected(item);
        }
        return true;
    }


    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.second_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.action_settings) {
                //…
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.create_new) {
                //…
                mode.finish();
                return true;
            } else {
                Log.v("Class18", "Invalid Menu id");
                mode.finish();
                return false;
            }
        }

    };
}
