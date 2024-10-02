package vn.edu.usth.weatheractivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private Handlertest refreshHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the ViewPager and its adapter
        ViewPager viewPager = findViewById(R.id.view_pager);
        WeatherPageAdapter adapter = new WeatherPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        MediaPlayer mediaPlayer = MediaPlayer.create(WeatherActivity.this, R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                String content = msg.getData().getString("server_response");
                Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        };

        refreshHandler = new Handlertest(handler);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for the toolbar
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            // Show a Toast when refresh is clicked
            Handlertest.NetworkRequest();
            return true;
        } else if (id == R.id.action_settings) {
            // Start the PrefActivity when settings is clicked
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}