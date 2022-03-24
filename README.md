# DigiCurrency-Checker

This is a simple spring boot app that is intended to be run as a CronJob deployment in Kube. 
Currently, it uses the [Nomics API](https://p.nomics.com/cryptocurrency-bitcoin-api) to query the current prices for a list of digital currencies every minute.


It requires an environment variable:
1. `nomics_api_key` set to your nomics API key. It is recommended that you set this up through a configmap/secrets in the kube namespace running the service. When running locally, put in a environment variable
2. It uses SpringBoot application profiles. If you want to run in dev mode with a web server you need to add:
    `-Dspring.profiles.active=dev`

    As a JVM parameter



@TODO 
1. Add back a web service for the kube health and readiness checks
   1. /health is just a simple 200 response. If spring boot is responding then we are ok
   2. /ready should actually make sure we have a connection to the gemfire cache
2. Get it to send the results as an update to our Gemfire instance
3. We need to have a postgres instance that stores all the different currencies to check and use Gemfire to cache the current list so we are not always hitting the DB every minutes.
   
Number 5 actually doesn't matter in this service - just the todo's above. 
5. The DB needs to store a mapping of users to currencies and their buy and sell prices (this is a many to many table with the currency, user, buy, sell, and time stamp). This table really only matters to the Rabbit notifier instance and the web app to show users in the web interface the latest prices of their currencies of interest.


For the trigger we want to write in gemfire
https://geode.apache.org/releases/latest/javadoc/org/apache/geode/cache/util/CacheWriterAdapter.html