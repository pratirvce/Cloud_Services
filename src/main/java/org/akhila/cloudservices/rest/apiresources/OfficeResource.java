package org.akhila.cloudservices.rest.apiresources;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Employee;
import org.akhila.cloudservices.rest.model.Office;
import org.akhila.cloudservices.rest.services.ServiceFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/office")
public class OfficeResource extends BaseApiResource{
    @GET
    @Path("/{officeCode}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOfficeByOfficeNumber(@PathParam("officeCode") String officeCode,
                                                @QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
        final Office office = ServiceFactory.getServiceFactory().getOfficeService().getOfficeByOfficeCode(officeCode);
        if (office == null) {
            return generate404Response("Offices not found Not Found");
        } else {
            return genarate200Response(office, callback);
        }
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOffices(@QueryParam("callback") String callback) throws SQLException, ClientErrorException, ClassNotFoundException {
        final JSONArray allOffices = ServiceFactory.getServiceFactory().getOfficeService().getAllOffices();
        if(allOffices == null) {
            return generate404Response("No offices found");
        } else {
            return genarate200Response(allOffices, callback);
        }
    }

}
