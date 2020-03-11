package rclub.wss.domain.data;

/**
 * simple class representing data from the ras pi
 *
 * must be separated to different files in later versions
 *
 * variables names are unpleasant
 */
public class Package {
    private float temp;
    private float pressPa;
    private float hum;
    private float CO2ppm;
    private float tVOCpp;
    private long count;
    private long packetNum;
    private int deviceInfo;

}
