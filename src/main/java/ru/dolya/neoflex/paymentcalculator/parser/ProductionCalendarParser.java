package ru.dolya.neoflex.paymentcalculator.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;
import ru.dolya.neoflex.paymentcalculator.model.ProductionCalendar;


import java.io.File;


@Service
public class ProductionCalendarParser {

    public ProductionCalendar getProductionCalendar() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(".\\src\\main\\resources\\calendar.json");
            mapper.registerModule(new JavaTimeModule())
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return mapper.readValue(file, ProductionCalendar.class);
        } catch (Exception ex) {
            throw new ProductionCalendarParsingException(ex);
        }

    }

}

