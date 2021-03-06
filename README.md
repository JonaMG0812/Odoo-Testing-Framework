# Odoo Ecommerce Testing Framework 
The Odoo-Testing-Framework is a Testing-Framework made in Java with the use of Selenium and TestNG capable of automating and validating a shopping process flow within a test page provided by the Odoo ERP.

## Work it out
These instructions will help you keep a copy of this project on your machine to review, develop, or play with the code. Have fun. 

### Requirements
To work on this project lets assume the following points:

- Have a computer with Windows 10
- Java SE 1.8
- Eclipse IDE
- TestNG on Eclipse IDE
- The working directory must be C:\Academy
- There's a Webdrivers directory called 'drivers' with at least chromedriver.exe (check your browser version to maintain compatibility)
- The working directory contains 'selenium-server-standalone-3.141.59.jar'

### Installation

Download or clone the repo: eg. git clone via HTTPS: https://github.com/JonaMG0812/Odoo-Testing-Framework.git

   1) Download and unzip the file .zip or clone the repo on your working directory
   2) Open it on your prefered IDE (eg. Eclipse)
   3) Copy 'selenium-server-standalone-3.141.59.jar' on root working directory
   4) Copy 'chromedriver.exe' on the 'drivers' folder
   5) On some cases: Add TestNG library to Java Build Path
   7) Run the script

## Scaffolding and Directory tree
This framework is using POM because reduce code duplication and improves test maintenance, you can view the directory tree to get a general view of structure.
```bash .
└── Odoo-Testing-Framework
   ├── README.md
   ├── TestCases.md
   └── src
      └── pom
         ├── AllSuiteTest.java
         ├── Base.java
         ├── Data.java
         ├── EcommercePage.java
         └── TestNGSuiteTest.xml
```

## Data to test
If you decide to use this framework and test with your own data, you have to change the next files: WIP

## Test Cases
The following test cases are contemplated in this framework:

   1) Load Odoo Page
   2) Log In
   3) Search Item
   4) Add Item
   5) Checkout
   6) Pay Item

If you want to see more info about it, check this [Link](https://github.com/JonaMG0812/Odoo-Testing-Framework/blob/main/TestCases.md).
