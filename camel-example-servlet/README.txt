Camel Servlet and JBoss Data Grid example
=======================================

An example which shows how to use the Camel Servlet with JBoss Data Grid.

This project depends on cdm project: https://github.com/jstakun/cdm.

To run the example deploy it to JBoss EAP using mvn jboss-as:deploy.

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

GET http://localhost:8080/camel-example-servlet/camel/hello?name=Jarek

------------------------




