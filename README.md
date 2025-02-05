# MyShop Backend

The **MyShop Backend** is a Java-based RESTful API built using the **Spring Framework**. It provides core functionalities to manage resources such as creating, reading, updating, and deleting (CRUD operations).

## 🚀 Features

- CRUD operations for managing entities
- RESTful API design following best practices
- Modular architecture with service and controller layers
- Add orders to users and add products to categories or orders

## 📋 Endpoints

### 1️⃣ **Retrieve All Entities**
- **GET** `/all`
- **Description:** Returns a list of all entities.

### 2️⃣ **Retrieve an Entity by ID**
- **GET** `/{id}`
- **Path Variable:** `id` (long) - The unique identifier of the entity
- **Description:** Fetches a single entity based on the provided ID.

### 3️⃣ **Create/Save an Entity**
- **POST** `/save`
- **Request Body:** JSON representing the entity to be saved
- **Description:** Saves a new entity or updates an existing one.

### 4️⃣ **Delete an Entity by ID**
- **DELETE** `/delete/{id}`
- **Path Variable:** `id` (long) - The unique identifier of the entity
- **Description:** Deletes an entity based on the provided ID.

### 5️⃣ **Add Order to User**
- **POST** `/add/{userId}`
- **Path Variable:** `userId` (long) - The unique identifier of the user
- **Request Body:** JSON representing the order to be added
- **Description:** Adds a new order to the specified user.

### 6️⃣ **Add Product to Category or Order**
- **POST** `/add/{categoryId}` or `/add/{orderId}`
- **Path Variable:** `categoryId` or `orderId` (long) - The unique identifier of the category or order
- **Request Body:** JSON representing the product to be added
- **Description:** Adds a new product to the specified category or order.

## ⚙️ Getting Started

### Prerequisites
- **Java 17**
- **Maven** or **Gradle**
- **Spring Boot** dependencies

### 🏗️ Installation & Running

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build the Project** (if using Maven):
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   Or if using Gradle:
   ```bash
   ./gradlew bootRun
   ```

4. **Access the API**
   The backend will run at: `http://localhost:8080`

## 📦 Example Requests

### 📥 **Create Entity (POST /save)**
```json
{
  "name": "John",
  "email": "user@email.com",
   "hashPassword": "pass"
}
```

### 📤 **Get All Entities (GET /all)**
```bash
curl -X GET http://localhost:8080/api/v1/user/all
```

### 🗑️ **Delete Entity (DELETE /delete/{id})**
```bash
curl -X DELETE http://localhost:8080/api/v1/category/delete/1
```

### ➕ **Add Order to User (POST /add/{userId})**
```bash
curl -X POST http://localhost:8080/api/v1/user/add/1 \
-H "Content-Type: application/json" \
-d '{
  "orderStatus": "NEW",
  "products": [
      {
          "name": "Smartphone",
          "description": "NEW HANDSOME smartphone",
          "price": 499.99
      }
  ]
}'
```

### ➕ **Add Product to Category (POST /add/{categoryId})**
```bash
curl -X POST http://localhost:8080/api/v1/category/add/5 \
-H "Content-Type: application/json" \
-d '{
  "name": "Smartphone",
  "description": "NEW HANDSOME smartphone",
  "price": 499.99
}'
```

### ➕ **Add Product to Order (POST /add/{orderId})**
```bash
curl -X POST http://localhost:8080/api/v1/order/add/10 \
-H "Content-Type: application/json" \
-d '{
  "name": "Headphones",
  "description": "pretty-one headphones",
  "price": 99.99
}'
```

## 📝 Notes

- Ensure proper configuration of `application.properties` for database connections if required.
- Error handling and validation can be extended as per project needs.

## 📧 Contact

For questions or support, please contact the development team.

