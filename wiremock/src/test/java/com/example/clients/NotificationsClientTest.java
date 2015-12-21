package com.example.clients;

import com.example.DemoApplication;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;


/**
 * For more information about WireMock framework
 * http://wiremock.org/
 *
 * @author jmbataller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class NotificationsClientTest {

    @Autowired
    private NotificationsClient notificationsClient;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(9000));

    @Test
    public void testSend_notification() {
        stubFor(post(urlEqualTo("/notifications/test"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")));

        notificationsClient.publish("test", "test data");
        verify(1, postRequestedFor(urlEqualTo("/notifications/test")));
    }

    @Test(expected = HystrixRuntimeException.class)
    public void testSend_notification_timeout() {
        stubFor(post(urlEqualTo("/notifications/test"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withFixedDelay(6000)));

        notificationsClient.publish("test", "test data");
        verify(1, postRequestedFor(urlEqualTo("/notifications/test")));
    }

    @Test(expected = HystrixRuntimeException.class)
    public void testSend_notification_not_found() {
        stubFor(post(urlEqualTo("/notifications/test"))
                .willReturn(aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", "application/json")));

        notificationsClient.publish("test", "test data");
        verify(1, postRequestedFor(urlEqualTo("/notifications/test")));
    }
}
