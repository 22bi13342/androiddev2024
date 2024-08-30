package vn.edu.usth.weatheractivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "Weather";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this layout has a FrameLayout with ID 'container'

        // Create a new instance of ForecastFragment
        ForecastFragment forecastFragment = new ForecastFragment();

        // Add the fragment to the 'container' FrameLayout dynamically
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, forecastFragment) // Ensure R.id.container exists in activity_weather.xml
                .commit();

        textView = findViewById(R.id.textView);


    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "On Start");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "On Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "On Pause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "On Stop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "On Destroy");
    }
}