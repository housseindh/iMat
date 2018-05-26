
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
    "wadl|file:/C:/Users/lenovo/workspace/AMI/src/metacritic.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T05:33:06.432+03:00")
public class Metacritic {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://byroredux-metacritic.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Metacritic.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static Metacritic.FindGame findGame(Client client, URI baseURI) {
        return new Metacritic.FindGame(client, baseURI);
    }

    public static Metacritic.FindGame findGame() {
        return findGame(Client.create(), BASE_URI);
    }

    public static Metacritic.FindGame findGame(Client client) {
        return findGame(client, BASE_URI);
    }

    public static Metacritic.GameListPlatformList_type gameListPlatformList_type(Client client, URI baseURI, String platform, String listType) {
        return new Metacritic.GameListPlatformList_type(client, baseURI, platform, listType);
    }

    public static Metacritic.GameListPlatformList_type gameListPlatformList_type(String platform, String listType) {
        return gameListPlatformList_type(Client.create(), BASE_URI, platform, listType);
    }

    public static Metacritic.GameListPlatformList_type gameListPlatformList_type(Client client, String platform, String listType) {
        return gameListPlatformList_type(client, BASE_URI, platform, listType);
    }

    public static Metacritic.SearchGame searchGame(Client client, URI baseURI) {
        return new Metacritic.SearchGame(client, baseURI);
    }

    public static Metacritic.SearchGame searchGame() {
        return searchGame(Client.create(), BASE_URI);
    }

    public static Metacritic.SearchGame searchGame(Client client) {
        return searchGame(client, BASE_URI);
    }

    public static Metacritic.AlbumListComingSoon albumListComingSoon(Client client, URI baseURI) {
        return new Metacritic.AlbumListComingSoon(client, baseURI);
    }

    public static Metacritic.AlbumListComingSoon albumListComingSoon() {
        return albumListComingSoon(Client.create(), BASE_URI);
    }

    public static Metacritic.AlbumListComingSoon albumListComingSoon(Client client) {
        return albumListComingSoon(client, BASE_URI);
    }

    public static Metacritic.AlbumListNewReleasesOrder_by albumListNewReleasesOrder_by(Client client, URI baseURI, String orderBy) {
        return new Metacritic.AlbumListNewReleasesOrder_by(client, baseURI, orderBy);
    }

    public static Metacritic.AlbumListNewReleasesOrder_by albumListNewReleasesOrder_by(String orderBy) {
        return albumListNewReleasesOrder_by(Client.create(), BASE_URI, orderBy);
    }

    public static Metacritic.AlbumListNewReleasesOrder_by albumListNewReleasesOrder_by(Client client, String orderBy) {
        return albumListNewReleasesOrder_by(client, BASE_URI, orderBy);
    }

    public static Metacritic.SearchAlbum searchAlbum(Client client, URI baseURI) {
        return new Metacritic.SearchAlbum(client, baseURI);
    }

    public static Metacritic.SearchAlbum searchAlbum() {
        return searchAlbum(Client.create(), BASE_URI);
    }

    public static Metacritic.SearchAlbum searchAlbum(Client client) {
        return searchAlbum(client, BASE_URI);
    }

    public static Metacritic.FindMovie findMovie(Client client, URI baseURI) {
        return new Metacritic.FindMovie(client, baseURI);
    }

    public static Metacritic.FindMovie findMovie() {
        return findMovie(Client.create(), BASE_URI);
    }

    public static Metacritic.FindMovie findMovie(Client client) {
        return findMovie(client, BASE_URI);
    }

    public static Metacritic.MovieListComingSoon movieListComingSoon(Client client, URI baseURI) {
        return new Metacritic.MovieListComingSoon(client, baseURI);
    }

    public static Metacritic.MovieListComingSoon movieListComingSoon() {
        return movieListComingSoon(Client.create(), BASE_URI);
    }

    public static Metacritic.MovieListComingSoon movieListComingSoon(Client client) {
        return movieListComingSoon(client, BASE_URI);
    }

    public static Metacritic.MovieListNewReleasesOrder_by movieListNewReleasesOrder_by(Client client, URI baseURI, String orderBy) {
        return new Metacritic.MovieListNewReleasesOrder_by(client, baseURI, orderBy);
    }

    public static Metacritic.MovieListNewReleasesOrder_by movieListNewReleasesOrder_by(String orderBy) {
        return movieListNewReleasesOrder_by(Client.create(), BASE_URI, orderBy);
    }

    public static Metacritic.MovieListNewReleasesOrder_by movieListNewReleasesOrder_by(Client client, String orderBy) {
        return movieListNewReleasesOrder_by(client, BASE_URI, orderBy);
    }

    public static Metacritic.SearchMovie searchMovie(Client client, URI baseURI) {
        return new Metacritic.SearchMovie(client, baseURI);
    }

    public static Metacritic.SearchMovie searchMovie() {
        return searchMovie(Client.create(), BASE_URI);
    }

    public static Metacritic.SearchMovie searchMovie(Client client) {
        return searchMovie(client, BASE_URI);
    }

    public static Metacritic.TypeDescriptionType typeDescriptionType(Client client, URI baseURI, String type) {
        return new Metacritic.TypeDescriptionType(client, baseURI, type);
    }

    public static Metacritic.TypeDescriptionType typeDescriptionType(String type) {
        return typeDescriptionType(Client.create(), BASE_URI, type);
    }

    public static Metacritic.TypeDescriptionType typeDescriptionType(Client client, String type) {
        return typeDescriptionType(client, BASE_URI, type);
    }

    public static Metacritic.Reviews reviews(Client client, URI baseURI) {
        return new Metacritic.Reviews(client, baseURI);
    }

    public static Metacritic.Reviews reviews() {
        return reviews(Client.create(), BASE_URI);
    }

    public static Metacritic.Reviews reviews(Client client) {
        return reviews(client, BASE_URI);
    }

    public static Metacritic.UserReviews userReviews(Client client, URI baseURI) {
        return new Metacritic.UserReviews(client, baseURI);
    }

    public static Metacritic.UserReviews userReviews() {
        return userReviews(Client.create(), BASE_URI);
    }

    public static Metacritic.UserReviews userReviews(Client client) {
        return userReviews(client, BASE_URI);
    }

    public static class AlbumListComingSoon {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public AlbumListComingSoon(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("album-list/coming-soon");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private AlbumListComingSoon(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
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

    }

    public static class AlbumListNewReleasesOrder_by {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public AlbumListNewReleasesOrder_by(Client client, URI uri, String orderBy) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("album-list/new-releases/{order_by}");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("order_by", orderBy);
        }

        private AlbumListNewReleasesOrder_by(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Get order_by
         * 
         */
        public String getOrderBy() {
            return ((String) _templateAndMatrixParameterValues.get("order_by"));
        }

        /**
         * Duplicate state and set order_by
         * 
         */
        public Metacritic.AlbumListNewReleasesOrder_by setOrderBy(String orderBy) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("order_by", orderBy);
            return new Metacritic.AlbumListNewReleasesOrder_by(_client, copyUriBuilder, copyMap);
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

    }

    public static class FindGame {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        
        public FindGame() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("find/game");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public FindGame(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("find/game");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private FindGame(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }



        public<T >T postAsJson(Integer platform, String title, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (platform == null) {
                throw new IllegalArgumentException("Parameter platform of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("platform", platform);
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }
        
        public String findGame(String title) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            Integer platform= new Integer(0);
            localUriBuilder = localUriBuilder.replaceQueryParam("platform", platform);
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";

            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res=response.getEntity(String.class);
            try {
				JSONObject o=new JSONObject(res);
				o=o.getJSONObject("result");
  				return new JSONArray().put(o).toString();
			} catch (Exception e) {
				return "[]";
			} 
        }
        
        
        public String findGame(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            Integer platform= new Integer(0);
            localUriBuilder = localUriBuilder.replaceQueryParam("platform", platform);
            if (input.get("title") == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", input.get("title"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";

            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res=response.getEntity(String.class);
            try {
				JSONObject o=new JSONObject(res);
				o=o.getJSONObject("result");
			    return o.toString();
			} catch (Exception e) {
				return "()";
			} 
        }


    }

    public static class FindMovie {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public FindMovie() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("find/movie");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        public FindMovie(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("find/movie");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private FindMovie(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }


        public<T >T postAsJson(String title, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }
        
        public String findMovie(String title) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res=response.getEntity(String.class);
            try {
				JSONObject o=new JSONObject(res);
				o=o.getJSONObject("result");
  				return new JSONArray().put(o).toString();
			} catch (Exception e) {
				return "[]";
			} 
        }

        
        public String findMovie(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (input.get("title") == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", input.get("title"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res=response.getEntity(String.class);
            try {
				JSONObject o=new JSONObject(res);
				o=o.getJSONObject("result");
			    return o.toString();
			} catch (Exception e) {
				return "()";
			} 
        }
     

    }

    public static class GameListPlatformList_type {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public GameListPlatformList_type(Client client, URI uri, String platform, String listType) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("game-list/{platform}/{list_type}");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("platform", platform);
            _templateAndMatrixParameterValues.put("list_type", listType);
        }

        private GameListPlatformList_type(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Get platform
         * 
         */
        public String getPlatform() {
            return ((String) _templateAndMatrixParameterValues.get("platform"));
        }

        /**
         * Duplicate state and set platform
         * 
         */
        public Metacritic.GameListPlatformList_type setPlatform(String platform) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("platform", platform);
            return new Metacritic.GameListPlatformList_type(_client, copyUriBuilder, copyMap);
        }

        /**
         * Get list_type
         * 
         */
        public String getListType() {
            return ((String) _templateAndMatrixParameterValues.get("list_type"));
        }

        /**
         * Duplicate state and set list_type
         * 
         */
        public Metacritic.GameListPlatformList_type setListType(String listType) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("list_type", listType);
            return new Metacritic.GameListPlatformList_type(_client, copyUriBuilder, copyMap);
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

    }

    public static class MovieListComingSoon {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public MovieListComingSoon(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("movie-list/coming-soon");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private MovieListComingSoon(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
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

    }

    public static class MovieListNewReleasesOrder_by {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public MovieListNewReleasesOrder_by(Client client, URI uri, String orderBy) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("movie-list/new-releases/{order_by}");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("order_by", orderBy);
        }

        private MovieListNewReleasesOrder_by(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Get order_by
         * 
         */
        public String getOrderBy() {
            return ((String) _templateAndMatrixParameterValues.get("order_by"));
        }

        /**
         * Duplicate state and set order_by
         * 
         */
        public Metacritic.MovieListNewReleasesOrder_by setOrderBy(String orderBy) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("order_by", orderBy);
            return new Metacritic.MovieListNewReleasesOrder_by(_client, copyUriBuilder, copyMap);
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

    }

    public static class Reviews {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Reviews(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("reviews");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Reviews(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(String url, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
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

        public<T >T getAsJson(String url, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
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

        public<T >T getAsJson(String url, String xMashapeKey, Sort sort, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("sort", sort);
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

        public<T >T getAsJson(String url, String xMashapeKey, Sort sort, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("sort", sort);
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

    public static class SearchAlbum {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public SearchAlbum(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/album");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private SearchAlbum(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T postAsJson(String title, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postAsJson(String title, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postAsJson(String title, String xMashapeKey, Max_pages maxPages, Retry retry, Integer yearFrom, Integer yearTo, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            localUriBuilder = localUriBuilder.replaceQueryParam("max_pages", maxPages);
            localUriBuilder = localUriBuilder.replaceQueryParam("retry", retry);
            localUriBuilder = localUriBuilder.replaceQueryParam("year_from", yearFrom);
            localUriBuilder = localUriBuilder.replaceQueryParam("year_to", yearTo);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postAsJson(String title, String xMashapeKey, Max_pages maxPages, Retry retry, Integer yearFrom, Integer yearTo, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            localUriBuilder = localUriBuilder.replaceQueryParam("max_pages", maxPages);
            localUriBuilder = localUriBuilder.replaceQueryParam("retry", retry);
            localUriBuilder = localUriBuilder.replaceQueryParam("year_from", yearFrom);
            localUriBuilder = localUriBuilder.replaceQueryParam("year_to", yearTo);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class SearchGame {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public SearchGame() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("search/game");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        
        public SearchGame(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/game");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private SearchGame(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

   
        public<T >T postAsJson(Integer platform, String title, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (platform == null) {
                throw new IllegalArgumentException("Parameter platform of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("platform", platform);
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }
        
       
        public String searchGame(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            Integer platform=new Integer(0);
            localUriBuilder = localUriBuilder.replaceQueryParam("platform", platform);
            if (input.get("title") == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", input.get("title"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res= response.getEntity(String.class);
            try{
            	JSONObject o=new JSONObject(res);
            	o=o.getJSONArray("results").getJSONObject(0);
            	FindGame f=new FindGame();
            	return f.findGame(o.getString("name"));
            }
            catch(Exception e){
            	return "{}";
            }
        }



    }

    public static class SearchMovie {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        
        public SearchMovie() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("search/movie");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public SearchMovie(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("search/movie");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private SearchMovie(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

   

        public<T >T postAsJson(String title, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (title == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", title);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            if (xMashapeKey == null) {
                throw new IllegalArgumentException("Parameter X-Mashape-Key of method postAsJson is required and must not be null");
            }
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public String searchMovie(HashMap<String,String> input) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (input.get("title") == null) {
                throw new IllegalArgumentException("Parameter title of method postAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("title", input.get("title"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class);
            String res= response.getEntity(String.class);
            try{
            	JSONObject o=new JSONObject(res);
            	o=o.getJSONArray("results").getJSONObject(0);
            	FindMovie f=new FindMovie();
            	return f.findMovie(o.getString("name"));
            }
            catch(Exception e){
            	return "{}";
            }
        }


    }

    public static class TypeDescriptionType {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public TypeDescriptionType(Client client, URI uri, String type) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("type-description/{type}");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("type", type);
        }

        private TypeDescriptionType(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Get type
         * 
         */
        public String getType() {
            return ((String) _templateAndMatrixParameterValues.get("type"));
        }

        /**
         * Duplicate state and set type
         * 
         */
        public Metacritic.TypeDescriptionType setType(String type) {
            Map<String, Object> copyMap;
            copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
            UriBuilder copyUriBuilder = _uriBuilder.clone();
            copyMap.put("type", type);
            return new Metacritic.TypeDescriptionType(_client, copyUriBuilder, copyMap);
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

        public<T >T getAsJson(String xMashapeKey, Retry retry, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("retry", retry);
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

        public<T >T getAsJson(String xMashapeKey, Retry retry, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("retry", retry);
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

    public static class UserReviews {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public UserReviews(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("user-reviews");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private UserReviews(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(String url, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
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

        public<T >T getAsJson(String url, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
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

        public<T >T getAsJson(String url, String xMashapeKey, Integer pageCount, Sort sort, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("page_count", pageCount);
            localUriBuilder = localUriBuilder.replaceQueryParam("sort", sort);
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

        public<T >T getAsJson(String url, String xMashapeKey, Integer pageCount, Sort sort, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (url == null) {
                throw new IllegalArgumentException("Parameter url of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("page_count", pageCount);
            localUriBuilder = localUriBuilder.replaceQueryParam("sort", sort);
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
