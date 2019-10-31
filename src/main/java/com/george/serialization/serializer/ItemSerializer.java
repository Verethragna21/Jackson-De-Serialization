package com.george.serialization.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.george.serialization.models.Item;

import java.io.IOException;

public class ItemSerializer extends StdSerializer<Item> {

    public ItemSerializer() {
        this(null);
    }

    protected ItemSerializer(Class<Item> src) {
        super(src);
    }

    public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("itemId", item.itemId);
        jsonGenerator.writeStringField("itemName", item.itemName);

            //public User user;
            jsonGenerator.writeObjectFieldStart("user");
            jsonGenerator.writeNumberField("id", item.user.getId());
            jsonGenerator.writeStringField("name", item.user.getName());
            jsonGenerator.writeEndObject();

            //public List<Books> books;
            jsonGenerator.writeArrayFieldStart("books");
            item.getBooks().forEach(books -> {
                try {
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeStringField("bookName", books.getBookName());
                    jsonGenerator.writeStringField("bookCategory", books.getBookCategory());
                    jsonGenerator.writeEndObject();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            jsonGenerator.writeEndArray();

            //public List<String> autos;
            jsonGenerator.writeFieldName("autos");
            jsonGenerator.writeStartArray();
            item.getAutos().forEach(auto -> {
                try {
                    jsonGenerator.writeString(auto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}
