
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
    "wadl|file:/C:/Users/lenovo/AppData/Local/Temp/wadl_5174356906630526773.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2015-04-05T19:46:11.007+03:00")
public class DBPedia {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://spotlight.sztaki.hu:2222/rest/annotate/"); //http://spotlight.sztaki.hu:2222/rest //http://spotlight.dbpedia.org/rest
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = DBPedia.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
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

    public static DBPedia.Candidates candidates(Client client, URI baseURI) {
        return new DBPedia.Candidates(client, baseURI);
    }

    public static DBPedia.Candidates candidates() {
        return candidates(Client.create(), BASE_URI);
    }

    public static DBPedia.Candidates candidates(Client client) {
        return candidates(client, BASE_URI);
    }

    public static DBPedia.Annotate annotate(Client client, URI baseURI) {
        return new DBPedia.Annotate(client, baseURI);
    }

    public static DBPedia.Annotate annotate() {
        return annotate(Client.create(), BASE_URI);
    }

    public static DBPedia.Annotate annotate(Client client) {
        return annotate(client, BASE_URI);
    }

    public static DBPedia.Disambiguate disambiguate(Client client, URI baseURI) {
        return new DBPedia.Disambiguate(client, baseURI);
    }

    public static DBPedia.Disambiguate disambiguate() {
        return disambiguate(Client.create(), BASE_URI);
    }

    public static DBPedia.Disambiguate disambiguate(Client client) {
        return disambiguate(client, BASE_URI);
    }

    public static DBPedia.Feedback feedback(Client client, URI baseURI) {
        return new DBPedia.Feedback(client, baseURI);
    }

    public static DBPedia.Feedback feedback() {
        return feedback(Client.create(), BASE_URI);
    }

    public static DBPedia.Feedback feedback(Client client) {
        return feedback(client, BASE_URI);
    }

    public static DBPedia.Spot spot(Client client, URI baseURI) {
        return new DBPedia.Spot(client, baseURI);
    }

    public static DBPedia.Spot spot() {
        return spot(Client.create(), BASE_URI);
    }

    public static DBPedia.Spot spot(Client client) {
        return spot(client, BASE_URI);
    }

    public static class Annotate {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Annotate(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("/annotate");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Annotate(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsTextTurtle(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            if(spotter!=null)localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            if(prefix!=null)localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            if(urirecipe!=null)localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            if(contextLength!=null)localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            if(spotter!=null)localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
           
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextHtml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextHtml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXhtmlXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXhtmlXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            if(spotter!=null)localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Candidates {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Candidates(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
           // _uriBuilder = _uriBuilder.path("/candidates");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Candidates(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            if(spotter!=null)localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
       
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            try{response = resourceBuilder.method("GET", ClientResponse.class);
            
            return response.getEntity(returnType);}
            catch(Exception e){
            	return null;
            }
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String spotter, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            if(spotter!=null)localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
          
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Disambiguate {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Disambiguate(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("/disambiguate");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Disambiguate(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsTextTurtle(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextHtml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXhtmlXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
          
            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            
            
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextHtml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextHtml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/html");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXhtmlXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXhtmlXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xhtml+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);
            localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, Double confidence, Integer support, String types, String sparql, String policy, Boolean coreferenceresolution, String disambiguator, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if(text!=null)localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            if(confidence!=null)localUriBuilder = localUriBuilder.replaceQueryParam("confidence", confidence);
            if(support!=null)localUriBuilder = localUriBuilder.replaceQueryParam("support", support);
            if(types!=null)localUriBuilder = localUriBuilder.replaceQueryParam("types", types);
            if(sparql!=null)localUriBuilder = localUriBuilder.replaceQueryParam("sparql", sparql);
            if(policy!=null)localUriBuilder = localUriBuilder.replaceQueryParam("policy", policy);
            if(coreferenceresolution!=null)localUriBuilder = localUriBuilder.replaceQueryParam("coreferenceResolution", coreferenceresolution);

            if(disambiguator!=null)localUriBuilder = localUriBuilder.replaceQueryParam("disambiguator", disambiguator);

            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

    public static class Feedback {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Feedback(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("/feedback");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Feedback(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

    }

    public static class Spot {

        private Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;
        private URI _uri;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Spot(Client client, URI uri) {
            _client = client;
            _uri = uri;
            _uriBuilder = UriBuilder.fromUri(uri);
            _uriBuilder = _uriBuilder.path("/spot");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        private Spot(Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        public<T >T getAsTextTurtle(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextTurtle(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextPlain(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsRdfXml(String text, String url, String spotter, String prefix, String urirecipe, Integer contextLength, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            localUriBuilder = localUriBuilder.replaceQueryParam("prefix", prefix);
            localUriBuilder = localUriBuilder.replaceQueryParam("urirecipe", urirecipe);
            localUriBuilder = localUriBuilder.replaceQueryParam("context-length", contextLength);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, String spotter, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String text, String url, String spotter, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextTurtle(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/turtle");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsTextPlain(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/plain");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsRdfXml(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/rdf+xml");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T postXWwwFormUrlencodedAsJson(Object input, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            resourceBuilder = resourceBuilder.type("application/x-www-form-urlencoded");
            ClientResponse response;
            response = resourceBuilder.method("POST", ClientResponse.class, input);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, String spotter, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsTextXml(String text, String url, String spotter, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
           if(text!=null) localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
           if(url!=null) localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
           if(spotter!=null) localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("text/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String text, String url, String spotter, GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

        public<T >T getAsXml(String text, String url, String spotter, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            localUriBuilder = localUriBuilder.replaceQueryParam("text", text);
            localUriBuilder = localUriBuilder.replaceQueryParam("url", url);
            localUriBuilder = localUriBuilder.replaceQueryParam("spotter", spotter);
            WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/xml");
            ClientResponse response;
            response = resourceBuilder.method("GET", ClientResponse.class);
            return response.getEntity(returnType);
        }

    }

}
