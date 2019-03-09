package ipfilter;

import ipfilter.model.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IPFilterApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IPFilterRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(IPFilterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Filter with id 10001 -> {}", repository.findById(10001L));

		logger.info("Inserting a new filter  -> {}",
				repository.save(new Filter("86.155")));


		repository.deleteById(10002L);

		logger.info("All ip filter rules -> {}", repository.findAll());
	}
}