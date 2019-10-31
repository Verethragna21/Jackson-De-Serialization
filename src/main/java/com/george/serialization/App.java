package com.george.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.george.serialization.deserializer.ItemDeserializer;
import com.george.serialization.models.Books;
import com.george.serialization.models.Item;
import com.george.serialization.models.User;
import com.george.serialization.serializer.ItemSerializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws JsonProcessingException {

        //Custom Serialization
        //System.out.println(letsSerialize());

        //Custom Deserialization
        /*System.out.println(letsDeserialize().getItemId());
        System.out.println(letsDeserialize().getItemName());

        System.out.println(letsDeserialize().getUser().getId());
        System.out.println(letsDeserialize().getUser().getName());

        letsDeserialize().getBooks().forEach(books -> {
            System.out.println(books.getBookName());
            System.out.println(books.getBookCategory());
        });

        letsDeserialize().getAutos().forEach(autos -> {
            System.out.println(autos);
        });*/
    }

    private static String letsSerialize() throws JsonProcessingException {
        var user = new User(1, "Jorge Canales");
        var books = new ArrayList<Books>();
        books.add(new Books("Don quijote de la mancha", "Literatura clasica"));
        books.add(new Books("El infierno de Dante", "Literatura clasica"));

        var autos = Arrays.asList("bmw e46 2001", "Ford Edge 2010");

        var item = new Item(1, "theItemName", user, books, autos);

        var mapper = new ObjectMapper();

        var simpleModule = new SimpleModule();
        mapper.registerModule(simpleModule.addSerializer(Item.class, new ItemSerializer()));

        var serialized = mapper.writeValueAsString(item);
        return serialized;
    }

    private static Item letsDeserialize() throws JsonProcessingException {
        var json = "{\"itemId\":1,\"itemName\":\"theItemName\",\"user\":{\"id\":1,\"name\":\"Jorge Canales\"},\"books\":[{\"bookName\":\"Don quijote de la mancha\",\"bookCategory\":\"Literatura clasica\"},{\"bookName\":\"El infierno de Dante\",\"bookCategory\":\"Literatura clasica\"}],\"autos\":[\"bmw e46 2001\",\"Ford Edge 2010\"]}";

        var mapper = new ObjectMapper();
        var simpleModule = new SimpleModule();
        mapper.registerModule(simpleModule.addDeserializer(Item.class, new ItemDeserializer()));

        var readValue = mapper.readValue(json, Item.class);
        return readValue;
    }

}
