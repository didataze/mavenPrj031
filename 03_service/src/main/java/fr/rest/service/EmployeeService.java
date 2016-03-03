package fr.rest.service;

import com.rest.employee.model.Employee;
import com.rest.employee.model.Track;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by stepinfo on 03/03/16.
 */
@Path("/emp")
public class EmployeeService {

    @GET
    @Path("/get/{empID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("empID") String empID){
        Employee employee = new Employee();

        employee.setEmpID(empID);
        employee.setName("aze dida");
        employee.setEmail("aze@aze.aze");
        return employee;
    }

    @GET
    @Path("/getM")
    @Produces(MediaType.APPLICATION_JSON)
    public Track getTrackInJSON() {

        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");

        return track;

    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Employee createEmployee(Employee employee){
        return employee;
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Employee updateEmployee(Employee employee){

        employee.setName(employee.getName()+"updated");
        return employee;
    }

    @DELETE
    @Path("/delete/{empID}")
    public Response deleteEmployee(@PathParam("empID") int empID) throws URISyntaxException{
        return Response.status(200).entity("Employee with " + empID + "is deleted successfully").build();
    }
}
