package rclub.wss.persistance.dto;


import lombok.Data;

import javax.persistence.*;

/**
 * for now same as package
 */
@Entity
@Data
@Table(name = "packages")
public class PackageDTO {
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
