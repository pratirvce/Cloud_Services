package org.akhila.cloudservices.rest.apiresources;

import org.akhila.cloudservices.rest.model.Employee;
import org.akhila.cloudservices.rest.model.Order;
import org.akhila.cloudservices.rest.services.ServiceFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/order")
public class OrderResource extends BaseApiResource{
        @GET
        @Path("/{orderNumber}")
        @PermitAll
        @Produces(MediaType.APPLICATION_JSON)
        public Response getOrderByOrderNumber(@PathParam("orderNumber") int orderNumber,
                                                    @QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
            final Order order = ServiceFactory.getServiceFactory().getOrderService().getOrderByOrderNumber(orderNumber);
            if (order.getOrderNumber() == 0) {
                return generate404Response("Order Not Found");
            } else {
                return genarate200Response(order, callback);
            }
        }

}
