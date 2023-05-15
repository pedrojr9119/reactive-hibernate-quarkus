package org.acme;

import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/client")
public class ClientResource {

    @Inject
    ClientRepository repository;

    @GET
    public Uni<RestResponse<List<Object>>> findAll() {
        return repository.findAll().map(response -> RestResponse.ResponseBuilder.ok(response).build());
    }

}