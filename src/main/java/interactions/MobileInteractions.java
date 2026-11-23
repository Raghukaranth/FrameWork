package interactions;

import constants.ConstFile;
import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

@Slf4j
public class MobileInteractions extends BaseInteractions<AppiumDriver> {

    public MobileInteractions(AppiumDriver driver) {
        super(driver);
    }

    public void tap(WebElement element) {
        waitForElementToBeClicked(element);
    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

    public void swipeByCoordinates(Point start, Point end, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.getX(), start.getY()))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), end.getX(), end.getY()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        log.info("Swiped from ({}, {}) to ({}, {})", start.getX(), start.getY(), end.getX(), end.getY());
    }

    public void scroll(ScrollDirection direction, double distanceRatio, Duration duration) {
        Dimension size = driver.manage().window().getSize();
        int midX = size.getWidth() / 2;
        int midY = size.getHeight() / 2;
        int verticalDelta = (int) (size.getHeight() * distanceRatio * 0.5);
        int horizontalDelta = (int) (size.getWidth() * distanceRatio * 0.5);

        switch (direction) {
            case DOWN:
                // Drag finger up to scroll content down
                swipeByCoordinates(
                        new Point(midX, midY + verticalDelta),
                        new Point(midX, midY - verticalDelta),
                        duration
                );
                break;
            case UP:
                // Drag finger down to scroll content up
                swipeByCoordinates(
                        new Point(midX, midY - verticalDelta),
                        new Point(midX, midY + verticalDelta),
                        duration
                );
                break;
            case LEFT:
                // Drag finger left to scroll content right
                swipeByCoordinates(
                        new Point(midX + horizontalDelta, midY),
                        new Point(midX - horizontalDelta, midY),
                        duration
                );
                break;
            case RIGHT:
                // Drag finger right to scroll content left
                swipeByCoordinates(
                        new Point(midX - horizontalDelta, midY),
                        new Point(midX + horizontalDelta, midY),
                        duration
                );
                break;
        }
    }

    public void scrollToElement(WebElement element, ScrollDirection direction, int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            try {
                if (element.isDisplayed()) {
                    log.info("Element is visible after {} scroll(s)", i);
                    return;
                }
            } catch (Exception ignored) {
                // Element not yet attached or visible in viewport
            }
            scroll(direction, 0.5, Duration.ofMillis(600));
        }
        throw new org.openqa.selenium.NoSuchElementException("Element not found after " + maxSwipes + " scroll(s)");
    }
}
