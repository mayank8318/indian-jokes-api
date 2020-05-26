from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.chrome.options import Options


options = Options()
options.add_argument("--headless")

driver = webdriver.Firefox()
driver.get("https://latestsms.in/santa-banta-jokes.htm")

jokes = []


def nextPage(curPage):
    pagination = driver.find_element_by_class_name("pagination")
    ul = pagination.find_element_by_tag_name("ul")
    lis = ul.find_elements_by_tag_name("li")

    i = 1
    for item in lis:
        if i == curPage + 1:
            return item.find_element_by_tag_name("a")
        i += 1
    return None


for curPage in range(1, 4):
    jokeItems = driver.find_elements_by_class_name("maincontent")

    for j in jokeItems:
        try:
            j.find_element_by_tag_name("img")
        except NoSuchElementException:
            try:
                j.find_element_by_tag_name("a")
            except NoSuchElementException:
                print(j.text)
                print("")

    a = nextPage(curPage)
    a.click()

driver.close()