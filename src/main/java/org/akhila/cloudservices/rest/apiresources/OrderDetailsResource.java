package org.akhila.cloudservices.rest.apiresources;

import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Office;
import org.akhila.cloudservices.rest.model.OrderDetails;
import org.akhila.cloudservices.rest.services.ServiceFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/orderdetail")
public class OrderDetailsResource extends BaseApiResource {
    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderDetailsByOrderNumberAndProductCode(@QueryParam("orderNumber") int orderNumber, @QueryParam("productCode") String productCode,
                                            @QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
        final OrderDetails orderDetails = ServiceFactory.getServiceFactory().getOrderDetailsService().getOrderDetailsByOrderNumberAndProductCode(orderNumber, productCode);
        if ( orderDetails == null) {
            return generate404Response("No order found found Not Found");
        } else {
            return genarate200Response(orderDetails, callback);
        }
    }
    @GET
    @PermitAll
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrderDetails(@QueryParam("callback") String callback) throws SQLException, ClientErrorException, ClassNotFoundException {
        final JSONArray allOrderDetails = ServiceFactory.getServiceFactory().getOrderDetailsService().getAllOrderDetails();
        if(allOrderDetails == null) {
            return generate404Response("No orders found");
        } else {
            return genarate200Response(allOrderDetails, callback);
        }
    }
}
