package com.practice;


public class Main {

    public static void main(String[] args) {
        Wall wall = new Wall(6,"Solid smth", "Yellow",true);
        Furniture furniture = new Furniture("Brown", "Wood",true);



//                                                                 new is intiializing on fly
        Lights lights = new Lights(8,"6400K",new GarlandLights("Red", true, 2.3f));

        //write this line next and initialize it after
        Room zbyszkoRoom = new Room(wall, furniture, lights);

        zbyszkoRoom.flexWithGarland();
        furniture.movingFurn("table");
        zbyszkoRoom.moving1Obj();
        wall.punchWall();

        System.out.println("The furniture color is "+zbyszkoRoom.getFurniture().getPrimaryColor());

    }
}
