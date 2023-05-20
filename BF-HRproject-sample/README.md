# HRproject

This is partial code for an early version of a project's I did in BF.

The project is aim to implement a Employee onboarding web-application in Microservice architecture.

I am mainly responsible to the Employee Service of the project, other service code may not include.

The code here may not include enough comment or tests

# Project Requirement

1. Each team will be assigned a team lead. The team lead has to make the decision on all
   tools to be used in the project and need to host daily meeting to assign and check the work
   of each teammate.
2. Each team needs to have their own PRIVATE Git Repository on GitHub. Team leads should
   create proper branch for teammates to merge code.
3. Each team needs to add trainers in their Git Repository.
4. Team leaders will have a meeting with trainers every day from 2:00 PM to 3:00 PM EDT. In
   the meeting, the team lead needs to provide a report about:
   • What the team has finished?
   • Is there any road blocker?
   • A brief demo (either a unit test or Postman calls)
   • What did each team member work on?
5. Each team has to follow the Agile methodology to have deliverable items every one or two
   days.
6. “Done is better than perfect” — You should finish all requirements first. But DO think about
   how to make it better. (This is where you can talk more about during in the interview)
7. The main application should be built in a microservice architecture using Netflix Eureka and
   Spring Cloud API Gateway. All inter-service communication needs to be done using Spring
   Cloud OpenFeign or message queue (base on business logic).
8. Core Services in the Microservice architecture are EmployeeService, ApplicationService,
   HousingService and EmailService. Please design your own Composite Services if
   needed.
9. For each service, you need to use SpringBoot, Maven, Spring Security, Hibernate with
   MySQL, Spring Data JPA with MongoDB to build a RESTful application.
10. There should be an Authentication Server that is outside of the Microservice Architecture,
    which handles all operations related to User Identity Management, including authenticate,
    role management and registration.
11. The structure of each database will be provided, please follow strictly.
12. Each team has to create all the tables using MySQL and MongoDB and add corresponding
    constraints to the tables. Amazon Relational Database Service (AWS RDS) and MongoDB
    Atlas needs to be used to share database between team members.
13. All actions related to file storage should be associated with the AWS S3. e.g., uploading
    Driver License, Avatar, I-20, etc. You have to design and implement a project which is used
    for new employee onboarding process, visa status management and housing management.
    You only have to design and implement the backend of this project which is used for new
    employee onboarding process, visa status management and housing management.
