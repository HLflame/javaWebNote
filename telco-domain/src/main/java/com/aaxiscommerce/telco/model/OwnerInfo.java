package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.aaxiscommerce.telco.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OwnerInfo
 */
@Validated

public class OwnerInfo   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("documentID")
  private String documentID = null;

  @JsonProperty("documentType")
  private String documentType = null;

  @JsonProperty("taxStatus")
  private String taxStatus = null;

  @JsonProperty("entityType")
  private String entityType = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("address")
  private Address address = null;

  public OwnerInfo name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "RICARDO", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OwnerInfo documentID(String documentID) {
    this.documentID = documentID;
    return this;
  }

  /**
   * Get documentID
   * @return documentID
  **/
  @ApiModelProperty(example = "14191368-9", required = true, value = "")
  @NotNull


  public String getDocumentID() {
    return documentID;
  }

  public void setDocumentID(String documentID) {
    this.documentID = documentID;
  }

  public OwnerInfo documentType(String documentType) {
    this.documentType = documentType;
    return this;
  }

  /**
   * Get documentType
   * @return documentType
  **/
  @ApiModelProperty(example = "rut", required = true, value = "")
  @NotNull


  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public OwnerInfo taxStatus(String taxStatus) {
    this.taxStatus = taxStatus;
    return this;
  }

  /**
   * Get taxStatus
   * @return taxStatus
  **/
  @ApiModelProperty(value = "")


  public String getTaxStatus() {
    return taxStatus;
  }

  public void setTaxStatus(String taxStatus) {
    this.taxStatus = taxStatus;
  }

  public OwnerInfo entityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Get entityType
   * @return entityType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public OwnerInfo emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Get emailAddress
   * @return emailAddress
  **/
  @ApiModelProperty(example = "ricardo.aor@gmail.com", value = "")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public OwnerInfo phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(example = "+56963403629", value = "")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public OwnerInfo address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OwnerInfo ownerInfo = (OwnerInfo) o;
    return Objects.equals(this.name, ownerInfo.name) &&
        Objects.equals(this.documentID, ownerInfo.documentID) &&
        Objects.equals(this.documentType, ownerInfo.documentType) &&
        Objects.equals(this.taxStatus, ownerInfo.taxStatus) &&
        Objects.equals(this.entityType, ownerInfo.entityType) &&
        Objects.equals(this.emailAddress, ownerInfo.emailAddress) &&
        Objects.equals(this.phoneNumber, ownerInfo.phoneNumber) &&
        Objects.equals(this.address, ownerInfo.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, documentID, documentType, taxStatus, entityType, emailAddress, phoneNumber, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnerInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    documentID: ").append(toIndentedString(documentID)).append("\n");
    sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
    sb.append("    taxStatus: ").append(toIndentedString(taxStatus)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

