# ECommerce
Sample backend application for an e-commerce website.

Technologies Used:
Java (Spring Boot)
Mysql

Features:
1.CRUD operations on items
2.All items listing
3.Single & bulk ordering (Just consider the item, no. of items & email ids as params for ordering)
4.All orders

Api for the features:

1.CRUD operations on items

CREATE API:
http://localhost:8080/save

Body:
{
	"productName":"pencils",
	"productQuantity":10,
	"productPrice":20
}

READ API:
http://localhost:8080/product/{productName}

UPDATE API:
http://localhost:8080/update

Body:
{
	"fromName":"pens",
	"toName":"pencils"
}

DELETE API:
http://localhost:8080/delete/{productName}

2.All items listing
API:
http://localhost:8080/allProducts

3.Single & bulk ordering (Just consider the item, no. of items & email ids as params for ordering)
API:
http://localhost:8080/order

Body:
{
	"name":"pencils",
	"quantity":5,
	"email":"karthik.ganesankarthik.ganesan@gmail.com"
}

4.All Orders
API:
http://localhost:8080/allOrders

Note:
This project has controller, service and dao layers
controller recieves api hit from client, calls the service layer, gets the data and sends the data back to the client.
service recieves call from controller, gets the data from dao, changes the data if necessary and sends the data to controller.
dao recieves call from service and sends the data to service.

