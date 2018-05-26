package org.imat.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GoogleLocation {
    public final static URI BASE_URI=URI.create("https://maps.googleapis.com/maps/api/geocode/");
    
    public static class GoogleGeoCode{
    	private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;
        
        public GoogleGeoCode(){
        	_client = new Client();
            _uri = BASE_URI;
            _uriBuilder = UriBuilder.fromUri(BASE_URI);
            _uriBuilder = _uriBuilder.path("json");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }
        
        public String getLocation(HashMap<String,String> input){
        	try {
        		  UriBuilder localUriBuilder = _uriBuilder.clone();


                  localUriBuilder = localUriBuilder.replaceQueryParam("key", "AIzaSyBstshXqTR4wb0exbqm7JSHJO9vUNe5wKY");
                  if(input.get("address")!=null)localUriBuilder = localUriBuilder.replaceQueryParam("address", input.get("address"));
                  else throw new Exception("Missing input Argument"); 
                  
                  WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                  com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                  resourceBuilder = resourceBuilder.accept("application/json");
                  ClientResponse response;
                  response = resourceBuilder.method("GET", ClientResponse.class);
                  String res=response.getEntity(String.class);

      				JSONObject o=new JSONObject(res);
      				o=o.getJSONArray("results").getJSONObject(0);
      				o=o.getJSONObject("geometry");
      				o=o.getJSONObject("location");
      				
      				return new JSONArray().put(o).toString();
      			} catch (Exception e) {
      				e.printStackTrace();
      				return "[]";
      			} 
        	  }
        
        
    }
}
