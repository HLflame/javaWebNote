package com.aaxiscommerce.telco.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.serviceAccount.base-path:/aaxis/TelcoServiceAccount/1.0.0}")
public class CustomerAccountsApiController implements CustomerAccountsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerAccountsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
