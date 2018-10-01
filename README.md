
MySQL Change Data Capture
======================================

The **MySQLcdc** is a simple java console application which reads MySQL's binlog and capture the change data real-time. Change data is the database changes including table creations, deletions, data insertions, deletions, updates and etc.

## Prerequisites

* Make sure you have MySQL installed on your computer.
* The MySQL server must be configured to use a row-level binary log. 
* Add mysql jdbc connector to your project.
you may download the jdbc driver with the following link.
https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.45.tar.gz
* Add shyiko mysql binlog reader to your project. Please follow the link given.
https://mvnrepository.com/artifact/com.github.shyiko/mysql-binlog-connector-java/0.16.1

## How to use
* Download or clone this repository and run in your favourite IDE. IntelliJ idea is recommended.
* While the application is running, do INSERT, UPDATE or DELETE operation to the MySQL database. Observe the change data events are printed on the console. Note that only the INSERT, UPDATE or DELETE operations are filtered and printed on the console. You can edit the program to capture other change events.

## How to develop.

* You can develop this code to retrieve a specific change data operation details. Eg: Retrieve only insert events with the row details of insertions. Navigate to  `onEvent(Event event)` method in `MysqlBinLogReader` class. You can get the specific details from the change event by calling relevant methods of `event` object.