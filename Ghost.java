import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    public static final int OFFSET = 5;
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_LEFT = 1;
    private static final int DELAY = 120;
    private int imageIndex;
    private String []images;
    private int direction = DIRECTION_RIGHT;
    private int turnDelay = DELAY;
    /**
     * Act - do whatever the Ghost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveGhost();
        
        handleImageSelector();
        
        checkPacman();
        
        checkWall();
        
        checkBoundaries();
    }
    
    public Ghost(){
        images = new String[]{
            "images/ghost.png",
            "images/ghost-left.png"
        };
        
    }
    
    private void moveGhost(){
        switch(direction){
            case DIRECTION_RIGHT:
                setLocation(getX() + OFFSET, getY());
                break;
  
            case DIRECTION_LEFT:
                setLocation(getX() - OFFSET, getY());
                break;
        }
    }
    
    private void handleImageSelector(){
        if(direction == DIRECTION_RIGHT){
            setImage(images[0]);
        }else if(direction == DIRECTION_LEFT){
            setImage(images[1]);
        }
    }
    
    private void checkPacman(){
        pacman Pacman = (pacman)getOneIntersectingObject(pacman.class);
        
        if(Pacman != null){
            this.getWorld().removeObject(Pacman);
            
            World world = getWorld();
            Greenfoot.playSound("sounds/game_over.mp3");
            world.addObject(new GO(), world.getWidth()/2, world.getHeight()/2);
            //world.showText("GAME OVER", world.getWidth()/2, world.getHeight()/2);
        }
    }
    
    private void checkWall(){
        if(isTouching(wall.class)){
            switch(direction){
                case DIRECTION_RIGHT:
                    direction = DIRECTION_LEFT;
                    break;
  
                case DIRECTION_LEFT:
                    direction = DIRECTION_RIGHT;
                    break;
            }
        }
    }
    
    private void checkBoundaries(){
        if(this.getX() == 10){
            direction = DIRECTION_RIGHT;
        }
        if(this.getX() == 680){
            direction = DIRECTION_LEFT;
        }
    }
}
