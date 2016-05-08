package org.akhila.cloudservices.rest.apiresources;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Customer;
import org.akhila.cloudservices.rest.services.CustomerService;
import org.akhila.cloudservices.rest.services.ServiceFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/customer")
/*http://localhost:8080/OrderManagement/webapi/customer*/
public class CustomerResource extends BaseApiResource {
    @GET
    @Path("/{customerNumber}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByCustomerNumber(@PathParam("customerNumber") int customerNumber,
            @QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
        final Customer customer = ServiceFactory.getServiceFactory().getCustomerService()
                .getCustomerByCustomerNumber(customerNumber);
        if (customer == null) {
            return generate404Response("Customer Not Found");
        } else {
            return genarate200Response(customer, callback);
        }
    }

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(@QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
        final JSONArray allCustomers = ServiceFactory.getServiceFactory().getCustomerService()
                .getAllCustomers();
        if (allCustomers == null) {
            return generate404Response("No customers found");
        } else {
            return genarate200Response(allCustomers, callback);
        }
    }
}
