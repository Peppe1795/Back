package it.epicode.be.godfather.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@PropertySource("classpath:application.properties")
public class CostoCoperto {
	@Value("${application.myvalue}")
	double myvalue;

	@PostConstruct
	public double getMyvalue() {
		return myvalue;
	}
}
