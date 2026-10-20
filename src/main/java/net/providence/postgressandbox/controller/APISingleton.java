package net.providence.postgressandbox.controller;

import lombok.RequiredArgsConstructor;
import net.providence.postgressandbox.storage.CounterStorage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class APISingleton {

    public final CounterStorage counterStorage = CounterStorage.getInstance();

    @PostMapping("/v1/setRandomCounter")
    public int setRandomCounter() {
        int randomCounter = (int) (Math.random() * 100);
        counterStorage.setCounter(randomCounter);
        return randomCounter;
    }

    @GetMapping("/v1/getCounter")
    public int getCounter() {
        return counterStorage.getCounter();
    }
}
