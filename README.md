# FullStack Challenge
System for registering, listing, editing, and deleting products.
For the REST API, we use Spring Boot and Spring Boot Security to protect endpoints that require an admin profile.
On the frontend, we use Angular with Material.
<Br><br>

## User Stories
### 1 - Schema
Create schema, which will allow storing different products and categories.<Br><br>
Keep in mind that getting full category path for the product might be a requirement in the future.
<Br><br>

### 2 - Page containing
Create a page containing a List of Products. 
The table should contain the following columns: name, description, price, categoryPath, available
<Br><br>

### 3 - Functionality
Add functionality for adding, editing, and deleting products.
<Br><be>

## Run project 
The docker-compose.yml includes the entire solution.
<br><br>
Start dockers with <i><b>docker-compose up --build -d</i></b>
<Br><br>
Open http://localhost/ in your browser.
<Br><br>

### Admin credentials:
<b>username:</b> admin <br>
<b>password:</b> admin
