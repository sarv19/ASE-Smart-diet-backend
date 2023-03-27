# Introduction

This is the API document for smartDiet system.

@since: 2023-03-26

@version: v0.5.1

## releases

- [0.5.1] support summarize by date, and add the function that queries list of ingredients.

- [0.5.0] fix bugs about the summary function
  - add functions about food performance
  
  - the diet recommendation algorithm is updated to use data about food performance, it will never (0), less (0.8) or more (1.2) to recommend a food basing on the users' food performance settings.
  
- [0.4.1] fix bugs about the summary function

- [0.4.0] add functions about the summary

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

# Path

All API path should start with `/sd`. For example, `HTTP://IP:PORT/sd/user/login`

# APIs

## User(to gain authorization)

### login

| Name           | value                                         |
| -------------- | --------------------------------------------- |
| Route          | /user/login                                   |
| Pre-condition  | 1.                                            |
| Post-condition | 1.                                            |
| Description    | Backup interface. Get the `userUid` of a user |

#### request

`username`,`password` can not be blank.

```json
{
  "username": "tester00",
  "password": "123"
}
```

#### ok

API will return `userUid` in the "data" field.

```json
{
  "msg": "",
  "code": 200,
  "data": "1"
}
```

### register

| Name           | value                           |
|----------------|---------------------------------|
| Route          | /user/register                  |
| Pre-condition  | 1.                              |
| Post-condition | 1.                              |
| Description    | Get data from email information |

#### request

`userUid`,`email` can not be null.

```json
{
  "userUid": "testdata00",
  "email": "testdata00@gmail.com"
}
```

#### ok

API will return `userUid`

```json
{
  "msg": "",
  "code": 200,
  "data": "testdata00"
}
```

## Settings(personal information settings)

### queryDietPreference

| Name           | value                                       |
|----------------|---------------------------------------------|
| Route          | /settings/queryDietPreference               |
| Pre-condition  | 1. User already login                       |
| Post-condition | 1.                                          |
| Description    | Return the list of diet preference of user. |

#### request

```json
{
  "userUid": "test123"
}
```

#### ok

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

### addDietPreference

| Name           | value                                                         |
|----------------|---------------------------------------------------------------|
| Route          | /settings/addDietPreference                                   |
| Pre-condition  | 1. User already login 2. targetId **must** be null            |
| Post-condition | 1. The new setting will be actived, the old one is inactived. |
| Description    | Add the list of diet preference of user.                      |

#### request

```json
{
  "targetCaloriesMin": 1500,
  "targetCaloriesMax": 2000
}
```

#### ok

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

### editDietPreference

| Name           | value                                                       |
|----------------|-------------------------------------------------------------|
| Route          | /settings/editDietPreference                                |
| Pre-condition  | 1. User already login 2. targetId **cannot** be null        |
| Post-condition | 1. The orignial one is inactived, and then active this one. |
| Description    | Edit the list of diet preference of user.                   |

#### request

```json
{
  "targetId": 2023031305575402,
  "targetCaloriesMin": 1500,
  "targetCaloriesMax": 2000
}
```

#### ok

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

### deleteDietPreference

| Name           | value                                                                                   |
|----------------|-----------------------------------------------------------------------------------------|
| Route          | /settings/deleteDietPreference                                                          |
| Pre-condition  | 1. User already login 2. targetId **cannot** be null 3. cannot delete an active setting |
| Post-condition | 1.                                                                                      |
| Description    | delete the list of diet preference of user.                                             |

#### request

```json
{
  "targetId": 2023031305315593
}
```

#### ok

```json
{
  "msg": "success",
  "code": 200
}
```

### querySettings

| Name           | value                               |
|----------------|-------------------------------------|
| Route          | /settings/querySettings             |
| Pre-condition  | 1. User already login               |
| Post-condition | 1.                                  |
| Description    | query the list of settings of user. |

#### request

```json
{

}
```

#### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "fullName": "test123",
    "gender": "unknown",
    "emailAddress": "test123@gmail.com",
    "phoneNumber": null,
    "address": null
  }
}
```

### editSettings

| Name           | value                          |
|----------------|--------------------------------|
| Route          | /settings/editSettings         |
| Pre-condition  | 1. User already login          |
| Post-condition | 1.                             |
| Description    | edit the list of settings of user. |

#### request

```json
{

}
```

#### ok

```json
{
  "msg": "success",
  "code": 200
}
```

### queryFoodPerformance

| Name           | value                          |
|----------------|--------------------------------|
| Route          | /settings/queryFoodPerformance |
| Pre-condition  | 1. User already login          |
| Post-condition | 1.                             |
| Description    | query food performance of user |

#### request

```json
{
  
}
```

#### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "preferred": [],
    "unwanted": [],
    "allergens": []
  }
}
```

### addFoodPerformance

| Name           | value                                                        |
| -------------- | ------------------------------------------------------------ |
| Route          | /settings/addFoodPerformance                                 |
| Pre-condition  | 1. User already login                                        |
| Post-condition | 1.                                                           |
| Description    | add the food performance of one user, "recommendLevel": -1 = allergy; 0 = dislike; 1 = like |

#### request

```json
{
    "ingredientId": 32,
    "recommendLevel": 1
}
```

#### ok

```json
{
    "msg": "success",
    "code": 200,
    "data": true
}
```

### deleteFoodPerformance

| Name           | value                                                                                      |
|----------------|--------------------------------------------------------------------------------------------|
| Route          | /settings/deleteFoodPerformance                                                            |
| Pre-condition  | 1. User already login                                                                      |
| Post-condition | 1.                                                                                         |
| Description    | delete food performance of one user |

#### request

```json
{
    "preferenceId": 72
}
```

#### ok

```json
{
    "msg": "success",
    "code": 200,
    "data": false
}
```

## Ingredient

### ingredientList

| Name           | value                                      |
|----------------|--------------------------------------------|
| Route          | /ingredient/ingredientList                 |
| Pre-condition  | 1. User already login                      |
| Post-condition |                                            |
| Description    | Return list of ingredient. Attention paging |

#### request

```json
{
  
}
```

#### ok

```json
{
    "msg": "success",
    "code": 200,
    "data": {
        "total": 43,
        "list": [
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301000,
                "typeId": 1,
                "ingredientName": "chicken breast",
                "description": "chicken breast",
                "calories": 136,
                "fat": 30,
                "protein": 254
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301001,
                "typeId": 1,
                "ingredientName": "chicken thigh",
                "description": "chicken thigh",
                "calories": 250,
                "fat": 188,
                "carbohydrate": 3,
                "protein": 187
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301002,
                "typeId": 1,
                "ingredientName": "shrimp",
                "description": "shrimp",
                "calories": 80,
                "fat": 10,
                "carbohydrate": 10,
                "protein": 150
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301003,
                "typeId": 1,
                "ingredientName": "bacon strip",
                "description": "bacon strip",
                "calories": 640,
                "fat": 560,
                "protein": 400
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301004,
                "typeId": 1,
                "ingredientName": "tilapia fillet",
                "description": "tilapia fillet",
                "calories": 90,
                "fat": 15,
                "protein": 190
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301005,
                "typeId": 1,
                "ingredientName": "beef shank",
                "description": "beef shank",
                "calories": 228,
                "fat": 72,
                "protein": 380
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301006,
                "typeId": 1,
                "ingredientName": "beef rib",
                "description": "beef rib",
                "calories": 383,
                "fat": 309,
                "protein": 244
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301007,
                "typeId": 1,
                "ingredientName": "pork loin",
                "description": "pork loin",
                "calories": 120,
                "fat": 40,
                "carbohydrate": 10,
                "protein": 230
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301008,
                "typeId": 1,
                "ingredientName": "egg",
                "description": "egg",
                "calories": 140,
                "fat": 100,
                "protein": 120
            },
            {
                "createdAt": "2023-03-24 17:01:44",
                "updatedAt": "2023-03-24 17:01:44",
                "ingredientId": 2023031414301009,
                "typeId": 1,
                "ingredientName": "ground beef",
                "description": "ground beef",
                "calories": 200,
                "fat": 120,
                "protein": 230
            }
        ],
        "pageNum": 1,
        "pageSize": 10,
        "size": 10,
        "startRow": 1,
        "endRow": 10,
        "pages": 5,
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2,
            3,
            4,
            5
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 5
    }
}
```

## Meal(recommendation, Main feature)

### queryAMeal

| Name           | value                                                                                                   |
|----------------|---------------------------------------------------------------------------------------------------------|
| Route          | /meal/queryAMeal                                                                                        |
| Pre-condition  | 1. User already login 2. meal type cannot be null while meal id is null                                 |
| Post-condition | 1.                                                                                                      |
| Description    | Return the list of type of food that user can select. Use `/querySubstitutions` to query substitutions. |

#### request

`MealId` **can be null at the first time**. However, `MealId` should be **the same** in the following queries for the
same meal.

```json
{
  "mealType": "dinner",
  "mealId": 2023032100563037,
  "pageNum": 1,
  "pageSize": 10
}
```

#### ok

API will return a list of type of food, such as grains(rice/pasta), meet(dog/beef).

```json
{
    "msg": "success",
    "code": 200,
    "data": {
        "mealId": 2023032100563037,
        "data": {
            "total": 6,
            "list": [
                {
                    "ingredientId": 2023031414301001,
                    "typeId": 1,
                    "ingredientName": "chicken thigh",
                    "calories": 228,
                    "weight": 91
                },
                {
                    "ingredientId": 2023031414301012,
                    "typeId": 2,
                    "ingredientName": "corn",
                    "calories": 152,
                    "weight": 233
                },
                {
                    "ingredientId": 2023031414301017,
                    "typeId": 3,
                    "ingredientName": "celery",
                    "calories": 152,
                    "weight": 1085
                },
                {
                    "ingredientId": 2023031414401012,
                    "typeId": 4,
                    "ingredientName": "banana",
                    "calories": 76,
                    "weight": 72
                },
                {
                    "ingredientId": 2023031414401005,
                    "typeId": 5,
                    "ingredientName": "cow milk",
                    "calories": 98,
                    "weight": 155
                },
                {
                    "ingredientId": 2023031414401001,
                    "typeId": 6,
                    "ingredientName": "butter unsalted",
                    "calories": 76,
                    "weight": 29
                }
            ],
            "pageNum": 1,
            "pageSize": 6,
            "size": 6,
            "startRow": 0,
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
        },
        "mealDate": null
    }
}
```

### querySubstitutions

| Name           | value                                                |
|----------------|------------------------------------------------------|
| Route          | /meal/querySubstitutions                             |
| Pre-condition  | 1. User already login                                |
| Post-condition | 1.                                                   |
| Description    | Return the list of substitutions that user selected. |

#### request

```json
{
    "mealId": 2023032100563037,
    "ingredientId": 2023031414301001
}
```

#### ok

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
                    "ingredientId": 2023031414301011,
                    "typeId": 1,
                    "ingredientName": "tuna",
                    "calories": 228,
                    "weight": 455
                },
                {
                    "ingredientId": 2023031414301010,
                    "typeId": 1,
                    "ingredientName": "salmon",
                    "calories": 228,
                    "weight": 227
                },
                {
                    "ingredientId": 2023031414301009,
                    "typeId": 1,
                    "ingredientName": "ground beef",
                    "calories": 228,
                    "weight": 113
                },
                {
                    "ingredientId": 2023031414301008,
                    "typeId": 1,
                    "ingredientName": "egg",
                    "calories": 228,
                    "weight": 162
                },
                {
                    "ingredientId": 2023031414301007,
                    "typeId": 1,
                    "ingredientName": "pork loin",
                    "calories": 228,
                    "weight": 190
                }
            ],
            "pageNum": 1,
            "pageSize": 5,
            "size": 5,
            "startRow": 0,
            "endRow": 4,
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

### confirmAMeal

| Name           | value                                                              |
|----------------|--------------------------------------------------------------------|
| Route          | /meal/confirmAMeal                                                 |
| Pre-condition  | 1. User already login 2. submit the meal that not be confirmed yet |
| Post-condition | 1. A meal will be confirmed and cannot change anymore              |
| Description    | Return the list of substitutions that user selected.               |

#### request

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

#### ok

```json
{
  "msg": "success",
  "code": 200
}
```

### mealHistory

| Name           | value                                     |
|----------------|-------------------------------------------|
| Route          | /meal/mealHistory                         |
| Pre-condition  | 1. User already login                     |
| Post-condition |                                           |
| Description    | Return the list of history of user's meal |

#### request

```json
{
}
```

#### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "total": 0,
    "list": [],
    "pageNum": 1,
    "pageSize": 10,
    "size": 0,
    "startRow": 0,
    "endRow": 0,
    "pages": 0,
    "prePage": 0,
    "nextPage": 0,
    "isFirstPage": true,
    "isLastPage": true,
    "hasPreviousPage": false,
    "hasNextPage": false,
    "navigatePages": 8,
    "navigatepageNums": [],
    "navigateFirstPage": 0,
    "navigateLastPage": 0
  }
}
```

### clearHistory

| Name           | value                            |
| -------------- | -------------------------------- |
| Route          | /meal/clearHistory               |
| Pre-condition  | 1. User already login            |
| Post-condition |                                  |
| Description    | Clear all the data of one's meal |

#### request

```json
{
}
```

#### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": true
}
```



## Summary(Summary of all meals in a day)

### summarizeToday

| Name           | value                                                |
| -------------- |------------------------------------------------------|
| Route          | /summary/summarizeADay                               |
| Pre-condition  | 1. User already login                                |
| Post-condition |                                                      |
| Description    | Return the list of substitutions that user selected. |

#### request

```json
{
  
}
```

#### ok

```json
{
  "msg": "success",
  "code": 200,
  "data": {
    "summary": [],
    "userTarget": {
      "createdAt": "2023-03-14 15:43:36",
      "updatedAt": "2023-03-14 15:43:36",
      "targetId": 2023031420433601,
      "userId": 2023031420433602,
      "userUid": "test123",
      "isActive": true,
      "targetCaloriesMin": 1800,
      "targetCaloriesMax": 2000
    }
  }
}
```

