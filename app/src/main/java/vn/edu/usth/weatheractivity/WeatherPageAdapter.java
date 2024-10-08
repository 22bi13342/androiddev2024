package vn.edu.usth.weatheractivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherPageAdapter extends FragmentPagerAdapter {

    public WeatherPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Create new WeatherAndForecastFragment for each position (3 instances)
        return new WeatherAndForecastFragment();
    }

    @Override
    public int getCount() {
        // You want 3 instances of WeatherAndForecastFragment
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the title for each tab
        switch (position) {
            case 0:
                return "Hanoi";
            case 1:
                return "Paris";
            case 2:
                return "Toulouse";
            default:
                return null;
        }
    }
}
