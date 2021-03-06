import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class Player {
    private double courseWidth;
    private double courseHeight;
    private double stateSpeed;

    private Image playerRight;
    private Image playerLeft;
    ImageView playerView;

    boolean hasBag;

    private boolean stateOnRightEdgeOfScreen;
    private boolean stateOnLeftEdgeOfScreen;

    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;

    public Player(Group componentsGroup, double cWidth, double cHeight) {
        courseWidth = cWidth;
        courseHeight = cHeight;
        stateSpeed = 5;

        try {
            playerRight = new Image(new FileInputStream("assets/images/player.png"));
            playerLeft = new Image(new FileInputStream("assets/images/player_flip.png"));
        } catch (IOException e) {
        }
        playerView = new ImageView(playerRight);
        playerView.setFitHeight(320);
        playerView.setPreserveRatio(true);
        componentsGroup.getChildren().add(playerView);
    }

    public double getMinX() {
        return playerView.getBoundsInParent().getMinX();
    }

    public double getMaxX() {
        return playerView.getBoundsInParent().getMaxX();
    }

    public double getAverageX() {
        return (playerView.getBoundsInParent().getMaxX() + playerView.getBoundsInParent().getMinX()) / 2;
    }

    public void reposition(double x, double y) {
        playerView.setTranslateX(x);
        playerView.setTranslateY(y);
    }

    public void moveRight() {
        playerView.setTranslateX(playerView.getTranslateX() + stateSpeed);
    }

    public void moveLeft() {
        playerView.setTranslateX(playerView.getTranslateX() - stateSpeed);
    }

    public boolean isOnRightEdge() {
        if (playerView.getBoundsInParent().getMaxX() >= courseWidth) {
            stateOnRightEdgeOfScreen = true;
            return stateOnRightEdgeOfScreen;
        } else {
            stateOnRightEdgeOfScreen = false;
            return stateOnRightEdgeOfScreen;
        }
    }

    public boolean isOnLeftEdge() {
        if (playerView.getBoundsInParent().getMinX() <= 0) {
            stateOnLeftEdgeOfScreen = true;
            return stateOnLeftEdgeOfScreen;
        } else {
            stateOnLeftEdgeOfScreen = false;
            return stateOnLeftEdgeOfScreen;
        }
    }

    public Bounds getBounds() {
        return playerView.getBoundsInParent();
    }

    public void setSpeed(double speed) {
        stateSpeed = speed;
    }

    public double getSpeed() {
        return stateSpeed;
    }

    public void setCanMoveRight(boolean canMove) {
        canMoveRight = canMove;
    }

    public boolean getCanMoveRight() {
        return canMoveRight;
    }

    public void setCanMoveLeft(boolean canMove) {
        canMoveLeft = canMove;
    }

    public boolean getCanMoveLeft() {
        return canMoveLeft;
    }

    public Image getPlayerRight() {
        return playerRight;
    }

    public Image getPlayerLeft() {
        return playerLeft;
    }
}