public class NBody {

    //read radius from file name
    public static double readRadius(String s) {
        In in = new In(s);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    //return an array of planets
    public static Planet[] readPlanets(String s) {
        In in = new In(s);
        int n = in.readInt();
        in.readDouble(); // skip radius
        Planet[] arr_p = new Planet[n]; // create array of size n to store planets
        for(int i = 0; i < n;i ++) {
            //get planet properties
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            //create new planet using above properties
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel,mass,imgFileName);
            arr_p[i] = p;
        }
        return arr_p;
    }

    public static String imageToDraw = "images/starfield.jpg"; 

    public static void main(String[] args) {
        double t = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universe_radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(- universe_radius, universe_radius); 
        //StdDraw.picture(0, 0, imageToDraw); //background

        for (double time = 0; time <= t; time = time + dt) {
            double[] arr_x_forces = new double [planets.length];
            double[] arr_y_forces = new double [planets.length];

            //calculate net x y force of each body, put in array
            for(int i = 0; i < planets.length; i++){
                arr_x_forces[i] = planets[i].calcNetForceExertedByX(planets);
                arr_y_forces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            //update each body with net x y force
            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt,arr_x_forces[i],arr_y_forces[i]);
            }

            StdDraw.picture(0, 0, imageToDraw); 

            for (Planet p : planets) {
                p.draw();
            }

            StdDraw.show(10);

        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n",universe_radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }


    }
}