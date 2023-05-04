package com.example.a7minutesworkout

object Constants {

    fun defaultExerciseList() : ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()
        val jumpingJack = ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJack)

        val wallSit = ExerciseModel(
            2,
            "Wall Sit",
            R.drawable.ic_wall_sit,
            false,
            false
        )
        exerciseList.add(wallSit)

        val tricepsDipOnChair = ExerciseModel(
            3,
            "Triceps Dip On Chair",
            R.drawable.ic_triceps_dip_on_chair,
            false,
            false
        )
        exerciseList.add(tricepsDipOnChair)

        val stepUpOntoChair = ExerciseModel(
            4,
            "Step Up Onto Chair",
            R.drawable.ic_step_up_onto_chair,
            false,
            false
        )
        exerciseList.add(stepUpOntoChair)

        val squat = ExerciseModel(
            5,
            "Squat",
            R.drawable.ic_squat,
            false,
            false
        )
        exerciseList.add(squat)

        val sidePlank = ExerciseModel(
            6,
            "Side Plank",
            R.drawable.ic_side_plank,
            false,
            false
        )
        exerciseList.add(sidePlank)

        val pushUpAndRotation = ExerciseModel(
            7,
            "Push up and rotation",
            R.drawable.ic_push_up_and_rotation,
            false,
            false
        )
        exerciseList.add(pushUpAndRotation)

        val pushUp = ExerciseModel(
            8,
            "Push up",
            R.drawable.ic_push_up,
            false,
            false
        )
        exerciseList.add(pushUp)

        val plank = ExerciseModel(
            9,
            "Plank",
            R.drawable.ic_plank,
            false,
            false
        )
        exerciseList.add(plank)

        val lunge = ExerciseModel(
            10,
            "Lunge",
            R.drawable.ic_lunge,
            false,
            false
        )
        exerciseList.add(lunge)

        val jumpingJacks = ExerciseModel(
            11,
            "Jumping jacks",
            R.drawable.ic_jumping_jacks,
            false,
            false
        )
        exerciseList.add(jumpingJacks)

        val highKneesRunningInPlace = ExerciseModel(
            12,
            "High knees running in place",
            R.drawable.ic_high_knees_running_in_place,
            false,
            false
        )
        exerciseList.add(highKneesRunningInPlace)

        val abdominalCrunch = ExerciseModel(
            13,
            "Abdominal crunch",
            R.drawable.ic_abdominal_crunch,
            false,
            false
        )
        exerciseList.add(abdominalCrunch)

        return exerciseList
    }
}