package io.leedo.order.application.partner;

import io.leedo.order.domain.notification.NotificationService;
import io.leedo.order.domain.partner.PartnerCommand;
import io.leedo.order.domain.partner.PartnerInfo;
import io.leedo.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    // @Transactional : Facade에서는 Transactional을 붙이지 않는 것을 선호한다
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. partnerService register
        // 2. email (optional)
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");

        return partnerInfo;
    }
}
