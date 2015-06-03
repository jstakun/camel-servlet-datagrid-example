Camel Servlet and JBoss Data Grid example
=======================================

An example which shows how to use the Camel Servlet with JBoss Data Grid.

You will need to package this example first:
  mvn package

To run the example deploy it in JBoss EAP.

POST http://localhost:8080/camel-example-servlet/camel/datagrid

putXml=<customerTransaction>
    <transactionid>29</transactionid>
    <customerid>CST01010</customerid> 
    <amount>523.45</amount>
</customerTransaction>

putMemcached=<customerTransaction>
    <transactionid>29</transactionid>
    <customerid>CST01010</customerid> 
    <amount>523.45</amount>
</customerTransaction>

putJson={"transactionid":"29","customerid":"CST01010","amount":523.45,"transactionDate":1433313993}

GET http://localhost:8080/camel-example-servlet/camel/datagrid?getXml=29

GET http://localhost:8080/camel-example-servlet/camel/datagrid?getJson=29

GET http://localhost:8080/camel-example-servlet/camel/datagrid?getMemcached=29

------------------------




