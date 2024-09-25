package com.java.boilerplate.infrastructure.util;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@SuppressWarnings("PMD.ReturnEmptyCollectionRatherThanNull")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class ObjectMapperUtils {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

  static {
    OBJECT_MAPPER.registerModule(createAfterburnerModule());
    OBJECT_MAPPER.registerModule(new Jdk8Module());
    OBJECT_MAPPER.registerModule(new JavaTimeModule());
    OBJECT_MAPPER.registerModule(new RecordNamingStrategyPatchModule());
    OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    OBJECT_MAPPER.disable(WRITE_DATES_AS_TIMESTAMPS);
    OBJECT_MAPPER.setDateFormat(new SimpleDateFormat(DATE_FORMAT, Locale.ROOT));
    OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  private static AfterburnerModule createAfterburnerModule() {
    AfterburnerModule afterburnerModule = new AfterburnerModule();
    afterburnerModule.setUseValueClassLoader(false);
    return afterburnerModule;
  }


  public static String objectToJson(final Object object) {
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (Exception exception) {
      return object.getClass().toString();
    }
  }

  public static <T> T jsonToObject(final String json, final Class<T> objectType) {
    try {
      return OBJECT_MAPPER.readValue(json, objectType);
    } catch (Exception exception) {
      return null;
    }
  }
}
