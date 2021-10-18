# Backend Technical Test Kruger

### Author: Ing. Jonathan Navas
### Email: info@jonathan-navas.com

#### How to download this repo

```
    git clone url_repo
```
#### Create the database in Postgresql, Springboot will create all the tables and row auto on each start
```
    db_vaccine
```
#### Setup into src/main/resources/application.properties
```
    connection params
```
#### Port used
```
    PORT: 8080
```
#### How to run this backend
```
    right click / run as Springboot App
```

#### Tasks completed
* Create Project
* Setup enviroment
* Create Entities
* Create User
* Edit User
* Delete User
* List All users
* List One user
* Filter: findByEstado
* Oauth2 Implemented
* Setup User Roles
* Implement security middlewares on each url api that it required
* Swagger implemented

### Notes

If you need to test Swagger OpenApi you must change this on ResourceServerConfig.java
```
.anyRequest().authenticated()
```
to
```
.anyRequest().permitAll()
```

If you will check this backend use Postman
In postman you need to get your token in this url
```
http://localhost:8080/oauth/token
```
and you must select  Authorization: Basic Auth and  set 
```
Username: reactapp
Password: 12345
```
Next you need to introduce on the body x-www-form-urlencoded the next params
```
username: 1725635310
password: 12345 or your password generated that is your personal identification "dni"
grant_type: password
```



# Thanks! 