/*
 * Copyright (C) 2012-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pf4j.demo.service;

import org.pf4j.PluginManager;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.pf4j.demo.api.Greeting;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Decebal Suiu
 */
@Service
public class GreetingsService {
    @Autowired
    SpringPluginManager springPluginManager;

    public void printGreetings() {
        List<Greeting> greetings = springPluginManager.getExtensions(Greeting.class);
        System.out.println(String.format("Found %d extensions for extension point '%s'", greetings.size(), Greeting.class.getName()));

        for (Greeting greeting : greetings) {
            System.out.println(">>> " + greeting.getGreeting());
        }
    }

}
