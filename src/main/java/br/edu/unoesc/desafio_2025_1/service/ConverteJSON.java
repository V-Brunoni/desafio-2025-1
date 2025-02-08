package br.edu.unoesc.desafio_2025_1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ConverteJSON implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode firstResult = rootNode.get("results").get(0);
            ObjectNode jsonSimplificado = mapper.createObjectNode();

            jsonSimplificado.put("first", firstResult.get("name").get("first").asText());
            jsonSimplificado.put("last", firstResult.get("name").get("last").asText());
            jsonSimplificado.put("email", firstResult.get("email").asText());
            jsonSimplificado.put("phone", firstResult.get("phone").asText());
            String jsonFinal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSimplificado);
            System.out.println(jsonFinal);

            return mapper.readValue(jsonFinal, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
