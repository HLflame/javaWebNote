package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.aaxiscommerce.telco.model.OwnerInfo;
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
 * CustomerAccount
 */
@Validated

public class CustomerAccount   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("accountOwner")
  private OwnerInfo accountOwner = null;

  @JsonProperty("billingAccountIds")
  @Valid
  private List<String> billingAccountIds = null;

  @JsonProperty("serviceAccountIds")
  @Valid
  private List<String> serviceAccountIds = null;

  @JsonProperty("extraData")
  private String extraData = null;

  public CustomerAccount id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "90128444", required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerAccount accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  **/
  @ApiModelProperty(example = "14191368-9", required = true, value = "")
  @NotNull


  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public CustomerAccount accountOwner(OwnerInfo accountOwner) {
    this.accountOwner = accountOwner;
    return this;
  }

  /**
   * Get accountOwner
   * @return accountOwner
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OwnerInfo getAccountOwner() {
    return accountOwner;
  }

  public void setAccountOwner(OwnerInfo accountOwner) {
    this.accountOwner = accountOwner;
  }

  public CustomerAccount billingAccountIds(List<String> billingAccountIds) {
    this.billingAccountIds = billingAccountIds;
    return this;
  }

  public CustomerAccount addBillingAccountIdsItem(String billingAccountIdsItem) {
    if (this.billingAccountIds == null) {
      this.billingAccountIds = new ArrayList<>();
    }
    this.billingAccountIds.add(billingAccountIdsItem);
    return this;
  }

  /**
   * Get billingAccountIds
   * @return billingAccountIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getBillingAccountIds() {
    return billingAccountIds;
  }

  public void setBillingAccountIds(List<String> billingAccountIds) {
    this.billingAccountIds = billingAccountIds;
  }

  public CustomerAccount serviceAccountIds(List<String> serviceAccountIds) {
    this.serviceAccountIds = serviceAccountIds;
    return this;
  }

  public CustomerAccount addServiceAccountIdsItem(String serviceAccountIdsItem) {
    if (this.serviceAccountIds == null) {
      this.serviceAccountIds = new ArrayList<>();
    }
    this.serviceAccountIds.add(serviceAccountIdsItem);
    return this;
  }

  /**
   * Get serviceAccountIds
   * @return serviceAccountIds
  **/
  @ApiModelProperty(value = "")


  public List<String> getServiceAccountIds() {
    return serviceAccountIds;
  }

  public void setServiceAccountIds(List<String> serviceAccountIds) {
    this.serviceAccountIds = serviceAccountIds;
  }

  public CustomerAccount extraData(String extraData) {
    this.extraData = extraData;
    return this;
  }

  /**
   * Get extraData
   * @return extraData
  **/
  @ApiModelProperty(example = "{\"cliente\":{\"apellidoMaterno\":\"RUBILAR\",\"apellidoPaterno\":\"OLIVARES\",\"celularDeContacto\":\"+56963403629\",\"checkAceptacionCondicionesDeUso\":\"TRUE\",\"checkEnvioInformacionVTR\":\"FALSE\",\"emailDeContacto\":\"ricardo.aor@gmail.com\",\"estadoCivil\":\"1\",\"fechaAniversarioMatrimonio\":null,\"fechaCreacionComoCliente\":1404975630000,\"fechaDeNacimiento\":342932400000,\"fechaUltimaModificacionDePerfil\":1525987838000,\"fijoDeContacto\":\"+562\",\"flagTipoPersona\":\"N\",\"genero\":\"M\",\"nombres\":\"RICARDO\",\"rut\":\"0014191368-9\",\"usuario\":\"ricardo.aor@gmail.com\",\"existe\":true}}", value = "")


  public String getExtraData() {
    return extraData;
  }

  public void setExtraData(String extraData) {
    this.extraData = extraData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerAccount customerAccount = (CustomerAccount) o;
    return Objects.equals(this.id, customerAccount.id) &&
        Objects.equals(this.accountNumber, customerAccount.accountNumber) &&
        Objects.equals(this.accountOwner, customerAccount.accountOwner) &&
        Objects.equals(this.billingAccountIds, customerAccount.billingAccountIds) &&
        Objects.equals(this.serviceAccountIds, customerAccount.serviceAccountIds) &&
        Objects.equals(this.extraData, customerAccount.extraData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountNumber, accountOwner, billingAccountIds, serviceAccountIds, extraData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerAccount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountOwner: ").append(toIndentedString(accountOwner)).append("\n");
    sb.append("    billingAccountIds: ").append(toIndentedString(billingAccountIds)).append("\n");
    sb.append("    serviceAccountIds: ").append(toIndentedString(serviceAccountIds)).append("\n");
    sb.append("    extraData: ").append(toIndentedString(extraData)).append("\n");
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

