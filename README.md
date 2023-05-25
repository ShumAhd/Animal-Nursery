
# Итоговая аттестация
## Информация о проекте
Необходимо организовать систему учета для питомника, в котором живут
домашние и вьючные животные.

#### 1 Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
```
cat > "Домашние животные" <<EOL
Собаки
Кошки
Хомяки
EOL
```
```
cat > "Вьючные животные" <<EOL
Лошади
Верблюды
Ослы
EOL
```
Объеденил эти два файла
```
cat "Домашние животные" "Вьючные животные" > "Друзья человека"
```
Посмотрел содержимое
```
cat "Друзья человека"
```
Переименовал файл
```
mv "Друзья человека" "Лучшие друзья человека"
```
#### 2 Создать директорию, переместить файл туда.
Создал новую директорию
```
mkdir "Контрольная"
```
Переместил файлы в новую директорию
```
mv "Лучшие друзья человека" "Контрольная/"
```




