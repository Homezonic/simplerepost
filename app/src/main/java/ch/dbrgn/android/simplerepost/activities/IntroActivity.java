/**
 * SimpleRepost -- A simple Instagram reposting Android app.
 * Copyright (C) 2014-2015 Danilo Bargen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

package ch.dbrgn.android.simplerepost.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;

import ch.dbrgn.android.simplerepost.Config;
import ch.dbrgn.android.simplerepost.R;
import ch.dbrgn.android.simplerepost.utils.PreferencesHelper;


public class IntroActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show.
     */
    private static int[] VIEW_PAGES = new int[] {
            R.layout.viewpage_introduction_1,
            R.layout.viewpage_introduction_2,
            R.layout.viewpage_introduction_3,
            R.layout.viewpage_introduction_4,
            R.layout.viewpage_introduction_5,
            R.layout.viewpage_introduction_6,
            R.layout.viewpage_introduction_7,
    };

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager)findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        // Bind the title indicator to the adapter
        CirclePageIndicator titleIndicator = (CirclePageIndicator)findViewById(R.id.viewpager_dots);
        titleIndicator.setViewPager(mPager);

        // If this has been shown, set the isFirstRun shared property to false.
        PreferencesHelper.getSharedPreferences(this)
            .edit()
            .putBoolean(Config.SHARED_PREFS_KEY_FIRSTRUN, false)
            .apply();
    }

    /**
     * The user should be able to close the intro using the back button.
     */
    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * A simple pager adapter that represents multiple ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            // Create bundle and fragment instances
            final Bundle bundle = new Bundle();
            final Fragment fragment = new IntroPageFragment();

            // Set arguments
            final int viewpageResource = VIEW_PAGES[position];
            bundle.putInt(IntroPageFragment.ARGUMENT_VIEWPAGE, viewpageResource);
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getCount() {
            return VIEW_PAGES.length;
        }
    }

}