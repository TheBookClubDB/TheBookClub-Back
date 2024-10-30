package br.com.db.endpoints;

import br.com.db.utils.PropertiesData;

public class AutorEndpointConfig extends ServiceUrlPaths {

    protected static String baseUri() {
        return BASE_URI = PropertiesData.getPropertiesData("url", "BASE_URI");
    }

    protected static String basePathAutorRegistro() {
        return BASE_PATH_AUTOR = PropertiesData.getPropertiesData("url", "BASE_PATH_AUTOR");
    }
}