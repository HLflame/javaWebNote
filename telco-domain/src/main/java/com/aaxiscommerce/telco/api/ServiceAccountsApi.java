/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.aaxiscommerce.telco.api;

import com.aaxiscommerce.telco.model.ServiceAccount;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Api(value = "serviceAccounts", description = "the serviceAccounts API")
public interface ServiceAccountsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "serviceAccountsPost", notes = "Create or Update Service Account", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok"),
        @ApiResponse(code = 400, message = "InvalidRequest") })
    @RequestMapping(value = "/serviceAccounts",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> serviceAccountsPost(@ApiParam(value = "description"  )  @Valid @RequestBody ServiceAccount serviceAccount) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
