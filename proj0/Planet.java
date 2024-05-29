public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

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
}