public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xDisSquare = Math.pow(p.xxPos - this.xxPos, 2);
        double yDisSquare = Math.pow(p.yyPos - this.yyPos, 2);
        return Math.sqrt(xDisSquare + yDisSquare);
    }

    public double calcForceExertedBy(Planet p) {
        if (this.calcDistance(p) == 0)
            return 0.0;
        double G = 6.67e-11;
        return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);

    }

    public double calcForceExertedByX(Planet p) {
        if (this.calcDistance(p) == 0)
            return 0.0;
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        if (this.calcDistance(p) == 0)
            return 0.0;
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0;
        for (Planet planet : planets)
            sum += this.calcForceExertedByX(planet);
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0;
        for (Planet planet : planets)
            sum += this.calcForceExertedByY(planet);
        return sum;
    }

    public void update(double dt, double fX, double fY) {
        // 计算加速度
        double accX = fX / this.mass;
        double accY = fY / this.mass;
        // 更新速度
        this.xxVel = this.xxVel + dt * accX;
        this.yyVel = this.yyVel + dt * accY;
        // 更新位置
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;

    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }

}
