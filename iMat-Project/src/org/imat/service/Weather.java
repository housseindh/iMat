
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
    "wadl|file:/C:/Users/lenovo/workspace/AMI/src/weather.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T05:38:35.066+03:00")
public class Weather {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("https://simple-weather.p.mashape.com/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Weather.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

   

    public static Weather.Weatherdata weatherdata(Client client, URI baseURI) {
        return new Weather.Weatherdata(client, baseURI);
    }

    public static Weather.Weatherdata weatherdata() {
        return weatherdata(Client.create(), BASE_URI);
    }

    public static Weather.Weatherdata weatherdata(Client client) {
        return weatherdata(client, BASE_URI);
    }

    public static class Weatherdata {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Weatherdata(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("weatherdata");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        
        public Weatherdata() {
            _client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("weatherdata");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Weatherdata(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(Double lat, Double lng, String xMashapeKey, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (lat == null) {
                throw new IllegalArgumentException("Parameter lat of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lat", lat);
            if (lng == null) {
                throw new IllegalArgumentException("Parameter lng of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lng", lng);
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

        public<T >T getAsJson(Double lat, Double lng, String xMashapeKey, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (lat == null) {
                throw new IllegalArgumentException("Parameter lat of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lat", lat);
            if (lng == null) {
                throw new IllegalArgumentException("Parameter lng of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lng", lng);
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
        
        
        public String fullWeather(HashMap<String,String> map) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (map.get("lat") == null) {
                throw new IllegalArgumentException("Parameter lat of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lat", map.get("lat"));
            if (map.get("lng") == null) {
                throw new IllegalArgumentException("Parameter lng of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lng", map.get("lng"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(String.class);
        }
        
        public 	String currentWeather(HashMap<String,String> map) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (map.get("lat") == null) {
                throw new IllegalArgumentException("Parameter lat of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lat", map.get("lat"));
            if (map.get("lng") == null) {
                throw new IllegalArgumentException("Parameter lng of method getAsJson is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lng", map.get("lng"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            String result= response.getEntity(String.class);
           try{
           	JSONObject res=new JSONObject();
            JSONObject obj=new JSONObject(result);
            obj=obj.getJSONObject("query");
            obj=obj.getJSONObject("results");
            obj=obj.getJSONObject("channel");
            
            JSONObject units,atm,loc,astr,wind;
            units= obj.getJSONObject("units");
            res.put("distance unit", units.getString("distance"));
            res.put("pressure unit", units.getString("pressure"));
            res.put("speed unit", units.getString("speed"));
            res.put("temperature unit", units.getString("temperature"));

            atm=obj.getJSONObject("atmosphere");
            res.put("humidity", atm.getString("humidity"));
            res.put("pressure", atm.getString("pressure"));
            res.put("rising", atm.getString("rising"));
            res.put("visibility", atm.getString("visibility"));

            loc=obj.getJSONObject("location");
            res.put("city", loc.getString("city"));
            res.put("country", loc.getString("country"));
            res.put("region", loc.getString("region"));
            
            astr=obj.getJSONObject("astronomy");
            res.put("sunrise", astr.getString("sunrise"));
            res.put("sunset", astr.getString("sunset"));
            
            wind=obj.getJSONObject("wind");
            res.put("chill", wind.getString("chill"));
            res.put("direction", wind.getString("direction"));
            res.put("speed", wind.getString("speed"));
           
            obj=obj.getJSONObject("item");
            obj=obj.getJSONObject("condition");
            res.put("date", obj.getString("date"));
            res.put("temp", obj.getString("temp"));
            res.put("text", obj.getString("text"));

				return new JSONArray().put(res).toString();
           }
           catch (Exception e){
        	   e.printStackTrace();
        	   return "{}";
           }
        }

        public String dayWeather(HashMap<String,String> map) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (map.get("lat") == null) {
                throw new IllegalArgumentException("Parameter lat of method dayWeather is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lat", map.get("lat"));
            if (map.get("lng") == null) {
                throw new IllegalArgumentException("Parameter lng of method dayWeather is required and must not be null");
            }
            if (map.get("day") == null) {
                throw new IllegalArgumentException("Parameter day of method dayWeather is required and must not be null");
            }
            localUriBuilder = localUriBuilder.replaceQueryParam("lng", map.get("lng"));
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            String xMashapeKey="JJrpWPjJOXmsh6hbF5VkOWCf1zZ2p1nS7RFjsnMFkWVVTbZbjr";
            if (xMashapeKey!= null) {
                resourceBuilder = resourceBuilder.header("X-Mashape-Key", xMashapeKey);
            }
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            String result= response.getEntity(String.class);
           try{
        	JSONObject res=new JSONObject();
            JSONObject obj=new JSONObject(result);
            obj=obj.getJSONObject("query");
            obj=obj.getJSONObject("results");
            obj=obj.getJSONObject("channel");
            
            JSONObject units,loc;
            units= obj.getJSONObject("units");
            
            res.put("distance unit", units.getString("distance"));
            res.put("pressure unit", units.getString("pressure"));
            res.put("speed unit", units.getString("speed"));
            res.put("temperature unit", units.getString("temperature"));



            loc=obj.getJSONObject("location");
            res.put("city", loc.getString("city"));
            res.put("country", loc.getString("country"));
            res.put("region", loc.getString("region"));
            
 
           
            obj=obj.getJSONObject("item");
            JSONArray arr=obj.getJSONArray("forecast");
            for(int i=0;i<arr.length();i++){
            	obj=arr.getJSONObject(i);
            	if(map.get("day").contains(obj.getString("day").toLowerCase())) break;
            }
            res.put("date", obj.getString("date"));
            res.put("day", obj.getString("day"));
            res.put("high", obj.getString("high"));
            res.put("low", obj.getString("low"));
            res.put("text", obj.getString("text"));
            
				return new JSONArray().put(res).toString();
           }
           catch (Exception e){
        	   e.printStackTrace();
        	   return "{}";
           }
        }


    }

}
