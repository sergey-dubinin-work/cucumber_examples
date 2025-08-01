package sergey.dubinin.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private String username;
    private String password;
    private String resultMessage;

    @Дано("пользователь открывает страницу входа")
    public void openLoginPage(){
        System.out.println("> > > Открыта страница входа");
    }

    @Когда("он вводит логин {string} и пароль {string}")
    public void inputUsernameAndPassword(String username, String password){
        System.out.printf("> > > Введён логин: %s\n", username);
        System.out.printf("> > > Введён пароль: %s\n", password);
        this.username = username;
        this.password = password;
    }

    @И("нажимает на кнопку {string}")
    public void clickOnButtonNamed(String buttonName){
        System.out.printf("> > > Нажата кнопка: %s\n", buttonName);
        if ("user".equals(username) && "pass123".equals(password)){
            resultMessage = "Добро пожаловать!";
        } else {
            resultMessage = "Ошибка авторизации";
        }
    }

    @Тогда("он должен увидеть сообщение {string}")
    public void checkMessage(String expectedMessage){
        System.out.printf("> > > Ожидаемое сообщение: %s\n", expectedMessage);
        System.out.printf("> > > Фактическое сообщение: %s\n", resultMessage);
        assertThat(expectedMessage).isEqualTo(resultMessage);
    }

}
