
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
    "wadl|file:/C:/Users/lenovo/workspace/AMI/src/eventful.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T05:17:29.034+03:00")
public class Eventful {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://community-eventful.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Eventful.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static Eventful.EventsSearch eventsSearch(Client client, URI baseURI) {
        return new Eventful.EventsSearch(client, baseURI);
    }

    public static Eventful.EventsSearch eventsSearch() {
        return eventsSearch(Client.create(), BASE_URI);
    }

    public static Eventful.EventsSearch eventsSearch(Client client) {
        return eventsSearch(client, BASE_URI);
    }

    public static Eventful.VenuesSearch venuesSearch(Client client, URI baseURI) {
        return new Eventful.VenuesSearch(client, baseURI);
    }

    public static Eventful.VenuesSearch venuesSearch() {
        return venuesSearch(Client.create(), BASE_URI);
    }

    public static Eventful.VenuesSearch venuesSearch(Client client) {
        return venuesSearch(client, BASE_URI);
    }

    public static class EventsSearch {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public EventsSearch(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("events/search");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private EventsSearch(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsTextXml(String appKey, String keywords, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (appKey == null) {
                throw new IllegalArgumentException("Parameter app_key of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("app_key", appKey);
            if (keywords == null) {
                throw new IllegalArgumentException("Parameter keywords of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("keywords", keywords);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsTextXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String appKey, String keywords, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (appKey == null) {
                throw new IllegalArgumentException("Parameter app_key of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("app_key", appKey);
            if (keywords == null) {
                throw new IllegalArgumentException("Parameter keywords of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("keywords", keywords);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsTextXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class VenuesSearch {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public VenuesSearch(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("venues/search");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private VenuesSearch(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsTextXml(String appKey, String keywords, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (appKey == null) {
                throw new IllegalArgumentException("Parameter app_key of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("app_key", appKey);
            if (keywords == null) {
                throw new IllegalArgumentException("Parameter keywords of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("keywords", keywords);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsTextXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String appKey, String keywords, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (appKey == null) {
                throw new IllegalArgumentException("Parameter app_key of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("app_key", appKey);
            if (keywords == null) {
                throw new IllegalArgumentException("Parameter keywords of method getAsTextXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("keywords", keywords);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsTextXml is required and must not be null");
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
