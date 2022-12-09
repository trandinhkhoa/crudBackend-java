
- 1
  - Error:
java.lang.RuntimeException: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
	[error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: javax.enterprise.inject.spi.DeploymentException: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type com.example.GreetingService and qualifiers [@Default]
	- java member: com.example.GreetingResource#greetingService
	- declared on CLASS bean [types=[com.example.GreetingResource, java.lang.Object], qualifiers=[@Default, @Any], target=com.example.GreetingResource]
The error message indicates that there is an unsatisfied dependency for the GreetingService type. This means that the GreetingResource class is trying to inject an instance of GreetingService, but the application is unable to find a suitable instance to inject.

  - Cause:
This can happen if the GreetingService class is not annotated with a scope that allows it to be injected (such as @ApplicationScoped), or if the GreetingService class is not registered as a bean in the application.

To fix this error, you can try the following steps:

Annotate the GreetingService class with a scope that allows it to be injected, such as @ApplicationScoped.
Make sure that the GreetingService class is registered as a bean in the application. This can be done by annotating the class with @javax.enterprise.inject.Produces or by adding a beans.xml file to the project.
