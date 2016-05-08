package org.akhila.cloudservices.rest.services;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.ProductLine;

public interface ProductLinesService {
    public ProductLine getProductLineByProductLine(String productLine);
    public JSONArray getAllProductLines();
}
