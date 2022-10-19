package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		// Objekt - variabel
		gpspoints = new GPSPoint[n];
		antall = 0;

		for (GPSPoint gpsPoint : gpspoints) {
			System.out.println(gpsPoint);
		}
		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;

		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
		}
		return inserted;

	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START

		// throw new UnsupportedOperationException(TODO.method());
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		boolean a = insertGPS(gpspoint);
		return a;

		// TODO - SLUTT

	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START

		// throw new UnsupportedOperationException(TODO.method());
		for (int i = 0; i < gpspoints.length; i++) {
			gpspoints[i].toString();
			System.out.println(gpspoints[i].toString());

		}
		
		

		// TODO - SLUTT

		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
