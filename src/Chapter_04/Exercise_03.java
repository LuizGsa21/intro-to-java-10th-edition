package Chapter_04;

/**
 * Chapter 4 Exercise 3:
 *
 *      (Geography: estimate areas) Find the GPS locations for
 *
 *      - Atlanta, Georgia;
 *      - Orlando, Florida;
 *      - Savannah, Georgia;
 *      - Charlotte, North Carolina;
 *
 *      from www.gps-data-team.com/map/ and compute the estimated area enclosed by these four cities.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */

public class Exercise_03 {

    private static final double AVERAGE_EARTH_RADIUS = 6371.01;

    public static void main(String[] args) {

        double atlantaGeoY = -84.3879824;
        double atlantaGeoX = 33.7489954;

        double orlandoFLY = -81.3792364999;
        double orlandoFLX = 28.5383355;

        double SavannahGeoY = -81.09983419999998;
        double SavannahGeoX = 32.0835407;

        double charlotteNCY = -80.84312669999997;
        double charlotteNCX = 35.2270869;

        // Getting sides for 2 triangles
        double t1Side1 = distanceBetweenTwoPointsGEOGRAPH(atlantaGeoX, atlantaGeoY, SavannahGeoX, SavannahGeoY);
        double t1Side2 = distanceBetweenTwoPointsGEOGRAPH(SavannahGeoX, SavannahGeoY, charlotteNCX, charlotteNCY);
        double t1Side3 = distanceBetweenTwoPointsGEOGRAPH(charlotteNCX, charlotteNCY, atlantaGeoX, atlantaGeoY);

        double t2Side1 = distanceBetweenTwoPointsGEOGRAPH(atlantaGeoX, atlantaGeoY, orlandoFLX, orlandoFLY);
        double t2Side2 = distanceBetweenTwoPointsGEOGRAPH(orlandoFLX, orlandoFLY, SavannahGeoX, SavannahGeoY);
        double t2Side3 = distanceBetweenTwoPointsGEOGRAPH(SavannahGeoX, SavannahGeoY, atlantaGeoX, atlantaGeoY);

        // Testing to see if both triangles are real triangles
        boolean isTriangle1 = isTriangle(t1Side1, t1Side2, t1Side3);
        boolean isTriangle2 = isTriangle(t1Side1, t1Side2, t1Side3);


        // If they are a triangle, add both areas to get
        // total area
        if (isTriangle1 && isTriangle2) {
            double area1 = getTriangleArea(t1Side1, t1Side2, t1Side3);
            double area2 = getTriangleArea(t2Side1, t2Side2, t2Side3);
            System.out.printf("Triangle 1: %f -- %f -- %f   : area = %f\n", t1Side1, t1Side2, t1Side3, area1);
            System.out.printf("Triangle 2: %f -- %f -- %f   : area = %f\n", t2Side1, t2Side2, t2Side3, area2);
            double totalArea = area1 + area2;
            System.out.println("The area of the triangle is " + totalArea);
        } else {
            System.out.println("Sorry the coordinates are incorrect");
        }

    }

    public static double distanceBetweenTwoPointsGEOGRAPH(double x1, double y1, double x2, double y2) {

        double distance = AVERAGE_EARTH_RADIUS *
                Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
                        Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1 - y2)));

        return distance;
    }

    public static double getTriangleArea(double side1, double side2, double side3) {

        double s = (side1 + side2 + side3) / 2.0;
        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
    }

    public static boolean isTriangle(double side1, double side2, double side3) {

        return  ((side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side3 + side2 > side1));

    }

}


