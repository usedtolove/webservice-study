1. mvn clean jetty:run
   start up this demo in jetty

2. http://localhost:8080/services
   check available web services

3. use web services
   http://localhost:8080/services/HelloWorld/sayHi?name=whatever
   get output: String

   http://localhost:8080/services/HelloWorld/getUser?name=whatever
   get output: User

   http://localhost:8080/services/HelloWorld/getSimpleList?num=5
   get output: List<Integer>

   http://localhost:8080/services/HelloWorld/getComplexList
   get output: List<User>

 caution:
 to avoid the http get bug,
 upgrade cxf version to 2.7.x,
 and run test case instead of browser!