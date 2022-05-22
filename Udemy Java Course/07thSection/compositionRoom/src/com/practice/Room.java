package com.practice;

//NOTE: never initialize an object in its class!
public class Room {
    private Wall wall;
    private Furniture furniture;
    private Lights lights;

    public Room(Wall wall, Furniture furniture, Lights lights) {
        this.wall = wall;
        this.furniture = furniture;
        this.lights = lights;
    }

    public void flexWithGarland(){
        getLights().getGarlandLights().pplsReaction();
    }

    public void moving1Obj(){
        furniture.movingFurn("Chair");
    }
    /* i dont them since i can access to the component directly (look above)
    public Wall getWall() {
        return wall;
    }
*/

    public Furniture getFurniture() {
        return furniture;
    }
    private Lights getLights() {
        return lights;
    }
}
