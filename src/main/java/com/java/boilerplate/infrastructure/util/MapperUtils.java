package com.java.boilerplate.infrastructure.util;

import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class MapperUtils {

  public <S, T> T map(final S source, final Class<T> cassTarget) {
    try {
      return mapJson(source, cassTarget);
    } catch (Exception e) {
      return mapReflection(source, cassTarget);
    }
  }

  private <S, T> T mapJson(final S source, final Class<T> cassTarget) {
    final var json = ObjectMapperUtils.objectToJson(source);
    return ObjectMapperUtils.jsonToObject(json, cassTarget);
  }

  private <S, T> T mapReflection(final S source, final Class<T> cassTarget) {
    final var target = createInstanceOf(cassTarget);
    BeanUtils.copyProperties(source, target);
    return target;
  }

  private <T> T createInstanceOf(final Class<T> cassTarget) {
    try {
      final var constructor = cassTarget.getConstructor();
      return constructor.newInstance();
    } catch (Exception ex) {
      return null;
    }
  }
}
