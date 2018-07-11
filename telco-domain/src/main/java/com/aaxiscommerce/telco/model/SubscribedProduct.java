package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.aaxiscommerce.telco.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubscribedProduct
 */
@Validated

public class SubscribedProduct   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("productType")
  private String productType = null;

  @JsonProperty("serviceAccountId")
  private String serviceAccountId = null;

  @JsonProperty("subscriptionType")
  private String subscriptionType = null;

  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("price")
  private Currency price = null;

  public SubscribedProduct id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "90128444", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SubscribedProduct productType(String productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
  **/
  @ApiModelProperty(example = "movil", value = "")


  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public SubscribedProduct serviceAccountId(String serviceAccountId) {
    this.serviceAccountId = serviceAccountId;
    return this;
  }

  /**
   * Get serviceAccountId
   * @return serviceAccountId
  **/
  @ApiModelProperty(example = "90128444", value = "")


  public String getServiceAccountId() {
    return serviceAccountId;
  }

  public void setServiceAccountId(String serviceAccountId) {
    this.serviceAccountId = serviceAccountId;
  }

  public SubscribedProduct subscriptionType(String subscriptionType) {
    this.subscriptionType = subscriptionType;
    return this;
  }

  /**
   * Get subscriptionType
   * @return subscriptionType
  **/
  @ApiModelProperty(example = "postpay", value = "")


  public String getSubscriptionType() {
    return subscriptionType;
  }

  public void setSubscriptionType(String subscriptionType) {
    this.subscriptionType = subscriptionType;
  }

  public SubscribedProduct productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  **/
  @ApiModelProperty(example = "963403629", value = "")


  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public SubscribedProduct price(Currency price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Currency getPrice() {
    return price;
  }

  public void setPrice(Currency price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscribedProduct subscribedProduct = (SubscribedProduct) o;
    return Objects.equals(this.id, subscribedProduct.id) &&
        Objects.equals(this.productType, subscribedProduct.productType) &&
        Objects.equals(this.serviceAccountId, subscribedProduct.serviceAccountId) &&
        Objects.equals(this.subscriptionType, subscribedProduct.subscriptionType) &&
        Objects.equals(this.productId, subscribedProduct.productId) &&
        Objects.equals(this.price, subscribedProduct.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productType, serviceAccountId, subscriptionType, productId, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscribedProduct {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    serviceAccountId: ").append(toIndentedString(serviceAccountId)).append("\n");
    sb.append("    subscriptionType: ").append(toIndentedString(subscriptionType)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

