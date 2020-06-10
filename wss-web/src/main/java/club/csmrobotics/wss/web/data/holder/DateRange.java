package club.csmrobotics.wss.web.data.holder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateRange {
    private Date start;
    private Date end;

    public boolean hasEnd() {
        return end != null;
    }

    public boolean hasStart() {
        return start != null;
    }
}
