package rclub.wss.domain.data;

import lombok.Data;

import javax.persistence.*;

/**
 * simple class representing data from the ras pi
 * <p>
 * must be separated to different files in later versions
 * <p>
 * variables names are unpleasant
 */
@Entity
@Data
@Table(name = "packages")
public class Package {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private float temp;
    @Column
    private float pressPa;
    @Column
    private float hum;
    @Column
    private float CO2ppm;
    @Column
    private float tVOCpp;
    @Column
    private long count;
    @Column
    private long packetNum;
    @Column
    private int deviceInfo;
    @Version
    private Long version;
}
