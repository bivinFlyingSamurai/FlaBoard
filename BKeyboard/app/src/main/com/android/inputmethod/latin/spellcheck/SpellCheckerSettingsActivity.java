

package com.android.inputmethod.latin.spellcheck;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import androidx.core.app.ActivityCompat;

import com.android.inputmethod.latin.permissions.PermissionsManager;
import com.android.inputmethod.latin.utils.FragmentUtils;

/**
 * Spell checker preference screen.
 */
public final class SpellCheckerSettingsActivity extends PreferenceActivity
        implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String DEFAULT_FRAGMENT = SpellCheckerSettingsFragment.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Intent getIntent() {
        final Intent modIntent = new Intent(super.getIntent());
        modIntent.putExtra(EXTRA_SHOW_FRAGMENT, DEFAULT_FRAGMENT);
        modIntent.putExtra(EXTRA_NO_HEADERS, true);
        return modIntent;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean isValidFragment(String fragmentName) {
        return FragmentUtils.isValidFragment(fragmentName);
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        PermissionsManager.get(this).onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }
}
