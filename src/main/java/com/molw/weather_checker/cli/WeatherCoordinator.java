package com.molw.weather_checker.cli;

import com.molw.weather_checker.sources.WeatherFetcher;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Profile(value= "!dev" )
public class WeatherCoordinator {

    @Scheduled(fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void run() throws Exception {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        System.out.println( weatherFetcher.getWeather().toString());

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
