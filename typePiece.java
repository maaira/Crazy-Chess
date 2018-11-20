package piece;

public abstract class typePiece {

    /**
     * @return the currentPositionX
     */
    public int getCurrentPositionX() {
        return currentPositionX;
    }

    /**
     * @param currentPositionX the currentPositionX to set
     */
    public void setCurrentPositionX(int currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    /**
     * @return the currentPositionY
     */
    public int getCurrentPositionY() {
        return currentPositionY;
    }

    /**
     * @param currentPositionY the currentPositionY to set
     */
    public void setCurrentPositionY(int currentPositionY) {
        this.currentPositionY = currentPositionY;
    }

    /**
     * @return the finalPositionX
     */
    public int getFinalPositionX() {
        return finalPositionX;
    }

    /**
     * @param finalPositionX the finalPositionX to set
     */
    public void setFinalPositionX(int finalPositionX) {
        this.finalPositionX = finalPositionX;
    }

    /**
     * @return the finalPositionY
     */
    public int getFinalPositionY() {
        return finalPositionY;
    }

    /**
     * @param finalPositionY the finalPositionY to set
     */
    public void setFinalPositionY(int finalPositionY) {
        this.finalPositionY = finalPositionY;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the fpX
     */
    
    private Player player; //It will have the name and the status of the player, being able to be installed in each piece
    private int currentPositionX, currentPositionY, finalPositionX, finalPositionY;
    
    public abstract void move(int spX,int spY, int fpX, int fpY); //Method that performs the move
    public abstract void attack(); //Method that performs the attack
    public abstract boolean isValidPatch(int fpX,int fpY); //Checks if the path can be performed
    
    /*
    public abstract int[][] drawPatch(int spX, int spY, int fpX, int fpY); //Draw the path
    ->This method may not be required.
    */    
    
}
