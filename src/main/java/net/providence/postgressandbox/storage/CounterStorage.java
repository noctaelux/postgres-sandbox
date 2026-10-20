package net.providence.postgressandbox.storage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounterStorage {

    public static CounterStorage instance;

    private int counter = 0;

    private CounterStorage(){}

    public static CounterStorage getInstance() {
        if (instance == null) {
            instance = new CounterStorage();
        }
        return instance;
    }



}
