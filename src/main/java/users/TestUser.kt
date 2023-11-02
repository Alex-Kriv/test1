package users

object TestUser {

    val testUserForRegistration = UserData(
        name = "Александр",
        birthday = "02.06.1998",
        email = "Alex@mail.com",
        instagram = "@Alexandrio",
        phoneNumber = "9231775570",
        smsCode = "",
        userWasAuthorized = false,
        city = "Санкт-Петербург",
        street = "Сапёрный переулок ",
        homeNumber = "20",
        apartNumber = "23",
        entrance = "2",
        intercom = "4466",
        floor = "6",
        commentAddress = "Комментарий",
    )

    val testUserForRegistrationAnother = UserData(
        name = "Петр",
        birthday = "02.06.1990",
        email = "123@mail.com",
        instagram = "@Petricio"
    )
}
