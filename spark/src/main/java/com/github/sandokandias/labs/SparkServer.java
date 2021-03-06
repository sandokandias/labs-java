package com.github.sandokandias.labs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static spark.Spark.post;

public class SparkServer {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        post("/", (request, response) -> {
            Transaction transaction = mapper.readValue(request.body(), Transaction.class);
            transaction.setId(UUID.randomUUID().toString());
            return mapper.writeValueAsString(transaction);
        });
    }
}