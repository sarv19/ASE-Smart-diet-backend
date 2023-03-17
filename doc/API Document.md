# Introduction

This is the API document for smartDiet system.

@since: 2023-03-17

@version: v0.4.0

## changes
- [0.4.0] add functions about the summary
  - API document not fully updated yet.

- [0.3.0] add functions about the personal settings
  - fix a bug that causes fail authorization.
  - fix a bug that stops generating meal.

- [0.2.2] add functions about the eating performance
- [0.2.1] not need to submit userId in the APIs that used need to, such as queryAMeal, confirmAMeal.

# Page support

please use this two param to use the page function.

```json
{
  "pageNum": 1,
  "pageSize": 10
}

```

**It only work for those APIs which support page.**

Even this two param is missing, default values are set, which is 1 for pageNum and 10 for pageSize.

# Login(to gain authorization)

## login

| Name           | value            |
| -------------- | ---------------- |
| Route          | /user/login      |
| Pre-condition  | 1.               |
| Post-condition | 1.               |
| Description    | Backup interface |

### request
`username`,`password` can not be blank.

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

## register

| Name           | value                           |
| -------------- | ------------------------------- |
| Route          | /user/register                  |
| Pre-condition  | 1.                              |
| Post-condition | 1.                              |
| Description    | Get data from email information |

### request
`userUid`,`email` can not be null.

```json
{
  "userUid": "testdata00",
  "email": "testdata00@gmail.com"
}
```

### ok

API will return `userUid`

```json
{
    "msg": "",
    "code": 200,
    "data": "testdata00"
}
```

# Settings(personal information settings)

## queryDietPreference

| Name           | value                                       |
| -------------- | ------------------------------------------- |
| Route          | /settings/queryDietPreference               |
| Pre-condition  | 1. User already login                       |
| Post-condition | 1.                                          |
| Description    | Return the list of diet preference of user. |

### request

```json
{
  "userUid": "test123"
}
```

### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "total": 1,
    "list": [
      {
        "createdAt": "2023-03-07 22:34:33",
        "updatedAt": "2023-03-07 22:34:33",
        "targetId": 2023030621401004,
        "userId": 2023021021401001,
        "userUid": "1",
        "isActive": true,
        "targetCaloriesMin": 1500,
        "targetCaloriesMax": 2000
      }
    ],
    "pageNum": 1,
    "pageSize": 10,
    "size": 1,
    "startRow": 1,
    "endRow": 1,
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
```

## addDietPreference

| Name           | value                                                        |
| -------------- | ------------------------------------------------------------ |
| Route          | /settings/addDietPreference                                  |
| Pre-condition  | 1. User already login 2. targetId **must** be null           |
| Post-condition | 1. The new setting will be actived, the old one is inactived. |
| Description    | Add the list of diet preference of user.                     |

### request

```json
{
  "targetCaloriesMin": 1500,
  "targetCaloriesMax": 2000
}
```

### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "targetId": 2023031305260190,
    "userId": 2023030803381701,
    "userUid": "test123",
    "isActive": true,
    "targetCaloriesMin": 1500,
    "targetCaloriesMax": 2000
  }
}
```

## editDietPreference

| Name           | value                                                       |
| -------------- | ----------------------------------------------------------- |
| Route          | /settings/editDietPreference                                |
| Pre-condition  | 1. User already login 2. targetId **cannot** be null        |
| Post-condition | 1. The orignial one is inactived, and then active this one. |
| Description    | Edit the list of diet preference of user.                   |

### request

```json
{
  "targetId": 2023031305575402,
  "targetCaloriesMin": 1500,
  "targetCaloriesMax": 2000
}
```

### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "targetId": 2023031305575402,
    "userId": 2023031305575401,
    "userUid": "test123",
    "isActive": true,
    "targetCaloriesMin": 1500,
    "targetCaloriesMax": 2000
  }
}
```

## deleteDietPreference

| Name           | value                                                        |
| -------------- | ------------------------------------------------------------ |
| Route          | /settings/deleteDietPreference                               |
| Pre-condition  | 1. User already login 2. targetId **cannot** be null 3. cannot delete an active setting |
| Post-condition | 1.                                                           |
| Description    | delete the list of diet preference of user.                  |

### request

```json
{
  "targetId": 2023031305315593
}
```

### ok

```json
{
  "msg": "success",
  "code": 200
}
```

# Meal(recommandation, Main feature)

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

# Summary(Summary of all meals in a day)

## summarizeToday

| Name           | value                                                |
| -------------- | ---------------------------------------------------- |
| Route          | summary/summarizeToday                               |
| Pre-condition  | 1. User already login                                |
| Post-condition |                                                      |
| Description    | Return the list of substitutions that user selected. |

### request

```json
{}
```

### ok

```json
{
    "msg": "success",
    "code": 200,
    "data": [
        {
            "mealId": 2023031700370002,
            "meal": {
                "mealId": 2023031700370002,
                "mealType": "dinner",
                "mealDate": "2023-03-17T00:37:10",
                "totalWeight": 408,
                "totalCalories": 800,
                "totalProtein": 600,
                "totalFat": 1260,
                "totalCarbohydrate": 1900,
                "totalSodium": 0
            },
            "ingredients": [
                {
                    "ingredientId": 2023031414301003,
                    "mealId": 2023031700370002,
                    "weight": 22,
                    "calories": 144,
                    "fat": 560,
                    "carbohydrate": 0,
                    "protein": 400,
                    "sodium": 0
                },
                {
                    "ingredientId": 2023031414401003,
                    "mealId": 2023031700370002,
                    "weight": 182,
                    "calories": 256,
                    "fat": 700,
                    "carbohydrate": 1900,
                    "protein": 200,
                    "sodium": 0
                }
            ]
        },
        {
            "mealId": 2023031700404502,
            "meal": {
                "mealId": 2023031700404502,
                "mealType": "lunch",
                "mealDate": "2023-03-17T00:40:54",
                "totalWeight": 408,
                "totalCalories": 800,
                "totalProtein": 600,
                "totalFat": 1260,
                "totalCarbohydrate": 1900,
                "totalSodium": 0
            },
            "ingredients": [
                {
                    "ingredientId": 2023031414301003,
                    "mealId": 2023031700404502,
                    "weight": 22,
                    "calories": 144,
                    "fat": 560,
                    "carbohydrate": 0,
                    "protein": 400,
                    "sodium": 0
                },
                {
                    "ingredientId": 2023031414401003,
                    "mealId": 2023031700404502,
                    "weight": 182,
                    "calories": 256,
                    "fat": 700,
                    "carbohydrate": 1900,
                    "protein": 200,
                    "sodium": 0
                }
            ]
        }
    ]
}
```

