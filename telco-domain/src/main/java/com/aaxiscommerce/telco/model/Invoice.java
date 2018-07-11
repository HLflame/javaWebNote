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
 * Invoice
 */
@Validated

public class Invoice   {
  @JsonProperty("invoiceNumber")
  private String invoiceNumber = null;

  @JsonProperty("invoiceTotal")
  private Currency invoiceTotal = null;

  public Invoice invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

  /**
   * Get invoiceNumber
   * @return invoiceNumber
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public Invoice invoiceTotal(Currency invoiceTotal) {
    this.invoiceTotal = invoiceTotal;
    return this;
  }

  /**
   * Get invoiceTotal
   * @return invoiceTotal
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Currency getInvoiceTotal() {
    return invoiceTotal;
  }

  public void setInvoiceTotal(Currency invoiceTotal) {
    this.invoiceTotal = invoiceTotal;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invoice invoice = (Invoice) o;
    return Objects.equals(this.invoiceNumber, invoice.invoiceNumber) &&
        Objects.equals(this.invoiceTotal, invoice.invoiceTotal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(invoiceNumber, invoiceTotal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    invoiceTotal: ").append(toIndentedString(invoiceTotal)).append("\n");
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

