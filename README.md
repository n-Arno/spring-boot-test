spring-boot-test
================

Containerized test Spring Boot app leveraging PostgreSQL

Demo usage
----------

Build and run the container together a with postgresql db:

```
make
```

Test the app:

```
curl -s http://localhost:8080/books | python3 -m json.tool
```

Check `http://localhost:8080/` for a web listing.

Stop it with:

```
make clean
```

Credits
-------

Built upon [https://github.com/mkyong/spring-boot.git](https://github.com/mkyong/spring-boot.git)

