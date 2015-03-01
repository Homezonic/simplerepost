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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ch.dbrgn.android.simplerepost.R;


public class IntroPageFragment extends Fragment {

    public static String ARGUMENT_VIEWPAGE = "viewpage";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final Bundle arguments = getArguments();
        final int viewpage = arguments.getInt(ARGUMENT_VIEWPAGE);

        // Inflate root view
        ViewGroup rootView = (ViewGroup) inflater.inflate(viewpage, container, false);

        // Set onClickListener on exit button
        Button exitButton = (Button)rootView.findViewById(R.id.exit_button);
        if (exitButton != null) {
            exitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishActivity();
                }
            });
        }

        return rootView;
    }

    /**
     * Finish parent activity.
     */
    private void finishActivity() {
        getActivity().finish();
    }

}