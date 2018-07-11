package com.aaxiscommerce.telco.model;

import java.util.Objects;
import com.aaxiscommerce.telco.model.Address;
import com.aaxiscommerce.telco.model.ProvisionedProduct;
import com.aaxiscommerce.telco.model.SubscribedProduct;
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
 * ServiceAccount
 */
@Validated

public class ServiceAccount   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("services")
  @Valid
  private List<ProvisionedProduct> services = null;

  @JsonProperty("billingAccountId")
  private String billingAccountId = null;

  @JsonProperty("customerAccountId")
  private String customerAccountId = null;

  @JsonProperty("serviceAddress")
  private Address serviceAddress = null;

  @JsonProperty("subscribedProducts")
  @Valid
  private List<SubscribedProduct> subscribedProducts = null;

  @JsonProperty("extraData")
  private String extraData = null;

  public ServiceAccount id(String id) {
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

  public ServiceAccount services(List<ProvisionedProduct> services) {
    this.services = services;
    return this;
  }

  public ServiceAccount addServicesItem(ProvisionedProduct servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ProvisionedProduct> getServices() {
    return services;
  }

  public void setServices(List<ProvisionedProduct> services) {
    this.services = services;
  }

  public ServiceAccount billingAccountId(String billingAccountId) {
    this.billingAccountId = billingAccountId;
    return this;
  }

  /**
   * Get billingAccountId
   * @return billingAccountId
  **/
  @ApiModelProperty(example = "89819065", value = "")


  public String getBillingAccountId() {
    return billingAccountId;
  }

  public void setBillingAccountId(String billingAccountId) {
    this.billingAccountId = billingAccountId;
  }

  public ServiceAccount customerAccountId(String customerAccountId) {
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

  public ServiceAccount serviceAddress(Address serviceAddress) {
    this.serviceAddress = serviceAddress;
    return this;
  }

  /**
   * Get serviceAddress
   * @return serviceAddress
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getServiceAddress() {
    return serviceAddress;
  }

  public void setServiceAddress(Address serviceAddress) {
    this.serviceAddress = serviceAddress;
  }

  public ServiceAccount subscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
    return this;
  }

  public ServiceAccount addSubscribedProductsItem(SubscribedProduct subscribedProductsItem) {
    if (this.subscribedProducts == null) {
      this.subscribedProducts = new ArrayList<>();
    }
    this.subscribedProducts.add(subscribedProductsItem);
    return this;
  }

  /**
   * Get subscribedProducts
   * @return subscribedProducts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<SubscribedProduct> getSubscribedProducts() {
    return subscribedProducts;
  }

  public void setSubscribedProducts(List<SubscribedProduct> subscribedProducts) {
    this.subscribedProducts = subscribedProducts;
  }

  public ServiceAccount extraData(String extraData) {
    this.extraData = extraData;
    return this;
  }

  /**
   * Get extraData
   * @return extraData
  **/
  @ApiModelProperty(example = "{\"cliente\":{\"direcciones\":[{\"DESC_LOCALIDAD\":\"San Bernardo\",\"CODI_LOCALIDAD\":\"SBER\",\"GLSA_VIVIENDA\":\"PJE MATICO 2931\",\"IDEN_VIVIENDA\":\"15323197\",\"numeroCuenta\":[{\"numeroCuenta\":\"89819065\",\"pat\":{\"pat\":false}}],\"contratos\":[{\"dirPostal\":\"PJE MATICO 2931\",\"idCuenta\":\"89819065\",\"email\":\"ricardo.olivares@vtr.cl\",\"isPat\":false,\"tipoIdentificador\":\"TANGO\",\"tipoSuscripcion\":\"E\",\"saldoPendiente\":29763,\"fechaVencimiento\":\"2018-05-16T23:00:00.000-0400\",\"isVencida\":false,\"APPTYPE\":\"DIREC\"}],\"servicios\":[[{\"CODI_CLASSERV\":\"2WAY\"},{\"CODI_CLASSERV\":\"C001\"},{\"CODI_CLASSERV\":\"F001\"},{\"CODI_CLASSERV\":\"PREM\"}]],\"productosCliente\":[{\"titulo\":\"Internet\",\"data\":[{\"servicio\":{\"cantidad\":1,\"producto\":{\"CODI_CLASSERV\":\"2WAY\",\"NOMB_PRODUCTO\":\"Mega 160\",\"CORR_CONCEPTO\":299416640,\"IDEN_GRUPOTAR\":12429,\"IDEN_SERVICIO\":26846248,\"DESC_PRODUCTONE\":\"PRecomendado para un uso avanzado de Internet, para familias muy tecnológicas que quieren disfrutar de la mejor  banda ancha, compartiendo la conexión en hasta 16 dispositivos simultáneos con la mejor experiencia (notebooks, smartphones, tablets, smartvs, consolas, parlantes wifi,etc). Velocidad de Bajada de hasta 160 Mbps / Velocidad de Subida de hasta 8 Mbps / WiFi incluido\"}}}]},{\"titulo\":\"Cable\",\"data\":[{\"servicio\":{\"cantidad\":2,\"producto\":{\"CODI_CLASSERV\":\"C001\",\"NOMB_PRODUCTO\":\"TV Full HD Digital\",\"CORR_CONCEPTO\":202006377,\"IDEN_GRUPOTAR\":30958,\"IDEN_SERVICIO\":26841677,\"DESC_PRODUCTONE\":\"PLa más completa grilla de canales de todas las categorías y gran calidad de contenido, junto a una amplia variedad de canales HD. Incluye un decodificador d-BOX HD. Consulta la grilla completa de canales para tu comuna en vtr.com/hogar.\"}}}]},{\"titulo\":\"Telefonía\",\"data\":[{\"servicio\":{\"cantidad\":3,\"producto\":{\"CODI_CLASSERV\":\"F001\",\"NOMB_PRODUCTO\":\"Fono Ilimitado 600 Móvil\",\"CORR_CONCEPTO\":299440668,\"IDEN_GRUPOTAR\":29827,\"IDEN_SERVICIO\":26846225,\"DESC_PRODUCTONE\":\"PEste plan permite realizar llamadas ilimitadas entre teléfonos de red fija de cualquier compañía e incluye 600 minutos mensuales para llamadas a teléfonos móviles. Una vez consumidos los 300 minutos, las llamadas a móviles se cobrarán según las tarifas vigentes en VTR. Renta mensual no incluye llamadas a Isla de Pascua o al 103, ni aquellas llamadas dirigidas a compañías locales o rurales en que se incluyan recargos al valor de la llamada local por sobre la tarifa del SLM. Tampoco incluye tráfico de datos o Internet, llamadas de larga distancia internacional, llamadas a móviles después de consumidos los 300 minutos incluidos, a números 700, 300, 606 y 609 y servicios adicionales, las que se cobrarán según las tarifas vigentes en VTR o del proveedor respectivo. Para activar el acceso al servicio de larga distancia internacional, a móviles y/o servicios 700, se requerirá de autorización expresa del cliente. El plan mantiene siempre el acceso a teléfonos de emergencia y al 600 800 9000.\"}}}]}],\"isDeco\":true,\"menuCount\":4,\"idServicioInternet\":26846248,\"isInternet\":true,\"idServicioCable\":26841677,\"isCable\":true,\"isTelefonia\":true,\"APPTYPE\":\"DIREC\"}]}}", value = "")


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
    ServiceAccount serviceAccount = (ServiceAccount) o;
    return Objects.equals(this.id, serviceAccount.id) &&
        Objects.equals(this.services, serviceAccount.services) &&
        Objects.equals(this.billingAccountId, serviceAccount.billingAccountId) &&
        Objects.equals(this.customerAccountId, serviceAccount.customerAccountId) &&
        Objects.equals(this.serviceAddress, serviceAccount.serviceAddress) &&
        Objects.equals(this.subscribedProducts, serviceAccount.subscribedProducts) &&
        Objects.equals(this.extraData, serviceAccount.extraData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, services, billingAccountId, customerAccountId, serviceAddress, subscribedProducts, extraData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceAccount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    billingAccountId: ").append(toIndentedString(billingAccountId)).append("\n");
    sb.append("    customerAccountId: ").append(toIndentedString(customerAccountId)).append("\n");
    sb.append("    serviceAddress: ").append(toIndentedString(serviceAddress)).append("\n");
    sb.append("    subscribedProducts: ").append(toIndentedString(subscribedProducts)).append("\n");
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

