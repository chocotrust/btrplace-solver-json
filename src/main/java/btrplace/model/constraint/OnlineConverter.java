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

package btrplace.model.constraint;

import btrplace.JSONConverterException;
import btrplace.Utils;
import net.minidev.json.JSONObject;

/**
 * JSON Converter for the constraint {@link Online}.
 *
 * @author Fabien Hermenier
 */
public class OnlineConverter extends SatConstraintConverter<Online> {


    @Override
    public Class<Online> getSupportedConstraint() {
        return Online.class;
    }

    @Override
    public String getJSONId() {
        return "online";
    }


    @Override
    public Online fromJSON(JSONObject o) throws JSONConverterException {
        checkId(o);
        return new Online(Utils.requiredUUIDs(o, "nodes"));
    }

    @Override
    public JSONObject toJSON(Online o) {
        JSONObject c = new JSONObject();
        c.put("id", getJSONId());
        c.put("nodes", Utils.toJSON(o.getInvolvedNodes()));
        return c;
    }
}
