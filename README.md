HibernateSimpleExample2
=======================

`HibernateSimpleExample2` [github.com ** HibernateSimpleExample2](https://github.com/Cache-Hibernate/HibernateSimpleExample2)

Database
========

`Database IDE 0xDBE 1.0 EAP` [https://confluence.jetbrains.com/display/DBE/0xDBE+1.0+EAP](https://confluence.jetbrains.com/display/DBE/0xDBE+1.0+EAP)


Ссылки:
=======
* `[5]`: [MySQL - СЕССИЯ](https://docviewer.yandex.ru/?uid=40270829&url=ya-mail%3A%2F%2F2370000006240542699%2F1.2&name=%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-2.txt&page=5&c=559ce2ea4c7c)
* `[6]`: [[MySQL - JOIN, Exception/RuntimeException]](https://docviewer.yandex.ru/?uid=40270829&url=ya-mail%3A%2F%2F2370000006240542699%2F1.2&name=%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-2.txt&page=6&c=559ce2ea4c7c)
* `[7]`: [7](https://docviewer.yandex.ru/?url=ya-mail%3A%2F%2F2370000006240542699%2F1.2&uid=40270829&name=%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-2.txt&c=559ce2ea4c7c&page=7)
* `[8]`: [Мьютекс/Семафор](https://docviewer.yandex.ru/?url=ya-mail%3A%2F%2F2370000006240542699%2F1.2&uid=40270829&name=%D1%81%D1%81%D1%8B%D0%BB%D0%BA%D0%B8-2.txt&c=559ce2ea4c7c&page=8)

* `pool3`: [Luxoft/pool3/service](https://github.com/Home-Java8/Luxoft/tree/hotfix-1.2/src/com/pool3/service)
* `queue`: [Luxoft/messages/observer](https://github.com/Home-Java8/Luxoft/tree/hotfix-1.2/src/com/messages/observer)
* `Solutions`: [Home-Java8/Solutions](https://github.com/Home-Java8/Solutions)
* `The Berlin Clock`: [The Berlin Clock](https://github.com/JobTest/BerlinClock/tree/master/src/main/java/com)
* `The Luhn Algorithm`: [The Luhn Algorithm](https://github.com/JobTest/LuhnAlgorithm/tree/master/src/main/java/com/algorithm)


Hibernate:
==========

* `Кеширование в Hibernate`: [Cache-Hibernate/docs](https://github.com/Cache-Hibernate/docs/blob/master/cash.txt)
* `Кеширование в Hibernate`: [Cache-Hibernate/docs](https://github.com/Cache-Hibernate/docs/blob/master/hibernate.txt)

> "JPA"            - это интерфейс, который реализуется с помощью других ORM.

> Эти              - "ORM" (Object Relational Mapping) - выступают в качестве поставщика для этого, это способ сохранения объектов в реляционную базу данных.

> "Hibernate"      - это один из самых популярных на сегодняшний день ORM-фреймворков

> "Entity Manager" - является частью спецификации JPA для выполнения доступа к базе данных с помощью управляемых объектов.

* `new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory()`
* `session = ...openSession()`
* `session   .beginTransaction()`
* `.save(), .update(), .saveOrUpdate(), .load(), .get(), .list(), .iterate(), .scroll(), .delete()`
* `session   .getTransaction().commit()`
* `session   .close();`

> Обнуление кэша происходит после закрытия сессии.

* contains() - проверяет сохранён ли объект в кэше
* flush()    - синхронизирует содержимое кэша с базой данных
* evict()    - удаляет объект из кэша
* clear()    - обнуляет кэш

> Hibernate обращается к кэшу в следующих случаях:

* Приложение выполняет поиск сущности по идентификатору
* Приложение выполняет ленивую загрузку коллекции

> Кэши разделяются в зависимости от области видимости (scope) на следующие виды:

* "Session scope cache"     - Кэш привязанный к транзакции, действительный только пока транзакция не завершиться. Каждая транзакция имеет свой кэш, следовательно, доступ к данному кэшу не может быть осуществлён в несколько потоков.
* "Process scope cache"     - Кэш привязанный к определённому процессу конкретной JVM и общий для многих транзакций с возможностью параллельного доступа.
* "Cluster scope cache"     - Кэш общий для нескольких процессов на одной машине или нескольких машин в составе кластера.
* "Transaction scope cache" - представляет собой кэш первого уровня hibernate, кэш же второго уровня может быть реализован либо в области видимости процесса илибо как распределённый кэш.

> Стратегии кеширования определяют поведения кеша в определенных ситуациях. Выделяют четыре группы:

* Read-only            - используется для данных, которые часто читаются но никогда не изменяются (изменение данных при использовании этой стратегии приведёт к исключению).
                         Испльзование данного подхода в распределённом кэше позволяет не волноваться об синхронизации данных, однако может привести к сильной загрузке базы на начальном этапе работы кластера пока не закэширует все необходимые объекты.
* Read-write           - используется для данных которые гораздо чаще читаются, чем обновляются, однако, устаревание которых критично для приложения. (при этом подходе, данные блокируются для чтения во время их изменении с использованием “soft-lock” механизма).
                         Недостатки - так если в кластере имеется возможность изменения одних и тех же данных разными узлами, довольно часто могут случаться блокировки устаревших данных в кэше, что сводит на нет приемущества использования данной стратегии.
* Nonstrict-read-write - используется для данных, которые изменяются очень редко (при параллельном доступе к данным из разных транзакций данная стратегия не даёт никакой гарантии, что в кэше будут сохранены актуальные данные, так как Hibernate никак не изолирует от других транзакций данные во время изменения).
                         Не слудует использовать данную стратегию, если небольшая вероятность считывания устаревших данных критична для приложения.
                         Данная стратегия обеспечивает уровень изоляции транзакций "read commited"
* Transactional        - используется, когда необходима изоляция транзакций вполоть до уровня "repeatable read". Так же как и предыдущие используется для данных, которые гораздо чаще читаются нежели обновляются.


> Кеширование в Connection#PreparedStatement:

> Полезно знать что - существуют 2-типа блокировок:

1. Shared(S) - блокировка уровня чтения
2. Exclusive(X) - блокировка уровня записи

> Полезно знать что - существуют 4-типа уровней изоляции:

4. `SERIALIZABLE (упорядоченная изоляция)`                                         - доступ (только) для 1-юзера (только) к зафиксированым данным - (самый высокий уровень изоляции).

3. `REPEATABLE READ (изоляция уровня повторяемого чтения)`                         - доступ для всех (только) к зафиксированым данным.

2. `READ COMMTITED (изоляция уровня чтения подтвержденного/фиксированных)`         - доступ для всех (только) к зафиксированым данным И (только) для 1-юзера к временным данным которые находятся в процессе и зафиксированым данным.

1. `READ UNCOMMITTED (изоляция уровня чтения неподтвержденного/незафиксированных)` - доступ для всех к временным данным которые находятся в процессе и зафиксированым данным - (самый низкий уровень изоляции) грязное чтение.

Criteria:
========

> Criteria API позволяет формировать запросы к базе данных программным средствами.

* `session = ...openSession()`
* `session   .createCriteria(..class)`
* `          .add( Expression.like("name", name + "%") )`
* `          .add( Expression.between("age", minAge, maxAge) )`
* `          .addOrder( Order.asc("age") )`
* `session   .close();`
