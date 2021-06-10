# Ranges
A small java library that implements ranges

## Samples
##### Вывод всех чисел от 1 до 100 с шагом 6
```Java
Range range = new Range(1, 101, 6);
range.forEach(System.out::println);
```
##### "Переворот" множества
```Java
Rangeable range = Ranges.invertRange(new Range(1, 5, -2));
range.forEach(System.out::println);
```

##### Сумма множества
```Java
Rangeable range = new Range(1, 10, 1);
System.out.println(Ranges.sum(range));
```

##### Среднее арифметическое
```Java
Rangeable range = new Range(1, 10, 1);
System.out.println(Ranges.average(range));
```
