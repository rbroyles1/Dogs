package com.example.dogs.view;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.dogs.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() {}

    @Override
    public void onCreatePreferences(Bundle savedInstaceState, String rootKey) {
        setPreferencesFromResource(R.xml.settings, rootKey);
    }
}
