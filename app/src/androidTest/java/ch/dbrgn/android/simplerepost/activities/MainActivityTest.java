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

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import ch.dbrgn.android.simplerepost.Config;
import ch.dbrgn.android.simplerepost.TestSecrets;
import ch.dbrgn.android.simplerepost.utils.SharedPreferencesHelper;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    // Lifecycle methods

    @Override
    public void setUp() throws Exception {
        super.setUp();

        // Log in
        SharedPreferencesHelper.setSharedPreference(getInstrumentation(), "AccessToken", TestSecrets.INSTAGRAM_ACCESS_TOKEN);

        // Get rid of intro pages
        SharedPreferencesHelper.setSharedPreference(getInstrumentation(), Config.SHARED_PREFS_KEY_FIRSTRUN, false);

        // Create robotium solo instance
        this.solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        // Clear shared preferences
        SharedPreferencesHelper.clearSharedPreferences(getInstrumentation());

        // Finish all activities
        this.solo.finishOpenedActivities();

        super.tearDown();
    }

    public void testActivityContent() {
        assertTrue(this.solo.waitForText("This app lets you repost an Instagram post", 1, 2000)); // Intro
    }

}