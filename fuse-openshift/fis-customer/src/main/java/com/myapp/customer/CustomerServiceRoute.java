/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.myapp.customer;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
@ContextName("customerRoute")
public class CustomerServiceRoute extends RouteBuilder {

    @Inject
    @Uri("timer:foo?period=5000")
    private Endpoint inputEndpoint;

    @Inject
    @Uri("log:output")
    private Endpoint resultEndpoint;

    @Override
    public void configure() throws Exception {
        // you can configure the route rule with Java DSL here

        from(inputEndpoint)
            .beanRef("customerBean")
            .to(resultEndpoint);

        restConfiguration()
            .contextPath(apiContext).apiContextPath("/api-doc")
            .host(apiDocHost)
            .port(apiDocPort)   
            //.apiProperty("api.title", "Order REST API")
            //.apiProperty("api.version", "1.0")
            //.apiProperty("cors", "true")
            .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json);

        rest("/orders").description("Orders service")

            .get("/").description("List orders")
                .route().routeId("orders-list")
                .beanRef("customerBean", "restResponse")
                .endRest();
    }

}
