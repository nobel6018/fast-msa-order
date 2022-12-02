package io.leedo.order.interfaces.partner;

import io.leedo.order.application.partner.PartnerFacade;
import io.leedo.order.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(PartnerDTO.RegisterRequest request) {
        // 1. 외부에서 전달된 파라미 (dto) -> Command, Criteria converter
        // 2. facade 호출 .. PartnerInfo (리턴 받음)
        // 3. PartnerInfo -> CommonResponse converter and rerturn

        var command = request.toCommand();
        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDTO.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
