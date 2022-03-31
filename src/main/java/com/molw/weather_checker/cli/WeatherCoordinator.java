package com.molw.weather_checker.cli;

import com.molw.weather_checker.data.WeatherReading;
import com.molw.weather_checker.sources.WeatherFetcher;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Profile(value= "!dev" )
public class WeatherCoordinator {

    /*
     the names in the hashmap here are only for user friendliness - we will actually be using the name returned by the
     Openweather API as the part of the key name
     */
    private static final HashMap<String, String> locations = (HashMap) Stream.of(new String[][]
            {
                    {"Santa Cruz, CA", "&lat=36.962421&lon=-122.023301"},
                    {"Madrid, ES", "&lat=40.416775&lon=-3.703790"},
                    {"Sydney, AU", "&lat=-33.868820&lon=151.209290"},
                    {"Atlanta, GA", "&lat=33.748997&lon=-84.387985"},
                    {"Denver, CO", "&lat=39.739235&lon=-104.990250"},
                    {"Austin, TX", "&lat=30.2671535&lon=-97.743057"},
                    {"Seattle, WA", "&lat=47.606209&lon=-122.332069"}
            }
    ).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void run() throws Exception {

        WeatherFetcher weatherFetcher = new WeatherFetcher();
        locations.forEach((name, coords) ->
            {
                //do the call and get the weatherreading back
                WeatherReading wr = weatherFetcher.getAPlaceReading(coords);
                System.out.println(wr);
                //TODO if this works then here is where we put all the pieces in the cache
                // The Key:value will be the "place_name-variable_name: {value: XXXX, timestamp: XXXXX}"

            });
        /* TODO Iterate through the hashmap HERE and accumulate the results we want




         */

        /* TODO now we are ready for gemfire integration



        once we get the data back we should just go ahead and push the data to gemfire
        https://docs.spring.io/spring-framework/docs/current/reference/html/integration.html#cache-annotations-put
        basically make a new method here that
        1. goes through each quote in the list returned
        2. For each put it in the cache
        3. Then a trigger in the cache will decide what do to with it

        This is the real article that shows how to wire it up
        https://docs.spring.io/spring-data/geode/docs/current/reference/html/#bootstrap-annotation-config-client-server-applications
        https://tanzu.vmware.com/developer/data/tanzu-gemfire/guides/get-started-tgf4k8s-sbdg/


        https://docs.spring.io/spring-data/geode/docs/current/reference/html/#bootstrap-annotation-config-client-server-applications
        https://docs.spring.io/spring-boot-data-geode-build/1.2.x/reference/html5/
        https://www.baeldung.com/spring-cache-tutorial
        https://docs.spring.io/spring-gemfire/docs/current/reference/html/#reference

        https://github.com/spring-projects/spring-data-geode



         */
    }
}
