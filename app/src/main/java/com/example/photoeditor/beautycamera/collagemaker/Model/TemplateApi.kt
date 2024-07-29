package com.example.photoeditor.beautycamera.collagemaker.Model

import com.google.gson.annotations.SerializedName

data class TemplateApi(

    @field:SerializedName("baseUrl") val baseUrl: String,

    @field:SerializedName("templates") val templates: List<TemplatesItem?>
)

data class Group11(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Pridemonth(

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Group4(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group7(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group1(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group19(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group8(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Summer(

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Group13(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group2(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group20(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group16(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group12(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group5(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group3(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Birthday(

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Group6(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Selfie(

    @field:SerializedName("group20") val group20: Group20,

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class LgStory(

    @field:SerializedName("group20") val group20: Group20,

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Love(

    @field:SerializedName("group20") val group20: Group20,

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class TemplatesItem(

    @field:SerializedName("birthday") val birthday: Birthday,

    @field:SerializedName("love") val love: Love,

    @field:SerializedName("childhood") val childhood: Childhood,

    @field:SerializedName("school") val school: School,

    @field:SerializedName("lgStory") val lgStory: LgStory,

    @field:SerializedName("selfie") val selfie: Selfie,

    @field:SerializedName("pridemonth") val pridemonth: Pridemonth,

    @field:SerializedName("summer") val summer: Summer,

    @field:SerializedName("frame") val frame: Frame

)

data class Group15(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group10(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group9(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Childhood(

    @field:SerializedName("group20") val group20: Group20,

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Group18(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class School(

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Frame(

    @field:SerializedName("group20") val group20: Group20,

    @field:SerializedName("group11") val group11: Group11,

    @field:SerializedName("group10") val group10: Group10,

    @field:SerializedName("group8") val group8: Group8,

    @field:SerializedName("group7") val group7: Group7,

    @field:SerializedName("group9") val group9: Group9,

    @field:SerializedName("group4") val group4: Group4,

    @field:SerializedName("group3") val group3: Group3,

    @field:SerializedName("group6") val group6: Group6,

    @field:SerializedName("group5") val group5: Group5,

    @field:SerializedName("group2") val group2: Group2,

    @field:SerializedName("group1") val group1: Group1,

    @field:SerializedName("group17") val group17: Group17,

    @field:SerializedName("group16") val group16: Group16,

    @field:SerializedName("group19") val group19: Group19,

    @field:SerializedName("group18") val group18: Group18,

    @field:SerializedName("group13") val group13: Group13,

    @field:SerializedName("group12") val group12: Group12,

    @field:SerializedName("group15") val group15: Group15,

    @field:SerializedName("group14") val group14: Group14
)

data class Group17(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)

data class Group14(

    @field:SerializedName("imageUrl") val imageUrl: String,

    @field:SerializedName("imageEditUrl") val imageEditUrl: String
)
