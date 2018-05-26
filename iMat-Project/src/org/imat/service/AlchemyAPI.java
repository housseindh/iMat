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

public class AlchemyAPI {
    public final static URI BASE_URI=URI.create("https://access.alchemyapi.com/calls/data/");

    public static class AlchemyNews{
    	private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;
    	  public AlchemyNews() {
              _client = new Client();
              _uri = BASE_URI;
              _uriBuilder = UriBuilder.fromUri(BASE_URI);
              _uriBuilder = _uriBuilder.path("GetNews");
              _templateAndMatrixParameterValues = new HashMap<String, Object>();
          }
    	  
    	  public String getNews(HashMap<String,String> input){
    	try {
    		  UriBuilder localUriBuilder = _uriBuilder.clone();

              localUriBuilder = localUriBuilder.replaceQueryParam("outputMode", "json");
              localUriBuilder = localUriBuilder.replaceQueryParam("start", "now-3d");
              localUriBuilder = localUriBuilder.replaceQueryParam("end", "now");
              localUriBuilder = localUriBuilder.replaceQueryParam("count", "5");
              localUriBuilder = localUriBuilder.replaceQueryParam("return", "enriched.url.url,enriched.url.text,"
              		+ "enriched.url.title,enriched.url.image");
              localUriBuilder = localUriBuilder.replaceQueryParam("apikey", "70a1c17785c5fdb70e104cf1d9344c70b6acb15b");//a226a3cf902edee66a881a39472c6c3651fc17a4
              if(input.get("text")!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", URI.create(input.get("text")));
              else throw new Exception("Missing input Argument"); 
              
              WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
              com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
              resourceBuilder = resourceBuilder.accept("application/json");
              ClientResponse response;
              response = resourceBuilder.method("POST", ClientResponse.class);
              String res=response.getEntity(String.class);
         
  				JSONObject o=new JSONObject(res);
  				o=o.getJSONObject("result");
  				JSONArray a=o.getJSONArray("docs");
  				for(int i=0;i<a.length();i++){
  					JSONObject obj=a.getJSONObject(i);
  					obj.remove("id");
  					obj.remove("timestamp");

  					JSONObject obj1=obj.getJSONObject("source").getJSONObject("enriched").getJSONObject("url");
  					String img=obj1.getString("image");
  					String title=obj1.getString("title");
  					String text=obj1.getString("text");
  					String url=obj1.getString("url");

  					obj.remove("source");
  					obj.put("image", img);
  					obj.put("title", title);
  					obj.put("text", text);
  					obj.put("url", url);

  				}
  				
  			    return a.toString();
  			} catch (Exception e) {
  				e.printStackTrace();
  				return "{}";
  			} 
    	  }
    }
}
