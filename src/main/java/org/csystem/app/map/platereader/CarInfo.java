package org.csystem.app.map.platereader;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.time.LocalDateTime;


@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
public class CarInfo {
    private String m_plate;
    private LocalDateTime m_date;
}
