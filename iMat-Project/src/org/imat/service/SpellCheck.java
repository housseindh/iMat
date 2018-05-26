
package org.imat.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Generated(value = {
    "wadl|file:/C:/Users/lenovo/workspace/AMI/wadl/spellcheck.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-09T14:21:43.840+03:00")
public class SpellCheck {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://montanaflynn-spellcheck.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = SpellCheck.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static SpellCheck.Check check(Client client, URI baseURI) {
        return new SpellCheck.Check(client, baseURI);
    }

    public static SpellCheck.Check check() {
        return check(Client.create(), BASE_URI);
    }

    public static SpellCheck.Check check(Client client) {
        return check(client, BASE_URI);
    }

    public static class Check {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        
        public Check() {
            _client = new  Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("check/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        public Check(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("check/");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Check(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(String text, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (text == null) {
                throw new IllegalArgumentException("Parameter text of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
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

        public<T >T getAsJson(String text, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (text == null) {
                throw new IllegalArgumentException("Parameter text of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
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
        
        
        public String check(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            if (input.get("text") == null) {
                throw new IllegalArgumentException("Parameter text of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("text", input.get("text"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            String res= response.getEntity(String.class);
            JSONObject o;
			try {
				o = new JSONObject(res);
				o.remove("corrections");
				return new JSONArray().put(o).toString();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "[]";
			}
            

        }

    }

}
