How to run:

-execute springboot app

-----------------QUESTION ONE-----------------
make a POST request to localhost:8080/getInvPicture with a Json Body as follows:

{ "productId":"Prod1","prodName":"Shirt", "reqDate": "2021-03-30"}

you should get the following response: {
    "productId": "Prod1",
    "prodName": "Shirt",
    "availQty": 50.0
}

-----------------QUESTION TWO-----------------
make another post request to localhost:8080/getProdAvailability with this body Json

{"storeNo": "Store001" , "productId":"Prod1","reqQty":2 ,"reqDate":"2021-02-20"} 

you should get the following response: {
    "storeNo": "Store001",
    "reqQty": 2,
    "productId": "Prod1",
    "reqDate": "2021-02-20",
    "status": "Available"
}

dependecies are Spring web, Lombok and org.json
