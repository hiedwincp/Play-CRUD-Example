# Play-CRUD-Example

Using Play framework how to implement CRUD operation using Java + Scala.html templates

In this example CRUD operation is performed on Person Table/Entity using EBean APIs and MY SQL database

Functions implemented :

 1. Listing all existing persons from My SQL DB
 2. Provision to filter/search by person's name
 3. Edit specific person by cliking hyper link on person name from thier listing page(home page)
 4. Add new person feature to for inserting new persons to DB
 5. Delete exisint person by cliking hyper link on person name from thier listing page(home page)
 
Code for this all features are

1. PersonController.java - All REST implmentation for CRUD operations  - under the folder /app/contollers
2. Person.java - DB Entity model + DAO functionlity uing Ebean as ORM for all DB releated operations  - under the folder /app/model
3. *.scala.html - for UI disaplys of Person CRUD operation - under the folder /app/view


Note: Test folder is not updated with latest test case, please fill this gap from your side


Thanks..

Edwin Paul C
