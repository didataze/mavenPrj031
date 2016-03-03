import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by stepinfo on 03/03/16.
 */
public class EmpPUTClient {

    public static void main(String[] args){

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/emp/update");

        Employee employee = new Employee();
        employee.setEmpID("350");
        employee.setName("azedidate");
        employee.setEmail("adddd@dd.com");

        ClientResponse response = webResource.type("application/xml").put(ClientResponse.class, employee);

        System.out.println("Update Operation Response Processing ....\n");
        String output = response.getEntity(String.class);
        System.out.print(output);

    }
}
