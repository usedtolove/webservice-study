======================================================
For SOAP:
1. mvn clean jetty:run

2. http://localhost:8888/services/CustomerService?wsdl
   http://localhost:8888/services/CustomerService/getCustomer?id=123
   http://localhost:8888/services/CustomerService/deleteCustomer?arg0=123
   http://localhost:8888/services/CustomerService/getOrder?arg0=223

3. mvn jetty:stop
======================================================
For REST:
1. mvn clean jetty:run

3. http://localhost:8888/services/rest/?_wadl&_type=xml
   GET http://localhost:8888/services/rest/customerservice/customers/123
   GET http://localhost:8888/services/rest/customerservice/orders/223/
	
   ps:PUT / DELETE may not test by browser directly	

3. mvn jetty:stop
======================================================