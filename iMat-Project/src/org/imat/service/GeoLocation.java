
package org.imat.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

@Generated(value = {
    "wadl|file:/C:/Users/lenovo/AppData/Local/Temp/wadl_4512518239309652477.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-04T01:11:14.864+03:00")
public class GeoLocation {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://devru-latitude-longitude-find-v1.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = GeoLocation.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static GeoLocation.Locate location(Client client, URI baseURI) {
        return new GeoLocation.Locate(client, baseURI);
    }

    public static GeoLocation.Locate location() {
        return GeoLocation.location(Client.create(), BASE_URI);
    }

    public static GeoLocation.Locate location(Client client) {
        return GeoLocation.location(client, BASE_URI);
    }

    public static class Locate{

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Locate() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("latlon.php");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        
        public Locate(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("latlon.php");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }


        private Locate(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsXml(String location, String xMashapeKey, String accept, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (location == null) {
                throw new IllegalArgumentException("Parameter location of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("location", location);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            if (accept == null) {
                throw new IllegalArgumentException("Parameter Accept of method getAsXml is required and must not be null");
            }
            if (accept!= null) {
                resourceBuilder = resourceBuilder.header("Accept", accept);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String location, String xMashapeKey, String accept, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (location == null) {
                throw new IllegalArgumentException("Parameter location of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("location", location);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            if (accept == null) {
                throw new IllegalArgumentException("Parameter Accept of method getAsXml is required and must not be null");
            }
            if (accept!= null) {
                resourceBuilder = resourceBuilder.header("Accept", accept);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }
        
        
        public String getLocation(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (input.get("location") == null) {
                throw new IllegalArgumentException("Parameter location of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("location", input.get("location"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            String accept="application/xml";
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            resourceBuilder = resourceBuilder.header("Accept", accept);
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(String.class);
        }
        
        public String getFirstLocation(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (input.get("location") == null) {
                throw new IllegalArgumentException("Parameter location of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("location", input.get("location"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String accept="application/json";
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            resourceBuilder = resourceBuilder.header("Accept", accept);
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            String result= response.getEntity(String.class);
            System.out.println(result);
            try{
            JSONObject obj=new JSONObject(result);
            JSONArray arr=obj.getJSONArray("Results");
            obj=arr.getJSONObject(0);
            
            
			return new JSONArray().put(obj).toString();
            }catch (Exception e){
            	e.printStackTrace();
            	return "[]";
            }
        }

    }

}
