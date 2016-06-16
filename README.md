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

# Running Play Framework

1> First set the bin PATH for activiator
  C:\Play\activator-dist-1.3.10\bin
  
  2> For Starting the Play frameowrk UI server console which is used for build,test,run, edit code from browser
 
     > activator ui   
	   
     This open the server console in browser or can be acccessed by http://127.0.0.1:8888/
  
  3> In Activiator window different project can be choosen and proceed with  build,test,run, edit code from browse

  4> There is also provision to do build,test,run, edit code from comand prompt using executing 'activiator'  from inside play project
  
    C:\Users\edwin\workspaceForScala\play-java-intro> activator
	[play-java-intro]>
  
  5> Noramlly application will be running on port http://localhost:9000
  
  6> To open ptoject in eclipse please execute the 'eclipse' from command line after executing 'activiator' command
  
    [play-java-intro]> eclipse
	
  7> Either run the application from UI or command praompt using "run" or "play" command
 
  8 > In the case you want o run unit test alone with dynamic changes use the command "play -test" 

Thanks..

Edwin Paul C
