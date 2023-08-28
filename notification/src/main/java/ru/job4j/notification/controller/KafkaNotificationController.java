package ru.job4j.notification.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.job4j.notification.model.Notification;
import ru.job4j.notification.service.NotificationService;

@EnableKafka
@Component
@AllArgsConstructor
public class KafkaNotificationController {
    private final NotificationService service;

    @KafkaListener(topics = "messengers")
    public void msgListener(ConsumerRecord<Integer, String> record) {
        Notification note = new Notification();
        note.setId(record.key());
        String massage = "Заказ № " + record.key() + " " + record.value();
        note.setMassage(massage);
        service.save(note);
    }
}