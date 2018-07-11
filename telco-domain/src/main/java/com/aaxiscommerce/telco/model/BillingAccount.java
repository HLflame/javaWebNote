package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.aaxiscommerce.telco.model.BillingAddress;
import com.aaxiscommerce.telco.model.Currency;
import com.aaxiscommerce.telco.model.Invoice;
import com.aaxiscommerce.telco.model.Payment;
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
 * BillingAccount
 */
@Validated

public class BillingAccount   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("customerAccountId")
  private String customerAccountId = null;

  @JsonProperty("serviceAccountId")
  private String serviceAccountId = null;

  @JsonProperty("accountBalance")
  private Currency accountBalance = null;

  @JsonProperty("billingAddress")
  private BillingAddress billingAddress = null;

  @JsonProperty("payments")
  @Valid
  private List<Payment> payments = null;

  @JsonProperty("invoices")
  @Valid
  private List<Invoice> invoices = null;

  @JsonProperty("extraData")
  private String extraData = null;

  public BillingAccount id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "89819065", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BillingAccount customerAccountId(String customerAccountId) {
    this.customerAccountId = customerAccountId;
    return this;
  }

  /**
   * Get customerAccountId
   * @return customerAccountId
  **/
  @ApiModelProperty(example = "0014191368-9", value = "")


  public String getCustomerAccountId() {
    return customerAccountId;
  }

  public void setCustomerAccountId(String customerAccountId) {
    this.customerAccountId = customerAccountId;
  }

  public BillingAccount serviceAccountId(String serviceAccountId) {
    this.serviceAccountId = serviceAccountId;
    return this;
  }

  /**
   * Get serviceAccountId
   * @return serviceAccountId
  **/
  @ApiModelProperty(example = "89819065", value = "")


  public String getServiceAccountId() {
    return serviceAccountId;
  }

  public void setServiceAccountId(String serviceAccountId) {
    this.serviceAccountId = serviceAccountId;
  }

  public BillingAccount accountBalance(Currency accountBalance) {
    this.accountBalance = accountBalance;
    return this;
  }

  /**
   * Get accountBalance
   * @return accountBalance
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Currency getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(Currency accountBalance) {
    this.accountBalance = accountBalance;
  }

  public BillingAccount billingAddress(BillingAddress billingAddress) {
    this.billingAddress = billingAddress;
    return this;
  }

  /**
   * Get billingAddress
   * @return billingAddress
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BillingAddress getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(BillingAddress billingAddress) {
    this.billingAddress = billingAddress;
  }

  public BillingAccount payments(List<Payment> payments) {
    this.payments = payments;
    return this;
  }

  public BillingAccount addPaymentsItem(Payment paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

  /**
   * Get payments
   * @return payments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public BillingAccount invoices(List<Invoice> invoices) {
    this.invoices = invoices;
    return this;
  }

  public BillingAccount addInvoicesItem(Invoice invoicesItem) {
    if (this.invoices == null) {
      this.invoices = new ArrayList<>();
    }
    this.invoices.add(invoicesItem);
    return this;
  }

  /**
   * Get invoices
   * @return invoices
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Invoice> getInvoices() {
    return invoices;
  }

  public void setInvoices(List<Invoice> invoices) {
    this.invoices = invoices;
  }

  public BillingAccount extraData(String extraData) {
    this.extraData = extraData;
    return this;
  }

  /**
   * Get extraData
   * @return extraData
  **/
  @ApiModelProperty(example = "{\"cliente\":{\"deudaCliente\":{\"NombreCliente\":\"OLIVARES RUBILAR, RICARDO\",\"RutCliente\":\"14191368-9\",\"SaldoTotal\":29763,\"detalleCuentas\":[{\"NumeroCuenta\":\"89819065\",\"SaldoCuenta\":29763,\"FechaVencimiento\":\"2018-05-16T23:00:00.000-0400\"}],\"detalleDocumentos\":[{\"NumeroCuenta\":\"89819065\",\"NumeroDocumento\":\"131937252\",\"SaldoDocumento\":29763,\"FechaVencimientoDcto\":\"2018-05-16T23:00:00.000-0400\",\"FechaEmisionDcto\":\"2018-04-23T00:00:00.000-0300\",\"DireccionCobranza\":\"PJE MATICO 2931\",\"TipoCorrelativo\":\"Boleta\",\"CodTipoDocumento\":\"BO\"}]},\"deuda\":true}}", value = "")


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
    BillingAccount billingAccount = (BillingAccount) o;
    return Objects.equals(this.id, billingAccount.id) &&
        Objects.equals(this.customerAccountId, billingAccount.customerAccountId) &&
        Objects.equals(this.serviceAccountId, billingAccount.serviceAccountId) &&
        Objects.equals(this.accountBalance, billingAccount.accountBalance) &&
        Objects.equals(this.billingAddress, billingAccount.billingAddress) &&
        Objects.equals(this.payments, billingAccount.payments) &&
        Objects.equals(this.invoices, billingAccount.invoices) &&
        Objects.equals(this.extraData, billingAccount.extraData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerAccountId, serviceAccountId, accountBalance, billingAddress, payments, invoices, extraData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillingAccount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerAccountId: ").append(toIndentedString(customerAccountId)).append("\n");
    sb.append("    serviceAccountId: ").append(toIndentedString(serviceAccountId)).append("\n");
    sb.append("    accountBalance: ").append(toIndentedString(accountBalance)).append("\n");
    sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
    sb.append("    invoices: ").append(toIndentedString(invoices)).append("\n");
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

