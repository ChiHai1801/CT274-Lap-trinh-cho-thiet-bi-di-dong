package com.example.b1906314_bai_tuan_7

object Constants {
    const val USER_NAME: String = "username"
    const val CORRECT_ANS: String = "correctAns"
    const val TOTAL_QUES: String = "TotalQues"

    fun getQuestion(): ArrayList<Question>{
        val quesList = ArrayList<Question>()
        val q1 = Question(
            id = 1,
            question = "What country does this flag belong to?",
            img = R.drawable.ic_flag_of_argentina,
            opt1 = "Argentina",
            opt2 = "Armenia",
            opt3 = "Australia",
            opt4 = "Austria",
            correct = 1,
        )
        quesList.add(q1)

        val q2 = Question(
            id = 1,
            question = "What country does this flag belong to?",
            img = R.drawable.ic_flag_of_brazil,
            opt1 = "Brunei",
            opt2 = "Brazil",
            opt3 = "Bulgaria",
            opt4 = "Bolivia",
            correct = 2,
        )
        quesList.add(q2)

        val q3 = Question(
            id = 1,
            question = "What country does this flag belong to?",
            img = R.drawable.ic_flag_of_belgium,
            opt1 = "Bhutan",
            opt2 = "Benin",
            opt3 = "Belize",
            opt4 = "Belgium",
            correct = 4,
        )
        quesList.add(q3)

        val q4 = Question(
            id = 1,
            question = "What country does this flag belong to?",
            img = R.drawable.ic_flag_of_india,
            opt1 = "Argentina",
            opt2 = "Armenia",
            opt3 = "Australia",
            opt4 = "Austria",
            correct = 3,
        )
        quesList.add(q4)

        return quesList
    }
}