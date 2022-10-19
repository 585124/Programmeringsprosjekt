package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;    
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;  		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double ø1 = latitude1;
		double ø2 = latitude2;
		double trekantØ = latitude2-latitude1;
		double lambda = longitude2-longitude1;
		
		double a = Math.pow(sin(trekantØ) / 2, 2) + Math.cos(ø1) * Math.cos(ø2) * 
				Math.pow(lambda / 2, 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		d = R*c;
		return d;
		  
		
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		speed = distance(gpspoint1, gpspoint2) / secs * 3.6;
		
		return speed;
		
		
		
		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		

		// TODO - START
		int hh = secs /3600;
		int secsLeft = secs - hh * 3600;
		int mm = secsLeft / 60;
		int ss = secsLeft - mm * 60;
		
		String hhFormat = String.format("  %02d", hh);
		String mmFormat = String.format("%02d", mm);
		String ssFormat = String.format("%02d", ss);
		
		timestr = hhFormat + TIMESEP + mmFormat + TIMESEP + ssFormat; 
		
		
		return timestr;
		
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		double avrundet = Math.round(d*100) / 100.00;
		
		String str = String.format("%" + TEXTWIDTH + "s", avrundet);
		
		return str;
		
		// TODO - SLUTT
		
	}
}
