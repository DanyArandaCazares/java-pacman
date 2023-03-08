import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pacman extends Actor
{
    private static final int MOUTH_COUNTER = 5;
    public static final int OFFSET = 5;
    private static final int DIRECTION_RIGHT = 0;
    private static final int DIRECTION_UP = 1;
    private static final int DIRECTION_LEFT = 2;
    private static final int DIRECTION_DOWN = 3;
    private static final int SOUND_DELAY = 300;
    private int mouth_delay = MOUTH_COUNTER;
    private int imageIndex;
    private String [][]images;
    private int direction = DIRECTION_RIGHT;
    private int score;
    private int soundDelay;
    /**
     * Act - do whatever the pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public pacman(){
        images = new String[4][];
        
        images[DIRECTION_RIGHT] = new String[]{
            "images/pacman-right-open.png",
            "images/pacman-right-close.png"
        };
        
        images[DIRECTION_UP] = new String[]{
            "images/pacman-up-open.png",
            "images/pacman-up-close.png"
        };
        
        images[DIRECTION_LEFT] = new String[]{
            "images/pacman-left-open.png",
            "images/pacman-left-close.png"
        };
        
        images[DIRECTION_DOWN] = new String[]{
            "images/pacman-down-open.png",
            "images/pacman-down-close.png"
        };
        
        setImage(images[DIRECTION_RIGHT][0]);
    }
    
    public void act()
    {
        movePacman();
        
        handleKeys();
        
        handleImageSelector();
        
        updateHud();
        
        checkCollisions();
        
        checkWall();
        
        checkBoundaries();
        
        manageSound();
    }
    
    private void manageSound(){
        if(soundDelay == 0){
            Greenfoot.playSound("sounds/waka.mp3");
            soundDelay = SOUND_DELAY;
        }
        soundDelay--;
    }
    
    private void movePacman(){
        
        switch(direction){
            case DIRECTION_RIGHT:
                setLocation(getX() + OFFSET, getY());
                if(isTouching(wall.class)){
                    setLocation(getX() - OFFSET, getY());
                }
                break;
            
            case DIRECTION_UP:
                setLocation(getX(), getY() - OFFSET);
                if(isTouching(wall.class)){
                    setLocation(getX(), getY() + OFFSET);
                }
                break;
                
            case DIRECTION_LEFT:
                setLocation(getX() - OFFSET, getY());
                if(isTouching(wall.class)){
                    setLocation(getX()+ OFFSET, getY());
                }
                break;
                
            case DIRECTION_DOWN:
                setLocation(getX(), getY() + OFFSET);
                if(isTouching(wall.class)){
                    setLocation(getX(), getY() - OFFSET);
                }
                break;
        }
    }
    
    private void handleKeys(){
        if(Greenfoot.isKeyDown("right")){
            direction = DIRECTION_RIGHT;
        }else if(Greenfoot.isKeyDown("up")){
            direction = DIRECTION_UP;
        }else if(Greenfoot.isKeyDown("left")){
            direction = DIRECTION_LEFT;
        }else if(Greenfoot.isKeyDown("down")){
            direction = DIRECTION_DOWN;
        }
    }
    
    private void handleImageSelector(){
        if(mouth_delay == 0){
            imageIndex = (imageIndex + 1) % images[direction].length;
            
            setImage(images[direction][imageIndex]);
            
            mouth_delay = MOUTH_COUNTER;
        }
        mouth_delay--;
    }
    
    private void updateHud(){
        World world = getWorld();
        world.showText("Score: " + score, world.getWidth() - 100, 20);
    }
    
    private void checkCollisions(){
        item newItem = (item)this.getOneIntersectingObject(item.class);
        
        if(newItem != null){
            score += newItem.getPoints();
            Greenfoot.playSound("sounds/eating.mp3");
            this.getWorld().removeObject(newItem);
        }
    }
    
    private void checkWall(){
        if(isTouching(wall.class)){
            switch(direction){
                case DIRECTION_RIGHT:
                    setLocation(getX() - OFFSET, getY());
                    break;
                
                case DIRECTION_UP:
                    setLocation(getX(), getY() + OFFSET);
                    break;
                    
                case DIRECTION_LEFT:
                    setLocation(getX()+ OFFSET, getY());
                    break;
                    
                case DIRECTION_DOWN:
                    setLocation(getX(), getY() - OFFSET);
                    break;
            }
        }
    }
    
    private void checkBoundaries(){
        if(this.getX() == 20){
            setLocation(getX()+ OFFSET, getY());
        }
        if(this.getX() == 680){
            setLocation(getX() - OFFSET, getY());
        }
        if(this.getY() == 20){
            setLocation(getX(), getY() + OFFSET);
        }
        if(this.getY() == 480){
            setLocation(getX(), getY() - OFFSET);
        }
    }
}
