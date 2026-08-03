package br.com.fiap.atendimento.infra.config.kafka;

import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.MarcarDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ControleFila {
    private final String bootstrapServers = "localhost:9092";

    @Bean
    public ProducerFactory<String, MarcarDTO> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, MarcarDTO> kafkaTemplate() {
        return new KafkaTemplate<String, MarcarDTO>(producerFactory());
    }

    @Bean
    public ConsumerFactory<String, MarcarDTO> consumerFactory() {
        JsonDeserializer<MarcarDTO> deserializer = new JsonDeserializer<>(MarcarDTO.class);
        deserializer.addTrustedPackages("*");

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "grupo-gerar");

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                deserializer
        );
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MarcarDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, MarcarDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public NewTopic orderGerarTopic() {
        return TopicBuilder.name("GERAR")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic orderExameTopic() {
        return TopicBuilder.name("EXAME")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
