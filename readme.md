## SPRING FRAMEWORK

This application is a basic User Management System
built using Spring Core without Spring Boot,
Spring MVC, and Spring Data JPA. It allows users to perform CRUD operations
such as creating, viewing, updating, and deleting users through a web interface.

## Table of Contents
- [Project Structure](#project-structure)
- [Dependency Injection (DI)](#dependency-injection-di)
- [Inversion of Control (IoC)](#inversion-of-control-ioc)
- [Spring Beans](#spring-beans)
- [Bean Scopes](#bean-scopes)
- [ApplicationContext](#applicationcontext)
- [Component Scanning and Stereotype Annotations](#component-scanning-and-stereotype-annotations)
- [Spring Data JPA](#spring-data-jpa)
- [Spring MVC](#spring-mvc)
- [Installation and Setup](#installation-and-setup)

### Project Structure
Maska<br>
├── .idea<br>
├── .smarttomcat<br>
├── conf<br>
├── logs<br>
├── src<br>
│   └── main<br>
│       ├── java<br>
│       │   └── dev.yassiraitelghari.maska<br>
│       │       ├── controller<br>
│       │       │   └── HomeController.java<br>
│       │       ├── domain<br>
│       │       │   └── Member.java          
│       │       ├── repository<br>
│       │       │   └── MemberRepository.java  
│       │       ├── service<br>
│       │       │   ├── implementations<br>
│       │       │   │   └── MemberServiceImpl.java<br>
│       │       │   └── MemberService.java      
│       │       └── web<br>
│       │           └── HomeController.java  
│       ├── resources<br>
│       │   └── applicationContext.xml       
│       └── webapp<br>
│           └── WEB-INF<br>
│               ├── views<br>
│               ├── dispatcher-servlet.xml       
│               └── web.xml<br>                     

### Dependency Injection (DI)

Dependency injection c'est un concept dans oop qui correspond a injecter ou bien passer les resources a un objet ou un element pour qui 'il puisse faire son travail completement.
Dans le context de oop , on peut donner l'example d'un objet qui a besoin des autres resources pour travailler 
comme considération ,  un objet UserService pour implementer la method delete ,  il doit communqiuer avec un autre objet qui a un relation direct avec la databse couche cest le UserRepository 
donc pour que le UserService puisse implementer  la method delete il doit aussi utilise des method specific dans l'objet UserReposiotry. 
c'est pour cela on injecte ou bien dans un autre context , on passe un objet UserRepository a l'objet UserService  pour qu'il l'utilse . 
c'est vrai qu'on peut instantier un objet directment dans la method supprimer mais le problem ici c'est que le plus on instantiate des objets le plus notre code sera couplé donc si on veux remplacer le objet UserReposiotry par un autre source on doit remplcaer tout les use cases mais si on utilise DI on peut just changer l'objet q'on inject dans l'attribute de l'objet .

pour injecter des resources a un objet ou bien une entity on peut le faire par 3 maniéres 
-DI par constructeur : c'est le preferable technique puisque les resources sont injecté le moment l'objet est instatie , aussi on peut decalrer les attribues comme final or consatnt
-DI par setter : setter c'est une autre method qui est préferable pour les optional dependeces que l'object utilise dans un moment specific et n'est pas dans lorque i est instantie
-Field DI en utilsant l'annotation @autowired : en utilsant autowired on peut aussi injecter les dependeces , mais cette method est le moins préfere puisque , on peut trouver des proublemes de tests puique le traitement d'injection est fait par la framework(Spring) , aussi on ne peut pas declarer les dependeces comme final .



### Inversion of Control (IoC)
inversion of control (i.e inversion de controle) c'est l'un de principal pile de la framework spring , ioc considére comme le core container de la framework spring puisque il gere les entities ou les beans de l'application 
ioc dans un autre context c'est de inverser le control d'un entity de le developer a le program . donc le developeur est ne plus a acceses ou besoin de gerer les enetities a soi meme , grace a le ioc container spring 
prend la responsabilité a gerer les entities (beans) en les instantianier , founir DI , détruire les objets , gerer la vie cycles,...etc 
### Spring Beans
Beans tout simplement c'est une entity ou objet qui est geré par le ioc container de spring , on peut declarer une entity comme bean dans le fichier xml 
### Bean Scopes
Bean scopes are how the ioc cotnainer treat beans based on their scrope types : 
-Singleton Scope :  only one instance of the class is created and used among the application . @Scope("singleton") , the scope of singleton is the default scope in spring framework so if nos cope defined , singleton will be selected
-Prototype Scope : creating an instance or a bean whenever we need it . this scope is defined within classes that are likely to be instantiated for each operation or for each need
-Request Scope : a new bean is created for each http request , this scope is widely used in web applications or rest applications
-Session Scope : the ioc creates a new bean for a each http session , it's also most in web applications and rest applications 
-Application Scope : this is a more general scope then the session scope , this scope is used for the lifecycle servletContext
-Websocket Scope ; this scope is known in messaging systems  , a bean is created and tied to each new websocket lifecycle
### ApplicationContext
ApplicationContext is the center interface to the ioc container , it's responsible of managing and configuring the beans of the application ,  the spring framework create an implementaiton of the ApplicaitonContext interface based on the applicationContext.xml configuration file .
### Component Scanning and Stereotype Annotations


Component Scanning : 
component scanning is a feature in spring that detect the beans based on package path and annotations , so instead of declaring beans one by one in teh dispatcher-servlet 
spring offer many annotations that define a bean like : @Component , @Repository , @Service , ...,etc . 
to use this feature we need only to define a xml element within the applicationContext xml file that define the project path 
<context:component-scan base-package="com.package.something">

StereoType Annotations:
StereoType Annotations help spring to know the role that the class will play within the application , annotation help user by organizing the structure of the code .
Annotations : 
@Component : 
this is the basic type of beans , it may also considered as the core of streotype Annotaitons , since A @Repository , @Controller , ..etc is also considred a @Component , @Component annotaiton inform spring that the class is a bean which enable di and ioc 
there are  other annotations that define bean types such as : 
@Repository that define a repository or a DAO layer ; Spring by knowing that the bean is Reposiotry may intergrat Db resources such as jdbc , jpa , hibernate.
@Controller this bean define our controller which is responsible of receiving and returnign http request from and to the users , by knowing that the compoent is a controller spring may allow to return an html response , plus usign web http requests that are specified for the controllers
@Service : Spring will be informed that this bean is role is to contain the business logic of the application 

### Spring Data JPA
Spring Data Jpa is a project of the Spring rich ecosystem , Spring Data jpa based on the standards of jpa make it easier for us to communicate with the databse by offering us predifined crud operation ,and others features such as getting all elements and more .Sprign data jpa is a rich project that is specialed to afford Class and inrerfaces that commmunicate with the database . such as CrudRepository  , JpaRepository , Repository , ...etc , it also offer pagination and sorting for large and heavy database resources
### Spring MVC
Spring Mvc is another robust project of the spring ecosystem it's based on the mvc Architectural pattern , mvc is a pattern that was known to be used for web application  , it aims to separate the concerns of the applicaiton into 3 parts : view(jsp) , model (@Reposiory) , controller (@Controller)  
in top of the mvc pattern spring extend the mvc by adding other component to secure and control the lifecycle of the requests , such as teh front controller and view resolver which are like the responsible to get the right controller and view of the request sent by the user
### Installation and Setup
git clone <br>
download tomcat  <br>
mvn clean install  <br>
add the war executice file to tomcat server  <br>
run application <br>
