package com.george.serialization.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.george.serialization.models.Books;
import com.george.serialization.models.Item;
import com.george.serialization.models.User;

import java.io.IOException;
import java.util.List;

public class ItemDeserializer extends StdDeserializer<Item> {

    public ItemDeserializer() {
        this(null);
    }

    protected ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        var objectMapper = new ObjectMapper();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        var userNode = node.get("user");
        var booksArrayNode = (ArrayNode) node.get("books");
        var autosArrayNode = (ArrayNode) node.get("autos");

        var item = new Item();
        item.setItemId(node.get("itemId").asInt());
        item.setItemName(node.get("itemName").asText());

            var user = new User();
            user.setId(userNode.get("id").asInt());
            user.setName(userNode.get("name").asText());

        item.setUser(user);

            List<Books> books = objectMapper.readValue(booksArrayNode.toString(), new TypeReference<List<Books>>() {});

        item.setBooks(books);

            List<String> autos = objectMapper.readValue(autosArrayNode.toString(), new TypeReference<List<String>>() {});

        item.setAutos(autos);

        return item;
    }
}
