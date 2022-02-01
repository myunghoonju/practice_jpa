package shop;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "test-logback")
public class ShopApplicationMain {

    public static void main(String[] args) {
        log.debug("DEBUG:: ShopApplicationMain");
    }
}
