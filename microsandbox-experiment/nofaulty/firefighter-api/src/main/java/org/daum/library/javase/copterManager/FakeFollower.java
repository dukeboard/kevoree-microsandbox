package org.daum.library.javase.copterManager;


import org.daum.common.followermodel.Event;
import org.daum.common.followermodel.Follower;
import org.kevoree.annotation.*;
import org.kevoree.extra.marshalling.RichJSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 14/02/13
 * Time: 13:56
 */
@ComponentType
public class FakeFollower implements  Runnable {

    @Param(optional = true, defaultValue = "jed")
    String id;
    @Param(optional = true, defaultValue = "5")
    int distance;

    @Output
    org.kevoree.api.Port location;

    private Follower firefighter = new Follower();
    private Thread cthread = null;
    private boolean alive = false;

    @Start
    public void start(){
        // random base on RENNES
        double lat =    48.115683+ (Math.random() * 0.1 );
        double lon =         -1.664286+ (Math.random() * 0.1);
        firefighter.lat=(int)(lat* 1E6);
        firefighter.lon =  (int)(lon* 1E6);
        firefighter.id = id;
        firefighter.accuracy = 3;
        firefighter.altitude= 10;
        firefighter.safety_distance = 5;
        firefighter.event = Event.UPDATE;
        cthread = new Thread(this);
        alive = true;
        cthread.start();
    }

    public double meters2degrees_lat(double meters) {
        return meters / (2.0*Math.PI*6356752.3142/360.0);
    }
    public double meters2degrees_lon(double meters) {
        return (double)((meters / (2.0*Math.PI*6378137.0/360.0)));
    }

    public double feet2meters(double feet) {
        return feet * 0.3048006096;
    }
    public double meters2feet(double meters) {
        return meters / 0.3048006096;
    }

    public  double deg2rad2(double degrees) { /* convert degrees to radians */
        return degrees * (Math.PI/180.0);
    }

    public  double rad2deg2(double radians) { /* convert radian to degree */
        return radians * (180.0/Math.PI);
    }


    int Random (int _iMin, int _iMax)
    {
        return (int)(Math.random() * (_iMax-_iMin)) + _iMin;
    }


    public void randomPoint(double distance)
    {
        double width, height;
        int yaw = Random(0,360);
        double lat;
        double lon;
        if (yaw< 90)
        {
            width  =  distance * Math.sin(deg2rad2(yaw));
            height =  distance * Math.cos(deg2rad2(yaw));
        } else if (yaw < 180) {
            width  =  distance * Math.cos(deg2rad2(yaw-90));
            height = -distance * Math.sin(deg2rad2(yaw-90));
        } else if (yaw < 270) {
            width  = -distance * Math.sin(deg2rad2(yaw-180));
            height = -distance * Math.cos(deg2rad2(yaw-180));
        } else {
            width  = -distance * Math.cos(deg2rad2(yaw-270));
            height =  distance * Math.sin(deg2rad2(yaw-270));
        }

        lat  = firefighter.lat /1E6+ meters2degrees_lat(height);
        lon = firefighter.lon /1E6+  meters2degrees_lon(width);

        firefighter.lat=  (int)(lat* 1E6);
        firefighter.lon =  (int)(lon* 1E6);

    }


    @Stop
    public void stop() {
        alive =false;
        cthread.interrupt();
        try {
            cthread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firefighter.event = Event.DELETE;
        RichJSONObject t = new RichJSONObject(firefighter);
        if (location.getConnectedBindingsSize() > 0) {
            location.send(t.toJSON());
        }

    }


    @Override
    public void run() {
        while (alive){

            try
            {
                randomPoint(distance);
                firefighter.accuracy  = Random(0,3);
                firefighter.event = Event.UPDATE;
                firefighter.temperature  = Random(30,26);
                firefighter.heartmonitor  = Random(60,120);
                RichJSONObject t = new RichJSONObject(firefighter);
                if (location.getConnectedBindingsSize() > 0) {
                    location.send(t.toJSON());
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                if(alive){

//                    e.printStackTrace();
                }
            }
        }
    }
}
