public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        double rad = in.readDouble();
        in.close();
        return rad;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        Planet[] planets = new Planet[num];
        in.readDouble();
        int i = 0;
        while (i < num) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = "images/" + in.readString();
            planets[i++] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }

        return planets;
    }

    public static void draw(Planet[] planets) {
        for (Planet planet : planets)
            planet.draw();
    }

    public static void printResult(double radius){
        
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);
        System.out.println("数量: " + planets.length);
        // 设置画布
        StdDraw.setScale(-radius, radius);
        // 绘制背景
        StdDraw.picture(0, 0, "images/starfield.jpg");
        // 绘制所有星球
        draw(planets);

        StdDraw.show(2000);

        double time = 0;
        
        while (time < T) {
            // Create an xForces array and yForces array.
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];

            // Calculate the net x and y forces for each planet,
            // storing these in the xForces and yForces arrays respectively.
            for (int i = 0; i < xForces.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            // 绘制背景
            StdDraw.picture(0, 0, "images/starfield.jpg");
            // 绘制所有星球
            draw(planets);
            StdDraw.show(10);
            // 增加时间
            time += dt;
        }
        
    }
}
