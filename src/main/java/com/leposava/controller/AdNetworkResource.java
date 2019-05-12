package com.leposava.controller;

import com.leposava.model.AdNetwork;
import com.leposava.repository.AdNetworksDAO;

import javax.faces.bean.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

@Path("networks")
@RequestScoped
public class AdNetworkResource {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllNetworks(@QueryParam("order") String order) {
        List<AdNetwork> adNetworkList = AdNetworksDAO.getInstance().getAllNetworks(order);
        if(adNetworkList == null || adNetworkList.size() <= 0){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(adNetworkList.toArray(new AdNetwork[adNetworkList.size()])).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addNetworks(List<AdNetwork> adNetworks){
        List<AdNetwork> adNetworksCreated = new LinkedList<>();
        for(AdNetwork adNetwork : adNetworks){
           adNetworksCreated.add(AdNetworksDAO.getInstance().saveNetwork(adNetwork));
        }
        return Response.ok(adNetworksCreated.toArray(new AdNetwork[adNetworksCreated.size()])).build();

    }

}
