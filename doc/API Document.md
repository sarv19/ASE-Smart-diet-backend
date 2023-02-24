# Introduction

This is the API document for smartDiet system.

@since: 2023-02-24

@version: v2.1

## changes

- [v2.1] not need to submit userId in the APIs that used need to, such as queryAMeal, confirmAMeal.

# Page support

please use this two param to use the page function.

```json
"pageNum": 1,
"pageSize": 10
```

**It only work for those APIs which support page.**

Even this two param is missing, default values are set, which is 1 for pageNum and 10 for pageSize.



# Login(to gain authorization)

## login

| Name           | value                               |
| -------------- |-------------------------------------|
| Route          | /user/login                         |
| Pre-condition  | 1.                                  |
| Post-condition | 1.                                  |
| Description    | Backup interface, not used for now. |

### request
`username`,`password` can not be blank 

```json
{
    "username": "tester00",
    "password": "123"
}
```

### ok

API will return user_uid in the "data" field.

```json
{
    "msg": "",
    "code": 200,
    "data": "1"
}
```



# Meal(recommandation, Main feature)

## mealForToday

| Name           | value                          |
| -------------- | ------------------------------ |
| Route          | /meal/mealForToday             |
| Pre-condition  | 1. User already login          |
| Post-condition | 1.                             |
| Description    | Knowing which meal it is today |

No ready to be used.

# User(personal information settings)





## queryAMeal

| Name           | value                                                        |
| -------------- | ------------------------------------------------------------ |
| Route          | /meal/queryAMeal                                             |
| Pre-condition  | 1. User already login 2. meal type cannot be null while meal id is null |
| Post-condition | 1.                                                           |
| Description    | Return the list of type of food that user can select. Use `/querySubstitutions` to query substitutions. |

### request

`MealId` **can be null at the first time**. However, `MealId` should be **the same** in the following queries for the same meal.

```json
{
    "mealType": "dinner",
    "mealId": 2023022123281601,
    "pageNum": 1,
    "pageSize": 10
}
```

### ok

API will return a list of type of food, such as grains(rice/pasta), meet(dog/beef).

```json
{
    "msg": "success",
    "code": 200,
    "data": {
        "mealId": 2023022123281601,
        "data": {
            "total": 6,
            "list": [
                {
                    "ingredientId": 2023021023502000,
                    "ingredientName": "grains",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 2023021023502001,
                    "ingredientName": "meet",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 2023021023502002,
                    "ingredientName": "fruit",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 2023021023502003,
                    "ingredientName": "vegetable",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 2023021023502004,
                    "ingredientName": "milk",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 2023021023502005,
                    "ingredientName": "beans",
                    "calories": 100,
                    "weight": 100
                }
            ],
            "pageNum": 1,
            "pageSize": 10,
            "size": 6,
            "startRow": 1,
            "endRow": 6,
            "pages": 1,
            "prePage": 0,
            "nextPage": 0,
            "isFirstPage": true,
            "isLastPage": true,
            "hasPreviousPage": false,
            "hasNextPage": false,
            "navigatePages": 8,
            "navigatepageNums": [
                1
            ],
            "navigateFirstPage": 1,
            "navigateLastPage": 1
        }
    }
}
```



## querySubstitutions

| Name           | value                                                |
| -------------- | ---------------------------------------------------- |
| Route          | /meal/querySubstitutions                             |
| Pre-condition  | 1. User already login                                |
| Post-condition | 1.                                                   |
| Description    | Return the list of substitutions that user selected. |

### request

```json
{
    "mealId": 2023022123281601,
    "ingredientId": 2023021023502000
}
```

### ok

API will return a list of food, such as rice/pasta for grains, dog/beef for meet.

```json
{
    "msg": "success",
    "code": 200,
    "data": {
        "data": {
            "total": 5,
            "list": [
                {
                    "ingredientId": 12,
                    "ingredientName": "test_food_L",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 13,
                    "ingredientName": "test_food_M",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 14,
                    "ingredientName": "test_food_N",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 15,
                    "ingredientName": "test_food_O",
                    "calories": 100,
                    "weight": 100
                },
                {
                    "ingredientId": 16,
                    "ingredientName": "test_food_P",
                    "calories": 100,
                    "weight": 100
                }
            ],
            "pageNum": 1,
            "pageSize": 10,
            "size": 5,
            "startRow": 1,
            "endRow": 5,
            "pages": 1,
            "prePage": 0,
            "nextPage": 0,
            "isFirstPage": true,
            "isLastPage": true,
            "hasPreviousPage": false,
            "hasNextPage": false,
            "navigatePages": 8,
            "navigatepageNums": [
                1
            ],
            "navigateFirstPage": 1,
            "navigateLastPage": 1
        }
    }
}
```



## confirmAMeal

| Name           | value                                                        |
| -------------- | ------------------------------------------------------------ |
| Route          | /meal/confirmAMeal                                           |
| Pre-condition  | 1. User already login 2. submit the meal that not be confirmed yet |
| Post-condition | 1. A meal will be confirmed and cannot change anymore        |
| Description    | Return the list of substitutions that user selected.         |

### request

```json
{
    "mealId": 2023022123281601,
    "ingredients": [
        {
            "ingredientId": 2023020821401001,
            "calories": 200,
            "quantity": 1,
            "weight": 100
        },
        {
            "ingredientId": 2023020821401002,
            "calories": 300,
            "quantity": 3,
            "weight": 300
        }
    ]
}
```

### ok

```json
{
    "msg": "success",
    "code": 200
}
```



