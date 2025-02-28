/*
 * Copyright 2023-present ByteChef Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.message.broker.redis.config;

import com.bytechef.message.broker.MessageBroker;
import com.bytechef.message.broker.redis.RedisMessageBroker;
import com.bytechef.message.broker.redis.serializer.RedisMessageDeserializer;
import com.bytechef.message.broker.redis.serializer.RedisMessageSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oblac.jrsmq.RedisSMQ;
import com.oblac.jrsmq.RedisSMQConfig;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Ivica Cardic
 */
@Configuration
@ConditionalOnProperty(prefix = "bytechef", name = "message-broker.provider", havingValue = "redis")
public class RedisMessageBrokerConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(RedisMessageBrokerConfiguration.class);

    public RedisMessageBrokerConfiguration() {
        if (logger.isInfoEnabled()) {
            logger.info("Message broker provider type enabled: redis");
        }
    }

    @Bean
    MessageBroker redisMessageBroker(
        RedisMessageSerializer redisMessageSerializer, RedisSMQ redisSMQ, StringRedisTemplate stringRedisTemplate) {

        return new RedisMessageBroker(redisMessageSerializer, redisSMQ, stringRedisTemplate);
    }

    @Bean
    RedisMessageDeserializer redisMessageDeserializer(ObjectMapper objectMapper) {
        return new RedisMessageDeserializer(objectMapper);
    }

    @Bean
    RedisMessageSerializer redisMessageSerializer(ObjectMapper objectMapper) {
        return new RedisMessageSerializer(objectMapper);
    }

    @Bean
    StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean
    RedisSMQ redisSMQ(RedisProperties redisProperties) {
        return new RedisSMQ(
            RedisSMQConfig.createDefaultConfig()
                .database(redisProperties.getDatabase())
                .host(redisProperties.getHost())
                .password(redisProperties.getPassword())
                .port(redisProperties.getPort())
//                .ssl(redisProperties.isSsl())
                .timeout(getTimeout(redisProperties.getTimeout())));
    }

    private static int getTimeout(Duration timeout) {
        return timeout == null ? 5000 : (int) timeout.toMillis();
    }
}
