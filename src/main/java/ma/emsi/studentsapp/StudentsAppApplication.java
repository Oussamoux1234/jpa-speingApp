package ma.emsi.studentsapp;

import ma.emsi.studentsapp.entities.Product;
import ma.emsi.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(1,"computer",115,12));
        productRepository.save(new Product(2,"oussama",17,12));
        productRepository.save(new Product(3,"lap",18,141));
        List<Product> Products = productRepository.findAll();
        Products.forEach(s->System.out.println(s.toString()));
        Product s= productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*****************find by id ***********************");
        System.out.println(s.toString());
        System.out.println("********************* search by name contians ou *******************");
        List<Product> pc= productRepository.findByNameContains("ou");
pc.forEach(System.out::println);
        System.out.println("*******************le nom contains u *********************");
        List<Product> pc1= productRepository.searchby("%u%");
        pc1.forEach(System.out::println);

        System.out.println("******************price greater than 16*********************");
        List<Product> pc3= productRepository.findByPrixGreaterThan(16);
        pc3.forEach(System.out::println);

        System.out.println("*******************price greater than 16 v2 ********************");
        List<Product> pc4= productRepository.searchbyPrice(16);
        pc4.forEach(System.out::println);

    }
}
