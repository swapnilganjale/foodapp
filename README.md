For Requirement please find requirement.png
-----------------------------------------------
Database configuration::

databasename=order
username=root
password=root

------------------------------
Build and run project ::
mvn spring-boot:run

--------------------------------

Rest api ::

1)POST localhost:8080/createorder       
  
{
	"tableid":"1",
	"productDetais":[
	     {
			"productcode":"1",
			"quantity":"2"
		  },
		    {
			"productcode":"2",
			"quantity":"5"
		  }
     ]
}

Response ===>1

PFA ::createorder.png

2)GET localhost:8080/getbill/1

Response ===>
{
    "orderid": 1,
    "tableid": 1,
    "date": "2019-10-03T14:36:50",
    "orderDetails": [
        {
            "productname": "Pohe",
            "quantity": 2,
            "price": 10.0
        },
        {
            "productname": "Dosa",
            "quantity": 5,
            "price": 30.0
        }
    ],
    "total": 170.0
}

PFA::getbill.png


