package active.since93.shortcutdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

/**
 * Created by darshan.parikh on 19-Nov-15.
 */
public class TransparentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_transparent);

        AlertDialog.Builder adb = new AlertDialog.Builder(TransparentActivity.this, R.style.Theme_Transparent);
        adb.setMessage("Blabla")
                .setTitle("Test")
                .show();


    }
}
