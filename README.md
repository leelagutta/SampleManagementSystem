<h2> INTRODUCTION </h2> <br>
Sample application of customer management system and Mailing Application that reads and writes to and from the messaging system.<br>

<h3>TECH STACK OUTLINE </h3>
Java EE 8:Bean validation using JSR(349) 
Spring MVC 3.2.3 
RESTful/JSON services using Spring MVC 3.2.3
Web App Init using JavaConfig, no web.xml or any xml config
JMS 4.1.4/Spring support 
Java Mail API
Embedded Jetty
Messaging Broker - ActiveMQ
Maven 

<h3>Application demonstartes some of the key features of Java EE 8, Spring MVC 3.2.3 like </h3> <br>
1.Form/bean validations<br>
2.Building RESTful JSON services <br>
3.Web application initilization using JavaConfig (no Xml at all). <br>
4.Integrating spring(JMSTemplate) with Java Message Service(JMS) for messaging and working with activeMQ as message broker. <br>
5.Working with Java Mail API to send email notifications, which are read from the queue asynchronously. <br>

<h3>Tools to install</h3>
ActiveMQ: http://activemq.apache.org/download.html<br>
MySQL: http://dev.mysql.com/downloads/mysql/<br>
Maven 3: https://maven.apache.org/download.cgi<br>

<h3>sample-management-system application consists of three components</h3>
A WebMVC application <br>
A Mailing System <br>
Common Libraries - Including DataStore persistence and ActiveMQ configurations that are shared by both the applications. <br>


