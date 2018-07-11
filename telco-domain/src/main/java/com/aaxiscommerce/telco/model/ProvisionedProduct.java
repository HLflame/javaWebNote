package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProvisionedProduct
 */
@Validated

public class ProvisionedProduct   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("productType")
  private String productType = null;

  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("deviceIds")
  @Valid
  private List<String> deviceIds = null;

  public ProvisionedProduct id(String id) {
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

  public ProvisionedProduct productType(String productType) {
    this.productType = productType;
    return this;
  }

  /**
   * Get productType
   * @return productType
  **/
  @ApiModelProperty(example = "TV", value = "")


  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public ProvisionedProduct productId(String productId) {
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

  public ProvisionedProduct deviceIds(List<String> deviceIds) {
    this.deviceIds = deviceIds;
    return this;
  }

  public ProvisionedProduct addDeviceIdsItem(String deviceIdsItem) {
    if (this.deviceIds == null) {
      this.deviceIds = new ArrayList<>();
    }
    this.deviceIds.add(deviceIdsItem);
    return this;
  }

  /**
   * Get deviceIds
   * @return deviceIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getDeviceIds() {
    return deviceIds;
  }

  public void setDeviceIds(List<String> deviceIds) {
    this.deviceIds = deviceIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProvisionedProduct provisionedProduct = (ProvisionedProduct) o;
    return Objects.equals(this.id, provisionedProduct.id) &&
        Objects.equals(this.productType, provisionedProduct.productType) &&
        Objects.equals(this.productId, provisionedProduct.productId) &&
        Objects.equals(this.deviceIds, provisionedProduct.deviceIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productType, productId, deviceIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProvisionedProduct {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    deviceIds: ").append(toIndentedString(deviceIds)).append("\n");
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

