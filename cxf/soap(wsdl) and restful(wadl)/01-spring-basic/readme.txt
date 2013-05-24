1. mvn clean jetty:run

2. For SOAP(access by browser):
   http://localhost:8080/services/CustomerService?wsdl
   http://localhost:8080/services/CustomerService/getCustomer?id=123
   http://localhost:8080/services/CustomerService/deleteCustomer?id=123
   http://localhost:8080/services/CustomerService/getOrder?orderId=223

3. For REST(access by browser):
   http://localhost:8080/services/rest/?_wadl
   http://localhost:8080/services/rest/customerservice/customers/123
   http://localhost:8080/services/rest/customerservice/customers/123.json
   http://localhost:8080/services/rest/customerservice/orders/223
   http://localhost:8080/services/rest/customerservice/orders/223.json
   http://localhost:8080/services/rest/customerservice/customers/123?_method=DELETE

   ps:PUT and POST can not test by browser directly,
      use TestRestClient (UnitTest) instead.

4. mvn jetty:stop
