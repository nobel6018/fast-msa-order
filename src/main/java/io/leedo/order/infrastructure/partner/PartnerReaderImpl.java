package io.leedo.order.infrastructure.partner;

import io.leedo.order.common.exception.EntityNotFoundException;
import io.leedo.order.domain.partner.Partner;
import io.leedo.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CommonsLog
@RequiredArgsConstructor
public class PartnerReaderImpl implements PartnerReader {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
            .orElseThrow(() -> new EntityNotFoundException(""));
    }
}
