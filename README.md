# ACWebServicesIntegration
This repository contains code that I use to demonstrate and experiment with integrating with Agile Central using Web Services API

Demo notes:

2 Tests are in the project. 
- MyUtilityTest.java is a unit test that is run during the test phase of the Maven build
- GetDisplayNameUITest.java is a Selenium test that is run during the integration-test phase of the Maven build

When the tests are executed is achieved using the <exclude> and <include> configurations in the surefire and failsafe
plugins. Surefire plugin excludes all tests ending with UITest and Failsafe plugin includes them. As such, ensure
that the naming of your Test classes are done appropriately. 

Use mvn tomcat7:deploy or tomcat7:undeploy to deploy the package to a local tomcat server running on port 8080
Remember to add the server definition in %MAVEN_HOME%/conf/settings.xml file.
This will be executed within pre-integration-test phase of the maven build as well. 

