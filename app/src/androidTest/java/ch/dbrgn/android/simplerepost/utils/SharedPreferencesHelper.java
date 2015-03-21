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

package ch.dbrgn.android.simplerepost.utils;

import android.app.Instrumentation;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import ch.dbrgn.android.simplerepost.Config;


public class SharedPreferencesHelper {

    // Log tag
    public static final String LOG_TAG = SharedPreferencesHelper.class.getName();

    private static SharedPreferences.Editor getEditor(Instrumentation instrumentation) {
        final Context context = instrumentation.getTargetContext();
        SharedPreferences settings = context.getSharedPreferences(
                Config.SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        return editor;
    }

    /**
     * Set shared property string "key" to "value".
     */
    public static void setSharedPreference(Instrumentation instrumentation, String key, String value) {
        SharedPreferences.Editor editor = getEditor(instrumentation);
        Log.i(LOG_TAG, "Setting '" + key + "' property to '" + value + "'");
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Set shared property boolean "key" to "value".
     */
    public static void setSharedPreference(Instrumentation instrumentation, String key, boolean value) {
        SharedPreferences.Editor editor = getEditor(instrumentation);
        Log.i(LOG_TAG, "Setting '" + key + "' property to '" + value + "'");
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Clear all shared properties.
     */
    public static void clearSharedPreferences(Instrumentation instrumentation) {
        final Context context = instrumentation.getTargetContext();
        SharedPreferences settings = context.getSharedPreferences(
                Config.SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        Log.i(LOG_TAG, "Clearing shared preferences");
        editor.clear();
        editor.commit();
    }

}