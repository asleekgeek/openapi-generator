package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.math.BigDecimal;
import org.openapitools.model.Entity;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Pizza
 */

@JsonIgnoreProperties(
  value = "@type", // ignore manually set @type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the @type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = PizzaSpeziale.class, name = "PizzaSpeziale")
})

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0-SNAPSHOT")
public class Pizza extends Entity {

  private @Nullable BigDecimal pizzaSize;

  public Pizza() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Pizza(String atType) {
    super(atType);
  }

  public Pizza pizzaSize(BigDecimal pizzaSize) {
    this.pizzaSize = pizzaSize;
    return this;
  }

  /**
   * Get pizzaSize
   * @return pizzaSize
   */
  @Valid 
  @Schema(name = "pizzaSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pizzaSize")
  public BigDecimal getPizzaSize() {
    return pizzaSize;
  }

  public void setPizzaSize(BigDecimal pizzaSize) {
    this.pizzaSize = pizzaSize;
  }


  public Pizza href(String href) {
    super.href(href);
    return this;
  }

  public Pizza id(String id) {
    super.id(id);
    return this;
  }

  public Pizza atSchemaLocation(String atSchemaLocation) {
    super.atSchemaLocation(atSchemaLocation);
    return this;
  }

  public Pizza atBaseType(String atBaseType) {
    super.atBaseType(atBaseType);
    return this;
  }

  public Pizza atType(String atType) {
    super.atType(atType);
    return this;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pizza pizza = (Pizza) o;
    return Objects.equals(this.pizzaSize, pizza.pizzaSize) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pizzaSize, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pizza {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    pizzaSize: ").append(toIndentedString(pizzaSize)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public static class Builder extends Entity.Builder {

    private Pizza instance;

    public Builder() {
      this(new Pizza());
    }

    protected Builder(Pizza instance) {
      super(instance); // the parent builder shares the same instance
      this.instance = instance;
    }

    protected Builder copyOf(Pizza value) { 
      super.copyOf(value);
      this.instance.setPizzaSize(value.pizzaSize);
      return this;
    }

    public Pizza.Builder pizzaSize(BigDecimal pizzaSize) {
      this.instance.pizzaSize(pizzaSize);
      return this;
    }
    
    @Override
    public Pizza.Builder href(String href) {
      this.instance.href(href);
      return this;
    }
    
    @Override
    public Pizza.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    @Override
    public Pizza.Builder atSchemaLocation(String atSchemaLocation) {
      this.instance.atSchemaLocation(atSchemaLocation);
      return this;
    }
    
    @Override
    public Pizza.Builder atBaseType(String atBaseType) {
      this.instance.atBaseType(atBaseType);
      return this;
    }
    
    @Override
    public Pizza.Builder atType(String atType) {
      this.instance.atType(atType);
      return this;
    }
    
    /**
    * returns a built Pizza instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Pizza build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        super.build();
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field (except for the default values).
  */
  public static Pizza.Builder builder() {
    return new Pizza.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Pizza.Builder toBuilder() {
    Pizza.Builder builder = new Pizza.Builder();
    return builder.copyOf(this);
  }

}

