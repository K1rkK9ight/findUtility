# findUtility
lesson2|Find
2е Задание 4го варианта, Find.

Пример запуска консольного приложения: 1. Запускаем консоль: press win-> search cmd->open cmd
                                       2. В командной строке открываем директорию, в которой расположен созданный Jar-файл проекта: 
                                       учитывая расроложение на моем устройстве: пишем cd C:\Users\GamerPro\IdeaProjects\findUtility
                                       3. Запускаем Jar-файл указывая аргументы ком.строки: 
                                       java -jar FindTest-1.0-SNAPSHOT-jar-with-dependencies.jar -r -d C:\Users\GamerPro\IdeaProjects\findUtility\src hidden.txt
ключ -r указывает на необходимость поиска во всех поддиректориях
ключ -d указывает на текущую директорию(после этого ключа идет полный путь до нашей директории)
hidden.txt -> название файла.txt.
