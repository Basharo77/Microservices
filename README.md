# Microservices-Shopping-App

This is a microservices project that simulates a small portion of an online shopping application.

There are 4 main services: Product, Order, Inventory, Notification
- Product Service:
  It's mainly for creating new products and viewing the existing products. It doesn't communicate with any other service.
- Order Service:
  It's the place we go when we want to order several items with different quantities.
- Inventory Service:
  This is the place where we keep the items that exists in the stock. The Order Service will call this service to ensure that we have the required products 
  with the required quantities.
- Notification Service:
  The order service will communicate with notification service to tell it that an order was placed succesfully so that the notification service can do whatever the
  business requires when such an event happen.

Features:
- API Gateway
- Eureka Clinet and Server for service discoery
- Circuit Breaker between order service and inventory service.
- Kafka Message Broker between order service and inventor service.

Note:

I am a student who is learning the basics of microservices, thus this project is not completely mine. I worked with a course from youtube and edited some things for
my convenience. Thnaks alot to programming techie for making this course and being very useful. This is the link to it: https://www.youtube.com/watch?v=mPPhcU7oWDU
  
