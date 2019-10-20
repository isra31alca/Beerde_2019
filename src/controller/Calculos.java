package controller;

public class Calculos {
	final double R = 0.539;
	final int DN = 351;
	final double P1 = 106161.22;
	
	public double[] calculoPaneles(double datosLibreria, double distanciaConstruccion, double altitud) {
		double E = (datosLibreria * distanciaConstruccion * 30000)/R;
		double delta = 23.45 * Math.sin(Math.toRadians(360 * (248 + DN)/365));
		double ws = Math.tan(Math.toRadians(altitud)) * Math.tan(Math.toRadians(delta));
		double H = P1 * ws * Math.sin(Math.toRadians(altitud)) * Math.sin(Math.toRadians(delta)) - Math.cos(Math.toRadians(altitud)) * Math.cos(Math.toRadians(delta)) * Math.sin(Math.toRadians(ws));
		double G = 1; //Rad. * 1000
		double ktm = G/H;
		double Fd = 1 - 1.13 * ktm;
		double Dd = 1; //Gd, m(0) * Fd, m(0)
		H = 1; //Gd - Dd;
		double Gf = H +Dd;
		
		double HPS = Gf * 0.001;
		double Pp = E / HPS;
		double Np = Pp/(1 * 0.9); // OpP
		
		
		return null;
	}
	
}
