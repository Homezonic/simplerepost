/**
 * SimpleRepost -- A simple Instagram reposting Android app.
 * Copyright (C) 2014-2014 Danilo Bargen
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

package ch.dbrgn.android.simplerepost.services;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import ch.dbrgn.android.simplerepost.api.MediaApi;
import ch.dbrgn.android.simplerepost.api.UserApi;
import ch.dbrgn.android.simplerepost.events.ApiErrorEvent;
import ch.dbrgn.android.simplerepost.events.LoadCurrentUserEvent;
import ch.dbrgn.android.simplerepost.events.LoadMediaPreviewEvent;
import ch.dbrgn.android.simplerepost.events.LoadedCurrentUserEvent;
import ch.dbrgn.android.simplerepost.events.LoadedMediaPreviewEvent;
import ch.dbrgn.android.simplerepost.models.MediaResponse;
import ch.dbrgn.android.simplerepost.models.Profile;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MediaService implements Service {

    private final MediaApi mApi;
    private final Bus mBus;

    public MediaService(MediaApi api, Bus bus) {
        mApi = api;
        mBus = bus;
    }

    /**
     * When desired, fetch the specified media item via shortcode
     * and post a `LoadedMediaPreview` event.
     */
    @Subscribe
    public void onLoadMediaPreview(LoadMediaPreviewEvent event) {

        Callback<MediaResponse> callback = new Callback<MediaResponse>() {
            @Override
            public void success(MediaResponse mediaResponse, Response response) {
                mBus.post(new LoadedMediaPreviewEvent(mediaResponse.getMedia().getImages()));
            }

            @Override
            public void failure(RetrofitError error) {
                mBus.post(new ApiErrorEvent(error));
            }
        };

        switch (event.getIdType()) {
            case ID:
                mApi.getMedia(event.getIdValue(), event.getAccessToken(), callback);
                break;
            case SHORTCODE:
                mApi.getMediaByShortcode(event.getIdValue(), event.getAccessToken(), callback);
                break;
        }
    }

}