
package org.imat.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Generated(value = {
    "wadl|file:/C:/Users/lenovo/workspace/AMI/src/wikipedia.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T05:39:04.828+03:00")
public class Wikipedia {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://community-wikipedia.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Wikipedia.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Wikipedia.ApiPhp apiPhp(Client client, URI baseURI) {
        return new Wikipedia.ApiPhp(client, baseURI);
    }

    public static Wikipedia.ApiPhp apiPhp() {
        return apiPhp(Client.create(), BASE_URI);
    }

    public static Wikipedia.ApiPhp apiPhp(Client client) {
        return apiPhp(client, BASE_URI);
    }

    public static class ApiPhp {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public ApiPhp(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("api.php");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private ApiPhp(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String xMashapeKey, String action, String prop, String rvprop, String title, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("action", action);
            localUriBuilder = localUriBuilder.replaceQueryParam("format", "json");
            localUriBuilder = localUriBuilder.replaceQueryParam("prop", prop);
            localUriBuilder = localUriBuilder.replaceQueryParam("rvprop", rvprop);
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String xMashapeKey, String action, String prop, String rvprop, String title, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("action", action);
            localUriBuilder = localUriBuilder.replaceQueryParam("format", "json");
            localUriBuilder = localUriBuilder.replaceQueryParam("prop", prop);
            localUriBuilder = localUriBuilder.replaceQueryParam("rvprop", rvprop);
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

}
