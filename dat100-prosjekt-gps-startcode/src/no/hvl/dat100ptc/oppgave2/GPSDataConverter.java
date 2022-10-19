package no.hvl.dat100ptc.oppgave2;

import static java.lang.Double.parseDouble;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
//		int secs = Integer.parseInt(timestr);
//		int hr = Integer.parseInt(timestr.substring(12, 13)); 
//		int min = Integer.parseInt(timestr.substring(15, 16));  
//		int sec = Integer.parseInt(timestr.substring(18, 19)); 
		
		int secs;
		int hr, min, sec;
		
		String tid = timestr.substring(TIME_STARTINDEX, 19);
		String tidtab[] = tid.split(":");
		hr = Integer.parseInt(tidtab[0]);
		min = Integer.parseInt(tidtab[1]);
		sec = Integer.parseInt(tidtab[2]);
		
		// TODO
		// OPPGAVE - START
		
		//throw new UnsupportedOperationException(TODO.method());
		 secs = (hr * 60 *60) + (min * 60) + sec;
		 
		 
		 
		 return secs;
		
		
		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		
		gpspoint = new GPSPoint(toSeconds(timeStr), parseDouble(latitudeStr), parseDouble(longitudeStr), parseDouble(elevationStr));
		
		return gpspoint;

		// OPPGAVE - SLUTT ;
	    
	}
	
}
