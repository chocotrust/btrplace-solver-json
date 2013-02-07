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

package btrplace.model;

import btrplace.JSONConverter;
import btrplace.model.view.ModelViewsConverter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Class to serialize/unserialize a model using the JSON format.
 *
 * @author Fabien Hermenier
 */
public class ModelConverter implements JSONConverter<Model> {

    private MappingConverter cfgParser;

    private AttributesConverter attrsParser;

    private ModelViewsConverter viewsConverter;

    public ModelConverter() {
        cfgParser = new MappingConverter();
        attrsParser = new AttributesConverter();
        viewsConverter = new ModelViewsConverter();
    }

    public ModelViewsConverter getViewsConverter() {
        return viewsConverter;
    }

    public void setModelViewConverters(ModelViewsConverter c) {
        this.viewsConverter = c;
    }

    @Override
    public JSONObject toJSON(Model i) {
        JSONArray rcs = new JSONArray();

        for (ModelView v : i.getViews()) {
            rcs.add(viewsConverter.toJSON(v));
        }

        JSONObject o = new JSONObject();
        o.put("mapping", cfgParser.toJSON(i.getMapping()));
        o.put("attributes", attrsParser.toJSON(i.getAttributes()));
        o.put("views", rcs);
        return o;
    }

    @Override
    public Model fromJSON(JSONObject o) {
        if (!o.containsKey("mapping")) {
            return null;
        }
        Mapping cfg = cfgParser.fromJSON((JSONObject) o.get("mapping"));
        Model i = new DefaultModel(cfg);
        if (o.containsKey("attributes")) {
            i.setAttributes(attrsParser.fromJSON(o));
        }

        if (o.containsKey("views")) {
            for (Object view : (JSONArray) o.get("views")) {
                i.attach(viewsConverter.fromJSON((JSONObject) view));
            }
        }
        return i;
    }
}