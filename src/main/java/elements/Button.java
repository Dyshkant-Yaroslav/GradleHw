package elements;

import org.openqa.selenium.WebElement;

public class Button extends AbstractElement{

    public Button(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
            element.click();
            System.out.println("Button custom");
    }

}