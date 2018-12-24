package components;

import org.springframework.stereotype.Component;

@Component
public class Hummer implements Tool {
    private int weight = 900;

    public Hummer() {
    }

    public Hummer(int weight) {
        this.weight = weight;
    }


    public void fix() {
        System.out.println(weight);
    }

}
