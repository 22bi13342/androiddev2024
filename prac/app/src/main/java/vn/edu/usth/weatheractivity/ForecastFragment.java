package vn.edu.usth.weatheractivity; // Use your actual package name

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = new View(getContext());
        // Set background color of the view
        view.setBackgroundColor(Color.parseColor("#20FF0000")); // Example color, you can change this

        return view;
    }
}
