/*
 * Copyright (c) 2012 University of Nice Sophia-Antipolis
 *
 * This file is part of btrplace.
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
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package btrplace.instance.json;

import org.json.simple.JSONArray;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Tools to help at converting object to JSON.
 *
 * @author Fabien Hermenier
 */
public class Utils {

    private Utils() {
    }

    public static Set<UUID> fromJSON(JSONArray a) {
        Set<UUID> s = new HashSet<UUID>(a.size());
        for (Object o : a) {
            s.add(UUID.fromString((String) o));
        }
        return s;
    }

    public static JSONArray toJSON(Set<UUID> s) {
        JSONArray a = new JSONArray();
        for (UUID u : s) {
            a.add(u.toString());
        }
        return a;
    }
}