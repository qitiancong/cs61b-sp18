public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    // constructor 
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    //second constructor that initialise an idendical Body
    public Planet(Planet b) {
        this(b.xxPos,b.yyPos,b.xxVel,b.yyVel,b.mass,b.imgFileName);
    }

    public double calcDistance(Planet b) {
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        double distance = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
        return distance;
    }

    //return force exerted on this by b.
    public double calcForceExertedBy(Planet b){
        return (G * this.mass * b.mass) / Math.pow(this.calcDistance(b),2);
    }

    public double calcForceExertedByX(Planet b) {
        double dx = b.xxPos - this.xxPos;
        double f = this.calcForceExertedBy(b);
        double r = this.calcDistance(b);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet b) {
        double dy = b.yyPos - this.yyPos;
        double f = this.calcForceExertedBy(b);
        double r = this.calcDistance(b);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double[] arr_X = new double[planets.length];
        for (int i = 0; i < planets.length; i++) {
            Planet p = planets[i];
            if (!(this.equals(p))) {
                arr_X[i] = this.calcForceExertedByX(p);
            } else {
                arr_X[i] = 0;
            }
        }

        double netX = 0;

        for(int i = 0; i < arr_X.length; i++) {
            netX += arr_X[i];
        }
        return netX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double[] arr_Y = new double[planets.length];
        for (int i = 0; i < planets.length; i++) {
            Planet p = planets[i];
            if (!(this.equals(p))) {
                arr_Y[i] = this.calcForceExertedByY(p);
            } else {
                arr_Y[i] = 0;
            }
        }

        double netY = 0;

        for(int i = 0; i < arr_Y.length; i++) {
            netY += arr_Y[i];
        }
        return netY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}