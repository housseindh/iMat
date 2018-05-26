
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
    "wadl|file:/C:/Users/lenovo/workspace/AMI/src/spotify.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T05:41:01.097+03:00")
public class Spotify {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://mager-spotify-web.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Spotify.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static Spotify.Lookup1Json lookup1Json(Client client, URI baseURI) {
        return new Spotify.Lookup1Json(client, baseURI);
    }

    public static Spotify.Lookup1Json lookup1Json() {
        return lookup1Json(Client.create(), BASE_URI);
    }

    public static Spotify.Lookup1Json lookup1Json(Client client) {
        return lookup1Json(client, BASE_URI);
    }

    public static Spotify.Search1AlbumJson search1AlbumJson(Client client, URI baseURI) {
        return new Spotify.Search1AlbumJson(client, baseURI);
    }

    public static Spotify.Search1AlbumJson search1AlbumJson() {
        return search1AlbumJson(Client.create(), BASE_URI);
    }

    public static Spotify.Search1AlbumJson search1AlbumJson(Client client) {
        return search1AlbumJson(client, BASE_URI);
    }

    public static Spotify.Search1ArtistJson search1ArtistJson(Client client, URI baseURI) {
        return new Spotify.Search1ArtistJson(client, baseURI);
    }

    public static Spotify.Search1ArtistJson search1ArtistJson() {
        return search1ArtistJson(Client.create(), BASE_URI);
    }

    public static Spotify.Search1ArtistJson search1ArtistJson(Client client) {
        return search1ArtistJson(client, BASE_URI);
    }

    public static Spotify.Search1TrackJson search1TrackJson(Client client, URI baseURI) {
        return new Spotify.Search1TrackJson(client, baseURI);
    }

    public static Spotify.Search1TrackJson search1TrackJson() {
        return search1TrackJson(Client.create(), BASE_URI);
    }

    public static Spotify.Search1TrackJson search1TrackJson(Client client) {
        return search1TrackJson(client, BASE_URI);
    }

    public static class Lookup1Json {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Lookup1Json(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("lookup/1/.json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Lookup1Json(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsXml(String extras, String uri, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (extras == null) {
                throw new IllegalArgumentException("Parameter extras of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("extras", extras);
            if (uri == null) {
                throw new IllegalArgumentException("Parameter uri of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("uri", uri);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String extras, String uri, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (extras == null) {
                throw new IllegalArgumentException("Parameter extras of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("extras", extras);
            if (uri == null) {
                throw new IllegalArgumentException("Parameter uri of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("uri", uri);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Search1AlbumJson {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Search1AlbumJson(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/1/album.json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Search1AlbumJson(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsXml(String q, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String q, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Search1ArtistJson {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Search1ArtistJson(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/1/artist.json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Search1ArtistJson(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsXml(String q, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String q, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Search1TrackJson {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Search1TrackJson(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/1/track.json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Search1TrackJson(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsXml(String q, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String q, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (q == null) {
                throw new IllegalArgumentException("Parameter q of method getAsXml is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("q", q);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method getAsXml is required and must not be null");
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
