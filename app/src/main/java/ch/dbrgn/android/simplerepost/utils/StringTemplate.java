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

public class StringTemplate {

    private StringBuilder builder;

    public StringTemplate(String template) {
        builder = new StringBuilder(template);
    }

    /**
     * Replace all occurrences of "pattern" with "replacement".
     * Source: http://stackoverflow.com/a/3472705/284318
     */
    public void replace(String pattern, String replacement) {
        int index = builder.indexOf(pattern);
        while (index != -1) {
            builder.replace(index, index + pattern.length(), replacement);
            index += replacement.length(); // Move to the end of the replacement
            index = builder.indexOf(pattern, index);
        }
    }

    /**
     * Return the processed string.
     */
    public String toString() {
        return builder.toString();
    }
}
