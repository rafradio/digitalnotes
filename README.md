# Веб-проект на Java Spring Boot, JS.
#### Абдюшев Р.Н.
#### Тестовое задание
<br>

## Веб приложение "Заметки разных типов"
### Rest Api, Thymeleaf, MySQL

#### Конструкция приложения
Сделано веб-приложение с использованием Java Spring Boot, Rest Api.
Данные сохраняются в MySQL.
Веб-страницы - HTML, Css, JavaScript.
Работа находится в папке "/digitalNotes".
* ToysShopSpringApplication.java - main файл для запуска приложения;
* /src/main/java/com/java/digitalNotes/digitalNotes - путь к данному файлу;
* /controllers - паккидж с контроллерами в которых прописан маппинг, в том числе Rest Api;    
* /models - класс "заметки" , класс "тип заметки" соотношение OneToMany;
* /dao - класс - обращение к БД MySQL, запись и чтение. CRUD;
* CRUD только к заметкам. к типам нет.
* /resources - папка с JavaScript, HTML, Css. В HTML стоят шаблонизаторы Thymeleaf.
<br>

#### Конструкция веб-страниц
* http://localhost:8080/index - Интерфейс главной веб страницы;
    > содержит только две кнопки "личные" и "рабочие" (два типа по умолчанию)<br>
    > типы не добавляются<br>
    > нажатие кнопок введет на следующую страницу с записками<br>
    > по данному типу<br>
    > Кнопка "Новая карточка" - для перехода на страницу формирования новой<br>
    > карточки игрушки;<br>
    > Кнопка "Списать выигранные" - для взятия информации с фронта и отражения<br>
    > в бэке и БД<br>;
    > Кнопка "Сохранить в файл" - Rest Api сервис. Сохраняет и на сервере и на стороне<br> 
    > клиента.<br>
* http://localhost:8080/notes/{id по типу} - Страница со списком заметок;
    > список заметок (кликабельный)<br>
    > при нажатии заметки попадаем в форму CRUD для заметки<br>
    > Две кнопки:<br>
    > (1) кнопка возврата в mainдля создания новой заметки.<br>
    > (2) кнопка возврата в index.<br>
* http://localhost:8080/note/{id по id} - Страница со списком заметок;
    > форма CRUD для заметки<br>
    > с соответсвующими кнопками
    > а также сохранения данных заметки в json файл, как на стороне сервера<br>
    > так и на стороне клиента<br>
    > кнопка для возврата в index<br>
    <br>
#### Конфигурация приложения
* пример файла application.properties<br>
    > spring.jpa.hibernate.ddl-auto=update<br>
    > spring.datasource.url=jdbc:mysql://localhost:3306/digitaltest<br>
    > spring.datasource.username=root<br>
    > spring.datasource.password=<br>
    > spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br>
    > driver=com.mysql.cj.jdbc.Driver<br>
    > url=jdbc:mysql://localhost:3306/digitaltest<br>
    > username_value=root<br>
    > password=<br>
    > path_onserver=C:\\Users\\ASUS\\Documents\\NetBeansProjects\\data_json\\note_id_<br>
    > сделал через JPA repository и JDBC Connector настройки нужны и те и те <br>
    > path_onserver - показывает куда сохранять файл на сервере.
    




