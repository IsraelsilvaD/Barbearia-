package com.trimtime.app.util;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

public class ObjectIdToLongConverter implements Converter<ObjectId, Long> {
    @Override
    public Long convert(ObjectId source) {
        return source.getDate().getTime();
    }
}
