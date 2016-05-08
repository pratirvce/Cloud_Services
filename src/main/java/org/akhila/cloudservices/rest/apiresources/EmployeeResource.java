package org.akhila.cloudservices.rest.apiresources;
import net.sf.json.JSONArray;
import org.akhila.cloudservices.rest.model.Employee;
import org.akhila.cloudservices.rest.services.ServiceFactory;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/employee")
public class EmployeeResource extends BaseApiResource {
    @GET
    @Path("/{employeeNumber}")
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeByEmployeeNumber(@PathParam("employeeNumber") int employeeNumber,
                                                @QueryParam("callback") String callback) throws SQLException, ClassNotFoundException {
        final Employee employee = ServiceFactory.getServiceFactory().getEmployeeService()
                .getEmployeeByEmployeeNumber(employeeNumber);
        if (employee == null) {
            return generate404Response("Employee Not Found");
        } else {
            return genarate200Response(employee, callback);
        }
    }


    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public Response getALlEmployees(@QueryParam("callback") String callback) throws SQLException, ClientErrorException, ClassNotFoundException {
        final JSONArray allEmployees = ServiceFactory.getServiceFactory().getEmployeeService().getAllEmployees();
        if(allEmployees == null) {
            return generate404Response("No customers found");
        } else {
            return genarate200Response(allEmployees, callback);
        }
    }

}
