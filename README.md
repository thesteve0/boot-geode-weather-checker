# Weather Checker
This is a simple Application that is intended to show using Spring Boot with Spring Data for Geode in a client server configuration. It fetches weatherReading data from an API and then, using annotation inserts it into the Geode cache. 


It requires an environment variable:
1. `openweather_api_key` set to your openweather API key. It is recommended that you set this up through a configmap/secrets in the kube namespace running the service. When running locally, put in a environment variable
2. It uses SpringBoot application profiles. If you want to run in dev mode with a web server you need to add:
    `-Dspring.profiles.active=dev`

    As a JVM parameter

## requirements
geode v 1.14.4
Spring boot v 2.6.6
SDG v 2.6.3
SBDG 1.6.6

@TODO 
2. Get it to send the results as an update to our Gemfire instance
3. We need to have a postgres instance that stores all the different currencies to check and use Gemfire to cache the current list so we are not always hitting the DB every minutes.
   