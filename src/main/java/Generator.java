import components.Hummer;
import components.Saw;
import components.Tool;
import components.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// 2-й спосіб створення бінів
@Configuration // дана анотація дозволяє будувати класи які генерують обєкти
@ComponentScan("components") // сканує наш проект і шукає класи з анотацією @Component
public class Generator {

    //1-й спосіб
    @Autowired // іде в бін контейнер і самостійно знаходить обєкт типу Tool і ініціалізує його
    Saw tool ;



    @Bean
    public Worker worker2(){
        Worker worker = new Worker();
        worker.setId(2);
        worker.setName("Petya");
        worker.setTool(hummerX());

        return worker;
    }

    //створюємо другий bean
    @Bean
    public Hummer hummerX(){
        Hummer hummer = new Hummer(200);
        return hummer;
    }

//    @Bean
//    public Worker worker2(/*2-й спосіб* @Autowired вказувати не потрібно*/ Saw tool){
//        Worker worker = new Worker();
//        worker.setId(2);
//        worker.setName("Petya");
//        worker.setTool(tool);
//
//        return worker;
//    }
}
