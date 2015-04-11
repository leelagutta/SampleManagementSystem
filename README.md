<h2> INTRODUCTION </h2> <br>
Sample application of customer management system and Mailing Application that reads and writes to and from the messaging system.<br>

<h2>TECH STACK OUTLINE </h2>
Java EE 8:Bean validation using JSR(349) <br>
Spring MVC 3.2.3 <br>
RESTful/JSON services using Spring MVC 3.2.3<br>
Web App Init using JavaConfig, no web.xml or any xml config<br>
JMS 4.1.4/Spring support <br>
Java Mail API<br>
Embedded Jetty<br>
Messaging Broker - ActiveMQ<br>
Maven <br>

<h2>Application demonstartes some of the key features of Java EE 8, Spring MVC 3.2.3 like </h2> <br>
1.Form/bean validations<br>
2.Building RESTful JSON services <br>
3.Web application initilization using JavaConfig (no Xml at all). <br>
4.Integrating spring(JMSTemplate) with Java Message Service(JMS) for messaging and working with activeMQ as message broker. <br>
5.Working with Java Mail API to send email notifications, which are read from the queue asynchronously. <br>

<h2>Tools to install</h2>
ActiveMQ: http://activemq.apache.org/download.html<br>
MySQL: http://dev.mysql.com/downloads/mysql/<br>
Maven 3: https://maven.apache.org/download.cgi<br>
You can optionally use homebrew to install the binaries above<br>

<h3> Starting the Application </h3>

cd ~/{yourworkspace}/ <br>
mvn exec:java -pl <br>
Default port: 9001. You can also set another port by passing command line arguments as port number<br>

<h2>sample-management-system application consists of three components</h2>
A WebMVC application <br>
A Mailing System <br>
Common Libraries - Including DataStore persistence and ActiveMQ configurations that are shared by both the applications. <br>


