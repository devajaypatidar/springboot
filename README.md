﻿# CRUD Demo Application: Spring Boot
 A simple Spring Boot application demonstrating CRUD operations on a Product entity using PostgreSQL.

 ## Getting Started 
 ### prerequisites
 - JDK 8 or Higher
 - PostgreSQL
 - maven
  ## installation 
  1. Clone the Repo
  2. Create application.properties
  3. create a PostgreSQL Database
     
## API Endpoints
  ### Create Products
  - POST `/api/products`
  - Body:
      ```
      {
    "name": "New Product",
    "price": 10.0
      }

      ```
  ### Get All Products
  - GET `/api/products`
  ### Get Product by ID
  - GET ` /api/products/{id}
  ### Update Product
  - PUT `/api/products/{id}
  - body
    ```{
        "name": "Updated Product",
        "price": 10.0
        }
    ```
    ### Delete Product
    - DELETE `/api/products/{id}

    Happy Coding :)

