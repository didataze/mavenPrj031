import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by stepinfo on 03/03/16.
 */
public class EmpPOSTClient {

    public static void main(String[] args){

        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:8080/rest/emp/create");

        Employee employee = new Employee();
        employee.setEmpID("260");
        employee.setName("didataze");
        employee.setEmail("aze@aze.com");

        ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, employee);

        System.out.println("Create Operation Response Processing ....\n");
        String output = response.getEntity(String.class);
        System.out.print(output);

    }
}
