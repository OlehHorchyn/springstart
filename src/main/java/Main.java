import components.Hummer;
import components.Saw;
import components.Tool;
import components.Worker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //коли в бін контейнері існує один клас то він називається Singleton аколи їх більше то вони називаються prototype


        //створюємо бін-контейнер
        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();
        container.register(Worker.class, Saw.class, Hummer.class, Generator.class); // реєструємо наш клас в бін-контейнері
        container.refresh();

        Worker bean = container.getBean("worker",Worker.class); // дістаємо нашого обєкта
        Tool tool = container.getBean("hummer",Hummer.class);
        bean.setTool(tool);

        System.out.println(bean);

        Saw saw = container.getBean(Saw.class);
        bean.setTool(saw);

        System.out.println(bean);


        /// дістаємо обєкт з Generator
        //оскільки в бін контейнері існує два обєкти типу Worker нам потрібно конкретизувати якого саме ми беремо
        Worker worker2 = container.getBean("worker2",Worker.class);
        System.out.println(worker2);
    }
}
