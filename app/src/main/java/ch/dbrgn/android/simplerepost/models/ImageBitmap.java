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

package ch.dbrgn.android.simplerepost.models;

import android.graphics.Bitmap;

public class ImageBitmap {

    private final Bitmap bitmap;
    private final String filename;

    public ImageBitmap(Bitmap bitmap, String filename) {
        this.bitmap = bitmap;
        this.filename = filename;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getFilename() {
        return filename;
    }

}