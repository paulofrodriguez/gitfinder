package tech.kodika.gitfinder.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.kodika.gitfinder.persistence.entities.Property;
import tech.kodika.gitfinder.persistence.repositories.PropertyRepository;

import java.util.List;

@Component
public class PropertiesHelper {

    public final static String URL_TARGET = "URL.TARGET";

    public static final String URL_TARGET_TRENDING = "URL.TARGET.TRENDING";

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {

        return propertyRepository.findAll();

    }


    public String getProperty(String key) {

        Property p = propertyRepository.findByKey(key.toUpperCase());

        if (p != null) {

            return p.getValue();

        } else {

            return "";
        }

    }


    public Property setProperty(String key, String value) {

        Property p = propertyRepository.findByKey(key);

        if (p == null) {

            p = new Property();

            p.setKey(key.toUpperCase());

            p.setValue(value);

            propertyRepository.save(p);

        } else {

            p.setKey(key);

            p.setValue(value);

            propertyRepository.save(p);
        }

        return p;
    }

}
