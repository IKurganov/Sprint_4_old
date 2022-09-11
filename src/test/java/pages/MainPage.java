package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    // список с вопросами
//    private By questionContainer = By.xpath("//div[@data-accordion-component='Accordion']");
//     локатор для стрелочки какого-либо вопроса
    private String questionArrow = ("//div[@class='accordion__button' and text()='%s']");
    //     локатор для ответа на какой-либо вопрос
    private By answerPanel = By.xpath(".//ancestor::div[@data-accordion-component='AccordionItem']/div[@data-accordion-component='AccordionItemPanel']");
    //     локатор для ответа на какой-либо вопрос
    private By orderButton = By.xpath("//button[text()='Заказать']");
    //     локатор для УНИЧТОЖЕНИЯ КУК КАК БУКАШЕК
    private By accessCookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
        try {
            driver.findElement(accessCookieButton).click();
        } catch (NoSuchElementException e) {
            System.out.println("Кнопки принятия куки нет");
        }
    }

    public String clickOnQuestionAndGiveAnswer(String question) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        WebElement questionElem = driver.findElement(By.xpath(String.format(questionArrow, question)));
        questionElem.sendKeys(Keys.END);
        questionElem.click();
        WebElement answer = questionElem.findElement(answerPanel);
        // закинуть ожидание из дисплейд
        // Ожидание, что кнопка станет кликабельной; ожидание не больше 3 секунд
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(answer));
        //  в тесте указываем что нажимаем на кнопку с таким - то вопросом, указываем его в параметрах. получаем ответ - сравниваем и так в 8 методах, в каждом open, vopros s otvetom i potom assert
        return answer.getText();
    }

    public ForWhomOrderPage clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return new ForWhomOrderPage(driver);
    }
//
//    public List<WebElement> getUpcomingEventsCardsList() {
//        return driver.findElements(eventsCardsElements);
//    }
//
//
//    public boolean isUpcomingEventsTabActive() {
////        return driver.findElement(upcomingEventsTab).getAttribute("class").contains("active");
//    }
//
//    public int getUpcomingEventCardsCount(List<WebElement> foundEventsList) {
//        return foundEventsList.size();
//    }
//
//    public int getUpcomingEventsTabCount() {
////        try {
////            return Integer.parseInt(driver.findElement(countOfUpcomingEventsFromTab).getText());
////        } catch (NoSuchElementException e) {
////            return 0;
////        }
//    }
//
//
//    public void clickButton() {
//        driver.findElement(pastEventsTab).click();
//    }
//
//
//    public boolean isSmthActive() {
//        return driver.findElement(pastEventsTab).getAttribute("class").contains("active");
//    }
//
//
//    public int getPastEventsTabCount() {
//        try {
//            return Integer.parseInt(driver.findElement(countOfPastEventsFromTab).getText());
//        } catch (NoSuchElementException e) {
//            return 0;
//        }
//    }
//
//
//    // common
//    public List<String> getEventsCardsList() {
//        return eventsCardContainer.findElements(eventsCardsElements).stream().map(element -> element.getText()).collect(Collectors.toList());
//    }
//
//
//    // filter
//    public void filterCardsByLocation(String location) {
//        waitForLoader();
//        driver.findElement(locationFilter).click();
//        driver.findElement(locationDropdown).findElement(inputValueInDropdown).sendKeys(location);
//        String locatorForCheckbox = String.format(".//label[@data-value='%s']/span[text()='%s']", location, location);
//        driver.findElement(By.xpath(locatorForCheckbox)).click();
//
//        waitForLoader();
//    }
}

