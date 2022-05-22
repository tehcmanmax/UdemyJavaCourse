public class SpeedConverter {

    public static long toMilesPerHour(double kilometeresPerHour){
        if(kilometeresPerHour<0){
            return -1;
        }

        float mile = 1.609f;
        long convertedToMiles = (long)(kilometeresPerHour / mile );


        return convertedToMiles;
    }


    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        }

        long milesPerHour = toMilesPerHour(kilometersPerHour);
        System.out.println(kilometersPerHour +
                " km/h = " + milesPerHour +
                " mi/h");
    }


        public static void main (String[]args){
            double kilometersPerHour = 25.42;
//        toMilesPerHour(kilometersPerHour);
            printConversion(kilometersPerHour);

        }
}