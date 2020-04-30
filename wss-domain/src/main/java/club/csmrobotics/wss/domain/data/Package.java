package club.csmrobotics.wss.domain.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * simple class representing data from the ras pi
 * <p>
 * must be separated to different files in later versions
 * <p>
 * variables names are unpleasant
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private float temp;
    private float pressPa;
    private float hum;
    private float CO2ppm;
    private float tVOCpp;
    private long count;
    private long packetNum;
    private int deviceInfo;
    @Version
    private Long version;
}
