package org.o7planning.freemarker;

import org.o7planning.freemarker.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@SpringBootApplication
public class SpringBootFreeMarkerApplication {

	public static void main(String[] args) throws JAXBException {
		SpringApplication.run(SpringBootFreeMarkerApplication.class, args);
		Person person = new Person("adasdasd", "qweqweqwe");
		jaxbObjectToXML(person);
	}

	private static void jaxbObjectToXML(Person person)
	{
		try
		{
			//Create JAXB Context
			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

			//Create Marshaller
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			//Required formatting??
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			//Print XML String to Console
			StringWriter sw = new StringWriter();

			//Write XML to StringWriter
			jaxbMarshaller.marshal(person, sw);

			//Verify XML Content
			String xmlContent = sw.toString();
			System.out.println( xmlContent );

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
