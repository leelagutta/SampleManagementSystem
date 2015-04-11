<h2> INTRODUCTION </h2> <br>
Sample application of customer management system and Mailing Application that reads and writes to and from the messaging system.<br>

<h2>TECH STACK OUTLINE </h2>
1. Java EE 8:Bean validation using JSR(349) <br>
2. Spring MVC 3.2.3 <br>
3. RESTful/JSON services using Spring MVC 3.2.3<br>
4. Web App Init using JavaConfig, no web.xml or any xml config<br>
5. JMS 4.1.4/Spring support <br>
6. Java Mail API<br>
7. Embedded Jetty<br>
8. Messaging Broker - ActiveMQ<br>
9. Maven <br>

<h2>Application demonstartes some of the key features of Java EE 8, Spring MVC 3.2.3 like </h2> <br>
1. Form/bean validations<br>
2. Building RESTful JSON services <br>
3. Web application initilization using JavaConfig (no Xml at all). <br>
4. Integrating spring(JMSTemplate) with Java Message Service(JMS) for messaging and working with activeMQ as message broker. <br>
5. Working with Java Mail API to send email notifications, which are read from the queue asynchronously. <br>

<h2>Tools to install</h2>
ActiveMQ: http://activemq.apache.org/download.html<br>
MySQL: http://dev.mysql.com/downloads/mysql/<br>
Maven 3: https://maven.apache.org/download.cgi<br>
You can optionally use homebrew to install the binaries above<br>

<h3> Starting the Application </h3>

<h3>Run customerService</h3>
cd ~/{yourworkspace}/sample-management-system <br>
mvn exec:java -pl customerService<br>
Default port: 9001. You can also set another port by passing command line arguments as port number<br>

<h3>Run EmailService</h3>
cd ~/{yourworkspace}/sample-management-system <br>
mvn exec:java -pl emailService<br>

