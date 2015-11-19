package active.since93.shortcutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCreateShortcut, btnTransparent;
    String title = getIntent().getStringExtra("title");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCreateShortcut = (Button) findViewById(R.id.btnCreateShortcut);
        btnTransparent = (Button) findViewById(R.id.btnTransparentActivity);

        btnCreateShortcut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shortcutIntent = new Intent(getApplicationContext(), MainActivity.class);
                shortcutIntent.putExtra("title", "HelloWorldShortcut");
                shortcutIntent.setAction(Intent.ACTION_MAIN);
                Intent addIntent = new Intent();
                addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
                addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "HelloWorldShortcut");
                addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,Intent.ShortcutIconResource.fromContext(getApplicationContext(),R.mipmap.ic_launcher));
                addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
                getApplicationContext().sendBroadcast(addIntent);
            }
        });

        btnTransparent.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String title = getIntent().getStringExtra("title");
        if(title != null) {
            btnTransparent.performClick();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnTransparentActivity:
                Intent intent = new Intent(MainActivity.this, TransparentActivity.class);
                startActivity(intent);
                finish();
            default:
                break;
        }
    }
}
