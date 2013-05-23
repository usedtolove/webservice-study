import demo.spring.server.Customer;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * User: hjl
 * Date: 2013-5-24
 */
//@Ignore
public class TestRestClient {

    @Test
    public void testAddCustomer(){
        WebClient client = WebClient.create("http://localhost:8080/services/rest");
        client.path("customerservice/customers");
        client.type("application/xml").accept("application/xml");

        Customer customer = new Customer();
        customer.setName("Test_Customer_"+System.currentTimeMillis());
        Response r = client.post(customer);
        System.out.println(r);
    }

    @Test
    public void testGetCustomer(){
        WebClient client = WebClient.create("http://localhost:8080/services/rest");
        client.path("customerservice/customers/124");

        Customer c = client.get(Customer.class);
        System.out.println(c);
    }

    @Test
    public void testUpdateCustomer(){
        //get a customer
        WebClient client = WebClient.create("http://localhost:8080/services/rest");
        client.path("customerservice/customers/124");

        Customer customer = client.get(Customer.class);
        System.out.println(customer);

        //update customer
        client = WebClient.create("http://localhost:8080/services/rest");
        client.path("customerservice/customers");
        customer.setName("updated name");
        Response r = client.put(customer);
        System.out.println(r);
    }


}
