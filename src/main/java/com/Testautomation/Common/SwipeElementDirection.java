package com.Testautomation.Common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public enum SwipeElementDirection {
    UP {
        void swipe(AppiumDriver driver, MobileElement element, int duration) {
            int offset = 1;
            Point p = element.getCenter();
            Point location = element.getLocation();
            Dimension size = element.getSize();
            //driver.swipe(p.getX(), location.getY() + size.getHeight() + offset, p.getX(), location.getY(), duration);
        }
    },
    DOWN {
        void swipe(AppiumDriver driver, MobileElement element, int duration) {
            int offset = 1;
            Point p = element.getCenter();
            Point location = element.getLocation();
            Dimension size = element.getSize();
            //driver.swipe(p.getX(), location.getY(), p.getX() - offset, location.getY() + size.getHeight(), duration);
        }
    },

}
