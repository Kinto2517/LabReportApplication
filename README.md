
# Lab Report Application &middot; [![Build Status](https://img.shields.io/travis/npm/npm/latest.svg?style=flat-square)](https://travis-ci.org/npm/npm) [![npm](https://img.shields.io/npm/v/npm.svg?style=flat-square)](https://www.npmjs.com/package/npm) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com) [![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://github.com/Kinto2517/LabReportApplication/blob/master/LICENSE)
> Özgür Yazılım Intern Application Project

Lab Report Application that admins can add ,view ,edit ,delete reports and users while users can only add reports. This is a Thymeleaf Web project.
 
## Installing / Getting started

A quick introduction of the minimal setup you need to get a hello world up &
running.

```shell
[git clone https://github.com/Kinto2517/LabReportApplication.git](https://github.com/Kinto2517/LabReportApplication.git)
```

Clone the project or download to your local system.

## Developing

### Built With
Used Spring, JPA, H2, Security, Bootstrap, Junit, Mockito, Thymeleaf, Hibernate, Maven, Css

### Setting up Dev

Run the following command in a terminal window (in the complete directory):

```shell
./mvnw spring-boot:run
```


### Deploying / Publishing


![image](https://user-images.githubusercontent.com/54002766/176387125-1aebbc55-59de-4bbc-97b9-7988a60d70dd.png)

You can change the username, password and url for your own datasource.

After that start the spring project and it will run on Port 5000.

You can start the project by going: 

```
localhost:5000/
```


## Tests

There are 2 test classes beside the main one. 

ReportTesting helps you test the ReportRepository and ReportService with Mockito testing.

UserTesting helps you test the UserRepository with JUnit testing.


## Style guide

There are css style codes inside the html headers to make it look better visually.

## Login Guide

There is custom Spring Security Login Page.

> Username : admin
> Şifre : admin
> Role : ADMIN

> Username : user
> Şifre : user
> Role : USER

> Username : kinto
> Şifre : kinto
> Role : USER


## Upcoming Updates

### More tests and register page will be added after next updates. Also cloud database will be used instead memory database. 


## Application Images

### Login Page
![image](https://user-images.githubusercontent.com/54002766/176390310-a2b59d5c-af00-410d-9590-896b3ff14bee.png)

### Admin Home Page
![image](https://user-images.githubusercontent.com/54002766/176390384-615e2336-66f7-49c0-a486-c876425a9c7f.png)

### User Home Page
![image](https://user-images.githubusercontent.com/54002766/176390529-2a4150e6-56f7-4153-bac5-ff233f6c9eba.png)

### Adding User Form Page
![image](https://user-images.githubusercontent.com/54002766/176390645-65743f79-d4b8-4c98-81ab-fb9b5b8ce15a.png)

### Users Table Page
![image](https://user-images.githubusercontent.com/54002766/176391001-bc5678dc-5c49-4e1c-815f-d8afba8f241d.png)

### Adding Report Form Page
![image](https://user-images.githubusercontent.com/54002766/176391203-e54a9491-b72f-49ef-9c6d-40191ff5859d.png)

### Reports Table Page
![image](https://user-images.githubusercontent.com/54002766/176391789-90f84fbe-e836-4c6b-a85c-506b2480f370.png)

## You can order by clicking the Date table head and download the file that just uploaded.


