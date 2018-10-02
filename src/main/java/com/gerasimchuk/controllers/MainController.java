package com.gerasimchuk.controllers;

import com.gerasimchuk.entities.OrderDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.WebResource.Builder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
public class MainController {

    private List<OrderDTO> getOrderDtoByWebServiceAsList(){
        ClientConfig clientConfig = new DefaultClientConfig();
        //clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource("http://localhost:8080/rest/mainservice/orders");
        Builder builder = webResource.accept(MediaType.APPLICATION_JSON).header("content-type", MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        if (response.getStatus() != 200){
            // bad
            System.out.println("Error 200");
            return null;
        }
        GenericType<List<OrderDTO>> generic = new GenericType<List<OrderDTO>>(){
        };
        List<OrderDTO> list = response.getEntity(generic);
        return list;
    }

    private String  getOrderDtoByWebServiceAsString(){
         //json as string
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/mainservice/orders");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus()!=200){
            System.out.println("failed");
        }
        String output = response.getEntity(String.class);
        output =  output.substring(12, output.length()-1);
//        output = "\'" + output + "\'";
        System.out.println("OUTPUT STRING = " + output);
        return output;
    }


    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String index(){
//        // json as list

        // json as string
//        Client client = Client.create();
//        WebResource webResource = client.resource("http://localhost:8080/rest/mainservice/get");
//        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
//        if (response.getStatus()!=200){
//            System.out.println("failed");
//        }
//        String output = response.getEntity(String.class);
//        System.out.println("Output from server:" + output);
        return "index";
    }

    @RequestMapping(value = "/getorders", method = RequestMethod.GET)
    @ResponseBody
    public String getOrderDTO(){
        return getOrderDtoByWebServiceAsString();
    }

    @RequestMapping(value = "/mainpage", method = RequestMethod.GET)
    public String mainPageGet(){
        return "/mainpage";
    }

}
