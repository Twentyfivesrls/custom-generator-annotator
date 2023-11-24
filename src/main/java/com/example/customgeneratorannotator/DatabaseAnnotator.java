package com.example.customgeneratorannotator;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

public class DatabaseAnnotator extends AbstractAnnotator {

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);

        // Note: does not have to be the propertyName, could be the field or propertyNode that is verified.
        if (propertyName.equals("isDocument")) {
            clazz.annotate(Document.class);
        }
    }
}
