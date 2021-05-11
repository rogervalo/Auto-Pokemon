# Auto-Pokemon

# Translations

Currently, there are these translations of **bash-handbook**:

- [Português (Brasil)](/translations/pt-BR/README.md)
- [Chinese](/translations/zh-TW/README.md)
- [Korean](/translations/ko-KR/README.md)

## Description

This is a simple project on order to have an easy-to-understand example of API Testing Automated with Maven Configuration and TestNG being the runner, based on some simple test cases

Some simple extras features useful for a Selenium project are also implemented and ready to use: 
- Use Retrofit2 to execute the API requests
- Use log4j to show the functionality with text
- Use AsertJ for create more complete assertions
	
## Requirements

you should to have the next tools for run this project:

- [Git](https://git-scm.com/)
- [Maven](https://maven.apache.org/)
- [JDK 1.8](https://www.oracle.com/mx/java/technologies/javase/javase-jdk8-downloads.html)
- [Eclipse](https://www.eclipse.org/) (Optional)
	
	
## Instructions

1 - you should download the github project, in your cmd go to your workspace and type:

```
$ git clone https://github.com/rogervalo/Auto-Pokemon.git
```


Remember, you should have git installed on your local PC, and you new to have github installed

2 - Then enter to your project on the bash, and install the dependencies:

```
$ mvn install
```

3 - finally when all the dependencies are already downloaded, you can run the Test Cases with the command : 

```
$ mvn test
```