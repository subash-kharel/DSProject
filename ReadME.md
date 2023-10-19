Running this application will only require three commands:
1. Get in to parent directory (cd parent)
2. mvn clean package dockerfile:build
3. docker-compose -f docker/docker-compose.yml up

This application has four microservices:
1. Config Server : Manages configuration for all services
2. Catalog Service: This manages CRUD for the products that are being sold.
3. Cart Service: This services is to add items to the cart and get items in the cart.
4. Order Service: This services is to create order for items in the cart.


Just a basic work flow:
- we could add,view update and delete items in catalog.
- Then the user can add items they like in catalog to the cart using cart service.
  -Note: Here cartservice calls catalog service to ensure that the item is in the catalog and creates reference of the catalogId.
- User can then order for all items in the cart using order service.
  - Note: Here order service calls cartservice to get all cartItems and then creates order.
